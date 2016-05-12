package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class GerenteFrame extends FuncionarioFrame {

	private JPanel contentPane;


	public GerenteFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		JButton btnAcessarRelatorios = new JButton("Acessar relatórios");
		btnAcessarRelatorios.setBounds(522, 348, 166, 29);
		contentPane.add(btnAcessarRelatorios);
		
		JButton btnGerenciarEstoque = new JButton("Gerenciar estoque");
		btnGerenciarEstoque.setBounds(522, 389, 166, 29);
		contentPane.add(btnGerenciarEstoque);
	}

}
