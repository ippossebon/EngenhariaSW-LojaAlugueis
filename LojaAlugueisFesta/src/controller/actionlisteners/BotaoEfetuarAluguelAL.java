package controller.actionlisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import model.Peca;
import view.aluguel.DadosNovoAluguelFrame;
import controller.PesquisaController;

public class BotaoEfetuarAluguelAL implements ActionListener{

	private DadosNovoAluguelFrame frame;
	
	public BotaoEfetuarAluguelAL(DadosNovoAluguelFrame frame){
		this.frame = frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String cpf_cliente = this.frame.getCpf_text_field().getText();
		String data_inicio = this.frame.getData_inicio_text_field().getText();
		String data_fim = this.frame.getData_fim_text_field().getText();
		ArrayList<Integer> codigos_pecas = new ArrayList<Integer>();
		
		for (int i = 0; i < this.frame.getItens_table().getModel().getRowCount(); i++){
			codigos_pecas.add(Integer.parseInt(this.frame.getItens_table().getModel().getValueAt(i, 0).toString()));
		}
		
		PesquisaController pesquisa_controller = new PesquisaController();
		ArrayList<Peca> pecas = new ArrayList<Peca>();
		for(Integer codigo: codigos_pecas){
			pecas.add(pesquisa_controller.pesquisarPeca(codigo, PesquisaController.pesquisa_disponiveis).get(0));
		}
		
		// AluguelController
	}

}