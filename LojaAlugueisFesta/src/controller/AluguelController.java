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
	
	// Devolve com multa
	public void registrarDevolucao(int id_aluguel, int codigo_peca, String multa, String data_entregue) {
	
		int dias_atrasados = 0;
		float valor_multa;
		DatabaseController db = new DatabaseController(Database.getInstance());
		Data entrega = new Data(data_entregue);

		for(Aluguel a: db.getAlugueis()) {
			
			// Encontra o aluguel pelo id
			if(a.getId() == id_aluguel) {
				a.removePecaDevolucao(codigo_peca);
				a.setData_entrega(entrega);
				dias_atrasados = a.getData_fim().converteDataParaDia() - a.getData_inicio().converteDataParaDia();
				
				//this.calcularMulta(a, 100, dias_atrasados); // 100 o que?
				
				// Se vai ser cobrada uma multa por dano ou perda
				if(!multa.isEmpty()) {
		
					valor_multa = Float.parseFloat(multa);
					this.setMultaDano(a, valor_multa);
				}	

				for(Cliente c: db.getClientes()) {
					// Procura o cliente do aluguel
					if(c.getCpf().equals(a.getCpf_cliente())) {
						
						// Se devolveu tudo, desbloqueia
						if(a.getPecasDevolucao().isEmpty()) {
							valor_multa = this.calcularMultaAtraso(a);
							
							// Se não houve atraso
							if(valor_multa <= 0) {
								c.setBloqueado(false);
							} else {
								
								// Atualiza com valor da multa por atraso
								a.setValor_multa(a.getValor_multa() + valor_multa); // Multa do aluguel corresponde a soma de todas as multas cobradas
								c.setBloqueado(true);
							}
							c.setBloqueado(false);	
						} else {
							// Cliente não devolveu todas as peças
							c.setBloqueado(true);
						}		
					}
				}	
			}
		}
		
		db.printDatabase();
	}
	
	
	// Devolve sem multa
	public void registrarDevolucao(int id_aluguel, int codigo_peca, String data_entregue) {
		
		Data entrega = new Data(data_entregue);
		DatabaseController db = new DatabaseController(Database.getInstance());
		
		for(Aluguel a: db.getAlugueis()) {
			
			// Encontra o aluguel pelo id
			if(a.getId() == id_aluguel) {
				
				a.removePecaDevolucao(codigo_peca); // Remove a peça devolvida
				a.setData_entrega(entrega); // Atualiza data entrega

				for(Cliente c: db.getClientes()) {
					// Procura o cliente do aluguel
					if(c.getCpf().equals(a.getCpf_cliente())) {
						
						// Se devolveu tudo, desbloqueia
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
			if(p.getTipo().contains("Vestido")) {
			
				existe_vestido = true;
				valor_total += p.getValor();
			} 
			else if(p.getTipo().contains("feminino")) { 
				/* Contém sapato feminino */
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
