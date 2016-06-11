package controller.actionlisteners.estoque;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Peca;
import view.MensagemFrame;
import view.estoque.AdicionarPecaFrame;
import database.Database;
import database.DatabaseController;

public class BotaoAdicionarPecaAL implements ActionListener{

	private AdicionarPecaFrame frame;
	
	public BotaoAdicionarPecaAL(AdicionarPecaFrame frame){
		this.frame = frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String tipo;
		int tamanho = Integer.parseInt(this.frame.getTamanho_text_field().getText());
		float valor = Float.parseFloat(this.frame.getValor_text_field().getText());
		
		if (this.frame.getTipo_combobox().getSelectedItem().toString().equals("Outro")){
			tipo = this.frame.getOutro_text_field().getText();
		}
		else{
			tipo = this.frame.getTipo_combobox().getSelectedItem().toString();
		}
		DatabaseController db_controller = new DatabaseController(Database.getInstance());
		int codigo = db_controller.gerarNovoCodigoPeca();
					
		Peca peca = new Peca(codigo, tamanho, tipo, valor);
		db_controller.adicionarPecaEstoque(peca);
		
		/* DEBUG */
		db_controller.printDatabase();
		
		MensagemFrame msg = new MensagemFrame("Peça adicionada com sucesso!");
		msg.setVisible(true);
		this.frame.dispose();
	}

}
