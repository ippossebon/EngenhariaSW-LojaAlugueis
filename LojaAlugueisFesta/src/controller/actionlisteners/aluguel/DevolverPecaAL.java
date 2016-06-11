package controller.actionlisteners.aluguel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Data;
import view.MensagemFrame;
import view.aluguel.PagamentoMultaFrame;
import view.aluguel.SelecionarPecasDevolucaoFrame;
import controller.AluguelController;

public class DevolverPecaAL implements ActionListener{

	private SelecionarPecasDevolucaoFrame frame;
	
	public DevolverPecaAL(SelecionarPecasDevolucaoFrame f){
		this.frame = f;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int linha_peca_selecionada = this.frame.getPecas_table().getSelectedRow();
		
		if (linha_peca_selecionada != -1){
			int codigo_peca_selecionada = Integer.parseInt(this.frame.getPecas_table().getValueAt(linha_peca_selecionada, 0).toString());
			int id_aluguel = this.frame.getAluguel().getId();
			String data_entrega = this.frame.getData_entrega_text_field().getText();
			AluguelController aluguel_controller = new AluguelController();
			
			if(!data_entrega.isEmpty()){
				if(this.frame.getChckbxMulta().isSelected()){
					// Contabiliza o valor da multa, e encaminha para a janela de pagamento da multa.
					
					// TO DO
					
					// Calcula multa
					float valor_multa = 0;
					PagamentoMultaFrame frame_pagamento_multa = new PagamentoMultaFrame(valor_multa);
					frame_pagamento_multa.setVisible(true);
					
					// cobra multa
					
					// Devolve peças
					
					
					// atualiza tela
					
					
					MensagemFrame msg = new MensagemFrame("Peça " + codigo_peca_selecionada + " devolvida com sucesso.");
					msg.setVisible(true);
				}
				else{
					// Devolve a peça normalmente.
					aluguel_controller.registrarDevolucao(id_aluguel, codigo_peca_selecionada, data_entrega);
					this.frame.dispose();
				}
			}
			else{
				MensagemFrame msg = new MensagemFrame("Data inválida!");
				msg.setVisible(true);
			}
		}
		else{
			MensagemFrame msg = new MensagemFrame("Selecione uma peça para devolver.");
			msg.setVisible(true);
		}
	}

}
