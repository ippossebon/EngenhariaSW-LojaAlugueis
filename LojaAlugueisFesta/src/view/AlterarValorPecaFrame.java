package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;

public class AlterarValorPecaFrame extends JFrame {

	private JPanel contentPane;
	private JTextField valor_atual_text_field;
	private JTextField codigo_peca_text_field;
	private JTextField textField_1;

	public AlterarValorPecaFrame() {
		setTitle("Alterar valor de peça");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 260, 226);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		valor_atual_text_field = new JTextField();
		valor_atual_text_field.setEditable(false);
		valor_atual_text_field.setBounds(99, 86, 149, 28);
		contentPane.add(valor_atual_text_field);
		valor_atual_text_field.setColumns(10);
		
		JLabel lblValorAtual = new JLabel("Valor atual:");
		lblValorAtual.setBounds(16, 92, 71, 16);
		contentPane.add(lblValorAtual);
		
		JLabel lblNovoValor = new JLabel("Novo valor:");
		lblNovoValor.setBounds(16, 132, 85, 16);
		contentPane.add(lblNovoValor);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(99, 126, 149, 28);
		contentPane.add(formattedTextField);
		
		codigo_peca_text_field = new JTextField();
		codigo_peca_text_field.setEditable(false);
		codigo_peca_text_field.setBounds(99, 6, 149, 28);
		contentPane.add(codigo_peca_text_field);
		codigo_peca_text_field.setColumns(10);
		
		JLabel lblCdigo = new JLabel("Código:");
		lblCdigo.setBounds(16, 12, 61, 16);
		contentPane.add(lblCdigo);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(99, 46, 149, 28);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(16, 52, 61, 16);
		contentPane.add(lblTipo);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(131, 166, 117, 29);
		contentPane.add(btnOk);
	}
}
