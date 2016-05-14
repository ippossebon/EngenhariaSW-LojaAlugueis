package controller;

import java.util.ArrayList;

import model.Funcionario;
import view.FuncionarioFrame;
import view.GerenteFrame;
import view.MensagemFrame;
import database.Database;
import database.DatabaseController;

public class LoginController {
	
	private String cpf_usuario;
	private String senha_usuario;
	private boolean ativar_interface_gerente; 
	
	public LoginController(String cpf, String senha){
		this.cpf_usuario = cpf;
		this.senha_usuario = senha;
		this.ativar_interface_gerente = false;
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
	public boolean validarFormatoCpf(){
		
		if(this.cpf_usuario.isEmpty() || this.contemLetra(this.cpf_usuario) || !this.contemNumero(this.cpf_usuario)){
			return false;
		}
		return true;
	}
	
	/* Garante que o campo de senha não estará vazio. */
	public boolean validarFormatoSenha(){
		if (this.senha_usuario.isEmpty()){
			return false;
		}
		return true;
	}
	
	/* Retorna true se o login está correto (cpf e senha têm correspondência) ; false, caso contrário. Seta a variável "gerente" */
	public boolean validarLogin(){
		PesquisaController pesquisa_controller = new PesquisaController();
		DatabaseController db_controller = new DatabaseController(Database.getInstance());
		ArrayList<Funcionario> funcionarios = pesquisa_controller.pesquisarFuncionarioPorCPF(this.cpf_usuario);
		
		if(funcionarios.size() == 0){
			return false;
		}
		else if (funcionarios.size() == 1){
			Funcionario funcionario = funcionarios.get(0);
			
			if(funcionario.getSenha().equals(this.senha_usuario)){
				if (db_controller.isGerente(this.cpf_usuario)){
					setAtivar_interface_gerente(true);
				}
				return true;
			}
		}

		return false;
	}
	
	public void login(){
		if(validarFormatoCpf()){
			if (validarLogin()){
				if(this.ativar_interface_gerente){
					//Cria interface para gerente
					GerenteFrame frame = new GerenteFrame();
					frame.setVisible(true);
				}
				else{
					//Cria interface para funcionario
					FuncionarioFrame frame = new FuncionarioFrame();
					frame.setVisible(true);
				}
			}
			else{
				MensagemFrame msg = new MensagemFrame("Login inválido.");
				msg.setVisible(true);
			}
		}
		else{
			MensagemFrame msg = new MensagemFrame("CPF inválido.");
			msg.setVisible(true);
		}
	}

	public boolean isAtivar_interface_gerente() {
		return ativar_interface_gerente;
	}

	public void setAtivar_interface_gerente(boolean gerente) {
		this.ativar_interface_gerente = gerente;
	}
	
	private boolean contemLetra(String s){
		
		return s.matches(".*?[a-zA-Z].*?");
	}
	
	private boolean contemNumero(String str) {
		
		return str.matches(".*\\d.*");
	
	}
}
