package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Aluguel;
import database.Database;
import database.DatabaseController;
import view.aluguel.SolicitarCPFClienteFrame;

public class EncaminhaPagamentoMultaAL implements ActionListener{

	private SolicitarCPFClienteFrame frame;
	
	public EncaminhaPagamentoMultaAL(SolicitarCPFClienteFrame frame){
		this.frame = frame;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		DatabaseController db = new DatabaseController(Database.getInstance());
		
		for (Aluguel a : db.getAlugueis()){
			if (a.getCpf_cliente().equals(this.frame.getCpf_text_field().getText())){
				
			}
		}
	}

}
