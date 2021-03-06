package view.aluguel;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
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
import view.MensagemFrame;
import view.Operacoes;
import controller.FecharFrameAL;
import controller.OperacoesDefaultTableModel;
import controller.actionlisteners.aluguel.AtivaCampoMultaAL;
import controller.actionlisteners.aluguel.DevolverPecaAL;

public class SelecionarPecasDevolucaoFrame extends JFrame {

	private JPanel contentPane;
	private Aluguel aluguel;
	private JTable pecas_table;
	private JSpinner porcentagem_multa_dano_perda;
	private JCheckBox chckbxMulta;
	private JLabel lblSobreO;
	private JLabel lblDataDaDevoluo;
	private JFormattedTextField data_entrega_text_field;

	public SelecionarPecasDevolucaoFrame(Aluguel a) {
		setTitle("Devolução de peças");
		this.aluguel = a;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 394, 417);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		aluguel = a;
		
		if(this.aluguel.getPecasDevolucao().isEmpty()){
			dispose();
			MensagemFrame msg = new MensagemFrame("Não existem peças para devolção");
			msg.setVisible(true);
		}
		else{
			JLabel lblSelecioneAsPeas = new JLabel("Selecione a peça que será devolvida:");
			lblSelecioneAsPeas.setBounds(22, 24, 264, 16);
			contentPane.add(lblSelecioneAsPeas);
			
			pecas_table = new JTable();
			DefaultTableModel dft = OperacoesDefaultTableModel.gerarDefaultTableModelPeca(this.aluguel.getPecasDevolucao());
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
			
			chckbxMulta = new JCheckBox("Multa (dano/perda)");
			chckbxMulta.addActionListener(new AtivaCampoMultaAL(this));
			chckbxMulta.setBounds(22, 247, 250, 23);
			contentPane.add(chckbxMulta);
			
			// Valor inicial = 10, varia entre 10 e 200, incremento de 10 
			SpinnerNumberModel spinner_model = new SpinnerNumberModel(10, 10, 200, 10);
			
			porcentagem_multa_dano_perda = new JSpinner(spinner_model);
			porcentagem_multa_dano_perda.setEnabled(false);
			porcentagem_multa_dano_perda.setBounds(290, 245, 80, 28);
			contentPane.add(porcentagem_multa_dano_perda);
			
			lblDataDaDevoluo = new JLabel("Data da devolução:");
			lblDataDaDevoluo.setBounds(22, 290, 138, 16);
			contentPane.add(lblDataDaDevoluo);
		}
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
	
	public JSpinner getPorcentagem_multa() {
		return porcentagem_multa_dano_perda;
	}

	public void setPorcentagem_multa(JSpinner porcentagem_multa) {
		this.porcentagem_multa_dano_perda = porcentagem_multa;
	}

	public JCheckBox getChckbxMulta() {
		return chckbxMulta;
	}

	public void setChckbxMulta(JCheckBox chckbxMulta) {
		this.chckbxMulta = chckbxMulta;
	}
}
