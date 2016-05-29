package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class DadosPecaFrame extends JFrame {

	private JPanel contentPane;
	private JTextField nro_alugueis_text_field;
	private JTextField status_text_field;
	private JTextField valor_text_field;
	private JTextField tamanho_text_field;
	private JTextField tipo_text_field;
	private JTextField codigo_text_field;

	public DadosPecaFrame(String codigo, String tipo, String tamanho, String valor, String status, String numero_alugueis) {
		setTitle("Dados da peça");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 316, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCdigoDaPea = new JLabel("Código da peça:");
		lblCdigoDaPea.setBounds(20, 25, 112, 16);
		contentPane.add(lblCdigoDaPea);
		
		JLabel lblTamanho = new JLabel("Tamanho:");
		lblTamanho.setBounds(20, 105, 82, 16);
		contentPane.add(lblTamanho);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(20, 65, 61, 16);
		contentPane.add(lblTipo);
		
		JLabel lblValor = new JLabel("Valor:");
		lblValor.setBounds(20, 145, 61, 16);
		contentPane.add(lblValor);
		
		JLabel lblNmeroDeAlugueis = new JLabel("Número de alugueis:");
		lblNmeroDeAlugueis.setBounds(20, 185, 130, 16);
		contentPane.add(lblNmeroDeAlugueis);
		
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setBounds(20, 225, 61, 16);
		contentPane.add(lblStatus);
		
		nro_alugueis_text_field = new JTextField();
		nro_alugueis_text_field.setText(numero_alugueis);
		nro_alugueis_text_field.setEditable(false);
		nro_alugueis_text_field.setBounds(162, 179, 134, 28);
		contentPane.add(nro_alugueis_text_field);
		nro_alugueis_text_field.setColumns(10);
		
		status_text_field = new JTextField();
		status_text_field.setText(status);
		status_text_field.setEditable(false);
		status_text_field.setBounds(162, 219, 134, 28);
		contentPane.add(status_text_field);
		status_text_field.setColumns(10);
		
		valor_text_field = new JTextField();
		valor_text_field.setText(valor);
		valor_text_field.setEditable(false);
		valor_text_field.setBounds(162, 139, 134, 28);
		contentPane.add(valor_text_field);
		valor_text_field.setColumns(10);
		
		tamanho_text_field = new JTextField();
		tamanho_text_field.setText(tamanho);
		tamanho_text_field.setEditable(false);
		tamanho_text_field.setBounds(162, 99, 134, 28);
		contentPane.add(tamanho_text_field);
		tamanho_text_field.setColumns(10);
		
		tipo_text_field = new JTextField();
		tipo_text_field.setText(tipo);
		tipo_text_field.setEditable(false);
		tipo_text_field.setBounds(162, 59, 134, 28);
		contentPane.add(tipo_text_field);
		tipo_text_field.setColumns(10);
		
		codigo_text_field = new JTextField();
		codigo_text_field.setText(codigo);
		codigo_text_field.setEditable(false);
		codigo_text_field.setBounds(162, 19, 134, 28);
		contentPane.add(codigo_text_field);
		codigo_text_field.setColumns(10);
	}
}
