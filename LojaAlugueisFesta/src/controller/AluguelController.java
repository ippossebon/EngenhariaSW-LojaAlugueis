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
		
		RegistroReceita reg = new RegistroReceita(inicio, valor_total);
		db.adicionarRegistroReceita(reg);
		/* DEBUG */
		db.printReceita();
		return true;
	}
	
	public float calculaMultaDano(int id_aluguel, String porcentagem_multa){
		float valor_multa = 0;
		float porcentagem = Float.parseFloat(porcentagem_multa);
		
		DatabaseController db = new DatabaseController(Database.getInstance());
		for (Aluguel a : db.getAlugueis()){
			if (a.getId() == id_aluguel){
				valor_multa = porcentagem * a.getValor_total();
				float valor_antigo = a.getValor_multa();
				a.setValor_multa(valor_multa + valor_antigo);
			}
		}
		
		return valor_multa;
	}
	
	public double calcularMultaAtraso(int id_aluguel) {
		
		int dias_atraso;
		double valor_multa = 0;
		
		DatabaseController db = new DatabaseController(Database.getInstance());
		for (Aluguel aluguel : db.getAlugueis()){
			if (aluguel.getId() == id_aluguel){
				dias_atraso = aluguel.getData_entrega().converteDataParaDia() - aluguel.getData_fim().converteDataParaDia();
				
				if (dias_atraso > 0){
					valor_multa = 0.1 * aluguel.getValor_total() * dias_atraso;
				}
			}
		}
	
		return valor_multa; 
		
	}
	
	// Retorna TRUE se o aluguel está atrasado; FALSE, caso contrário.
	public boolean verificaSeAluguelAtrasado(int codigo_aluguel, String data){
		
		// TO DO
		
		return false;
	}
	
	// Devolve com multa - o cliente permanece bloqueado até que a multa seja paga.
	public void registrarDevolucaoMulta(int id_aluguel, int codigo_peca, String data_entregue) {

		DatabaseController db = new DatabaseController(Database.getInstance());
		Data entrega = new Data(data_entregue);
			
		for(Aluguel a: db.getAlugueis()) {

			// Encontra o aluguel pelo id
			if(a.getId() == id_aluguel) {
				a.removePecaDevolucao(codigo_peca); // Remove a peça devolvida
				a.setData_entrega(entrega); // Atualiza data entrega
			}
		}
	}
	
	
	// Devolve sem multa - o cliente é desbloqueado após devolver todas as peças.
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
						if(a.getPecasDevolucao().isEmpty()) {
							c.setBloqueado(false);
						} else {
							c.setBloqueado(true);
						}		
					}
				}	
			}
		}
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
