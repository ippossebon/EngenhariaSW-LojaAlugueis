package controller;
//import database.DatabaseController;
//package database;

import model.Cliente;

public class CadastroController {

	private Cliente cliente;
	
	public CadastroController(String nome, String cpf, String email, String telefone, String endereco){
		// verificar se dados sao validos
		// criar Cliente()
		// adicionar ao databasecontroller
		
		if(!this.validaNome(nome)) {
			
			return;
		}
		
		if(!this.validaCpf(cpf)) {
			
			return;
		}
		
		if(!this.validaEmail(cpf)) {
			
			return;
		}
		
		if(!this.validaTelefone(telefone)) {
			
			return;
		}
		
		if(!this.validaEndereco(endereco)) {
			
			return;
		}
		
		cliente = new Cliente(nome, cpf, email, endereco, telefone);
		//DatabaseController dbController = new DatabaseController();
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
