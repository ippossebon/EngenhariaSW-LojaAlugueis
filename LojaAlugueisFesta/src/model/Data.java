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
		this.dia = Integer.parseInt(d.substring(0, 1));
		this.mes = Integer.parseInt(d.substring(3,4));
		this.ano = Integer.parseInt(d.substring(6,9));
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
	
	public int converteDataParaDia(Data d) {
		
		int dias = 0;
		
		dias = d.getDia() + d.getMes() * this.retornaDiadoMes(d.getMes()) + d.getAno() * 365;
		
		return dias;
		
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
