package view.actionlisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import view.MensagemFrame;
import controller.PesquisaController;

class BotaoPesquisarAL implements ActionListener{
	private JRadioButton button_peca;
	private JRadioButton button_cliente;
	private JRadioButton button_funcionario;
	private JRadioButton b_nome;
	private JRadioButton b_cpf;
	private JRadioButton b_tipo;
	private JRadioButton b_disponiveis;
	private JRadioButton b_alugadas;
	private JTextField text;
	private JFrame frame;
	
	public BotaoPesquisarAL (JFrame frame, JTextField text, JRadioButton button_peca, JRadioButton button_cliente, JRadioButton button_funcionario, JRadioButton b_nome, JRadioButton b_cpf, JRadioButton b_tipo, JRadioButton b_disp, JRadioButton b_alug){
		this.button_peca = button_peca;
		this.button_cliente = button_cliente;
		this.button_funcionario = button_funcionario;
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
		DefaultTableModel dft = new DefaultTableModel();
		
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
		else if (this.button_cliente.isSelected()){ // Pesquisa por cliente
			if (this.b_nome.isSelected()){
				// Pesquisa cliente pelo nome
				
			}
			else if (this.b_cpf.isSelected()){
				// Pesquisa cliente pelo cpf
				
			}
			else{
				MensagemFrame msg = new MensagemFrame("Erro: Selecione um filtro.");
				msg.setVisible(true);
			}
		}
		else if(this.button_funcionario.isSelected()){ // Pesquisa por funcionário
			if (this.b_nome.isSelected()){
				// Pesquisa funcionario pelo nome
				
				
			}
			else if (this.b_cpf.isSelected()){
				// Pesquisa funcionario pelo cpf
				
			}
			else{
				MensagemFrame msg = new MensagemFrame("Erro: Selecione um filtro.");
				msg.setVisible(true);
			}	
		}
		else{
			MensagemFrame msg = new MensagemFrame("Erro: Selecione uma opção de pesquisa.");
			msg.setVisible(true);
		}
		
	}
}

