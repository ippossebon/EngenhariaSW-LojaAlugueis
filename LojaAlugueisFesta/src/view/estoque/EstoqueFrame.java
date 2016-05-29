package view.estoque;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.Peca;
import controller.actionlisteners.estoque.BotaoAlterarPrecoPecaAL;
import controller.actionlisteners.estoque.BotaoRemoverDoEstoqueAL;
import database.Database;
import database.DatabaseController;

public class EstoqueFrame extends JFrame {

	private JPanel contentPane;
	private JTable estoque_table;

	public EstoqueFrame() {
		setTitle("Estoque");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 628, 495);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		estoque_table = new JTable();
		
		criaDFTEstoque();
		
		JScrollPane scrollPane = new JScrollPane(estoque_table);
		scrollPane.setBounds(6, 6, 485, 461);
		contentPane.add(scrollPane);
		
		JButton btnAdicionarPea = new JButton("Adicionar peça");
		btnAdicionarPea.setBounds(503, 6, 117, 29);
		contentPane.add(btnAdicionarPea);
		
		JButton btnRemoverPea = new JButton("Remover peça");
		btnRemoverPea.setBounds(503, 47, 117, 29);
		btnRemoverPea.addActionListener(new BotaoRemoverDoEstoqueAL(this));
		contentPane.add(btnRemoverPea);
		
		JButton btnAlterarValor = new JButton("Alterar valor");
		btnAlterarValor.setBounds(503, 88, 117, 29);
		btnAlterarValor.addActionListener(new BotaoAlterarPrecoPecaAL(this));
		contentPane.add(btnAlterarValor);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBounds(511, 438, 117, 29);
		btnAtualizar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e)
		    {
		    	criaDFTEstoque();
		    	estoque_table.repaint();
		    }
		});
		contentPane.add(btnAtualizar);
	}

	public JTable getEstoque_table() {
		return estoque_table;
	}

	public void setEstoque_table(JTable estoque_table) {
		this.estoque_table = estoque_table;
	}
	
	private void criaDFTEstoque(){
		
		DefaultTableModel dft = new DefaultTableModel();
		ArrayList<Integer> codigos = new ArrayList<Integer>();
		ArrayList<String> tipos = new ArrayList<String>();
		ArrayList<Integer> tamanhos = new ArrayList<Integer>();
		ArrayList<Float> valores = new ArrayList<Float>();
		ArrayList<String> status = new ArrayList<String>();
		DatabaseController db_controller = new DatabaseController(Database.getInstance());
		
		for (Peca p : db_controller.getPecas()){
			codigos.add(p.getCodigo_peca());
			tipos.add(p.getTipo());
			tamanhos.add(p.getTamanho());
			valores.add((float)p.getValor());
			
			if (p.isDisponivel()){
				status.add("Disponível");
			}
			else{
				status.add("Alugada");
			}
		}
		
		dft.addColumn("Código", codigos.toArray());
		dft.addColumn("Tipo", tipos.toArray());
		dft.addColumn("Tamanho", tamanhos.toArray());
		dft.addColumn("Valor", valores.toArray());
		dft.addColumn("Status", status.toArray());
		estoque_table.setModel(dft);
	}
}
