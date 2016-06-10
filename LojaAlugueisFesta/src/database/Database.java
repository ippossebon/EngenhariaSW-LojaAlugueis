package database;

import java.util.ArrayList;

import model.Aluguel;
import model.Cliente;
import model.Data;
import model.Funcionario;
import model.Gerente;
import model.Peca;
import model.RegistroReceita;

public class Database{
	
	private static Database database;
	private ArrayList<Gerente> gerentes;
	private ArrayList<Funcionario> funcionarios;
	private ArrayList<Cliente> clientes;
	private ArrayList<Aluguel> alugueis;
	private ArrayList<Peca> pecas;
	private ArrayList<RegistroReceita> receita;
	
	private Database(){
		this.setGerentes(new ArrayList<Gerente>());
		this.setFuncionarios(new ArrayList<Funcionario>());
		this.setClientes(new ArrayList<Cliente>());
		this.setAlugueis(new ArrayList<Aluguel>());
		this.setPecas(new ArrayList<Peca>());
		this.setReceita(new ArrayList<RegistroReceita>());
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
		
		System.out.println("PEÇAS:");
		for(Peca p: this.pecas){
			System.out.println(p.getTipo());
		}
		System.out.println();
		
		System.out.println("ALUGUEIS: ");
		for (Aluguel a: this.alugueis){
			System.out.println("* Aluguel para: " + a.getCpf_cliente());
			System.out.print("Peças: ");
			for (Peca p: a.getPecas()){
				System.out.print(p.getCodigo_peca() + " ");
			}
			System.out.println("Data inicio: " + a.getData_inicio().gerarString());
		}
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
	
	public void adicionarPeca(Peca p){
		this.pecas.add(p);
	}
	
	public void removerPeca(Peca p){
		this.pecas.remove(p);
	}
	
	public void adicionarAluguel(Aluguel a){
		this.alugueis.add(a);
	}
	
	public void removerAluguel(Aluguel a){
		this.alugueis.remove(a);
	}
	
	public void popularDatabase(){
		
		/* Clientes */
		Cliente c1 = new Cliente("Ana Ribeiro", "123.233.111-11", "anar@gmail.com", "Rua A, 123", "(51) 3333 3333");
		c1.setBloqueado(true);
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
		Funcionario f1 = new Funcionario("Isadora Possebon", "222.222.222-22", "isadorapossebon@gmail.com", "Rua B 123", "(51) 2222 2222", "senha");
		Database.database.cadastrarFuncionario(f1);
		
		Funcionario f2 = new Funcionario("Victoria Simonetti", "000.000.000-00", "victoria@gmail.com", "Rua Bento Goncalves 99", "(51) 2222 9999", "senha");
		Database.database.cadastrarFuncionario(f2);
		
		Funcionario f3 = new Funcionario("Lucas", "111.111.111-11", "lucas@gmail.com", "Rua A 12223", "(51) 8888 7777", "senha");
		Database.database.cadastrarFuncionario(f3);
		
		/* Gerentes */
		Gerente g1 = new Gerente("Isadora Possebon", "222.222.222-22", "isadorapossebon@gmail.com", "Rua B 123", "(51) 2222 2222", "senha");
		Database.database.cadastrarGerente(g1);
		
		Gerente g2 = new Gerente("Victoria Simonetti", "000.000.000-00", "victoria@gmail.com", "Rua Bento Goncalves 99", "(51) 2222 9999", "senha");
		Database.database.cadastrarGerente(g2);
		
		/* Peças */
		// Codigo, tamanho, tipo, valor
		Peca p1 = new Peca(1, 40, "Gravata normal", (float)15.00);
		Database.database.adicionarPeca(p1);
		
		Peca p2 = new Peca(2, 42, "Gravata normal", (float)15.00);
		Database.database.adicionarPeca(p2);
		
		Peca p3 = new Peca(3, 42, 1, "Gravata normal", (float)15.00, false);
		Database.database.adicionarPeca(p3);
		
		Peca p4 = new Peca(4, 44, "Gravata borboleta", (float)15.00);
		Database.database.adicionarPeca(p4);
		
		Peca p5 = new Peca(5, 40, "Gravata borboleta", (float)15.00);
		Database.database.adicionarPeca(p5);
		
		Peca p6 = new Peca(6, 42, "Gravata borboleta", (float)15.00);
		Database.database.adicionarPeca(p6);
		
		Peca p7 = new Peca(7, 38, "Sapato masculino", (float)25.00);
		Database.database.adicionarPeca(p7);
		
		Peca p8 = new Peca(8, 40, "Sapato masculino", (float)25.00);
		Database.database.adicionarPeca(p8);
		
		Peca p9 = new Peca(9, 41, "Sapato masculino", (float)25.00);
		Database.database.adicionarPeca(p9);
		
		Peca p10 = new Peca(10, 43, "Sapato masculino", (float)25.00);
		Database.database.adicionarPeca(p10);
		
		Peca p11 = new Peca(11, 40, "Terno com corte italiano", (float)100.00);
		Database.database.adicionarPeca(p11);
		
		Peca p12 = new Peca(12, 42, "Terno com corte italiano", (float)100.00);
		Database.database.adicionarPeca(p12);
		
		Peca p13 = new Peca(13, 42, "Terno com corte inglês", (float)85.00);
		Database.database.adicionarPeca(p13);
		
		Peca p14 = new Peca(14, 50, "Terno com corte inglês", (float)85.00);
		Database.database.adicionarPeca(p14);
		
		Peca p15 = new Peca(15, 52, "Terno com corte tradicional", (float)70.00);
		Database.database.adicionarPeca(p15);
		
		Peca p16 = new Peca(16, 48, "Terno com corte tradicional", (float)70.00);
		Database.database.adicionarPeca(p16);
		
		Peca p17 = new Peca(17, 44, "Fraque", (float)120.00);
		Database.database.adicionarPeca(p17);
		
		Peca p18 = new Peca(18, 42, "Fraque", (float)120.00);
		Database.database.adicionarPeca(p18);
		
		Peca p20 = new Peca(20, 46, "Calça social básica", (float)40.00);
		Database.database.adicionarPeca(p20);
		
		Peca p19 = new Peca(19, 40, "Calça social básica", (float)40.00);
		Database.database.adicionarPeca(p19);
		
		Peca p21 = new Peca(21, 42, "Calça social larga", (float)50.00);
		Database.database.adicionarPeca(p21);
		
		Peca p22 = new Peca(22, 44, "Calça social larga", (float)50.00);
		Database.database.adicionarPeca(p22);
		
		Peca p23 = new Peca(23, 44, "Calça social em microfibra", (float)65.00);
		Database.database.adicionarPeca(p23);
		
		Peca p24 = new Peca(24, 40, "Calça social em microfibra", (float)65.00);
		Database.database.adicionarPeca(p24);
		
		Peca p25 = new Peca(25, 40, "Camisa social de colarinho de pontas abertas", (float)25.00);
		Database.database.adicionarPeca(p25);
		
		Peca p26 = new Peca(26, 42, "Camisa social de colarinho de pontas abertas", (float)25.00);
		Database.database.adicionarPeca(p26);
		
		Peca p27 = new Peca(27, 44, "Camisa social de colarinho de pontas abertas", (float)25.00);
		Database.database.adicionarPeca(p27);
		
		Peca p28 = new Peca(28, 40, "Camisa social de presilha", (float)35.00);
		Database.database.adicionarPeca(p28);
		
		Peca p29 = new Peca(29, 42, "Camisa social de presilha", (float)35.00);
		Database.database.adicionarPeca(p29);
		
		Peca p30 = new Peca(30, 44, "Camisa social de presilha", (float)35.00);
		Database.database.adicionarPeca(p30);
		
		Peca p31 = new Peca(31, 40, "Camisa social de colarinho arredondado", (float)40.00);
		Database.database.adicionarPeca(p31);
		
		Peca p32 = new Peca(32, 42, "Camisa social de colarinho arredondado", (float)40.00);
		Database.database.adicionarPeca(p32);
		
		Peca p33 = new Peca(33, 46, "Camisa social de colarinho arredondado", (float)40.00);
		Database.database.adicionarPeca(p33);
		
		Peca p34 = new Peca(34, 34, "Vestido longo", (float)200.00);
		Database.database.adicionarPeca(p34);
		
		Peca p35 = new Peca(35, 38, "Vestido longo", (float)200.00);
		Database.database.adicionarPeca(p35);
		
		Peca p36 = new Peca(36, 42, "Vestido longo", (float)200.00);
		Database.database.adicionarPeca(p36);
		
		Peca p37 = new Peca(37, 40, "Vestido longo bordado", (float)250.00);
		Database.database.adicionarPeca(p37);
		
		Peca p38 = new Peca(38, 38, "Vestido longo bordado", (float)250.00);
		Database.database.adicionarPeca(p38);
		
		Peca p39 = new Peca(39, 44, "Vestido longo bordado", (float)250.00);
		Database.database.adicionarPeca(p39);
		
		Peca p40 = new Peca(40, 42, "Vestido curto", (float)150.00);
		Database.database.adicionarPeca(p40);
		
		Peca p41 = new Peca(41, 40, "Vestido curto", (float)150.00);
		Database.database.adicionarPeca(p41);
		
		Peca p42 = new Peca(42, 38, "Vestido curto", (float)150.00);
		Database.database.adicionarPeca(p42);
		
		Peca p43 = new Peca(43, 38, "Vestido curto bordado", (float)175.00);
		Database.database.adicionarPeca(p43);
		
		Peca p44 = new Peca(44, 42, "Vestido curto bordado", (float)175.00);
		Database.database.adicionarPeca(p44);
		
		Peca p45 = new Peca(45, 46, "Vestido curto bordado", (float)175.00);
		Database.database.adicionarPeca(p45);
		
		Peca p46 = new Peca(46, 38, "Sapato feminino", (float)25.00);
		Database.database.adicionarPeca(p46);
		
		Peca p47 = new Peca(47, 35, "Sapato feminino", (float)25.00);
		Database.database.adicionarPeca(p47);
		
		Peca p48 = new Peca(48, 39, "Sapato feminino", (float)25.00);
		Database.database.adicionarPeca(p48);
		
		ArrayList<Peca> pecas = new ArrayList<Peca>();
		pecas.add(p48);
		pecas.add(p47);
		Data inicio = new Data(8, 06, 2016);
		Data entrega = new Data(12, 06, 2016);
		Aluguel a = new Aluguel(pecas, inicio, null, entrega, "187.654.321-25", (float)50.0);
		Database.database.adicionarAluguel(a);
		
		ArrayList<Peca> pecas2 = new ArrayList<Peca>();
		pecas2.add(p45);
		pecas2.add(p44);
		Data inicio2 = new Data(8, 06, 2016);
		Data entrega2 = new Data(12, 06, 2016);
		Aluguel a2 = new Aluguel(pecas2, inicio2, null, entrega2, "187.654.321-25", (float)350.0);
		Database.database.adicionarAluguel(a2);
	}

	public int gerarNovoCodigoPeca(){
		int novo_codigo = 49; // 49 é o código da última peça adicionada em popularDatabase()
		
		for (Peca p : database.getPecas()){
			if (p.getCodigo_peca() == novo_codigo){
				novo_codigo++;
			}
		}
		
		return novo_codigo;
	}
	
	public int gerarNovoIdAluguel(){
		int count = 0;
		
		for (Aluguel a : database.getAlugueis()){
			if (a.getId() == count){
				count++;
			}
		}
		return count;
	}

	public ArrayList<RegistroReceita> getReceita() {
		return receita;
	}

	public void setReceita(ArrayList<RegistroReceita> receita) {
		this.receita = receita;
	}
	
	public void adicionarRegistroReceita(RegistroReceita reg){
		this.receita.add(reg);
	}
	
	public void removerRegistroReceita(RegistroReceita reg){
		this.receita.remove(reg);
	}
	
	public void printReceita(){
		System.out.println(">>>>> RECEITA <<<<<<");
		for(int i = 0; i < this.receita.size(); i++){
			System.out.println(i + " - " + this.receita.get(i).getData().gerarString() + " - " + this.receita.get(i).getValor());
		}
	}
}



