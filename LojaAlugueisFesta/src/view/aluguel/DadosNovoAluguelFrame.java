package view.aluguel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.Peca;
import view.Operacoes;
import controller.actionlisteners.aluguel.BotaoEfetuarAluguelAL;
import controller.actionlisteners.aluguel.BotaoRemoverPecaCarrinhoAL;

public class DadosNovoAluguelFrame extends JFrame {

	private JPanel contentPane;
	private ArrayList<Peca> pecas;
	private JTable itens_table;
	private JFormattedTextField cpf_text_field;
	private JFormattedTextField data_inicio_text_field;
	private JFormattedTextField data_fim_text_field;
	private JTextField total_text_field;
	private JRadioButton rdbtnCartoDeCrditodbito;
	private JRadioButton rdbtnDinheiro;
	private JRadioButton rdbtnNoEfetuado;
	
	public JTextField getTotal_text_field() {
		return total_text_field;
	}

	public void setTotal_text_field(JTextField total_text_field) {
		this.total_text_field = total_text_field;
	}

	public JRadioButton getRdbtnCartoDeCrditodbito() {
		return rdbtnCartoDeCrditodbito;
	}

	public void setRdbtnCartoDeCrditodbito(JRadioButton rdbtnCartoDeCrditodbito) {
		this.rdbtnCartoDeCrditodbito = rdbtnCartoDeCrditodbito;
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

	public JFormattedTextField getCpf_text_field() {
		return cpf_text_field;
	}

	public void setCpf_text_field(JFormattedTextField cpf_text_field) {
		this.cpf_text_field = cpf_text_field;
	}

	public JFormattedTextField getData_inicio_text_field() {
		return data_inicio_text_field;
	}

	public void setData_inicio_text_field(JFormattedTextField data_inicio_text_field) {
		this.data_inicio_text_field = data_inicio_text_field;
	}

	public JFormattedTextField getData_fim_text_field() {
		return data_fim_text_field;
	}

	public void setData_fim_text_field(JFormattedTextField data_fim_text_field) {
		this.data_fim_text_field = data_fim_text_field;
	}

	public ArrayList<Peca> getPecas() {
		return pecas;
	}

	public void setPecas(ArrayList<Peca> pecas) {
		this.pecas = pecas;
	}

	public JTable getItens_table() {
		return itens_table;
	}

	public void setItens_table(JTable itens_table) {
		this.itens_table = itens_table;
	}

	public DadosNovoAluguelFrame(ArrayList<Peca> pecas_aluguel) {
		this.pecas = pecas_aluguel;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 378, 537);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCPFCliente = new JLabel("CPF cliente:");
		lblCPFCliente.setBounds(16, 12, 81, 16);
		contentPane.add(lblCPFCliente);
		
		cpf_text_field = new JFormattedTextField(Operacoes.aplicaMascara("###.###.###-##"));
		cpf_text_field.setColumns(14);
		cpf_text_field.setBounds(128, 6, 237, 28);
		contentPane.add(cpf_text_field);
		
		JLabel lblDataDeIncio = new JLabel("Data de início:");
		lblDataDeIncio.setBounds(16, 52, 98, 16);
		contentPane.add(lblDataDeIncio);
		
		data_inicio_text_field = new JFormattedTextField(Operacoes.aplicaMascara("##/##/####"));
		data_inicio_text_field.setBounds(128, 46, 105, 28);
		contentPane.add(data_inicio_text_field);
		
		data_fim_text_field = new JFormattedTextField(Operacoes.aplicaMascara("##/##/####"));
		data_fim_text_field.setBounds(128, 87, 105, 28);
		contentPane.add(data_fim_text_field);
		
		JLabel lblDataDeFim = new JLabel("Data de fim:");
		lblDataDeFim.setBounds(16, 93, 81, 16);
		contentPane.add(lblDataDeFim);
		
		itens_table = new JTable();
		criarDFTTable(itens_table);
		
		JScrollPane scrollPane = new JScrollPane(itens_table);
		scrollPane.setEnabled(false);
		scrollPane.setBounds(16, 159, 349, 89);
		contentPane.add(scrollPane);
		
		JLabel lblItens = new JLabel("Itens:");
		lblItens.setBounds(16, 140, 61, 16);
		contentPane.add(lblItens);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(11, 480, 93, 29);
		btnCancelar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e)
		    {
		      dispose();
		    }
		});
		contentPane.add(btnCancelar);
		
		JButton btnOk = new JButton("Confirmar");
		btnOk.setBounds(260, 480, 105, 29);
		btnOk.addActionListener(new BotaoEfetuarAluguelAL(this));
		contentPane.add(btnOk);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(6, 295, 359, 12);
		contentPane.add(separator);
		
		JLabel lblMtodoDePagamento = new JLabel("Método de pagamento:");
		lblMtodoDePagamento.setBounds(16, 319, 173, 16);
		contentPane.add(lblMtodoDePagamento);
		
		JComboBox<String> comboBox_cartoes = new JComboBox<String>();
		comboBox_cartoes.setEnabled(false);
		comboBox_cartoes.addItem("Visa");
		comboBox_cartoes.addItem("Master Card");
		comboBox_cartoes.setBounds(239, 347, 126, 27);
		contentPane.add(comboBox_cartoes);
		
		rdbtnCartoDeCrditodbito = new JRadioButton("Cartão de crédito/débito");
		rdbtnCartoDeCrditodbito.setBounds(16, 347, 196, 23);
		rdbtnCartoDeCrditodbito.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				comboBox_cartoes.setEnabled(true);
			}
		});
		contentPane.add(rdbtnCartoDeCrditodbito);
		
		rdbtnDinheiro = new JRadioButton("Dinheiro");
		rdbtnDinheiro.setBounds(16, 382, 141, 23);
		contentPane.add(rdbtnDinheiro);
		
		rdbtnNoEfetuado = new JRadioButton("Não efetuado");
		rdbtnNoEfetuado.setBounds(16, 417, 141, 23);
		contentPane.add(rdbtnNoEfetuado);
		
		ButtonGroup button_group = new ButtonGroup();
		button_group.add(rdbtnNoEfetuado);
		button_group.add(rdbtnDinheiro);
		button_group.add(rdbtnCartoDeCrditodbito);
		
		JLabel lblTotal = new JLabel("Total (R$):");
		lblTotal.setBounds(16, 260, 98, 16);
		contentPane.add(lblTotal);
		
		float total = calculaValorTotalAluguel();
		
		total_text_field = new JTextField();
		total_text_field.setEditable(false);
		total_text_field.setBounds(213, 255, 152, 28);
		total_text_field.setText(String.valueOf(total));
		contentPane.add(total_text_field);
		total_text_field.setColumns(10);
	}
	
	private void criarDFTTable(JTable table){
		
		DefaultTableModel dft = new DefaultTableModel();
		ArrayList<Integer> codigos = new ArrayList<Integer>();
		ArrayList<String> tipos = new ArrayList<String>(); 
		ArrayList<Integer> tamanhos = new ArrayList<Integer>();
		ArrayList<Float> valores = new ArrayList<Float>();
		
		for (Peca p : pecas){
			codigos.add(p.getCodigo_peca());
			tipos.add(p.getTipo());
			tamanhos.add(p.getTamanho());
			valores.add(p.getValor());
		}
		
		dft.addColumn("Código", codigos.toArray());
		dft.addColumn("Tipo", tipos.toArray());
		dft.addColumn("Tamanho", tamanhos.toArray());
		dft.addColumn("Valor", valores.toArray());

		table.setModel(dft);
	}
	
	private float calculaValorTotalAluguel(){
		float total = 0;
		
		for (Peca p : this.pecas){
			total+= p.getValor();
		}
		
		return total;
	}
}
