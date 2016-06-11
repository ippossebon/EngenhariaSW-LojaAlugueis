package controller.actionlisteners.aluguel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Aluguel;
import view.MensagemFrame;
import view.aluguel.PagamentoMultaFrame;
import view.aluguel.SelecionarPecasDevolucaoFrame;
import controller.AluguelController;
import database.Database;
import database.DatabaseController;

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
			
			// Verifica se a entrega está atrasada.
			boolean aluguel_atrasado = aluguel_controller.verificaSeAluguelAtrasado(id_aluguel, data_entrega);
			
			try{
				// Multa por dano ou perda será cobrada.
				if(this.frame.getChckbxMulta().isSelected()){
					aluguel_controller.registrarDevolucaoMulta(id_aluguel, codigo_peca_selecionada, data_entrega);
					this.frame.dispose();
					
					MensagemFrame msg = new MensagemFrame("Peça " + codigo_peca_selecionada + " devolvida com sucesso. O cliente deve pagar a multa para não estar mais bloqueado no sistema.");
					msg.setVisible(true);
					
					float valor_multa = aluguel_controller.calculaMultaDano(id_aluguel, this.frame.getPorcentagem_multa().getValue().toString());
					
					PagamentoMultaFrame frame_pagamento_multa = new PagamentoMultaFrame(valor_multa, id_aluguel);
					frame_pagamento_multa.setVisible(true);
				}
				else if(aluguel_atrasado){
					aluguel_controller.registrarDevolucaoMulta(id_aluguel, codigo_peca_selecionada, data_entrega);
					this.frame.dispose();
					
					MensagemFrame msg = new MensagemFrame("Peça " + codigo_peca_selecionada + " devolvida com sucesso. O cliente deve pagar a multa para não estar mais bloqueado no sistema.");
					msg.setVisible(true);
					
					double valor_multa = aluguel_controller.calcularMultaAtraso(id_aluguel);
					
					PagamentoMultaFrame frame_pagamento_multa = new PagamentoMultaFrame((float)valor_multa, id_aluguel);
					frame_pagamento_multa.setVisible(true);
				}
				else{
					// Devolve a peça normalmente.
					aluguel_controller.registrarDevolucao(id_aluguel, codigo_peca_selecionada, data_entrega);
					this.frame.dispose();
					
					MensagemFrame msg = new MensagemFrame("Peça " + codigo_peca_selecionada + " devolvida com sucesso.");
					msg.setVisible(true);
				}
			}
			catch(NumberFormatException nfe){
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
