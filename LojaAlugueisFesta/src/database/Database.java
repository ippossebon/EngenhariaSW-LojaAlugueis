package database;

import java.util.ArrayList;

import model.Aluguel;
import model.Cliente;
import model.Funcionario;
import model.Gerente;
import model.Peca;

public class Database {
	
	private static Database database;
	private ArrayList<Gerente> gerentes;
	private ArrayList<Funcionario> funcionarios;
	private ArrayList<Cliente> clientes;
	private ArrayList<Aluguel> alugueis;
	private ArrayList<Peca> pecas;
	
	private Database(){
		this.setGerentes(new ArrayList<Gerente>());
		this.setFuncionarios(new ArrayList<Funcionario>());
		this.setClientes(new ArrayList<Cliente>());
		this.setAlugueis(new ArrayList<Aluguel>());
		this.setPecas(new ArrayList<Peca>());
	}
	
	public static synchronized Database getInstance() {
		if (database == null)
			database = new Database();

		return database;
	}

	public ArrayList<Gerente> getGerentes() {
		return gerentes;
	}

	public void setGerentes(ArrayList<Gerente> gerentes) {
		this.gerentes = gerentes;
	}

	public ArrayList<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(ArrayList<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}

	public ArrayList<Aluguel> getAlugueis() {
		return alugueis;
	}

	public void setAlugueis(ArrayList<Aluguel> alugueis) {
		this.alugueis = alugueis;
	}

	public ArrayList<Peca> getPecas() {
		return this.pecas;
	}

	public void setPecas(ArrayList<Peca> estoque) {
		this.pecas = estoque;
	}
	
	public void cadastrarCliente(Cliente c){
		this.clientes.add(c);
	}
	
	public void cadastrarFuncionario(Funcionario f){
		this.funcionarios.add(f);
	}
	
	public void cadastrarGerente(Gerente g){
		this.gerentes.add(g);
	}
	
	public Database getDatabase() {
		return database;
	}

	public void setDatabase(Database database) {
		Database.database = database;
	}
	
	public void popularDatabase(){
		
		/* Clientes */
		Cliente c1 = new Cliente("Ana", "123.233.111-11", "ana@gmail.com", "Rua A, 123", "(51) 3333 3333");
		Database.database.cadastrarCliente(c1);
		
		Cliente c2 = new Cliente("João Pedro", "000.000.111-23", "joao@gmail.com", "Rua B, 123", "(51) 2222 3333");
		Database.database.cadastrarCliente(c2);
		
		Cliente c3 = new Cliente("Joana", "443.233.111-11", "joana@gmail.com", "Rua X, 22", "(51) 2222 8888");
		Database.database.cadastrarCliente(c3);
		
		Cliente c4 = new Cliente("Marcos X. Almeida", "888.888.122-23", "marcosx@gmail.com", "Rua SSS, 123", "(51) 8181 3333");
		Database.database.cadastrarCliente(c4);
		
		/* Funcionários */
		Funcionario f1 = new Funcionario("Isadora Possebon", "034.455.120-28", "isadorapossebon@gmail.com", "Rua B 123", "(51) 2222 2222", "senha");
		Database.database.cadastrarFuncionario(f1);
		
		Funcionario f2 = new Funcionario("Victoria Simonetti", "000.000.000-00", "victoria@gmail.com", "Rua Bento Goncalves 99", "(51) 2222 9999", "senha");
		Database.database.cadastrarFuncionario(f2);
		
		Funcionario f3 = new Funcionario("Lucas", "111.111.111-11", "lucas@gmail.com", "Rua A 12223", "(51) 8888 7777", "senha");
		Database.database.cadastrarFuncionario(f3);
		
		/* Gerentes */
		Gerente g1 = new Gerente("Isadora", "034.455.120-28", "isadorapossebon@gmail.com", "Rua B 123", "(51) 2222 2222", "senha");
		Database.database.cadastrarGerente(g1);
		
		Gerente g2 = new Gerente("Victoria Simonetti", "000.000.000-00", "victoria@gmail.com", "Rua Bento Goncalves 99", "(51) 2222 9999", "senha");
		Database.database.cadastrarGerente(g2);
		
		/* Peças */
	}
	
	public void printDatabase(){
		System.out.println("** Database **");
		System.out.println("GERENTES:");
		for(Gerente g: this.gerentes){
			System.out.println(g.getNome());
		}
		System.out.println(" ");
		
		System.out.println("FUNCIONARIOS:");
		for(Funcionario f: this.funcionarios){
			System.out.println(f.getNome());
		}
		System.out.println();
		
		System.out.println("CLIENTES:");
		for(Cliente c: this.clientes){
			System.out.println(c.getNome());
		}
		System.out.println();
		
		System.out.print("PEÇAS:");
		for(Peca p: this.pecas){
			System.out.println(p.getTipo());
		}
		System.out.println();
	}
	
	public boolean isGerente(String cpf){
		
		for (Gerente g: this.gerentes){
			if(g.getCpf().equals(cpf)){
				return true;
			}
		}
		
		return false;
	}
	
	public ArrayList<Peca> getPecasDisponiveis(){
		ArrayList<Peca> resultado = new ArrayList<Peca>();
		
		for(Peca p : this.pecas){
			if(p.isDisponivel()){
				resultado.add(p);
			}
		}
		return resultado;
	}
	
	public ArrayList<Peca> getPecasAlugadas(){
		ArrayList<Peca> resultado = new ArrayList<Peca>();
		
		for(Peca p : this.pecas){
			if(!p.isDisponivel()){
				resultado.add(p);
			}
		}
		return resultado;
	}
}



