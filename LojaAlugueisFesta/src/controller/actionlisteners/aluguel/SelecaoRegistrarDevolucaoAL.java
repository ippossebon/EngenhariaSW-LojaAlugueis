package controller.actionlisteners.aluguel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.aluguel.SolicitarCPFClienteFrame;

public class SelecaoRegistrarDevolucaoAL implements ActionListener{
	
	public SelecaoRegistrarDevolucaoAL(){
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		SolicitarCPFClienteFrame frame = new SolicitarCPFClienteFrame(SolicitarCPFClienteFrame.registrar_devolucao);
		frame.setVisible(true);
	}
}
