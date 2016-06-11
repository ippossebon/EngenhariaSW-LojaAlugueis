package controller.actionlisteners.aluguel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Aluguel;
import view.MensagemFrame;
import view.aluguel.PagamentoMultaFrame;
import controller.PesquisaController;
import database.Database;
import database.DatabaseController;

public class PagamentoMultaAL implements ActionListener{

	private PagamentoMultaFrame frame;
	private int id_aluguel;
	
	public PagamentoMultaAL(PagamentoMultaFrame frame, int id_aluguel){
		this.frame = frame;
		this.id_aluguel = id_aluguel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(this.frame.getRdbtnNoEfetuado().isSelected()){
			MensagemFrame msg = new MensagemFrame("Cliente bloqueado. Para regularizar a situação, o cliente deve pagar esta multa.");
			msg.setVisible(true);
		}
		else{
			// A multa foi paga e, portanto, o cliente pode ser liberado.
			DatabaseController db = new DatabaseController(Database.getInstance());
			
			for (Aluguel a: db.getAlugueis()){
				if (a.getId() == this.id_aluguel){
					a.setEntregue(true);
					PesquisaController pc = new PesquisaController();
					pc.pesquisarClientePorCPF(a.getCpf_cliente()).get(0).setBloqueado(false);
				}
			}
			this.frame.dispose();
		}
	}

}
