package controller;

import model.Cliente;
import model.Funcionario;
import view.MensagemFrame;
import controller.exceptions.CPFInvalidoException;
import controller.exceptions.ConfirmarSenhaException;
import controller.exceptions.EmailInvalidoException;
import controller.exceptions.EnderecoInvalidoException;
import controller.exceptions.NomeInvalidoException;
import controller.exceptions.PessoaCadastradaException;
import controller.exceptions.TelefoneInvalidoException;
import database.Database;
import database.DatabaseController;


public class CadastroController {

	private Cliente cliente;
	private Funcionario funcionario;
	
	public CadastroController(){
		
	}
	
	/* Retorna true se o cadastro foi feito com sucesso. False, caso contrário. */
	public boolean cadastraCliente(String nome, String cpf, String email, String telefone, String endereco) {
		
		if(!this.validaNome(nome)) {
			
			//throw new NomeInvalidoException("Nome invalido.");
			MensagemFrame msg = new MensagemFrame("Nome inválido.");
			msg.setVisible(true);
			return false;
		}

		
		if(!this.validaCpf(cpf)) {
			
			//throw new CPFInvalidoException("CPF invalido.");
			MensagemFrame msg = new MensagemFrame("CPF inválido.");
			msg.setVisible(true);
			return false;
		}
		
		PesquisaController pController = new PesquisaController();
		
		if(pController.existeCliente(cpf)) {
			
			throw new PessoaCadastradaException("Este CPF já possui cadastro no sistema");
		}
		
		if(!this.validaEmail(email)) {
			
			//throw new EmailInvalidoException("Email invalido.");
			MensagemFrame msg = new MensagemFrame("E-mail inválido.");
			msg.setVisible(true);
			return false;
		}
		
		if(!this.validaTelefone(telefone)) {
			
			//throw new TelefoneInvalidoException("Telefone invalido.");
			MensagemFrame msg = new MensagemFrame("Telefone inválido.");
			msg.setVisible(true);
			return false;
		}
		
		if(!this.validaEndereco(endereco)) {
			
			//throw new EnderecoInvalidoException("Endereco invalido.");
			MensagemFrame msg = new MensagemFrame("Endereço inválido.");
			msg.setVisible(true);
			return false;
		}
		
		cliente = new Cliente(nome, cpf, email, endereco, telefone);
		DatabaseController dbController = new DatabaseController(Database.getInstance());
		dbController.cadastrarCliente(cliente);
		
		MensagemFrame mensagem_frame = new MensagemFrame("Cliente cadastrado com sucesso.");
		mensagem_frame.setVisible(true);
		return true;
	}
	
	public void cadastraFuncionario(String nome, String cpf, String email, String telefone, String endereco, String senha, String confirmarSenha) {
		
		if(!this.validaNome(nome)) {
			
			throw new NomeInvalidoException("Nome invalido.");
		}

		if(!this.validaCpf(cpf)) {
			
			throw new CPFInvalidoException("CPF invalido.");
		}
		
		PesquisaController pController = new PesquisaController();
		
		if(pController.existeFuncionario(cpf)) {
			throw new PessoaCadastradaException("Este CPF já possui cadastro no sistema.");
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
		
		if(!senha.equals(confirmarSenha)) {
			
			throw new ConfirmarSenhaException("lol");
		}
		
		funcionario = new Funcionario(nome, cpf, email, endereco, telefone, senha);
		DatabaseController dbController = new DatabaseController(Database.getInstance());
		dbController.cadastrarFuncionario(funcionario);
	}
	
	public boolean validaNome(String nome) {
		
		if(this.stringVazia(nome) || this.contemNumero(nome)) {
			
			return false;
		}
		
		return true;
	}
	
	public boolean validaCpf(String cpf) {
		System.out.println(cpf);
		
		if(this.stringVazia(cpf) || !this.contemNumero(cpf) || this.contemLetra(cpf)) {
			
			return false;
		}
		
		return true;
	}
	
	public boolean validaEmail(String email) {
		
		if(this.stringVazia(email) || !this.contemArroba(email)) {
			
			return false;
		}
		
		return true;
	}
	
	public boolean validaTelefone(String telefone){
		
		if(this.stringVazia(telefone) || !this.contemApenasNumeros(telefone)) {
			
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
		
		return str.matches(".*\\d.*");
	
	}
	
	// contém caracteres a-z A-Z
	public boolean contemApenasNumeros(String str) {
		
		return str.matches("[0-9]+");
		
	}
	
	public boolean contemArroba(String s){
		return s.contains("@");
	}
	
	public boolean contemLetra(String s){
	
		return s.matches(".*?[a-zA-Z].*?");
	}
	
}
