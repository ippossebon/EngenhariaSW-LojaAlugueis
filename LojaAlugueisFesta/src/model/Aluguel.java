package model;

import java.util.ArrayList;

import database.Database;
import database.DatabaseController;

public class Aluguel {
	private int id;
	private ArrayList<Peca> pecas;
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

}
