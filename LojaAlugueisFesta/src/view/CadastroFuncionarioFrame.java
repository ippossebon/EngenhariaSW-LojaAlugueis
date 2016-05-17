package view;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class CadastroFuncionarioFrame extends CadastroFrame {

	private JPanel contentPane;
	private JPasswordField password_field;
	private JPasswordField password_confirmation_field;

	public CadastroFuncionarioFrame() {
		getButtonOk().setLocation(278, 357);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 430, 430);
		setContentPane(contentPane);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(27, 236, 61, 16);
		contentPane.add(lblSenha);
		super.add(lblSenha);
		
		password_field = new JPasswordField();
		password_field.setBounds(95, 227, 300, 28);
		contentPane.add(password_field);
		super.add(password_field);
		
		JLabel lblConfirmarSenha = new JLabel("Confirmar");
		lblConfirmarSenha.setHorizontalAlignment(SwingConstants.LEFT);
		lblConfirmarSenha.setBounds(27, 272, 63, 21);
		contentPane.add(lblConfirmarSenha);
		super.add(lblConfirmarSenha);
		
		JLabel lblSenha_1 = new JLabel("senha:");
		lblSenha_1.setBounds(27, 290, 61, 16);
		contentPane.add(lblSenha_1);
		super.add(lblSenha_1);
		
		password_confirmation_field = new JPasswordField();
		password_confirmation_field.setBounds(95, 267, 300, 28);
		contentPane.add(password_confirmation_field);
		super.add(password_confirmation_field);
		
		JLabel lblCargo = new JLabel("Cargo:");
		lblCargo.setBounds(27, 327, 61, 16);
		contentPane.add(lblCargo);
		super.add(lblCargo);
		
		JRadioButton rdbtnFuncionario = new JRadioButton("Funcionário");
		rdbtnFuncionario.setBounds(95, 327, 106, 23);
		contentPane.add(rdbtnFuncionario);
		super.add(rdbtnFuncionario);
		
		JRadioButton rdbtnGerente = new JRadioButton("Gerente");
		rdbtnGerente.setBounds(222, 327, 80, 23);
		contentPane.add(rdbtnGerente);
		super.add(rdbtnGerente);
		
		ButtonGroup button_group = new ButtonGroup();
		button_group.add(rdbtnFuncionario);
		button_group.add(rdbtnGerente);
		
		super.getButtonOk().setBounds(278, 367, 117, 29);
	}

}
