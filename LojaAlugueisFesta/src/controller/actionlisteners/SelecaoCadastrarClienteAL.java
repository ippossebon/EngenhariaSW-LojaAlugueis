package controller.actionlisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.cadastro.CadastroFrame;

public class SelecaoCadastrarClienteAL implements ActionListener{

	public SelecaoCadastrarClienteAL(){
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		CadastroFrame frame = new CadastroFrame();
		frame.setVisible(true);
	}

}
