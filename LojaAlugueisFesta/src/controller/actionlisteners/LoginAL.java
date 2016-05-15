package controller.actionlisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;

import controller.LoginController;

public class LoginAL implements ActionListener{
	private JFormattedTextField text_field;
	private JPasswordField password_field;
	
	public LoginAL(JFormattedTextField text, JPasswordField password){
		this.text_field = text;
		this.password_field = password;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String cpf_usuario = this.text_field.getText();
		String password_usuario = this.password_field.getText();
		
		LoginController login_controller = new LoginController(cpf_usuario, password_usuario);
		login_controller.login();
	}
	
}
