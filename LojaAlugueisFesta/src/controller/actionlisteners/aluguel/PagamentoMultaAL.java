package controller.actionlisteners.aluguel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.MensagemFrame;
import view.aluguel.PagamentoMultaFrame;

public class PagamentoMultaAL implements ActionListener{

	private PagamentoMultaFrame frame;
	
	public PagamentoMultaAL(PagamentoMultaFrame frame){
		this.frame = frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(this.frame.getRdbtnNoEfetuado().isSelected()){
			MensagemFrame msg = new MensagemFrame("Cliente bloqueado. Para regularizar a situação, o cliente deve pagar esta multa.");
			msg.setVisible(true);
		}
		else{
			// Encerra o pagamentos e coloca essas informações no aluguel.
			
			//....
			this.frame.dispose();
		}
	}

}
