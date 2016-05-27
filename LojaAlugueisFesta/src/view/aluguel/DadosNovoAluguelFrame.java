package view.aluguel;

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

public class DadosNovoAluguelFrame extends JFrame {

	private JPanel contentPane;
	private ArrayList<Peca> pecas;
	
	public DadosNovoAluguelFrame(ArrayList<Peca> pecas_aluguel) {
		this.pecas = pecas_aluguel;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 351, 334);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCPFCliente = new JLabel("CPF cliente:");
		lblCPFCliente.setBounds(6, 12, 81, 16);
		contentPane.add(lblCPFCliente);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setColumns(14);
		formattedTextField.setBounds(118, 6, 219, 28);
		contentPane.add(formattedTextField);
		
		JLabel lblDataDeIncio = new JLabel("Data de início:");
		lblDataDeIncio.setBounds(6, 52, 98, 16);
		contentPane.add(lblDataDeIncio);
		
		JFormattedTextField formattedTextField_1 = new JFormattedTextField();
		formattedTextField_1.setBounds(118, 46, 219, 28);
		contentPane.add(formattedTextField_1);
		
		JFormattedTextField formattedTextField_2 = new JFormattedTextField();
		formattedTextField_2.setBounds(118, 86, 219, 28);
		contentPane.add(formattedTextField_2);
		
		JLabel lblDataDeFim = new JLabel("Data de fim:");
		lblDataDeFim.setBounds(6, 92, 81, 16);
		contentPane.add(lblDataDeFim);
		
		JTable itens_table = new JTable();
		criarDFTTable(itens_table);
		
		JScrollPane scrollPane = new JScrollPane(itens_table);
		scrollPane.setEnabled(false);
		scrollPane.setBounds(6, 140, 331, 117);
		contentPane.add(scrollPane);
		
		JLabel lblItens = new JLabel("Itens:");
		lblItens.setBounds(6, 120, 61, 16);
		contentPane.add(lblItens);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(6, 269, 117, 29);
		contentPane.add(btnCancelar);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(228, 269, 117, 29);
		contentPane.add(btnOk);
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
