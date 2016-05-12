package view.actionlisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;

import view.FuncionarioFrame;
import view.GerenteFrame;
import view.MensagemErroFrame;
import controller.LoginController;

public class LoginActionListener implements ActionListener{
	private JFormattedTextField text_field;
	private JPasswordField password_field;
	
	public LoginActionListener(JFormattedTextField text, JPasswordField password){
		this.text_field = text;
		this.password_field = password;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String cpf_usuario = this.text_field.getText();
		String password_usuario = this.password_field.getPassword().toString();
		
		LoginController login_controller = new LoginController(cpf_usuario, password_usuario);
		
		if(login_controller.validarFormatoCpf()){
			
			if (login_controller.validarFormatoSenha()){
				
				if(login_controller.validarLogin()){
					
					// Cria a interface correspondente ao tipo de usuário
					if (login_controller.isAtivar_interface_gerente()){
						GerenteFrame gerente_frame = new GerenteFrame();
						gerente_frame.setVisible(true);
					}
					else{
						FuncionarioFrame funcionario_frame = new FuncionarioFrame();
						funcionario_frame.setVisible(true);
					}
				}
				else{
					MensagemErroFrame erro_frame = new MensagemErroFrame("Login inválido. Verifique seu CPF ou senha.");
					erro_frame.setVisible(true);
				}
			}
			else{
				MensagemErroFrame erro_frame = new MensagemErroFrame("Senha inválida.");
				erro_frame.setVisible(true);
			}
		}
		else{
			MensagemErroFrame erro_frame = new MensagemErroFrame("CPF no formato errado"); // TO DO: verificar como vai ser o formato em que o usuário insere.
			erro_frame.setVisible(true); 
		}
		
	}
	
}
