package controller;

import database.Database;
import database.DatabaseController;
import view.MensagemFrame;

public class EstoqueController {

	public EstoqueController(){
		
	}
	
	public boolean alterarValorPeca(String valor, int codigo_peca){
		try{
			float novo_valor = Float.parseFloat(valor);
			
			PesquisaController pesquisa_controller = new PesquisaController();
			int index = pesquisa_controller.getPecaIndex(codigo_peca);
			
			if(index != -1){
				DatabaseController db_controller = new DatabaseController(Database.getInstance());
				db_controller.getPecas().get(index).setValor(novo_valor);
				MensagemFrame msg = new MensagemFrame ("Valor da peça de código " + codigo_peca + " alterado com sucesso.");
				msg.setVisible(true);
				return true;
			}
		}
		catch(NullPointerException e){
			MensagemFrame msg = new MensagemFrame("Formato inválido. Por favor, insira um valor no formato ###.##");
			msg.setVisible(true);
		}
		catch(NumberFormatException e){
			MensagemFrame msg = new MensagemFrame("Formato inválido. Por favor, insira um valor no formato ###.##");
			msg.setVisible(true);
		}
		catch(ArrayIndexOutOfBoundsException e){
			MensagemFrame msg = new MensagemFrame("Formato inválido. Por favor, insira um valor no formato ###.##");
			msg.setVisible(true);
		}
		return false;
	}
	
}
