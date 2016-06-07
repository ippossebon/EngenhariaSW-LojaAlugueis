package model;

import java.util.Observable;

public class Peca{
	private int codigo_peca;
	private int tamanho;
	private int numero_alugueis;
	private String tipo;
	private float valor;
	private boolean disponivel;
	
	public Peca(int codigo, int tamanho, String tipo, float valor){
		this.setCodigo_peca(codigo);
		this.setTamanho(tamanho);
		this.setNumero_alugueis(0);
		this.setTipo(tipo);
		this.setValor(valor);
		this.setDisponivel(true);
	}
	
	public Peca(int codigo, int tamanho, int numero_alugueis, String tipo, float valor, boolean disponivel){
		this.setCodigo_peca(codigo);
		this.setTamanho(tamanho);
		this.setNumero_alugueis(numero_alugueis);
		this.setTipo(tipo);
		this.setValor(valor);
		this.setDisponivel(disponivel);
	}

	public int getCodigo_peca() {
		return codigo_peca;
	}

	public void setCodigo_peca(int codigo_peca) {
		this.codigo_peca = codigo_peca;
	}

	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

	public int getNumero_alugueis() {
		return numero_alugueis;
	}

	public void setNumero_alugueis(int numero_alugueis) {
		this.numero_alugueis = numero_alugueis;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}
	
	public void incAluguel() {
		
		this.numero_alugueis++;
	}
}
