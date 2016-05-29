package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DadosFuncionarioFrame extends JFrame {

	private JPanel contentPane;
	private JTextField telefone_text_field;
	private JTextField cargo_text_field;
	private JTextField endereco_text_field;
	private JTextField email_text_field;
	private JTextField cpf_text_field;
	private JTextField nome_text_field;

	public DadosFuncionarioFrame(String nome, String cpf, String email, String endereco, String telefone, String cargo) {
		setTitle("Dados do cliente");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 316, 289);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(20, 25, 49, 16);
		contentPane.add(lblNome);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(20, 65, 38, 16);
		contentPane.add(lblCpf);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(20, 105, 61, 16);
		contentPane.add(lblEmail);
		
		JLabel lblEndereo = new JLabel("Endereço:");
		lblEndereo.setBounds(20, 145, 61, 16);
		contentPane.add(lblEndereo);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(20, 185, 61, 16);
		contentPane.add(lblTelefone);
		
		JLabel lblCargo = new JLabel("Cargo:");
		lblCargo.setBounds(20, 225, 61, 16);
		contentPane.add(lblCargo);
		
		telefone_text_field = new JTextField();
		telefone_text_field.setText(telefone);
		telefone_text_field.setEditable(false);
		telefone_text_field.setBounds(93, 179, 200, 28);
		contentPane.add(telefone_text_field);
		telefone_text_field.setColumns(10);
		
		cargo_text_field = new JTextField();
		cargo_text_field.setText(cargo);
		cargo_text_field.setEditable(false);
		cargo_text_field.setBounds(93, 219, 200, 28);
		contentPane.add(cargo_text_field);
		cargo_text_field.setColumns(10);
		
		endereco_text_field = new JTextField();
		endereco_text_field.setText(endereco);
		endereco_text_field.setEditable(false);
		endereco_text_field.setBounds(93, 139, 200, 28);
		contentPane.add(endereco_text_field);
		endereco_text_field.setColumns(10);
		
		email_text_field = new JTextField();
		email_text_field.setText(email);
		email_text_field.setEditable(false);
		email_text_field.setBounds(93, 99, 200, 28);
		contentPane.add(email_text_field);
		email_text_field.setColumns(10);
		
		cpf_text_field = new JTextField();
		cpf_text_field.setText(cpf);
		cpf_text_field.setEditable(false);
		cpf_text_field.setBounds(93, 59, 200, 28);
		contentPane.add(cpf_text_field);
		cpf_text_field.setColumns(10);
		
		nome_text_field = new JTextField();
		nome_text_field.setText(nome);
		nome_text_field.setEditable(false);
		nome_text_field.setBounds(93, 19, 200, 28);
		contentPane.add(nome_text_field);
		nome_text_field.setColumns(10);
	}

}
