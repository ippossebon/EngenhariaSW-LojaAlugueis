package controller;

import java.util.ArrayList;

import model.Aluguel;
import model.Data;
import model.Peca;
import model.RegistroReceita;
import view.MensagemFrame;
import database.Database;
import database.DatabaseController;

public class AluguelController {
	
	
	public AluguelController(){
		
	}
	
	public void alugarPeca(ArrayList<Integer> codigos_pecas, String cpf_cliente, String data_inicio, String data_fim){
		
		PesquisaController pc = new PesquisaController();
		ArrayList<Peca> pecas = new ArrayList<Peca>();
		
		Data inicio;
		Data fim;
		Data entregue = null;
		
		int dias_inicio;
		int dias_fim;
		
		String[] data;
		float valor_total = 0;
		
		// pesquisa as peças pelos códigos
		for(Integer codigo: codigos_pecas){
			pecas.add(pc.pesquisarPeca(codigo, PesquisaController.pesquisa_disponiveis).get(0));
		}
		
		// seta peças para indisponível
		for(Peca p: pecas) {
			p.setDisponivel(false);
			p.incAluguel();
			valor_total += p.getValor();
		}
		
		inicio = new Data(data_inicio);
		fim = new Data(data_fim);
		
		// criando Data
		//data = data_inicio.split("/");
		//inicio = new Data(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]));
		
		//data = data_fim.split("/");
		//fim  = new Data(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]));

		dias_inicio = inicio.converteDataParaDia();
		
		System.out.println("LOL" + dias_inicio);
		
		Aluguel aluguel = new Aluguel(pecas, inicio, fim, entregue, cpf_cliente, valor_total);
		aluguel.setEntregue(false);
		
		DatabaseController db = new DatabaseController(Database.getInstance());
		db.adicionarAluguel(aluguel);
		
		RegistroReceita reg = new RegistroReceita(inicio, valor_total);
		db.adicionarRegistroReceita(reg);
		db.printReceita();
	}

	public void confirmarPagamento(){
		
	}
	
	public void confirmarPagamentoMulta(){
		
	}
	
	public void calcularMulta(Aluguel aluguel, float valor_multa, int dias_atrasados){
		
		float multa = 0;
		
		// 200%
		if(valor_multa > 3 * aluguel.getValor_total()) {
			
			multa = valor_multa;
			System.out.println("multa > 200%");
		} if (valor_multa < 0) {
			
			MensagemFrame msg = new MensagemFrame("multa invalida");
			msg.setVisible(true);
		}

		// % por dia atrasado
		multa += aluguel.getValor_total() * (dias_atrasados / 10);
		
		aluguel.setValor_multa(multa);
		
	}
	
	public void registrarPagamento(){
		
	}
	
	public void registrarDevolucao(Aluguel aluguel, String valor_multa, String data_entregue) {
		
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
			
			RegistroReceita reg = new RegistroReceita(data, total);
			DatabaseController db_controller = new DatabaseController(Database.getInstance());
			db_controller.adicionarRegistroReceita(reg);
			db_controller.printReceita();
		}
		
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
