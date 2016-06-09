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
		database.cadastrarCliente(c);
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
	
	public void cadastrarFuncionario(Funcionario f){
		database.cadastrarFuncionario(f);
	}
	
	public void adicionarAluguel(Aluguel a){
		database.getAlugueis().add(a);
	}
	
	public void adicionarPecaEstoque(Peca p){
		database.getPecas().add(p);
	}
	
	public void removerPecaEstoque(int codigo){
		int indice = -1;
		
		for (int i = 0; i < database.getPecas().size(); i++){
			if (database.getPecas().get(i).getCodigo_peca() == codigo){
				indice = i;
			}
		}
		
		if (indice!= -1){
			database.getPecas().remove(indice);
		}
		
	}
	
	public void cadastrarGerente(Gerente g){
		database.cadastrarGerente(g);
	}
	
	public void printDatabase(){
		database.printDatabase();
	}
	
	public boolean isGerente(String cpf){
		return database.isGerente(cpf);
	}
	
	public ArrayList<Peca> getPecasDisponiveis(){
		return database.getPecasDisponiveis();
	}
	
	public ArrayList<Peca> getPecasAlugadas(){
		return database.getPecasAlugadas();
	}
	
	public void popularDatabase(){
		database.popularDatabase();
	}
	
	public int gerarNovoCodigoPeca(){
		return database.gerarNovoCodigoPeca();
	}
	
	public int gerarNovoIdAluguel(){
		return database.gerarNovoIdAluguel();
	}
}
