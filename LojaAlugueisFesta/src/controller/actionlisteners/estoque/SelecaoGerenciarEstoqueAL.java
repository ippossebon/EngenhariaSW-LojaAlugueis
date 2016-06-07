package controller.actionlisteners.estoque;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Peca;
import view.estoque.EstoqueFrame;
import database.Database;
import database.DatabaseController;

public class SelecaoGerenciarEstoqueAL implements ActionListener{

	public SelecaoGerenciarEstoqueAL(){
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		EstoqueFrame frame = new EstoqueFrame();
		frame.setVisible(true);
	}
}
