package view.actionlisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class BotaoCadastrarClienteAL implements ActionListener{
	
	private JTextField text_nome;
	private JTextField text_cpf;
	private JTextField text_email;
	private JTextField text_telefone;
	private JTextField text_endereco;
	

	public BotaoCadastrarClienteAL(JTextField nome, JTextField cpf, JTextField email, JTextField telefone, JTextField endereco){
		this.text_nome = nome;
		this.text_cpf = cpf;
		this.text_email = email;
		this.text_telefone = telefone;
		this.text_endereco = endereco;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//CadastroController cadastro_controller = new CadastroController();
		
		//envia dados para validar
		
	}

}
