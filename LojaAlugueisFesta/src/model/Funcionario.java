package model;


public class Funcionario extends Pessoa{

	private String senha;
	
	public Funcionario(String nome, String cpf, String email, String endereco, int telefone, String senha) {
		super(nome, cpf, email, endereco, telefone);
		// TODO Auto-generated constructor stub
		this.setSenha(senha);
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	/*** ERRADOS ****/
	public boolean verificarStatusCliente(String cpf_cliente){
		
		// Procura cliente a partir do seu cpf
		
		
		// teste
		return false;
	}
	
	public void confirmarPagamento(){
		
	}

}
