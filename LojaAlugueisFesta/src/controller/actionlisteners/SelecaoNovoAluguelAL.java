package controller.actionlisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.NovoAluguelFrame;

public class SelecaoNovoAluguelAL implements ActionListener{

	public SelecaoNovoAluguelAL(){
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		NovoAluguelFrame frame = new NovoAluguelFrame();
		frame.setVisible(true);
	}
}
