package controller;

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
	
	public boolean validaLogin(){
		
		// Cria PesquisaController();
		// Verifica se funcionário consta no banco de dados
		// Verifica se a senha fornecida corresponde à senha do funcionario.
		// Cpf e senha ok: true; define variavel "gerente". false, caso contrário.
		
		return false;
	}

	public boolean isGerente() {
		return gerente;
	}

	public void setGerente(boolean gerente) {
		this.gerente = gerente;
	}
	
}
