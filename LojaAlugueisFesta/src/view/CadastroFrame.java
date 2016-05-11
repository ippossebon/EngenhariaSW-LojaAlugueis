package view;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class CadastroFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	
	public CadastroFrame() {
		setTitle("Novo cadastro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 366);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(27, 33, 61, 16);
		contentPane.add(lblNome);
		
		textField = new JTextField();
		textField.setBounds(95, 27, 300, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(27, 71, 61, 16);
		contentPane.add(lblCpf);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(95, 67, 300, 28);
		contentPane.add(formattedTextField);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(27, 108, 61, 16);
		contentPane.add(lblEmail);
		
		textField_1 = new JTextField();
		textField_1.setBounds(95, 107, 300, 28);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(27, 149, 61, 16);
		contentPane.add(lblTelefone);
		
		textField_2 = new JTextField();
		textField_2.setBounds(95, 147, 300, 28);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblEndereco = new JLabel("Endereço:");
		lblEndereco.setBounds(27, 190, 61, 16);
		contentPane.add(lblEndereco);
		
		textField_3 = new JTextField();
		textField_3.setBounds(95, 187, 300, 28);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(278, 307, 117, 29);
		contentPane.add(btnOk);
	}
}
