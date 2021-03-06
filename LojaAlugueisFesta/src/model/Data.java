package model;

public class Data {
	private int dia;
	private int mes;
	private int ano;
	
	public Data(int dia, int mes, int ano){
		this.setDia(dia);
		this.setMes(mes);
		this.setAno(ano);
	}
	
	/* Formato ##/##/#### */
	public Data(String d){
		String[] data;
		data = d.split("/");
		this.dia = Integer.parseInt(data[0]);
		this.mes = Integer.parseInt(data[1]);
		this.ano = Integer.parseInt(data[2]);
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}
	
	public boolean isEqual(Data d){
		if (this.dia == d.getDia()){
			if (this.mes == d.getMes()){
				if (this.ano == d.getAno()){
					return true;
				}
			}
		}
		return false;
	}
	
	public int converteDataParaDia() {
		
		int dias = 0;
		dias = this.getDia();
	
		// -1 porque quando se pega o dia, já se considera o mês atual. ex.: 07/06/2015 -> ao contar os 7 dias, o mês de junho (6) já foi contabilizado
		// -1 porque o array de mes é de 0 a 11
		for(int i = this.getMes() - 2; i >= 0; i--) {
			
			dias += this.retornaDiadoMes(i);
		}
		
		dias += (this.getAno() - 1) * 365;
		
		return dias;
		
	}
	
	public boolean validaData() {
		
		if((this.dia < 1) || (this.dia > this.retornaDiadoMes(this.mes - 1))) {
			
			return false;
		} else {
			return true;
		}
	}
	
	public boolean intervaloValido(Data inicio, Data fim) {
		
		if((fim.converteDataParaDia() - inicio.converteDataParaDia()) <= 0) {
		
			return false;
		} else {
			
			return true;
		}
		
	}
	
	public int retornaDiadoMes(int mes) {
		
		int[] meses = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		return meses[mes]; 
		
	}
	
	public String gerarString(){
		String data = "";
		data = String.valueOf(this.dia) + "/" + String.valueOf(this.mes) + "/" + String.valueOf(this.ano);
		
		return data;
	}
}
