package view.actionlisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JTextField;

import controller.CadastroController;

public class BotaoCadastrarClienteAL implements ActionListener{
	
	private JFrame frame;
	private JTextField text_nome;
	private JFormattedTextField text_cpf;
	private JTextField text_email;
	private JTextField text_telefone;
	private JTextField text_endereco;
	

	public BotaoCadastrarClienteAL(JFrame frame, JTextField nome, JFormattedTextField cpf, JTextField email, JTextField telefone, JTextField endereco){
		this.frame = frame;
		this.text_nome = nome;
		this.text_cpf = cpf;
		this.text_email = email;
		this.text_telefone = telefone;
		this.text_endereco = endereco;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		CadastroController cadastro_controller = new CadastroController();
		boolean sucesso = cadastro_controller.cadastraCliente(this.text_nome.getText(), this.text_cpf.getText(), this.text_email.getText(), this.text_telefone.getText(), this.text_endereco.getText());
		if (sucesso){
			this.frame.dispose();
		}
	}

}
