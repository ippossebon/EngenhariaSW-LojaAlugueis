package view.actionlisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.EstoqueFrame;

public class SelecaoGerenciarEstoqueAL implements ActionListener{

	public SelecaoGerenciarEstoqueAL(){
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		EstoqueFrame frame = new EstoqueFrame();
		frame.setVisible(true);
		
	}
}
