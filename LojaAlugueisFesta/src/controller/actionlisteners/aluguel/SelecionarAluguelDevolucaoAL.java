package controller.actionlisteners.aluguel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Aluguel;
import view.MensagemFrame;
import view.aluguel.SelecionarAluguelDevolucaoFrame;
import view.aluguel.SelecionarPecasDevolucaoFrame;

public class SelecionarAluguelDevolucaoAL implements ActionListener{

	private SelecionarAluguelDevolucaoFrame frame;
	
	public SelecionarAluguelDevolucaoAL(SelecionarAluguelDevolucaoFrame frame){
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int indice_linha_selecionada = this.frame.getAlugueis_table().getSelectedRow();
		
		if (indice_linha_selecionada != -1){
			int id_aluguel_selecionado = Integer.parseInt(this.frame.getAlugueis_table().getValueAt(indice_linha_selecionada, 0).toString());
			Aluguel aluguel = new Aluguel();

			for (Aluguel a : this.frame.getAlugueis_cliente()){
				if (a.getId() == id_aluguel_selecionado){
					aluguel = a;
				}
			}
			SelecionarPecasDevolucaoFrame f = new SelecionarPecasDevolucaoFrame(aluguel);
			f.setVisible(true);
		}
		else{
			MensagemFrame msg = new MensagemFrame("Selecione um aluguel para registrar a devolução.");
			msg.setVisible(true);
		}
		
		
		
	}
}
