package database;

import java.util.ArrayList;

import model.Aluguel;
import model.Cliente;
import model.Funcionario;
import model.Gerente;
import model.Peca;

public class Database {
	private static int pesquisa_todas = 0;
	private static int pesquisa_disponiveis = 1;
	private static int pesquisa_alugadas = 2;
	
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
	
	public void adicionarCliente(Cliente c){
		this.clientes.add(c);
	}
	
	public void adicionarFuncionario(Funcionario f){
		this.funcionarios.add(f);
	}
	
	public void adicionarGerente(Gerente g){
		this.gerentes.add(g);
	}
	
	public Database getDatabase() {
		return database;
	}

	public void setDatabase(Database database) {
		Database.database = database;
	}

	public static int getPesquisa_todas() {
		return pesquisa_todas;
	}

	public static void setPesquisa_todas(int pesquisa_todas) {
		Database.pesquisa_todas = pesquisa_todas;
	}

	public static int getPesquisa_disponiveis() {
		return pesquisa_disponiveis;
	}

	public static void setPesquisa_disponiveis(int pesquisa_disponiveis) {
		Database.pesquisa_disponiveis = pesquisa_disponiveis;
	}

	public static int getPesquisa_alugadas() {
		return pesquisa_alugadas;
	}

	public static void setPesquisa_alugadas(int pesquisa_alugadas) {
		Database.pesquisa_alugadas = pesquisa_alugadas;
	}
	
	public void popularDatabase(){
		Cliente c1 = new Cliente("Ana", "12345612323", "ana@gmail.com", "Rua A, 123", "(51) 3333 3333");
		Database.database.adicionarCliente(c1);
		
		Funcionario f1 = new Funcionario("Isadora", "034.455.120-28", "isadorapossebon@gmail.com", "Rua B 123", "(51) 2222 2222", "senha");
		Database.database.adicionarFuncionario(f1);
		
		Gerente g1 = new Gerente("Isadora", "034.455.120-28", "isadorapossebon@gmail.com", "Rua B 123", "(51) 2222 2222", "senha");
		Database.database.adicionarGerente(g1);
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
}



