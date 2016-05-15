package controller.actionlisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.CadastroFuncionarioFrame;

public class SelecaoCadastrarFuncionarioAL implements ActionListener{

	public SelecaoCadastrarFuncionarioAL(){
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		CadastroFuncionarioFrame frame = new CadastroFuncionarioFrame();
		frame.setVisible(true);
	}
}
