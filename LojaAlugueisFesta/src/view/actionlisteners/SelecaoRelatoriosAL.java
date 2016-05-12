package view.actionlisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.RelatoriosFrame;

public class SelecaoRelatoriosAL implements ActionListener{

	public SelecaoRelatoriosAL(){
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		RelatoriosFrame frame = new RelatoriosFrame();
		frame.setVisible(true);
	}
}
