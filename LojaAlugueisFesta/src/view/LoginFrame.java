package view;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import controller.actionlisteners.login.LoginAL;
import database.Database;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JFormattedTextField cpf_text_field;

	// Launch application
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Database.getInstance().popularDatabase();
					LoginFrame frame = new LoginFrame();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	// Create frame
	public LoginFrame() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 327, 207);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		this.passwordField = new JPasswordField();
		this.passwordField.setBounds(90, 84, 200, 28);
		this.contentPane.add(this.passwordField);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(30, 43, 61, 16);
		this.contentPane.add(lblCpf);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(30, 90, 61, 16);
		this.contentPane.add(lblSenha);
		
		this.cpf_text_field = new JFormattedTextField(Operacoes.aplicaMascara("###.###.###-##"));
		this.cpf_text_field.setColumns(14);
		this.cpf_text_field.setBounds(90, 37, 200, 28);
		this.contentPane.add(this.cpf_text_field);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(173, 130, 117, 29);
		btnLogin.addActionListener(new LoginAL(this));
		contentPane.add(btnLogin);
	}

	public JFormattedTextField getCpf_text_field() {
		return cpf_text_field;
	}

	public void setCpf_text_field(JFormattedTextField cpf_text_field) {
		this.cpf_text_field = cpf_text_field;
	}
	
	public JPasswordField getPasswordField(){
		return this.passwordField;
	}
	
	public void setPasswordField(JPasswordField p){
		this.passwordField = p;
	}
}


