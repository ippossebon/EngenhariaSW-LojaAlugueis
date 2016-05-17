package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class EstoqueFrame extends JFrame {

	private JPanel contentPane;

	public EstoqueFrame() {
		setTitle("Estoque");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 628, 495);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 6, 485, 461);
		contentPane.add(scrollPane);
		
		JButton btnAdicionarPea = new JButton("Adicionar peça");
		btnAdicionarPea.setBounds(503, 6, 117, 29);
		contentPane.add(btnAdicionarPea);
		
		JButton btnRemoverPea = new JButton("Remover peça");
		btnRemoverPea.setBounds(503, 47, 117, 29);
		contentPane.add(btnRemoverPea);
		
		JButton btnAlterarValor = new JButton("Alterar valor");
		btnAlterarValor.setBounds(503, 88, 117, 29);
		contentPane.add(btnAlterarValor);
	}
}
