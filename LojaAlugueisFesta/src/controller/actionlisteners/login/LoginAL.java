package controller.actionlisteners.login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;

import view.LoginFrame;
import controller.LoginController;

public class LoginAL implements ActionListener{
	private LoginFrame frame;
	
	public LoginAL(LoginFrame frame){
		this.frame = frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		LoginController login_controller = new LoginController(this.frame.getCpf_text_field().getText(), this.frame.getPasswordField().getText());
		login_controller.login();
	}
	
}
