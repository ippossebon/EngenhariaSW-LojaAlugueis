package controller.actionlisteners.aluguel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.aluguel.NovoAluguelFrame;
import controller.AluguelController;

public class BotaoAluguelAL implements ActionListener{

	private NovoAluguelFrame frame;
	
	public BotaoAluguelAL(NovoAluguelFrame frame){
		this.frame = frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		AluguelController aluguel_controller = new AluguelController();
		System.out.println("CLIQUEI");
	}

}
