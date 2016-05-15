package view.actionlisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;

public class SetFiltrosPessoaAL implements ActionListener{

	private JRadioButton b_todas;
	private JRadioButton b_disponiveis;
	private JRadioButton b_alugadas;
	private JRadioButton b_nome;
	private JRadioButton b_cpf;
	
	public SetFiltrosPessoaAL(JRadioButton todas, JRadioButton disponiveis, JRadioButton alugadas, JRadioButton nome, JRadioButton cpf){
		this.b_todas = todas;
		this.b_disponiveis = disponiveis;
		this.b_alugadas = alugadas;
		this.b_nome = nome;
		this.b_cpf = cpf;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.b_todas.setEnabled(false);
		this.b_disponiveis.setEnabled(false);
		this.b_alugadas.setEnabled(false);
		
		this.b_nome.setEnabled(true);
		this.b_cpf.setEnabled(true);
	}
}
