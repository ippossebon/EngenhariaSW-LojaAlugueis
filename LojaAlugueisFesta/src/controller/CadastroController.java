package controller;

import model.Cliente;

public class CadastroController {

	private Cliente cliente;
	
	public CadastroController(String nome, String cpf, String email, String telefone, String endereco){
		// verificar se dados sao validos
		// criar Cliente()
		// adicionar ao databasecontroller
		
		
		cliente = new Cliente(nome, cpf, email, endereco, telefone);
	}
	
	public boolean validaNome(String nome) {
		
		if(this.stringVazia(nome) || this.contemNumero(nome)) {
			
			return false;
		}
		
		return true;
	}
	
	public boolean validaCpf(String cpf) {
		
		return true;
	}
	
	public boolean validaEmail(String email) {
		
		return true;
	}
	
	public boolean validaTelefone(String telefone){
		
		return true;
	}

	public boolean validaEndereco(String endereco) {
		
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
