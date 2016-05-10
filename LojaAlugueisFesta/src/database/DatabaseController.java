package database;

import java.util.ArrayList;

import model.Aluguel;
import model.Cliente;
import model.Funcionario;
import model.Gerente;
import model.Peca;

public class DatabaseController {
	private static Database database;
	
	
	public DatabaseController(Database db){
		database = db;
	}

	public Database getDatabase() {
		return database;
	}

	public void setDatabase(Database db) {
		database = db;
	}
	
	public ArrayList<Gerente> getGerentes() {
		return database.getGerentes();
	}

	public void setGerentes(ArrayList<Gerente> gerentes) {
		database.setGerentes(gerentes);
	}

	public ArrayList<Funcionario> getFuncionarios() {
		return database.getFuncionarios();
	}

	public void setFuncionarios(ArrayList<Funcionario> funcionarios) {
		database.setFuncionarios(funcionarios);
	}

	public ArrayList<Cliente> getClientes() {
		return database.getClientes();
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		database.setClientes(clientes);
	}

	public ArrayList<Aluguel> getAlugueis() {
		return database.getAlugueis();
	}

	public void setAlugueis(ArrayList<Aluguel> alugueis) {
		database.setAlugueis(alugueis);
	}

	public ArrayList<Peca> getPecas() {
		return database.getPecas();
	}

	public void setPecas(ArrayList<Peca> estoque) {
		database.setPecas(estoque);
	}
	
	public void cadastrarCliente(Cliente c){
		database.adicionarCliente(c);
	}
	
	public void removerCliente(Cliente c){
		database.getClientes().remove(c);
	}
	
	public void removerCliente(String cpf){
		for (Cliente c : database.getClientes()){
			if (c.getCpf().equals(cpf)){
				database.getClientes().remove(c); // TO DO: Verificar se funciona
			}
		}
	}
	
	public void adicionarAluguel(Aluguel a){
		database.getAlugueis().add(a);
	}
	
	public void adicionarPecaEstoque(Peca p){
		database.getPecas().add(p);
	}
	
	public void removerPecaEstoque(int codigo){
		
		for(Peca p : database.getPecas()){
			if (p.getCodigo_peca() == codigo){
				database.getPecas().remove(p);
			}
		}
	}
}
