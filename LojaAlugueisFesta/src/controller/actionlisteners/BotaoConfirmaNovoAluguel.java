package controller.actionlisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import model.Peca;
import view.aluguel.DadosNovoAluguelFrame;
import view.aluguel.NovoAluguelFrame;
import controller.PesquisaController;

public class BotaoConfirmaNovoAluguel implements ActionListener{
	
	private NovoAluguelFrame frame;
	
	public BotaoConfirmaNovoAluguel(NovoAluguelFrame frame){
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		ArrayList<Integer> codigos_pecas = new ArrayList<Integer>();
		
		for (int i = 0; i < this.frame.getCarrinho_table().getModel().getRowCount(); i++){
			codigos_pecas.add(Integer.parseInt(this.frame.getCarrinho_table().getModel().getValueAt(i, 0).toString()));
		}
		
		ArrayList<Peca> pecas = new ArrayList<Peca>();
		PesquisaController pesquisa_controller = new PesquisaController();
		
		for (Integer c : codigos_pecas){
			pecas.add(pesquisa_controller.pesquisarPeca(c, PesquisaController.pesquisa_disponiveis).get(0));
		}
		
		DadosNovoAluguelFrame frame = new DadosNovoAluguelFrame(pecas);
		frame.setVisible(true);
	}

}
