package controller.actionlisteners.aluguel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;

import view.aluguel.SelecionarPecasDevolucaoFrame;

public class AtivaCampoMultaAL implements ActionListener{

	private SelecionarPecasDevolucaoFrame frame;
	
	public AtivaCampoMultaAL(SelecionarPecasDevolucaoFrame frame){
		this.frame = frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (this.frame.getPecas_table().getSelectedRow() != -1){
			if(this.frame.getChckbxMulta().isSelected()){
				this.frame.getPorcentagem_multa().setEnabled(true);
			}
		}
	}

}
