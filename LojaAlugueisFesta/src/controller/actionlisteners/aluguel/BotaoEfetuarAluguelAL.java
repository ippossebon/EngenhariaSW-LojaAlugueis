package controller.actionlisteners.aluguel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import controller.AluguelController;
import controller.PesquisaController;
import model.Peca;
import view.MensagemFrame;
import view.aluguel.DadosNovoAluguelFrame;

public class BotaoEfetuarAluguelAL implements ActionListener{

	private DadosNovoAluguelFrame frame;
	
	public BotaoEfetuarAluguelAL(DadosNovoAluguelFrame frame){
		this.frame = frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		// Verifica se o pagamento foi efetuado.
		boolean pagamento_efetuado;
		if (this.frame.getRdbtnCartoDeCrditodbito().isSelected() || this.frame.getRdbtnDinheiro().isSelected()){
			pagamento_efetuado = true;
		}
<<<<<<< HEAD
	
		PesquisaController pesquisa_controller = new PesquisaController();
		ArrayList<Peca> pecas = new ArrayList<Peca>();
		for(Integer codigo: codigos_pecas){
			pecas.add(pesquisa_controller.pesquisarPeca(codigo, PesquisaController.pesquisa_disponiveis).get(0));
		}
		
		
		 System.out.println("CLIQUEI");
		// AluguelController
		 
		 AluguelController aluguel_controller = new AluguelController();
		 aluguel_controller.alugarPeca(codigos_pecas, cpf_cliente, data_inicio, data_fim);

=======
		else{
			pagamento_efetuado = false;
		}
		
		if (pagamento_efetuado){
			String cpf_cliente = this.frame.getCpf_text_field().getText();
			String data_inicio = this.frame.getData_inicio_text_field().getText();
			String data_fim = this.frame.getData_fim_text_field().getText();
			Float total = Float.parseFloat(this.frame.getTotal_text_field().getText());
			
			ArrayList<Integer> codigos_pecas = new ArrayList<Integer>();
			
			for (int i = 0; i < this.frame.getItens_table().getModel().getRowCount(); i++){
				codigos_pecas.add(Integer.parseInt(this.frame.getItens_table().getModel().getValueAt(i, 0).toString()));
			}
			
			PesquisaController pesquisa_controller = new PesquisaController();
			ArrayList<Peca> pecas = new ArrayList<Peca>();
			for(Integer codigo: codigos_pecas){
				pecas.add(pesquisa_controller.pesquisarPeca(codigo, PesquisaController.pesquisa_disponiveis).get(0));
			}
			
			// AluguelController - verificar se os campos não são vazios e são válidos
		}
		else{
			MensagemFrame msg = new MensagemFrame("Aluguel cancelado. O pagamento precisa ser realizado no ato.");
			msg.setVisible(true);
		}
>>>>>>> origin/master
	}

}
