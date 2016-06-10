package controller.actionlisteners.relatorios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//-----------TESTE--------------------------
import java.util.ArrayList;
import model.Data;
import model.Peca;
import model.Aluguel;
import model.Cliente;
import controller.RelatoriosController;
//-----------TESTE---------------------------
import view.RelatoriosFrame;

public class BotaoGerarRelatorioAL implements ActionListener{

	private RelatoriosFrame frame;
	
	public BotaoGerarRelatorioAL(RelatoriosFrame f){
		this.frame = f;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		/*Teste - REMOVER DEPOIS*/
		RelatoriosController relatorios_controller = new RelatoriosController();
		
		for (Cliente c: relatorios_controller.getClientesBloqueados("01/01/1992", "01/01/2016")){
			System.out.println(c.getNome());
		}
		
		System.out.println("");
		
		for (Aluguel a: relatorios_controller.getAlugueisEmAndamento("01/01/1992", "01/01/2016")){
			System.out.print("ID: "+Integer.toString(a.getId())+" Peças Alugadas:");
			for (Peca p: a.getPecas()){
				System.out.print(" "+p.getTipo());
			}
			System.out.println("");

		}
		/*Teste - REMOVER DEPOIS*/
	}

	
}
