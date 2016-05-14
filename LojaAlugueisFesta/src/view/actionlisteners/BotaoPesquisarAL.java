package view.actionlisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;
import javax.swing.JTextField;

import view.MensagemFrame;
import controller.PesquisaController;

class BotaoPesquisarAL implements ActionListener{
	private JRadioButton button_peca;
	private JRadioButton button_pessoa;
	private JRadioButton b_nome;
	private JRadioButton b_cpf;
	private JRadioButton b_tipo;
	private JRadioButton b_disponiveis;
	private JRadioButton b_alugadas;
	private JTextField text;
	
	public BotaoPesquisarAL (JTextField text, JRadioButton button_peca, JRadioButton button_pessoa, JRadioButton b_nome, JRadioButton b_cpf, JRadioButton b_tipo, JRadioButton b_disp, JRadioButton b_alug){
		this.button_peca = button_peca;
		this.button_pessoa = button_pessoa;
		this.b_nome = b_nome;
		this.b_cpf = b_cpf;
		this.b_cpf = b_tipo;
		this.b_disponiveis = b_disp;
		this.b_alugadas = b_alug;
		this.text = text;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		PesquisaController pesquisa_controller = new PesquisaController();
		
		if (this.button_peca.isSelected()){
			// Pesquisa por peça
			
			if (this.b_tipo.isSelected()){
				if (this.b_disponiveis.isSelected()){
					//pesquisa pela palavra
					
				}else if(this.b_alugadas.isSelected()){
					// pesquisa pela palavra
					
				}else{
					// Pesquisa pela palavra em todo o banco de dados
				}
			}
			else{
				if (this.b_disponiveis.isSelected()){
					//pesquisa pela palavra
					
				}else if(this.b_alugadas.isSelected()){
					// pesquisa pela palavra
					
				}
			}
		}
		else if (this.button_pessoa.isSelected()){ // Pesquisa por pessoa
			if (this.b_nome.isSelected()){
				// Pesquisa pessoa pelo nome
				
			}else if (this.b_cpf.isSelected()){
				// Pesquisa pessoa pelo cpf
				
			}else{
				MensagemFrame msg = new MensagemFrame("Selecione um filtro.");
				msg.setVisible(true);
			}
		}
		else{
			MensagemFrame msg = new MensagemFrame("Selecione uma opção de pesquisa.");
			msg.setVisible(true);
		}
		
	}
	
}

