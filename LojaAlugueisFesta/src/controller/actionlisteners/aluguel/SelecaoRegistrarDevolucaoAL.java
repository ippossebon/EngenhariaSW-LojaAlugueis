package controller.actionlisteners.aluguel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.aluguel.RegistrarDevolucaoFrame;

public class SelecaoRegistrarDevolucaoAL implements ActionListener{
	
	public SelecaoRegistrarDevolucaoAL(){
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		RegistrarDevolucaoFrame frame = new RegistrarDevolucaoFrame();
		frame.setVisible(true);
	}
}
