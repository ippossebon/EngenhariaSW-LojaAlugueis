package controller;
//import database.DatabaseController;
//package database;

import model.Cliente;
import database.Database;
import database.DatabaseController;

public class CadastroController {

	private Cliente cliente;
	
	public CadastroController(String nome, String cpf, String email, String telefone, String endereco){
		
	}
	
	public void cadastraCliente(String nome, String cpf, String email, String telefone, String endereco) {
		
		if(!this.validaNome(nome)) {
			
			throw new NomeInvalidoException("Nome invalido.");
		}

		
		if(!this.validaCpf(cpf)) {
			
			throw new CPFInvalidoException("CPF invalido.");
		}
		
		if(!this.validaEmail(email)) {
			
			throw new EmailInvalidoException("Email invalido.");
		}
		
		if(!this.validaTelefone(telefone)) {
			
			throw new TelefoneInvalidoException("Telefone invalido.");
		}
		
		if(!this.validaEndereco(endereco)) {
			
			throw new EnderecoInvalidoException("Endereco invalido.");
		}
		
		cliente = new Cliente(nome, cpf, email, endereco, telefone);
		DatabaseController dbController = new DatabaseController(Database.getInstance());
		dbController.cadastrarCliente(cliente);
	}
	
	public boolean validaNome(String nome) {
		
		if(this.stringVazia(nome) || this.contemNumero(nome)) {
			
			return false;
		}
		
		return true;
	}
	
	public boolean validaCpf(String cpf) {
		
		if(this.stringVazia(cpf) || this.contemLetras(cpf)) {
			
			return false;
		}
		
		return true;
	}
	
	public boolean validaEmail(String email) {
		
		if(this.stringVazia(email)) {
			
			return false;
		}
		
		return true;
	}
	
	public boolean validaTelefone(String telefone){
		
		if(this.stringVazia(telefone) || this.contemLetras(telefone)) {
			
			return false;
		}
		
		return true;
	}

	public boolean validaEndereco(String endereco) {
		
		if(this.stringVazia(endereco)) {
			
			return false;
		}
		
		return true;
	}
	
	public boolean stringVazia(String str) {
		
		return str.trim().equals("");
	}
	
	// contém caracteres 0-9
	public boolean contemNumero(String str) {
		
		return str.contains("^[0-9]");
	}
	
	// contém caracteres a-z A-Z
	public boolean contemLetras(String str) {
		
		return str.contains("^[a-Z]");
	}
	
}
