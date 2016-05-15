package view.actionlisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;

public class SetFiltrosPecaAL implements ActionListener{
	
	private JRadioButton b_todas;
	private JRadioButton b_disponiveis;
	private JRadioButton b_alugadas;
	private JRadioButton b_nome;
	private JRadioButton b_cpf;

	public SetFiltrosPecaAL(JRadioButton todas, JRadioButton disponiveis, JRadioButton alugadas, JRadioButton nome, JRadioButton cpf){
		this.b_todas= todas;
		this.b_disponiveis = disponiveis;
		this.b_alugadas = alugadas;
		this.b_nome = nome;
		this.b_cpf = cpf;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.b_nome.setEnabled(false);
		this.b_cpf.setEnabled(false);
		
		this.b_todas.setEnabled(true);
		this.b_disponiveis.setEnabled(true);
		this.b_alugadas.setEnabled(true);
		
	}



}
