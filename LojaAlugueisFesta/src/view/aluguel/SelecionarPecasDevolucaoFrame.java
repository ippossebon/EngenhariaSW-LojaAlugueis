package view.aluguel;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.Aluguel;
import controller.FecharFrameAL;
import controller.OperacoesDefaultTableModel;
import controller.actionlisteners.aluguel.AtivaCampoMultaAL;
import controller.actionlisteners.aluguel.DevolverPecaAL;

import javax.swing.JFormattedTextField;

import view.Operacoes;

public class SelecionarPecasDevolucaoFrame extends JFrame {

	private JPanel contentPane;
	private Aluguel aluguel;
	private JTable pecas_table;
	public JSpinner getPorcentagem_multa() {
		return porcentagem_multa;
	}

	public void setPorcentagem_multa(JSpinner porcentagem_multa) {
		this.porcentagem_multa = porcentagem_multa;
	}

	public JCheckBox getChckbxMulta() {
		return chckbxMulta;
	}

	public void setChckbxMulta(JCheckBox chckbxMulta) {
		this.chckbxMulta = chckbxMulta;
	}

	private JSpinner porcentagem_multa;
	private JCheckBox chckbxMulta;
	private JLabel lblSobreO;
	private JLabel lblDataDaDevoluo;
	private JFormattedTextField data_entrega_text_field;

	public SelecionarPecasDevolucaoFrame(Aluguel a) {
		setTitle("Devolução de peças");
		this.aluguel = a;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 394, 417);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		aluguel = a;
		
		JLabel lblSelecioneAsPeas = new JLabel("Selecione a peça que será devolvida:");
		lblSelecioneAsPeas.setBounds(22, 24, 264, 16);
		contentPane.add(lblSelecioneAsPeas);
		
		pecas_table = new JTable();
		DefaultTableModel dft = OperacoesDefaultTableModel.gerarDefaultTableModelPeca(this.aluguel.getPecas());
		pecas_table.setModel(dft);
		pecas_table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		
		JScrollPane scrollPane = new JScrollPane(pecas_table);
		scrollPane.setBounds(22, 52, 344, 183);
		contentPane.add(scrollPane);
		
		data_entrega_text_field = new JFormattedTextField(Operacoes.aplicaMascara("##/##/####"));
		data_entrega_text_field.setBounds(262, 284, 104, 28);
		contentPane.add(data_entrega_text_field);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(249, 360, 117, 29);
		btnOk.addActionListener(new DevolverPecaAL(this));
		contentPane.add(btnOk);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(22, 360, 117, 29);
		btnCancelar.addActionListener(new FecharFrameAL(this));
		contentPane.add(btnCancelar);
		
		chckbxMulta = new JCheckBox("Multa");
		chckbxMulta.addActionListener(new AtivaCampoMultaAL(this));
		chckbxMulta.setBounds(22, 247, 80, 23);
		contentPane.add(chckbxMulta);
		
		// Valor inicial = 10, varia entre 10 e 200, incremento de 10 
		SpinnerNumberModel spinner_model = new SpinnerNumberModel(10, 10, 200, 10);
		
		porcentagem_multa = new JSpinner(spinner_model);
		porcentagem_multa.setEnabled(false);
		porcentagem_multa.setBounds(286, 245, 80, 28);
		contentPane.add(porcentagem_multa);
		
		lblSobreO = new JLabel("(% sobre o valor da peça)");
		lblSobreO.setBounds(101, 251, 173, 16);
		contentPane.add(lblSobreO);
		
		lblDataDaDevoluo = new JLabel("Data da devolução:");
		lblDataDaDevoluo.setBounds(22, 290, 138, 16);
		contentPane.add(lblDataDaDevoluo);
	}

	public JFormattedTextField getData_entrega_text_field() {
		return data_entrega_text_field;
	}

	public void setData_entrega_text_field(
			JFormattedTextField data_entrega_text_field) {
		this.data_entrega_text_field = data_entrega_text_field;
	}

	public Aluguel getAluguel() {
		return aluguel;
	}

	public void setAluguel(Aluguel aluguel) {
		this.aluguel = aluguel;
	}

	public JTable getPecas_table() {
		return pecas_table;
	}

	public void setPecas_table(JTable pecas_table) {
		this.pecas_table = pecas_table;
	}
}
