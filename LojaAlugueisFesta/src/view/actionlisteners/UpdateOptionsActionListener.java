package view.actionlisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;

public class UpdateOptionsActionListener implements ActionListener{
	private JRadioButton button_peca;
	private JRadioButton button_pessoa;
	private JRadioButton button_funcionario;
	private JRadioButton b_nome;
	private JRadioButton b_cpf;
	private JRadioButton b_tipo;
	private JRadioButton b_disponiveis;
	private JRadioButton b_alugadas;
	
	
	public UpdateOptionsActionListener(JRadioButton button_peca, JRadioButton button_pessoa, JRadioButton button_funcionario, JRadioButton b_nome, JRadioButton b_cpf, JRadioButton b_tipo, JRadioButton b_disp, JRadioButton b_alug){
		this.button_peca = button_peca;
		this.button_pessoa = button_pessoa;
		this.button_funcionario = button_funcionario;
		this.b_nome = b_nome;
		this.b_cpf = b_cpf;
		this.b_cpf = b_tipo;
		this.b_disponiveis = b_disp;
		this.b_alugadas = b_alug;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (this.button_peca.isSelected()){
			this.b_nome.setEnabled(false);
			this.b_cpf.setEnabled(false);
		}
		
		if(this.button_pessoa.isSelected() || this.button_funcionario.isSelected()){
			this.b_tipo.setEnabled(false);
			this.b_disponiveis.setEnabled(false);
			this.b_alugadas.setEnabled(false);
		}
		
	}
}