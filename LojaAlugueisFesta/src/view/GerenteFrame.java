package view;

import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import controller.actionlisteners.SelecaoGerenciarEstoqueAL;
import controller.actionlisteners.SelecaoRelatoriosAL;

public class GerenteFrame extends FuncionarioFrame {

	private JPanel contentPane;


	public GerenteFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		 /* Menu Estoque - Atalho: E */
	    JMenu estoqueMenu = new JMenu("Estoque");
	    estoqueMenu.setMnemonic(KeyEvent.VK_E);
	    super.getJMenuBar().add(estoqueMenu);
	    
	    JMenuItem gerenciarEstoqueItem = new JMenuItem("Gerenciar estoque...");
	    gerenciarEstoqueItem.addActionListener(new SelecaoGerenciarEstoqueAL());
	    estoqueMenu.add(gerenciarEstoqueItem);
	    
	    /* Menu Relatórios - Atalho: R */
	    JMenu relatoriosMenu = new JMenu("Relatórios");
	    relatoriosMenu.setMnemonic(KeyEvent.VK_R);
	    super.getJMenuBar().add(relatoriosMenu);
	    
	    JMenuItem itemGerarRelatorios = new JMenuItem("Gerar relatórios...");
	    itemGerarRelatorios.addActionListener(new SelecaoRelatoriosAL());
	    relatoriosMenu.add(itemGerarRelatorios);
	    
	}

}
