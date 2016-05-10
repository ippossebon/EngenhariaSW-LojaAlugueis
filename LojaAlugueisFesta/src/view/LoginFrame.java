package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	// Launch application
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 327, 207);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		//btnLogin.addActionListener();
		contentPane.add(btnLogin);
	}
}
