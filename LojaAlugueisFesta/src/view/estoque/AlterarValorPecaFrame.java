package view.estoque;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.actionlisteners.BotaoConfirmaNovoPrecoAL;

public class AlterarValorPecaFrame extends JFrame {

	private JPanel contentPane;
	private JTextField valor_atual_text_field;
	private JTextField codigo_peca_text_field;
	private JTextField tipo_text_field;

	public AlterarValorPecaFrame(String codigo_peca, String tipo, String valor_atual) {
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
		valor_atual_text_field.setText(valor_atual);
		contentPane.add(valor_atual_text_field);
		valor_atual_text_field.setColumns(10);
		
		JLabel lblValorAtual = new JLabel("Valor atual:");
		lblValorAtual.setBounds(16, 92, 71, 16);
		contentPane.add(lblValorAtual);
		
		JLabel lblNovoValor = new JLabel("Novo valor:");
		lblNovoValor.setBounds(16, 132, 85, 16);
		contentPane.add(lblNovoValor);
		
		JTextField novo_valor_text_field = new JTextField();
		novo_valor_text_field.setBounds(99, 126, 149, 28);
		contentPane.add(novo_valor_text_field);
		
		codigo_peca_text_field = new JTextField();
		codigo_peca_text_field.setEditable(false);
		codigo_peca_text_field.setBounds(99, 6, 149, 28);
		codigo_peca_text_field.setText(codigo_peca);
		contentPane.add(codigo_peca_text_field);
		codigo_peca_text_field.setColumns(10);
		
		JLabel lblCdigo = new JLabel("Código:");
		lblCdigo.setBounds(16, 12, 61, 16);
		contentPane.add(lblCdigo);
		
		tipo_text_field = new JTextField();
		tipo_text_field.setEditable(false);
		tipo_text_field.setBounds(99, 46, 149, 28);
		tipo_text_field.setText(tipo);
		contentPane.add(tipo_text_field);
		tipo_text_field.setColumns(10);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(16, 52, 61, 16);
		contentPane.add(lblTipo);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(131, 166, 117, 29);
		btnOk.addActionListener(new BotaoConfirmaNovoPrecoAL(this));
		contentPane.add(btnOk);
	}
}
