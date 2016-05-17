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
		Cliente c1 = new Cliente("Ana Ribeiro", "123.233.111-11", "anar@gmail.com", "Rua A, 123", "(51) 3333 3333");
		Database.database.cadastrarCliente(c1);
		
		Cliente c2 = new Cliente("João Pedro", "000.000.111-23", "joaop@gmail.com", "Rua B, 123", "(51) 2222 3333");
		Database.database.cadastrarCliente(c2);
		
		Cliente c3 = new Cliente("Joana Silva", "443.233.111-11", "joanas@gmail.com", "Rua X, 22", "(51) 2222 8888");
		Database.database.cadastrarCliente(c3);
		
		Cliente c4 = new Cliente("Marcos X. Almeida", "888.888.122-23", "marcosx@gmail.com", "Rua SSS, 123", "(51) 8181 3333");
		Database.database.cadastrarCliente(c4);
		
		Cliente c5 = new Cliente("Beatriz Ramos", "123.456.789-10", "beatrizr@gmail.com", "Rua Beta, 124", "(51) 3233 3435");
		Database.database.cadastrarCliente(c5);
		
		Cliente c6 = new Cliente("Sofia Abraão", "123.456.789-12", "sofiaa@gmail.com", "Rua Afonso , 126", "(51) 3233 3437");
		Database.database.cadastrarCliente(c6);
		
		Cliente c7 = new Cliente("Isabela Fiorentino", "123.456.789-13", "isabelaf@gmail.com", "Rua Flores , 127", "(51) 3233 3438");
		Database.database.cadastrarCliente(c7);
		
		Cliente c8 = new Cliente("Camila Soares", "123.456.789-14", "camilas@gmail.com", "Rua Fampas , 128", "(51) 3233 3439");
		Database.database.cadastrarCliente(c8);
		
		Cliente c9 = new Cliente("Luana Costa", "123.456.789-15", "luanac@gmail.com", "Rua Rosas , 129", "(51) 3233 3440");
		Database.database.cadastrarCliente(c9);
		
		Cliente c10 = new Cliente("Luana Pinto", "123.456.789-16", "luanap@gmail.com", "Rua Violetas , 129", "(51) 3233 3441");
		Database.database.cadastrarCliente(c10);
		
		Cliente c11 = new Cliente("Luana Conde Correa", "123.456.789-17", "luanacc@gmail.com", "Rua Vasconcelos , 130", "(51) 3233 3442");
		Database.database.cadastrarCliente(c11);
		
		Cliente c12 = new Cliente("Carmen das Flores", "123.456.789-18", "carmenf@gmail.com", "Rua Piratini, 131", "(51) 3233 3443");
		Database.database.cadastrarCliente(c12);
		
		Cliente c13 = new Cliente("Antonia Almeida", "123.456.789-19", "antoniaa@gmail.com", "Rua Armindo, 132", "(51) 3233 3444");
		Database.database.cadastrarCliente(c13);
		
		Cliente c14 = new Cliente("Luiza Gonçalves", "123.456.789-20", "luizag@gmail.com", "Rua Bento Gonçalves, 133", "(51) 3233 3445");
		Database.database.cadastrarCliente(c14);
		
		Cliente c15 = new Cliente("Fátima Farias", "123.456.789-21", "fatimaf@gmail.com", "Rua Coronel Vicente, 134", "(51) 3233 3446");
		Database.database.cadastrarCliente(c15);
		
		Cliente c16 = new Cliente("Arnaldo Antunes", "187.654.321-22", "arnaldoa@gmail.com", "Rua Lima e Silva, 135", "(51) 3233 3447");
		Database.database.cadastrarCliente(c16);
		
		Cliente c17 = new Cliente("Laura Vargas", "123.456.789-11", "laurav@gmail.com", "Rua Alameda dos Ricos, 125", "(51) 3233 3436");
		Database.database.cadastrarCliente(c17);
		
		Cliente c18 = new Cliente("Otávio Gomes", "187.654.321-23", "otaviog@gmail.com", "Rua Alameda dos Pobres, 136", "(51) 3233 3448");
		Database.database.cadastrarCliente(c18);
		
		Cliente c19 = new Cliente("Árton Dorneles", "187.654.321-24", "artond@gmail.com", "Av. Paraná, 136", "(51) 3233 3449");
		Database.database.cadastrarCliente(c19);
		
		Cliente c20 = new Cliente("Amanda Torbes", "187.654.321-25", "amandat@gmail.com", "Av. Buriti, 137", "(51) 3233 3450");
		Database.database.cadastrarCliente(c20);
		
		Cliente c21 = new Cliente("Breno Portella", "187.654.321-26", "brenop@gmail.com", "Av. Júlio de Castilhos, 138", "(51) 3233 3451");
		Database.database.cadastrarCliente(c21);
		
		Cliente c22 = new Cliente("Lorenzo da Cunha", "187.654.321-27", "lorenzoc@gmail.com", "Av. Carlos Gomes, 222", "(51) 3233 3452");
		Database.database.cadastrarCliente(c22);
		
		Cliente c23 = new Cliente("Claudio Lucca", "187.654.321-28", "claudiol@gmail.com", "Av. Carlos Barbosa, 223", "(51) 3233 3453");
		Database.database.cadastrarCliente(c23);
		
		Cliente c24 = new Cliente("Marjara Dorneles", "187.654.321-29", "marjarad@gmail.com", "Rua Conde de Porto Alegre, 245", "(51) 3233 3454");
		Database.database.cadastrarCliente(c24);
		
		Cliente c25 = new Cliente("Eva Pereira", "187.654.321-30", "evapereira@gmail.com", "Rua Marechal Floriano, 246", "(51) 3233 3455");
		Database.database.cadastrarCliente(c25);
		
		Cliente c26 = new Cliente("Evandro Mesquita", "187.654.321-31", "evandrom@gmail.com", "Rua Uruguai, 243", "(51) 3233 3456");
		Database.database.cadastrarCliente(c26);
		
		Cliente c27 = new Cliente("Carlo Sartori", "187.654.321-32", "carlos@gmail.com", "Rua das Montanhas, 244", "(51) 3233 3457");
		Database.database.cadastrarCliente(c27);
		
		Cliente c28 = new Cliente("Candida Reis", "187.654.321-33", "candidar@gmail.com", "Rua Colinas, 245", "(51) 3233 3458");
		Database.database.cadastrarCliente(c28);
		
		Cliente c29 = new Cliente("Luiza Borges", "187.654.321-34", "luizab@gmail.com", "Rua Dr. Turi, 154", "(51) 3233 3556");
		Database.database.cadastrarCliente(c29);
		
		Cliente c30 = new Cliente("Leonel Borba", "187.654.321-35", "leonelb@gmail.com", "Rua Cururi, 155", "(51) 3233 3557");
		Database.database.cadastrarCliente(c30);
		
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



