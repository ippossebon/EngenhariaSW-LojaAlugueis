package view;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import view.actionlisteners.LoginAL;
import database.Database;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
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
					database = new Database();
					
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
		
		passwordField = new JPasswordField();
		passwordField.setBounds(90, 84, 200, 28);
		contentPane.add(passwordField);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(30, 43, 61, 16);
		contentPane.add(lblCpf);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(30, 90, 61, 16);
		contentPane.add(lblSenha);
		
		JFormattedTextField cpf_formatted_text_field = new JFormattedTextField(mascara("###.###.###-##"));
		cpf_formatted_text_field.setBounds(90, 37, 200, 28);
		contentPane.add(cpf_formatted_text_field);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(173, 130, 117, 29);
		btnLogin.addActionListener(new LoginAL(cpf_formatted_text_field, passwordField));
		contentPane.add(btnLogin);
	}
	
	public  MaskFormatter mascara(String Mascara){
	    MaskFormatter F_Mascara = new MaskFormatter();
	    try{
	        F_Mascara.setMask(Mascara); // Atribui a mascara
	        F_Mascara.setPlaceholderCharacter(' '); // Caractere para preencimento 
	    }
	    catch (Exception excecao) {
	    excecao.printStackTrace();
	    } 
	    return F_Mascara;
	}
}


