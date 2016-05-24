package view.aluguel;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class NovoAluguelFrame extends JFrame {

	private JPanel contentPane;
	private JTextField pesquisa_text_field;
	private JRadioButton rdbtnCodigo;
	private JRadioButton rdbtnTipo;
	private JCheckBox chckbxApenasDisponveis;
	private JTable resultados_table;
	private JTable carrinho_table;

	public NovoAluguelFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 926, 499);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		pesquisa_text_field = new JTextField();
		pesquisa_text_field.setBounds(18, 25, 332, 28);
		contentPane.add(pesquisa_text_field);
		pesquisa_text_field.setColumns(10);
		
		carrinho_table = new JTable();
		resultados_table = new JTable();
		
		JLabel pesquisar_label = new JLabel("Pesquisar peça:");
		pesquisar_label.setBounds(18, 6, 165, 16);
		contentPane.add(pesquisar_label);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(352, 25, 66, 30);
		contentPane.add(btnOk);
		
		JScrollPane resultados_scroll_pane = new JScrollPane();
		resultados_scroll_pane.setBounds(18, 110, 400, 315);
		contentPane.add(resultados_scroll_pane);
		resultados_scroll_pane.add(resultados_table);
		
		JScrollPane carrinho_scroll_pane = new JScrollPane();
		carrinho_scroll_pane.setBounds(512, 110, 400, 315);
		contentPane.add(carrinho_scroll_pane);
		carrinho_scroll_pane.add(carrinho_table);
		
		rdbtnCodigo= new JRadioButton("Código");
		rdbtnCodigo.setBounds(18, 58, 77, 23);
		contentPane.add(rdbtnCodigo);
		
		rdbtnTipo = new JRadioButton("Tipo");
		rdbtnTipo.setBounds(106, 58, 66, 23);
		contentPane.add(rdbtnTipo);
		
		chckbxApenasDisponveis = new JCheckBox("Apenas disponíveis");
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
		
		JButton buttonAdicionarCarrinho = new JButton(">>");
		buttonAdicionarCarrinho.setBounds(430, 184, 70, 29);
		contentPane.add(buttonAdicionarCarrinho);
		
		JButton btnRemoverCarrinho = new JButton("<<");
		btnRemoverCarrinho.setBounds(430, 220, 70, 29);
		contentPane.add(btnRemoverCarrinho);
	}
}
