package controller.actionlisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class BotaoCadastrarFuncionarioAL implements ActionListener{
	
	private JTextField text_nome;
	private JTextField text_cpf;
	private JTextField text_email;
	private JTextField text_telefone;
	private JTextField text_endereco;
	private JPasswordField text_senha;
	private JPasswordField text_confirmacao_senha;
	
	public BotaoCadastrarFuncionarioAL(JTextField nome, JTextField cpf, JTextField email, JTextField telefone, JTextField endereco,
													JPasswordField senha, JPasswordField confirmacao_senha){
		this.text_nome = nome;
		this.text_cpf = cpf;
		this.text_email = email;
		this.text_telefone = telefone;
		this.text_endereco = endereco;
		this.text_senha = senha;
		this.text_confirmacao_senha = confirmacao_senha;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// Cria cadastro controller
		// Envia dados - include: verificar se senha e confirmação da senha são iguais.
	}

}
