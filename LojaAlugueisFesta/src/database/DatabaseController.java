package database;

import java.util.ArrayList;

import model.Aluguel;
import model.Cliente;
import model.Funcionario;
import model.Gerente;
import model.Peca;

public class DatabaseController {
	private Database database;
	
	
	public DatabaseController(Database db){
		this.database = db;
	}

	public Database getDatabase() {
		return database;
	}

	public void setDatabase(Database database) {
		this.database = database;
	}
	
	public ArrayList<Gerente> getGerentes() {
		return this.database.getGerentes();
	}

	public void setGerentes(ArrayList<Gerente> gerentes) {
		this.database.setGerentes(gerentes);
	}

	public ArrayList<Funcionario> getFuncionarios() {
		return this.database.getFuncionarios();
	}

	public void setFuncionarios(ArrayList<Funcionario> funcionarios) {
		this.database.setFuncionarios(funcionarios);
	}

	public ArrayList<Cliente> getClientes() {
		return this.database.getClientes();
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.database.setClientes(clientes);
	}

	public ArrayList<Aluguel> getAlugueis() {
		return this.database.getAlugueis();
	}

	public void setAlugueis(ArrayList<Aluguel> alugueis) {
		this.database.setAlugueis(alugueis);
	}

	public ArrayList<Peca> getPecas() {
		return this.database.getPecas();
	}

	public void setPecas(ArrayList<Peca> estoque) {
		this.database.setPecas(estoque);
	}
	
	public void cadastrarCliente(Cliente c){
		this.database.adicionarCliente(c);
	}
	
	public void removerCliente(Cliente c){
		this.database.getClientes().remove(c);
	}
	
	public void removerCliente(String cpf){
		for (Cliente c : this.database.getClientes()){
			if (c.getCpf().equals(cpf)){
				this.database.getClientes().remove(c); // Verificar se funciona
			}
		}
	}
	
	public void adicionarAluguel(Aluguel a){
		this.database.getAlugueis().add(a);
	}
	
	public void adicionarPecaEstoque(Peca p){
		this.database.getPecas().add(p);
	}
	
	public void removerPecaEstoque(int codigo){
		
		for(Peca p : this.database.getPecas()){
			if (p.getCodigo_peca() == codigo){
				this.database.getPecas().remove(p);
			}
		}
	}
}
