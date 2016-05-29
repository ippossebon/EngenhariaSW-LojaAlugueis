package controller.actionlisteners.estoque;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.estoque.EstoqueFrame;

public class SelecaoGerenciarEstoqueAL implements ActionListener{

	public SelecaoGerenciarEstoqueAL(){
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		EstoqueFrame frame = new EstoqueFrame();
		frame.setVisible(true);
		
	}
}
