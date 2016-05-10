package controller;

import java.util.ArrayList;

import model.Funcionario;

public class LoginController {
	
	private String cpf_usuario;
	private String senha_usuario;
	private boolean gerente; // indica se a interface que devemos utilizar é a de gerente ou funcionario
	
	public LoginController(String cpf, String senha){
		this.cpf_usuario = cpf;
		this.senha_usuario = senha;
	}

	public String getCpf_usuario() {
		return cpf_usuario;
	}

	public void setCpf_usuario(String cpf_usuario) {
		this.cpf_usuario = cpf_usuario;
	}

	public String getSenha_usuario() {
		return senha_usuario;
	}

	public void setSenha_usuario(String senha_usuario) {
		this.senha_usuario = senha_usuario;
	}
	
	/* Retorna true se o formato está correto; false, caso contrário. */
	public boolean validaFormatoCpf(){
		
		return false;
	}
	
	/* Garante que o campo de senha não estará vazio. */
	public boolean validaFormatoSenha(){
		if (this.senha_usuario.isEmpty()){
			return false;
		}
		return true;
	}
	
	/* Retorna true se o login está correto (cpf e senha têm correspondência) ; false, caso contrário */
	public boolean validaLogin(){
		
		PesquisaController pesquisa_controller = new PesquisaController();
		ArrayList<Funcionario> funcionarios = pesquisa_controller.pesquisarFuncionarioPorCPF(this.cpf_usuario);
		
		if (funcionarios.size() != 1){
			Funcionario funcionario = funcionarios.get(0);
			
			if(funcionario.getSenha().equals(this.senha_usuario)){
				
				// TO DO: Verifica se é gerente. Seta a variavel gerente
				
				return true;
			}
		}

		return false;
	}

	public boolean isGerente() {
		return gerente;
	}

	public void setGerente(boolean gerente) {
		this.gerente = gerente;
	}
	
}
