package controller.actionlisteners.relatorios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//-----------TESTE--------------------------
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import model.Data;
import model.Funcionario;
import model.Peca;
import model.Aluguel;
import model.Cliente;
import model.RegistroReceita;
import controller.OperacoesDefaultTableModel;
import controller.RelatoriosController;
import database.Database;
import database.DatabaseController;
import view.MensagemFrame;
//-----------TESTE---------------------------
import view.RelatoriosFrame;

public class BotaoGerarRelatorioAL implements ActionListener{

	private RelatoriosFrame frame;
	
	public BotaoGerarRelatorioAL(RelatoriosFrame f){
		this.frame = f;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		RelatoriosController relatorios_controller = new RelatoriosController();
		
		try {
			String data_inicio = this.frame.getData_inicio_text_field().getText();
			String data_fim = this.frame.getData_fim_text_field().getText();
			
			switch((String)this.frame.getFiltro_combo_box().getSelectedItem()){
			case "Alugueis efetuados":
				ArrayList<Aluguel> alugueis_efetuados = relatorios_controller.getAlugueisEmAndamento(data_inicio, data_fim);
				break;
			case "Quantidade de alugueis":
				ArrayList<Aluguel> alugueis_efetuados2 = relatorios_controller.getAlugueisEmAndamento(data_inicio, data_fim);
				int quantidade_alugueis = alugueis_efetuados2.size();
				break;
			case "Alugueis por peça":
				ArrayList<Aluguel> alugueis_por_peca = relatorios_controller.getAlugueisPorPeca(peca, data_inicio, data_fim);
				break;
			case "Clientes bloqueados":
				ArrayList<Cliente> clientes_bloqueados = relatorios_controller.getClientesBloqueados(data_inicio, data_fim);
				
				break;
			case "Lucro":
				ArrayList<RegistroReceita> receita = relatorios_controller.getRelatorioReceita(data_inicio, data_fim);
				int total_receita = relatorios_controller.getValorTotalReceita(data_inicio, data_fim);
				break;
			}
		} catch(IllegalArgumentException exception){
			MensagemFrame msg = new MensagemFrame("Erro ao gerar relatório.");
			msg.setVisible(true);
		}
		
		/*Teste - REMOVER DEPOIS
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
		Teste - REMOVER DEPOIS*/
	}

	
}
