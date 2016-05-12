package model;

public class Cliente extends Pessoa{

	private boolean bloqueado;
	
	public Cliente(String nome, String cpf, String email, String endereco, String telefone) {
		super(nome, cpf, email, endereco, telefone);
		this.setBloqueado(false);
		// TODO Auto-generated constructor stub
	}

	public boolean isBloqueado() {
		return bloqueado;
	}

	public void setBloqueado(boolean bloqueado) {
		this.bloqueado = bloqueado;
	}

}
