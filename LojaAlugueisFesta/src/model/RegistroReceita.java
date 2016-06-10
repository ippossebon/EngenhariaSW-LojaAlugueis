package model;

public class RegistroReceita {

	private Data data;
	private double valor;
	
	public RegistroReceita(){
		
	}
	
	public RegistroReceita(Data data, double valor){
		this.setData(data);
		this.setValor(valor);
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
}
