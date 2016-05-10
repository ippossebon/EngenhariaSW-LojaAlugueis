package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.LoginController;
import database.Database;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	public static Database database; //teste
	
	
	// Launch application
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
					frame.setVisible(true);
					
					// Teste
					Database database = new Database();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Create frame
	public LoginFrame() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 327, 207);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		textField = new JTextField();
		textField.setBounds(90, 37, 200, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(90, 84, 200, 28);
		contentPane.add(passwordField);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(30, 43, 61, 16);
		contentPane.add(lblCpf);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(30, 90, 61, 16);
		contentPane.add(lblSenha);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(173, 130, 117, 29);
		btnLogin.addActionListener(new LoginAction(textField, passwordField));
		contentPane.add(btnLogin);
	}
}

class LoginAction implements ActionListener{
	private JTextField text_field;
	private JPasswordField password_field;
	
	public LoginAction(JTextField text, JPasswordField password){
		this.text_field = text;
		this.password_field = password;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String cpf_usuario = this.text_field.getText();
		String password_usuario = this.password_field.getPassword().toString();
		
		LoginController login_controller = new LoginController(cpf_usuario, password_usuario);
		
		if(login_controller.validaFormatoCpf()){
			
			if (login_controller.validaFormatoSenha()){
				
				if(login_controller.validaLogin()){
					
					// Cria a interface correspondente ao tipo de usuário
					if (login_controller.isGerente()){
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
