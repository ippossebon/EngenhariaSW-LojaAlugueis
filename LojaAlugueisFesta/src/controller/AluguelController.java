package controller;

import java.util.ArrayList;

import database.Database;
import database.DatabaseController;
import model.Aluguel;
import model.Cliente;
import model.Data;
import model.Peca;
import model.RegistroReceita;
import view.MensagemFrame;

public class AluguelController {
	
	
	public AluguelController(){
		
	}
	
	public boolean alugarPeca(ArrayList<Integer> codigos_pecas, String cpf_cliente, String data_inicio, String data_fim){
		DatabaseController db = new DatabaseController(Database.getInstance());
		PesquisaController pc = new PesquisaController();
		ArrayList<Peca> pecas = new ArrayList<Peca>();
		ArrayList<Aluguel> alugueis = new ArrayList<Aluguel>();
		
		Data inicio, fim;
		Data entregue = null;
		int dias_inicio, dias_fim;
	
		String[] data;
		float valor_total = 0;
		
		if (pc.pesquisarClientePorCPF(cpf_cliente).isEmpty()){
			MensagemFrame msg = new MensagemFrame("Este cliente não está cadastrado no sistema.");
			msg.setVisible(true);
			return false;
		}
		
		if (pc.pesquisarClientePorCPF(cpf_cliente).get(0).isBloqueado()){
			MensagemFrame msg = new MensagemFrame("Aluguel cancelado! Este cliente está bloqueado para realizar alugueis. Para efetuar um novo aluguel, deve regularizar sua situação");
			msg.setVisible(true);
			return false;
		}
		
		alugueis = db.getAlugueis();
		
		// precisa ter alugueis pra pesquisar por alugueis
		if(alugueis != null) {
			
			for(Aluguel a: alugueis) {
				
				// buscar em todos os alugueis do cliente
				if(a.getCpf_cliente().equals(cpf_cliente)) {
					
					// basta um pendente para cancelar a ação
					if(a.isEntregue() == false) {
						MensagemFrame msg = new MensagemFrame("Este cliente possui alugueis pendentes.  Para efetuar um novo aluguel, deve regularizar sua situação");
						msg.setVisible(true);
						return false;
					}
				}
			}
		}
		
		// Pesquisa as peças pelos códigos
		for(Integer codigo: codigos_pecas){
			pecas.add(pc.pesquisarPeca(codigo, PesquisaController.pesquisa_disponiveis).get(0));
		}
		
		// Seta peças para indisponível
		for(Peca p: pecas) {
			p.setDisponivel(false);
			p.incAluguel();
			valor_total += p.getValor();
		}
		
		inicio = new Data(data_inicio);
		fim = new Data(data_fim);
		dias_inicio = inicio.converteDataParaDia();
		
		Aluguel aluguel = new Aluguel(pecas, inicio, fim, entregue, cpf_cliente, valor_total);
		aluguel.setEntregue(false);
		
		db.adicionarAluguel(aluguel);
		/* DEBUG */
		db.printDatabase();
		
		//System.out.println("Remover");
		//this.registrarDevolucao(2, 10, "17/11/2011");
		
		
		RegistroReceita reg = new RegistroReceita(inicio, valor_total);
		db.adicionarRegistroReceita(reg);
		/* DEBUG */
		db.printReceita();
		return true;
	}
	
	// incrementa multa de dano/perda de acordo com devoluções
	public void setMultaDano(Aluguel aluguel, float valor_multa){
		
		// 200%
		if(valor_multa > 3 * aluguel.getValor_total()) {
			
			System.out.println("Multa > 200%");
			MensagemFrame msg = new MensagemFrame("Erro no sistema: multa inválida.");
			msg.setVisible(true);
			return;
			
		} if (valor_multa < 0) {
			
			MensagemFrame msg = new MensagemFrame("Erro no sistema: multa inválida.");
			msg.setVisible(true);
			return;
		}
		
		// atualiza multa
		aluguel.setValor_multa(valor_multa + aluguel.getValor_multa());
		
	}
	
	public float calcularMultaAtraso(Aluguel aluguel) {
		
		float dias_atraso = aluguel.getData_entrega().converteDataParaDia() - aluguel.getData_fim().converteDataParaDia();
		
		return aluguel.getValor_total() * (dias_atraso / 10); 
		
	}
	
	// devolve com multa
	public void registrarDevolucao(int id_aluguel, int codigo_peca, String multa, String data_entregue) {
		
		ArrayList<Aluguel> alugueis = new ArrayList<Aluguel>();
		Data entrega = new Data(data_entregue);
		int dias_atrasados = 0;
		float valor_multa;
		
		DatabaseController db = new DatabaseController(Database.getInstance());
		
		// pega todos os alugueis
		alugueis = db.getAlugueis();
		
		for(Aluguel a: alugueis) {
			
			// encontra o aluguel pelo id
			if(a.getId() == id_aluguel) {
				
				a.removePecaDevolucao(codigo_peca); // remove a peça devolvida
				a.setData_entrega(entrega); // atualiza data entrega
				
				// se multa por dano/perda
				if(!multa.isEmpty()) {
					
					valor_multa = Float.parseFloat(multa);
					this.setMultaDano(a, valor_multa);
				}	

				for(Cliente c: db.getClientes()) {
					// procura o cliente do aluguel
					if(c.getCpf().equals(a.getCpf_cliente())) {
						
						// se devolveu tudo, desbloqueia
						if(a.getPecasDevolucao() == null) {
							
							valor_multa = this.calcularMultaAtraso(a);
							
							// se não houve atraso
							if(valor_multa <= 0) {
								
								c.setBloqueado(false);
							} else {
								
								// atualiza com valor da multa por atraso
								a.setValor_multa(a.getValor_multa() + valor_multa);
								c.setBloqueado(true);
							}
							
						} else {
							// não devolveu true
							c.setBloqueado(true);
						}		
					}
				}	
			}
		}
		
		db.printDatabase();
		
		/*
		Data data;
		String[] d;
		
		int data_inicio;
		int data_fim;
		
		d = data_entregue.split("/");
		data = new Data(Integer.parseInt(d[0]), Integer.parseInt(d[1]), Integer.parseInt(d[2]));
		
		
		this.calcularMulta(aluguel, Float.parseFloat(valor_multa), 2);
		
		for(Peca p: aluguel.getPecas()) {
			
			p.setDisponivel(true);
		}
		
		aluguel.setEntregue(true);
		
		if(aluguel.getValor_multa() != 0) {
			
			MensagemFrame msg = new MensagemFrame("gerou multa");
			msg.setVisible(true);
			
			double total = (double) aluguel.getValor_multa();
			
			/* Rever se deve ser feito aqui mesmo 
			RegistroReceita reg = new RegistroReceita(data, total);
			DatabaseController db_controller = new DatabaseController(Database.getInstance());
			db_controller.adicionarRegistroReceita(reg);
			db_controller.printReceita();
		}
			*/
		
	}
	
	
	// devolve sem multa
	public void registrarDevolucao(int id_aluguel, int codigo_peca, String data_entregue) {
		
		ArrayList<Aluguel> alugueis = new ArrayList<Aluguel>();
		Data entrega = new Data(data_entregue);
		int dias_atrasados = 0;
		float valor_multa;
		
		DatabaseController db = new DatabaseController(Database.getInstance());
		
		// pega todos os alugueis
		alugueis = db.getAlugueis();
		
		for(Aluguel a: alugueis) {
			
			// encontra o aluguel pelo id
			if(a.getId() == id_aluguel) {
				
				a.removePecaDevolucao(codigo_peca); // remove a peça devolvida
				a.setData_entrega(entrega); // atualiza data entrega

				for(Cliente c: db.getClientes()) {
					// procura o cliente do aluguel
					if(c.getCpf().equals(a.getCpf_cliente())) {
						
						// se devolveu tudo, desbloqueia
						if(a.getPecasDevolucao() == null) {
							
							c.setBloqueado(false);
						} else {
							
							c.setBloqueado(true);
						}		
					}
				}	
			}
		}
		
		db.printDatabase();
	}
	
	public float calcularValorTotal(ArrayList<Peca> pecas) {
		
		float valor_total = 0;
		boolean existe_sapato_feminino = false;
		boolean existe_vestido = false;
		int conta_pecas_masculinas = 0;
		
		for(Peca p: pecas){
			System.out.println(p.getTipo());
			
			if(p.getTipo().contains("Vestido")) {
			
				existe_vestido = true;
				valor_total += p.getValor();
			} 
			else if(p.getTipo().contains("feminino")) { // Contém um sapato feminino
				
				existe_sapato_feminino = true;
				valor_total += p.getValor();
			}
			else{
				conta_pecas_masculinas++;
				valor_total += p.getValor();
			}
		}
		
		if((existe_vestido && existe_sapato_feminino)) {
			valor_total *= 0.85;
		}
		
		if ((conta_pecas_masculinas >= 4)){
			valor_total *= 0.85;
		}
		
		return valor_total;
	}
}
