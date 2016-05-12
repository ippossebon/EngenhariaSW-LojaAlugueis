package view.actionlisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;

public class DisableFiltrosPecaAL implements ActionListener{

	private JRadioButton b_todas;
	private JRadioButton b_disponiveis;
	private JRadioButton b_alugadas;
	
	public DisableFiltrosPecaAL(JRadioButton todas, JRadioButton disponiveis, JRadioButton alugadas){
		this.b_todas = todas;
		this.b_disponiveis = disponiveis;
		this.b_alugadas = alugadas;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.b_todas.setEnabled(false);
		this.b_disponiveis.setEnabled(false);
		this.b_alugadas.setEnabled(false);
	}
}
