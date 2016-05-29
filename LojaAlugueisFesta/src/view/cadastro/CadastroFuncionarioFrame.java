package view.cadastro;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import view.Operacoes;
import controller.actionlisteners.cadastro.BotaoCadastrarFuncionarioAL;

public class CadastroFuncionarioFrame extends JFrame{

	private JPanel contentPane;
	private JTextField nome_text_field;
	private JTextField email_text_field;
	private JTextField telefone_text_field;
	private JTextField endereco_text_field;
	private JPasswordField passwordField;
	private JPasswordField confirmacao_senha_field;
	private JFormattedTextField cpf_text_field;
	private JRadioButton rdbtnFuncionrio;
	private JRadioButton rdbtnGerente;
	
	public JFormattedTextField getCPFTextField(){
		return this.cpf_text_field;
	}
	
	public void setCPFTextField(JFormattedTextField ft){
		this.cpf_text_field = ft;
	}
	
	public JTextField getNome_text_field() {
		return nome_text_field;
	}


	public void setNome_text_field(JTextField nome_text_field) {
		this.nome_text_field = nome_text_field;
	}


	public JTextField getEmail_text_field() {
		return email_text_field;
	}


	public void setEmail_text_field(JTextField email_text_field) {
		this.email_text_field = email_text_field;
	}


	public JTextField getTelefone_text_field() {
		return telefone_text_field;
	}


	public void setTelefone_text_field(JTextField telefone_text_field) {
		this.telefone_text_field = telefone_text_field;
	}


	public JTextField getEndereco_text_field() {
		return endereco_text_field;
	}


	public void setEndereco_text_field(JTextField endereco_text_field) {
		this.endereco_text_field = endereco_text_field;
	}


	public JPasswordField getPasswordField() {
		return passwordField;
	}


	public void setPasswordField(JPasswordField passwordField) {
		this.passwordField = passwordField;
	}


	public JPasswordField getConfirmacao_senha_field() {
		return confirmacao_senha_field;
	}


	public void setConfirmacao_senha_field(JPasswordField confirmacao_senha_field) {
		this.confirmacao_senha_field = confirmacao_senha_field;
	}	

	public CadastroFuncionarioFrame() {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 430, 430);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNomeLabel = new JLabel("Nome:");
		lblNomeLabel.setBounds(27, 33, 61, 18);
		contentPane.add(lblNomeLabel);
		
		nome_text_field = new JTextField();
		nome_text_field.setBounds(110, 28, 300, 28);
		contentPane.add(nome_text_field);
		nome_text_field.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(27, 71, 61, 16);
		contentPane.add(lblCpf);
		
		cpf_text_field = new JFormattedTextField(Operacoes.aplicaMascara("###.###.###-##"));
		cpf_text_field.setBounds(110, 68, 300, 28);
		contentPane.add(cpf_text_field);
		
		JLabel lblEmailLabel = new JLabel("E-mail:");
		lblEmailLabel.setBounds(27, 109, 61, 16);
		contentPane.add(lblEmailLabel);
		
		email_text_field = new JTextField();
		email_text_field.setBounds(110, 108, 300, 28);
		contentPane.add(email_text_field);
		email_text_field.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(27, 147, 61, 16);
		contentPane.add(lblTelefone);
		
		telefone_text_field = new JTextField();
		telefone_text_field.setBounds(110, 141, 300, 28);
		contentPane.add(telefone_text_field);
		telefone_text_field.setColumns(10);
		
		JLabel lblEndereo = new JLabel("Endereço:");
		lblEndereo.setBounds(27, 185, 61, 16);
		contentPane.add(lblEndereo);
		
		endereco_text_field = new JTextField();
		endereco_text_field.setBounds(110, 179, 300, 28);
		contentPane.add(endereco_text_field);
		endereco_text_field.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(27, 223, 61, 16);
		contentPane.add(lblSenha);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(110, 217, 300, 28);
		contentPane.add(passwordField);
		
		JLabel lblConfirmao = new JLabel("Confirmação");
		lblConfirmao.setBounds(27, 261, 80, 16);
		contentPane.add(lblConfirmao);
		
		JLabel lblSenha_1 = new JLabel("senha:");
		lblSenha_1.setBounds(27, 278, 61, 16);
		contentPane.add(lblSenha_1);
		
		confirmacao_senha_field = new JPasswordField();
		confirmacao_senha_field.setBounds(110, 257, 300, 28);
		contentPane.add(confirmacao_senha_field);
		
		JLabel lblCargo = new JLabel("Cargo:");
		lblCargo.setBounds(27, 316, 61, 16);
		contentPane.add(lblCargo);
		
		rdbtnFuncionrio = new JRadioButton("Funcionário");
		rdbtnFuncionrio.setBounds(110, 312, 106, 23);
		contentPane.add(rdbtnFuncionrio);
		
		rdbtnGerente = new JRadioButton("Gerente");
		rdbtnGerente.setBounds(228, 312, 88, 23);
		contentPane.add(rdbtnGerente);
		
		ButtonGroup button_group = new ButtonGroup();
		button_group.add(rdbtnFuncionrio);
		button_group.add(rdbtnGerente);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new BotaoCadastrarFuncionarioAL(this));
		btnOk.setBounds(293, 360, 117, 29);
		contentPane.add(btnOk);

		
	}

	public JRadioButton getRdbtnFuncionrio() {
		return rdbtnFuncionrio;
	}

	public void setRdbtnFuncionrio(JRadioButton rdbtnFuncionrio) {
		this.rdbtnFuncionrio = rdbtnFuncionrio;
	}

	public JRadioButton getRdbtnGerente() {
		return rdbtnGerente;
	}

	public void setRdbtnGerente(JRadioButton rdbtnGerente) {
		this.rdbtnGerente = rdbtnGerente;
	}
}
