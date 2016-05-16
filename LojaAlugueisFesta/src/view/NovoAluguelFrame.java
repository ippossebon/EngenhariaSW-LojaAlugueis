package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;

public class NovoAluguelFrame extends JFrame {

	private JPanel contentPane;
	private JTextField pesquisa_text_field;

	public NovoAluguelFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 926, 499);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		pesquisa_text_field = new JTextField();
		pesquisa_text_field.setBounds(18, 25, 332, 28);
		contentPane.add(pesquisa_text_field);
		pesquisa_text_field.setColumns(10);
		
		JLabel pesquisar_label = new JLabel("Pesquisar peça:");
		pesquisar_label.setBounds(18, 6, 165, 16);
		contentPane.add(pesquisar_label);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(352, 25, 66, 30);
		contentPane.add(btnOk);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(18, 110, 400, 315);
		contentPane.add(scrollPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(512, 110, 400, 315);
		contentPane.add(scrollPane_1);
		
		JRadioButton rdbtnCdigo = new JRadioButton("Código");
		rdbtnCdigo.setBounds(18, 58, 77, 23);
		contentPane.add(rdbtnCdigo);
		
		JRadioButton rdbtnTipo = new JRadioButton("Tipo");
		rdbtnTipo.setBounds(106, 58, 66, 23);
		contentPane.add(rdbtnTipo);
		
		JCheckBox chckbxApenasDisponveis = new JCheckBox("Apenas disponíveis");
		chckbxApenasDisponveis.setBounds(184, 58, 154, 23);
		contentPane.add(chckbxApenasDisponveis);
		
		JLabel lblResultados = new JLabel("Resultados:");
		lblResultados.setBounds(18, 94, 90, 16);
		contentPane.add(lblResultados);
		
		JLabel lblCarrinho = new JLabel("Carrinho:");
		lblCarrinho.setBounds(512, 94, 77, 16);
		contentPane.add(lblCarrinho);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(795, 437, 117, 29);
		contentPane.add(btnConfirmar);
	}
}
