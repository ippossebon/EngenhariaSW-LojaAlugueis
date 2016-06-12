package view.aluguel;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.actionlisteners.aluguel.PagamentoMultaAL;
import javax.swing.JSeparator;

public class PagamentoMultaFrame extends JFrame {

	private JPanel contentPane;
	private float valor;
	private JTextField valor_multa_text_field;
	private JRadioButton rdbtnCartoCrditodbito;
	private JRadioButton rdbtnDinheiro;
	private JRadioButton rdbtnNoEfetuado;
	private JSeparator separator;

	public JTextField getValor_multa_text_field() {
		return valor_multa_text_field;
	}

	public void setValor_multa_text_field(JTextField valor_multa_text_field) {
		this.valor_multa_text_field = valor_multa_text_field;
	}

	public JRadioButton getRdbtnCartoCrditodbito() {
		return rdbtnCartoCrditodbito;
	}

	public void setRdbtnCartoCrditodbito(JRadioButton rdbtnCartoCrditodbito) {
		this.rdbtnCartoCrditodbito = rdbtnCartoCrditodbito;
	}

	public JRadioButton getRdbtnDinheiro() {
		return rdbtnDinheiro;
	}

	public void setRdbtnDinheiro(JRadioButton rdbtnDinheiro) {
		this.rdbtnDinheiro = rdbtnDinheiro;
	}

	public JRadioButton getRdbtnNoEfetuado() {
		return rdbtnNoEfetuado;
	}

	public void setRdbtnNoEfetuado(JRadioButton rdbtnNoEfetuado) {
		this.rdbtnNoEfetuado = rdbtnNoEfetuado;
	}

	public PagamentoMultaFrame(float valor, int id_aluguel) {
		
		this.valor = valor;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 340, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblValorDaMulta = new JLabel("Valor da multa: (R$)");
		lblValorDaMulta.setBounds(18, 30, 135, 16);
		contentPane.add(lblValorDaMulta);
		
		valor_multa_text_field = new JTextField();
		valor_multa_text_field.setText(String.valueOf(valor));
		valor_multa_text_field.setEditable(false);
		valor_multa_text_field.setBounds(192, 24, 135, 28);
		contentPane.add(valor_multa_text_field);
		valor_multa_text_field.setColumns(10);
		
		JLabel lblPagamento = new JLabel("Pagamento:");
		lblPagamento.setBounds(18, 85, 87, 16);
		contentPane.add(lblPagamento);
		
		rdbtnCartoCrditodbito = new JRadioButton("Cartão crédito/débito");
		rdbtnCartoCrditodbito.setBounds(12, 117, 174, 23);
		contentPane.add(rdbtnCartoCrditodbito);
		
		rdbtnDinheiro = new JRadioButton("Dinheiro");
		rdbtnDinheiro.setBounds(12, 152, 99, 23);
		contentPane.add(rdbtnDinheiro);
		
		rdbtnNoEfetuado = new JRadioButton("Não efetuado");
		rdbtnNoEfetuado.setBounds(12, 190, 124, 23);
		contentPane.add(rdbtnNoEfetuado);
		
		ButtonGroup button_group = new ButtonGroup();
		button_group.add(rdbtnCartoCrditodbito);
		button_group.add(rdbtnDinheiro);
		button_group.add(rdbtnNoEfetuado);
		
		JComboBox<String> cartoes_combo_box = new JComboBox<String>();
		cartoes_combo_box.setBounds(191, 117, 135, 27);
		cartoes_combo_box.addItem("Master Card");
		cartoes_combo_box.addItem("Visa");
		contentPane.add(cartoes_combo_box);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new PagamentoMultaAL(this, id_aluguel));
		btnOk.setBounds(217, 243, 117, 29);
		
		contentPane.add(btnOk);
		
		separator = new JSeparator();
		separator.setBounds(6, 60, 328, 12);
		contentPane.add(separator);
	}
	
	public PagamentoMultaFrame(){
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 340, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblValorDaMulta = new JLabel("Valor da multa: (R$)");
		lblValorDaMulta.setBounds(18, 30, 135, 16);
		contentPane.add(lblValorDaMulta);
		
		valor_multa_text_field = new JTextField();
		//valor_multa_text_field.setText(String.valueOf(valor));
		valor_multa_text_field.setEditable(false);
		valor_multa_text_field.setBounds(192, 24, 135, 28);
		contentPane.add(valor_multa_text_field);
		valor_multa_text_field.setColumns(10);
		
		JLabel lblPagamento = new JLabel("Pagamento:");
		lblPagamento.setBounds(18, 85, 87, 16);
		contentPane.add(lblPagamento);
		
		rdbtnCartoCrditodbito = new JRadioButton("Cartão crédito/débito");
		rdbtnCartoCrditodbito.setBounds(12, 117, 174, 23);
		contentPane.add(rdbtnCartoCrditodbito);
		
		rdbtnDinheiro = new JRadioButton("Dinheiro");
		rdbtnDinheiro.setBounds(12, 152, 99, 23);
		contentPane.add(rdbtnDinheiro);
		
		rdbtnNoEfetuado = new JRadioButton("Não efetuado");
		rdbtnNoEfetuado.setBounds(12, 190, 124, 23);
		contentPane.add(rdbtnNoEfetuado);
		
		ButtonGroup button_group = new ButtonGroup();
		button_group.add(rdbtnCartoCrditodbito);
		button_group.add(rdbtnDinheiro);
		button_group.add(rdbtnNoEfetuado);
		
		JComboBox<String> cartoes_combo_box = new JComboBox<String>();
		cartoes_combo_box.setBounds(191, 117, 135, 27);
		cartoes_combo_box.addItem("Master Card");
		cartoes_combo_box.addItem("Visa");
		contentPane.add(cartoes_combo_box);
		
		JButton btnOk = new JButton("OK");
		//btnOk.addActionListener(new PagamentoMultaAL(this, id_aluguel));
		btnOk.setBounds(217, 243, 117, 29);
		
		contentPane.add(btnOk);
		
		separator = new JSeparator();
		separator.setBounds(6, 60, 328, 12);
		contentPane.add(separator);
	}
}
