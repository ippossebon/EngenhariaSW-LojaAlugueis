package controller.actionlisteners.estoque;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.MensagemFrame;
import view.estoque.AlterarValorPecaFrame;
import controller.EstoqueController;

public class BotaoConfirmaNovoPrecoAL implements ActionListener{

	private AlterarValorPecaFrame frame;
	
	public BotaoConfirmaNovoPrecoAL(AlterarValorPecaFrame f){
		this.frame = f;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		EstoqueController estoque_controller = new EstoqueController();
		boolean sucesso = estoque_controller.alterarValorPeca(this.frame.getNovo_valor_text_field().getText(), Integer.parseInt(this.frame.getCodigo_peca_text_field().getText()));
		
		if (!sucesso){
			MensagemFrame msg = new MensagemFrame("Erro no sistema: peça não encontrada a partir do código.");
			msg.setVisible(true);
		}
		this.frame.dispose();
	}

}
