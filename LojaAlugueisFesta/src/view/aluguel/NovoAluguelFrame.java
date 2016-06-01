package view.aluguel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
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
import javax.swing.table.DefaultTableModel;

import controller.actionlisteners.aluguel.BotaoAdicionarCarrinhoAL;
import controller.actionlisteners.aluguel.BotaoOkNovoAluguel;
import controller.actionlisteners.aluguel.BotaoPesquisarPecaAL;
import controller.actionlisteners.aluguel.BotaoRemoverCarrinhoAL;

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
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(null);
		
		this.pesquisa_text_field = new JTextField();
		this.pesquisa_text_field.setBounds(18, 25, 305, 28);
		this.contentPane.add(this.pesquisa_text_field);
		this.pesquisa_text_field.setColumns(10);
		
		JLabel pesquisar_label = new JLabel("Pesquisar peça:");
		pesquisar_label.setBounds(18, 6, 165, 16);
		this.contentPane.add(pesquisar_label);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(328, 25, 90, 30);
		btnPesquisar.addActionListener(new BotaoPesquisarPecaAL(this));
		this.contentPane.add(btnPesquisar);
		
		DefaultTableModel dft_carrinho = new DefaultTableModel();
		ArrayList<Integer> codigos = new ArrayList<Integer>();
		dft_carrinho.addColumn("Código", codigos.toArray());
		ArrayList<String> tipos = new ArrayList<String>();
		dft_carrinho.addColumn("Tipo", tipos.toArray());
		ArrayList<Integer> tamanhos = new ArrayList<Integer>();
		dft_carrinho.addColumn("Tamanho", tamanhos.toArray());
		ArrayList<String> status = new ArrayList<String>();
		dft_carrinho.addColumn("Status", status.toArray());
		ArrayList<Float> valores = new ArrayList<Float>();
		dft_carrinho.addColumn("Valor", valores.toArray());
		ArrayList<Integer> numero_alugueis = new ArrayList<Integer>();
		dft_carrinho.addColumn("Número alugueis", numero_alugueis.toArray());
		
		this.carrinho_table = new JTable();
		this.carrinho_table.setModel(dft_carrinho);
		this.resultados_table = new JTable();
		
		JScrollPane resultados_scroll_pane = new JScrollPane(this.resultados_table);
		resultados_scroll_pane.setBounds(18, 110, 400, 315);
		this.contentPane.add(resultados_scroll_pane);
		
		
		JScrollPane carrinho_scroll_pane = new JScrollPane(this.carrinho_table);
		carrinho_scroll_pane.setBounds(512, 110, 400, 315);
		this.contentPane.add(carrinho_scroll_pane);
		
		
		this.rdbtnCodigo= new JRadioButton("Código");
		this.rdbtnCodigo.setBounds(18, 58, 77, 23);
		this.contentPane.add(this.rdbtnCodigo);
		
		this.rdbtnTipo = new JRadioButton("Tipo");
		this.rdbtnTipo.setBounds(98, 58, 66, 23);
		this.contentPane.add(this.rdbtnTipo);
		
		ButtonGroup button_group = new ButtonGroup();
		button_group.add(this.rdbtnCodigo);
		button_group.add(this.rdbtnTipo);
		
		this.chckbxApenasDisponveis = new JCheckBox("Apenas disponíveis");
		this.chckbxApenasDisponveis.setBounds(166, 58, 154, 23);
		this.contentPane.add(this.chckbxApenasDisponveis);
		
		JLabel lblResultados = new JLabel("Resultados:");
		lblResultados.setBounds(18, 94, 90, 16);
		this.contentPane.add(lblResultados);
		
		JLabel lblCarrinho = new JLabel("Carrinho:");
		lblCarrinho.setBounds(512, 94, 77, 16);
		this.contentPane.add(lblCarrinho);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(795, 437, 117, 29);
		btnConfirmar.addActionListener(new BotaoOkNovoAluguel(this));
		this.contentPane.add(btnConfirmar);
		
		JButton btnAdicionarCarrinho = new JButton(">>");
		btnAdicionarCarrinho.setBounds(430, 184, 70, 29);
		btnAdicionarCarrinho.addActionListener(new BotaoAdicionarCarrinhoAL(this));
		this.contentPane.add(btnAdicionarCarrinho);
		
		JButton btnRemoverCarrinho = new JButton("<<");
		btnRemoverCarrinho.setBounds(430, 220, 70, 29);
		btnRemoverCarrinho.addActionListener(new BotaoRemoverCarrinhoAL(this));
		this.contentPane.add(btnRemoverCarrinho);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(18, 437, 117, 29);
		btnCancelar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				dispose();
			}
		});
		contentPane.add(btnCancelar);
	}

	public JTextField getPesquisa_text_field() {
		return pesquisa_text_field;
	}

	public void setPesquisa_text_field(JTextField pesquisa_text_field) {
		this.pesquisa_text_field = pesquisa_text_field;
	}

	public JRadioButton getRdbtnCodigo() {
		return rdbtnCodigo;
	}

	public void setRdbtnCodigo(JRadioButton rdbtnCodigo) {
		this.rdbtnCodigo = rdbtnCodigo;
	}

	public JRadioButton getRdbtnTipo() {
		return rdbtnTipo;
	}

	public void setRdbtnTipo(JRadioButton rdbtnTipo) {
		this.rdbtnTipo = rdbtnTipo;
	}

	public JCheckBox getChckbxApenasDisponveis() {
		return chckbxApenasDisponveis;
	}

	public void setChckbxApenasDisponveis(JCheckBox chckbxApenasDisponveis) {
		this.chckbxApenasDisponveis = chckbxApenasDisponveis;
	}

	public JTable getResultados_table() {
		return resultados_table;
	}

	public void setResultados_table(JTable resultados_table) {
		this.resultados_table = resultados_table;
	}

	public JTable getCarrinho_table() {
		return carrinho_table;
	}

	public void setCarrinho_table(JTable carrinho_table) {
		this.carrinho_table = carrinho_table;
	}
	
}
