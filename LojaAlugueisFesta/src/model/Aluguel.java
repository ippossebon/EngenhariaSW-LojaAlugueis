package model;

import java.util.ArrayList;

import database.Database;
import database.DatabaseController;

public class Aluguel {
	private int id;
	private ArrayList<Peca> pecas;
	private ArrayList<Peca> pecas_devolucao;
	private Data data_inicio;
	private Data data_fim;
	private Data data_entrega;
	private String cpf_cliente;
	private float valor_total;
	private float valor_multa;
	private boolean entregue;

	public Aluguel(){
		
	}
	
	public Aluguel(ArrayList<Peca> carrinho, Data inicio, Data fim, Data entrega, String cpf_cliente, float total){
		this.setPecas(carrinho);
		this.setPecasDevolucao((ArrayList<Peca>) carrinho.clone());
		this.setData_inicio(inicio);
		this.setData_fim(fim);
		this.setData_entrega(entrega);
		this.setCpf_cliente(cpf_cliente);
		this.setValor_total(total);
		this.setValor_multa(0);
		this.setEntregue(false);
		
		DatabaseController dbc = new DatabaseController(Database.getInstance());
		this.setId(dbc.gerarNovoIdAluguel());
	}

	public ArrayList<Peca> getPecas() {
		return pecas;
	}

	public void setPecas(ArrayList<Peca> pecas) {
		this.pecas = pecas;
	}
	
	public ArrayList<Peca> getPecasDevolucao() {
		return pecas_devolucao;
	}

	public void setPecasDevolucao(ArrayList<Peca> pecas) {
		this.pecas_devolucao = pecas;
	}
	
	public void removePecaDevolucao(int codigo_peca) {
		int i = 0;
		Peca p = this.pecas_devolucao.get(i);
		
		while(p.getCodigo_peca() != codigo_peca && i < this.pecas_devolucao.size()){
			i++;
			p = this.pecas_devolucao.get(i);
		}
		if(p.getCodigo_peca() == codigo_peca){
			this.pecas_devolucao.get(i).setDisponivel(true);
			this.pecas_devolucao.remove(i);
		}
		else{
			System.out.println("Aluguel >> Erro ao remover peça da lista de devoluções: peça não encontrada.");
		}
	}
	
	public boolean devolveuTudo() {
		
		if(this.pecas_devolucao == null) {
			return true;
		} else {
			return false;
		}
	}

	public Data getData_inicio() {
		return data_inicio;
	}

	public void setData_inicio(Data data_inicio) {
		this.data_inicio = data_inicio;
	}

	public Data getData_fim() {
		return data_fim;
	}

	public void setData_fim(Data data_fim) {
		this.data_fim = data_fim;
	}

	public Data getData_entrega() {
		return data_entrega;
	}

	public void setData_entrega(Data data_entrega) {
		this.data_entrega = data_entrega;
	}

	public String getCpf_cliente() {
		return cpf_cliente;
	}

	public void setCpf_cliente(String cpf_cliente) {
		this.cpf_cliente = cpf_cliente;
	}

	public float getValor_total() {
		return valor_total;
	}

	public void setValor_total(float valor_total) {
		this.valor_total = valor_total;
	}

	public float getValor_multa() {
		return valor_multa;
	}

	public void setValor_multa(float valor_multa) {
		this.valor_multa = valor_multa;
	}

	public boolean isEntregue() {
		return entregue;
	}

	public void setEntregue(boolean entregue) {
		this.entregue = entregue;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void printAluguel(){
		System.out.println("ID: " + this.id);
		System.out.println("Peças: ");
		for (Peca p : this.pecas){
			System.out.println(p.getCodigo_peca() + " entregue: " + p.isDisponivel());
		}
		
		System.out.println("Peças para devolver:");
		for (Peca p : this.pecas_devolucao){
			System.out.print(p.getCodigo_peca() + " ");
		}
		
	}

}
