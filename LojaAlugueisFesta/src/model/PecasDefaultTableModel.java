package model;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import database.Database;
import database.DatabaseController;

public class PecasDefaultTableModel extends DefaultTableModel{
	
	private DefaultTableModel dft;
	private ArrayList<Integer> codigos;
	private ArrayList<String> tipos;
	public DefaultTableModel getDft() {
		return dft;
	}

	public void setDft(DefaultTableModel dft) {
		this.dft = dft;
	}

	public ArrayList<Integer> getCodigos() {
		return codigos;
	}

	public void setCodigos(ArrayList<Integer> codigos) {
		this.codigos = codigos;
	}

	public ArrayList<String> getTipos() {
		return tipos;
	}

	public void setTipos(ArrayList<String> tipos) {
		this.tipos = tipos;
	}

	public ArrayList<Integer> getTamanhos() {
		return tamanhos;
	}

	public void setTamanhos(ArrayList<Integer> tamanhos) {
		this.tamanhos = tamanhos;
	}

	public ArrayList<String> getStatus() {
		return status;
	}

	public void setStatus(ArrayList<String> status) {
		this.status = status;
	}

	public ArrayList<Float> getValores() {
		return valores;
	}

	public void setValores(ArrayList<Float> valores) {
		this.valores = valores;
	}

	public ArrayList<Integer> getNumero_alugueis() {
		return numero_alugueis;
	}

	public void setNumero_alugueis(ArrayList<Integer> numero_alugueis) {
		this.numero_alugueis = numero_alugueis;
	}

	private ArrayList<Integer> tamanhos;
	private ArrayList<String> status;
	private ArrayList<Float> valores;
	private ArrayList<Integer> numero_alugueis;
	
	public PecasDefaultTableModel(){
		this.dft = new DefaultTableModel();
		
		this.codigos = new ArrayList<Integer>();
		this.tipos = new ArrayList<String>();
		this.tamanhos = new ArrayList<Integer>();
		this.status = new ArrayList<String>();
		this.valores = new ArrayList<Float>();
		this.numero_alugueis = new ArrayList<Integer>();
	}
	
	public PecasDefaultTableModel(ArrayList<Peca> pecas){
		this.dft = new DefaultTableModel();
		
		this.codigos = new ArrayList<Integer>();
		this.tipos = new ArrayList<String>();
		this.tamanhos = new ArrayList<Integer>();
		this.status = new ArrayList<String>();
		this.valores = new ArrayList<Float>();
		this.numero_alugueis = new ArrayList<Integer>();
		
		this.criaModel(pecas);
	}
	
	public void criaModel(ArrayList<Peca> pecas){
		if(!pecas.isEmpty()){
			for(Peca p : pecas){
				this.codigos.add(p.getCodigo_peca());
				this.tipos.add(p.getTipo());
				this.tamanhos.add(p.getTamanho());
				
				if (p.isDisponivel()){
					this.status.add("Disponível");
				}
				else{
					this.status.add("Alugada");
				}
				
				this.valores.add(p.getValor());
				this.numero_alugueis.add(p.getNumero_alugueis());
			}
			this.dft.addColumn("Código", this.codigos.toArray());
			this.dft.addColumn("Tipo", this.tipos.toArray());
			this.dft.addColumn("Tamanho", this.tamanhos.toArray());
			this.dft.addColumn("Status", this.status.toArray());
			this.dft.addColumn("Valor", this.valores.toArray());
			this.dft.addColumn("Número de alugueis", this.numero_alugueis.toArray());
		}
	}
	
	// Se o model em questão for destinado para exibir todas as peças do banco de dados.
	public void updateModelDatabase(){
		DatabaseController db_controller = new DatabaseController(Database.getInstance());
		
		this.codigos.clear();
		this.tipos.clear();
		this.tamanhos.clear();
		this.status.clear();
		this.valores.clear();
		this.numero_alugueis.clear();
		
		criaModel(db_controller.getPecas());
	}
}
