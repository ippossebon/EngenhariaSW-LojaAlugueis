package view.aluguel;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.Aluguel;
import controller.FecharFrameAL;
import controller.actionlisteners.aluguel.SelecionarAluguelDevolucaoAL;

public class SelecionarAluguelDevolucaoFrame extends JFrame {

	private JPanel contentPane;
	private ArrayList<Aluguel> alugueis_cliente;
	private DefaultTableModel dft_alugueis;
	private JTable alugueis_table;

	public DefaultTableModel getDft_alugueis() {
		return dft_alugueis;
	}

	public void setDft_alugueis(DefaultTableModel dft_alugueis) {
		this.dft_alugueis = dft_alugueis;
	}

	public JTable getAlugueis_table() {
		return alugueis_table;
	}

	public void setAlugueis_table(JTable alugueis_table) {
		this.alugueis_table = alugueis_table;
	}

	public SelecionarAluguelDevolucaoFrame(ArrayList<Aluguel> alugueis, DefaultTableModel dft) {
		setTitle("Selecionar aluguel para devolução");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 448, 342);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAlugueisEmAndamento = new JLabel("Alugueis em andamento:");
		lblAlugueisEmAndamento.setBounds(18, 17, 171, 16);
		contentPane.add(lblAlugueisEmAndamento);
		
		this.alugueis_cliente = alugueis;
		
		alugueis_table = new JTable();
		alugueis_table.setModel(dft);
		alugueis_table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		
		JScrollPane scrollPane = new JScrollPane(alugueis_table);
		scrollPane.setBounds(18, 45, 406, 209);
		contentPane.add(scrollPane);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new SelecionarAluguelDevolucaoAL(this));
		btnOk.setBounds(307, 266, 117, 29);
		contentPane.add(btnOk);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(18, 266, 117, 29);
		btnCancelar.addActionListener(new FecharFrameAL(this));
		contentPane.add(btnCancelar);
	}

	public ArrayList<Aluguel> getAlugueis_cliente() {
		return alugueis_cliente;
	}

	public void setAlugueis_cliente(ArrayList<Aluguel> alugueis_cliente) {
		this.alugueis_cliente = alugueis_cliente;
	}
	
}
