package view.aluguel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.Peca;
import view.Operacoes;
import controller.actionlisteners.BotaoRemoverPecaCarrinhoAL;

public class DadosNovoAluguelFrame extends JFrame {

	private JPanel contentPane;
	private ArrayList<Peca> pecas;
	private JTable itens_table;
	private JFormattedTextField cpf_text_field;
	private JFormattedTextField data_inicio_text_field;
	private JFormattedTextField data_fim_text_field;
	
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
		setBounds(100, 100, 442, 334);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCPFCliente = new JLabel("CPF cliente:");
		lblCPFCliente.setBounds(6, 12, 81, 16);
		contentPane.add(lblCPFCliente);
		
		cpf_text_field = new JFormattedTextField(Operacoes.aplicaMascara("###.###.###-##"));
		cpf_text_field.setColumns(14);
		cpf_text_field.setBounds(118, 6, 318, 28);
		contentPane.add(cpf_text_field);
		
		JLabel lblDataDeIncio = new JLabel("Data de início:");
		lblDataDeIncio.setBounds(6, 52, 98, 16);
		contentPane.add(lblDataDeIncio);
		
		data_inicio_text_field = new JFormattedTextField(Operacoes.aplicaMascara("##/##/####"));
		data_inicio_text_field.setBounds(118, 46, 105, 28);
		contentPane.add(data_inicio_text_field);
		
		data_fim_text_field = new JFormattedTextField(Operacoes.aplicaMascara("##/##/####"));
		data_fim_text_field.setBounds(331, 46, 105, 28);
		contentPane.add(data_fim_text_field);
		
		JLabel lblDataDeFim = new JLabel("Data de fim:");
		lblDataDeFim.setBounds(238, 52, 81, 16);
		contentPane.add(lblDataDeFim);
		
		itens_table = new JTable();
		criarDFTTable(itens_table);
		
		JScrollPane scrollPane = new JScrollPane(itens_table);
		scrollPane.setEnabled(false);
		scrollPane.setBounds(6, 131, 331, 117);
		contentPane.add(scrollPane);
		
		JLabel lblItens = new JLabel("Itens:");
		lblItens.setBounds(6, 103, 61, 16);
		contentPane.add(lblItens);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(6, 269, 93, 29);
		btnCancelar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e)
		    {
		      dispose();
		    }
		});
		contentPane.add(btnCancelar);
		
		JButton btnOk = new JButton("Confirmar");
		btnOk.setBounds(343, 269, 93, 29);
		contentPane.add(btnOk);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.setBounds(343, 127, 93, 29);
		btnRemover.addActionListener(new BotaoRemoverPecaCarrinhoAL(this));
		contentPane.add(btnRemover);
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
}
