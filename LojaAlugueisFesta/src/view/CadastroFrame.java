package view;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import view.actionlisteners.BotaoCadastrarClienteAL;

public class CadastroFrame extends JFrame {

	private JPanel contentPane;
	private JTextField text_field_nome;
	private JTextField text_field_email;
	private JTextField text_field_telefone;
	private JTextField text_field_endereco;
	JFormattedTextField formatted_text_field_cpf;
	private JButton btnOk;
	
	public CadastroFrame() {
		setTitle("Novo cadastro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 430, 294);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(27, 33, 61, 16);
		contentPane.add(lblNome);
		
		text_field_nome = new JTextField();
		text_field_nome.setBounds(95, 27, 300, 28);
		contentPane.add(text_field_nome);
		text_field_nome.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(27, 71, 61, 16);
		contentPane.add(lblCpf);
		
		formatted_text_field_cpf = new JFormattedTextField(Operacoes.aplicaMascara("###.###.###-##"));
		formatted_text_field_cpf.setBounds(95, 67, 300, 28);
		
		contentPane.add(formatted_text_field_cpf);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(27, 108, 61, 16);
		contentPane.add(lblEmail);
		
		text_field_email = new JTextField();
		text_field_email.setBounds(95, 107, 300, 28);
		contentPane.add(text_field_email);
		text_field_email.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(27, 149, 61, 16);
		contentPane.add(lblTelefone);
		
		text_field_telefone = new JTextField();
		text_field_telefone.setBounds(95, 147, 300, 28);
		contentPane.add(text_field_telefone);
		text_field_telefone.setColumns(10);
		
		JLabel lblEndereco = new JLabel("Endereço:");
		lblEndereco.setBounds(27, 190, 61, 16);
		contentPane.add(lblEndereco);
		
		text_field_endereco = new JTextField();
		text_field_endereco.setBounds(95, 187, 300, 28);
		contentPane.add(text_field_endereco);
		text_field_endereco.setColumns(10);
		
		btnOk = new JButton("OK");
		btnOk.setBounds(277, 227, 117, 29);
		btnOk.addActionListener(new BotaoCadastrarClienteAL(this, this.text_field_nome, this.formatted_text_field_cpf, this.text_field_email, this.text_field_telefone, this.text_field_endereco));
		contentPane.add(btnOk);
	}
	
	public JButton getButtonOk(){
		return this.btnOk;
	}
}
