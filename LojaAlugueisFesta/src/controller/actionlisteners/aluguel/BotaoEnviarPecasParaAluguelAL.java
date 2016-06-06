package controller.actionlisteners.aluguel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import model.Peca;
import view.MensagemFrame;
import view.aluguel.DadosNovoAluguelFrame;
import view.aluguel.NovoAluguelFrame;
import controller.PesquisaController;

public class BotaoEnviarPecasParaAluguelAL implements ActionListener{
	
	private NovoAluguelFrame frame;
	
	public BotaoEnviarPecasParaAluguelAL(NovoAluguelFrame frame){
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
		
<<<<<<< HEAD:LojaAlugueisFesta/src/controller/actionlisteners/aluguel/BotaoOkNovoAluguel.java
		DadosNovoAluguelFrame frame = new DadosNovoAluguelFrame(pecas);
		frame.setVisible(true);
		
		System.out.println("Cliquei hehe");
=======
		if(pecas.size() != 0){
			DadosNovoAluguelFrame frame = new DadosNovoAluguelFrame(pecas);
			frame.setVisible(true);
		}
		else{
			MensagemFrame msg = new MensagemFrame("Por favor, escolha as peças que deseja alugar.");
			msg.setVisible(true);
		}
		
>>>>>>> origin/master:LojaAlugueisFesta/src/controller/actionlisteners/aluguel/BotaoEnviarPecasParaAluguelAL.java
	}

}
