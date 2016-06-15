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
		DatabaseController database_controller = new DatabaseController(Database.getInstance());
		MensagemFrame msg = new MensagemFrame("Erro na geração de relatório");
		try {
			String data_inicio = this.frame.getData_inicio_text_field().getText();
			String data_fim = this.frame.getData_fim_text_field().getText();
			DefaultTableModel dft;
			
			switch((String)this.frame.getFiltro_combo_box().getSelectedItem()){
			case "Alugueis efetuados":
				msg = new MensagemFrame("Nenhum aluguel encontrado nesse período.");
				ArrayList<Aluguel> alugueis_efetuados = relatorios_controller.getAlugueisEmAndamento(data_inicio, data_fim);
				dft = OperacoesDefaultTableModel.gerarDefaultTableModelAlugueis(alugueis_efetuados);
				this.frame.getResultados_table().setModel(dft);
				break;
			case "Quantidade de alugueis":
				msg = new MensagemFrame("Nenhum aluguel encontrado nesse período.");
				ArrayList<Aluguel> alugueis_efetuados2 = relatorios_controller.getAlugueisEmAndamento(data_inicio, data_fim);
				dft = OperacoesDefaultTableModel.gerarDefaultTableModelQtdAlugueis(alugueis_efetuados2);
				this.frame.getResultados_table().setModel(dft);
				break;
<<<<<<< HEAD
			case "Alugueis por peï¿½a":
				//ArrayList<Aluguel> alugueis_por_peca = relatorios_controller.getAlugueisPorPeca(peca, data_inicio, data_fim);
=======
			case "Alugueis por peça":
				msg = new MensagemFrame("Nenhum aluguel encontrado nesse período.");
				dft = OperacoesDefaultTableModel.gerarDefaultTableModelAlugueisPorPeca();
				int qtd_alugueis = 0;
				for(Peca p: database_controller.getPecas()){
					qtd_alugueis = relatorios_controller.getQtdAlugueisPorPeca(p, data_inicio, data_fim);
					OperacoesDefaultTableModel.addDefaultTableModelAlugueisPorPeca(p, qtd_alugueis, dft);
				}
				this.frame.getResultados_table().setModel(dft);
>>>>>>> origin/master
				break;
			case "Clientes bloqueados":
				msg = new MensagemFrame("Nenhum cliente bloqueado nesse período.");
				ArrayList<Cliente> clientes_bloqueados = relatorios_controller.getClientesBloqueados(data_inicio, data_fim);
				dft = OperacoesDefaultTableModel.gerarDefaultTableModelCliente(clientes_bloqueados);
				this.frame.getResultados_table().setModel(dft);
				break;
			case "Lucro":
				msg = new MensagemFrame("Nenhum aluguel realizado nesse período.");
				ArrayList<RegistroReceita> receita = relatorios_controller.getRelatorioReceita(data_inicio, data_fim);
				double total_receita = relatorios_controller.getValorTotalReceita(data_inicio, data_fim);
				dft = OperacoesDefaultTableModel.gerarDefaultTableModelReceita(receita, total_receita);
				this.frame.getResultados_table().setModel(dft);
				this.frame.getResultados_table().repaint();
				break;
			}
		} catch(IllegalArgumentException exception){
<<<<<<< HEAD
			MensagemFrame msg = new MensagemFrame("Erro ao gerar relatï¿½rio.");
=======
>>>>>>> origin/master
			msg.setVisible(true);
		}
		
		/*Teste - REMOVER DEPOIS
		RelatoriosController relatorios_controller = new RelatoriosController();
		
		for (Cliente c: relatorios_controller.getClientesBloqueados("01/01/1992", "01/01/2016")){
			System.out.println(c.getNome());
		}
		
		System.out.println("");
		
		for (Aluguel a: relatorios_controller.getAlugueisEmAndamento("01/01/1992", "01/01/2016")){
			System.out.print("ID: "+Integer.toString(a.getId())+" Peï¿½as Alugadas:");
			for (Peca p: a.getPecas()){
				System.out.print(" "+p.getTipo());
			}
			System.out.println("");

		}
		Teste - REMOVER DEPOIS*/
	}

	
}
