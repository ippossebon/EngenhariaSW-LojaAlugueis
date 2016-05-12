package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class CadastroFuncionarioFrame extends CadastroFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	public CadastroFuncionarioFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(27, 236, 61, 16);
		contentPane.add(lblSenha);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(95, 227, 300, 28);
		contentPane.add(passwordField);
		
		JLabel lblConfirmarSenha = new JLabel("Confirmar");
		lblConfirmarSenha.setHorizontalAlignment(SwingConstants.LEFT);
		lblConfirmarSenha.setBounds(27, 272, 63, 21);
		contentPane.add(lblConfirmarSenha);
		
		JLabel lblSenha_1 = new JLabel("senha:");
		lblSenha_1.setBounds(27, 290, 61, 16);
		contentPane.add(lblSenha_1);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(95, 267, 300, 28);
		contentPane.add(passwordField_1);
	}

}
