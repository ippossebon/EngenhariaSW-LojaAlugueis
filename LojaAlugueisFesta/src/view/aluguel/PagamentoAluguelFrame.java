package view.aluguel;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JSeparator;

public class PagamentoAluguelFrame extends JFrame {

	private JPanel contentPane;
	private JTextField cpf_cliente_text_field;
	private JTextField data_inicio_text_field;
	private JTextField data_fim_text_field;
	private JLabel total_label;
	private JTextField total_text_field;
	private JLabel lblMtodoDePagamento;

	
	public PagamentoAluguelFrame(String cpf_cliente, String data_inicio, String data_fim) {
		setTitle("Pagamento Aluguel");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 439, 358);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCpfCliente = new JLabel("CPF Cliente:");
		lblCpfCliente.setBounds(20, 27, 82, 16);
		contentPane.add(lblCpfCliente);
		
		cpf_cliente_text_field = new JTextField();
		cpf_cliente_text_field.setEditable(false);
		cpf_cliente_text_field.setBounds(114, 21, 295, 28);
		contentPane.add(cpf_cliente_text_field);
		cpf_cliente_text_field.setColumns(10);
		
		JLabel lblDataIncio = new JLabel("Data início:");
		lblDataIncio.setBounds(20, 66, 82, 16);
		contentPane.add(lblDataIncio);
		
		data_inicio_text_field = new JTextField();
		data_inicio_text_field.setEditable(false);
		data_inicio_text_field.setBounds(114, 61, 105, 28);
		contentPane.add(data_inicio_text_field);
		data_inicio_text_field.setColumns(10);
		
		JLabel lblDataFim = new JLabel("Data fim:");
		lblDataFim.setBounds(231, 66, 61, 16);
		contentPane.add(lblDataFim);
		
		data_fim_text_field = new JTextField();
		data_fim_text_field.setEditable(false);
		data_fim_text_field.setBounds(304, 60, 105, 28);
		contentPane.add(data_fim_text_field);
		data_fim_text_field.setColumns(10);
		
		total_label = new JLabel("Total (R$):");
		total_label.setBounds(20, 100, 82, 16);
		contentPane.add(total_label);
		
		total_text_field = new JTextField();
		total_text_field.setEditable(false);
		total_text_field.setBounds(114, 94, 105, 28);
		contentPane.add(total_text_field);
		total_text_field.setColumns(10);
		
		lblMtodoDePagamento = new JLabel("Método de pagamento:");
		lblMtodoDePagamento.setBounds(20, 143, 158, 16);
		contentPane.add(lblMtodoDePagamento);
		
		JRadioButton rdbtnDinheiro = new JRadioButton("Dinheiro");
		rdbtnDinheiro.setBounds(20, 206, 99, 23);
		contentPane.add(rdbtnDinheiro);
		
		JRadioButton rdbtnCartoDeCrdito = new JRadioButton("Cartão de crédito/débito");
		rdbtnCartoDeCrdito.setBounds(20, 171, 199, 23);
		contentPane.add(rdbtnCartoDeCrdito);
		
		JRadioButton rdbtnNoEfetuado = new JRadioButton("Não efetuado");
		rdbtnNoEfetuado.setBounds(20, 241, 141, 23);
		contentPane.add(rdbtnNoEfetuado);
		
		JComboBox cartaoComboBox = new JComboBox();
		cartaoComboBox.setBounds(304, 171, 105, 27);
		contentPane.add(cartaoComboBox);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(20, 301, 117, 29);
		btnCancelar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e)
		    {
		      dispose();
		    }
		});
		contentPane.add(btnCancelar);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(305, 301, 117, 29);
		contentPane.add(btnConfirmar);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 129, 439, 12);
		contentPane.add(separator);
		
		
	}
}
