package view.actionlisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;

public class DisableFiltrosPessoaAL implements ActionListener{
	
	private JRadioButton b_nome;
	private JRadioButton b_cpf;

	public DisableFiltrosPessoaAL(JRadioButton nome, JRadioButton cpf){
		this.b_nome = nome;
		this.b_cpf = cpf;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.b_nome.setEnabled(false);
		this.b_cpf.setEnabled(false);
		
	}



}
