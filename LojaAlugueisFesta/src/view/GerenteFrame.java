package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GerenteFrame extends FuncionarioFrame {

	private JPanel contentPane;


	public GerenteFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(contentPane);
		
		
		JButton btnAcessarRelatorios = new JButton("Acessar relatórios");
		btnAcessarRelatorios.setBounds(522, 348, 166, 29);
		contentPane.add(btnAcessarRelatorios);
		super.add(btnAcessarRelatorios);
		
		JButton btnGerenciarEstoque = new JButton("Gerenciar estoque");
		btnGerenciarEstoque.setBounds(522, 389, 166, 29);
		contentPane.add(btnGerenciarEstoque);
		super.add(btnGerenciarEstoque);
	}

}
