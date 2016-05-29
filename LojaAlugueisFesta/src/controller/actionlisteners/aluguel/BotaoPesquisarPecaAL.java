package controller.actionlisteners.aluguel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import model.Peca;
import view.MensagemFrame;
import view.aluguel.NovoAluguelFrame;
import controller.PesquisaController;
import database.Database;
import database.DatabaseController;

public class BotaoPesquisarPecaAL implements ActionListener{

	private NovoAluguelFrame frame;
	
	public BotaoPesquisarPecaAL(NovoAluguelFrame frame){
		this.frame = frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		PesquisaController pesquisa_controller = new PesquisaController();
		
		
		if (this.frame.getChckbxApenasDisponveis().isSelected()){
			// Pesquisa apenas pelas peças disponíveis
			if (this.frame.getPesquisa_text_field().getText().isEmpty()){
				// Exibe toda a lista de peças
				DatabaseController db_controller = new DatabaseController(Database.getInstance());
				ArrayList<Peca> pecas_encontradas = db_controller.getPecasDisponiveis();
				DefaultTableModel dft = pesquisa_controller.gerarDefaultTableModelPeca(pecas_encontradas);
				this.frame.getResultados_table().setModel(dft);
				this.frame.getResultados_table().repaint();
			}
			else{
				if(this.frame.getRdbtnCodigo().isSelected()){
					// Pesquisa por código
					ArrayList<Peca> pecas_encontradas = pesquisa_controller.pesquisarPeca(Integer.parseInt(this.frame.getPesquisa_text_field().getText()), PesquisaController.pesquisa_disponiveis);
					DefaultTableModel dft = pesquisa_controller.gerarDefaultTableModelPeca(pecas_encontradas);
					this.frame.getResultados_table().setModel(dft);
					this.frame.getResultados_table().repaint();
				}
				else if(this.frame.getRdbtnTipo().isSelected()){
					// Pesquisa por tipo
					ArrayList<Peca> pecas_encontradas = pesquisa_controller.pesquisarPeca(this.frame.getPesquisa_text_field().getText(), PesquisaController.pesquisa_disponiveis);
					DefaultTableModel dft = pesquisa_controller.gerarDefaultTableModelPeca(pecas_encontradas);
					this.frame.getResultados_table().setModel(dft);
					this.frame.getResultados_table().repaint();
				}else{
					// Erro
					MensagemFrame msg = new MensagemFrame("Selecione um filtro de pesquisa.");
					msg.setVisible(true);
				}
			}
			
		}
		else{
			if (this.frame.getPesquisa_text_field().getText().isEmpty()){
				// Exibe toda a lista de peças
				DatabaseController db_controller = new DatabaseController(Database.getInstance());
				ArrayList<Peca> pecas_encontradas = db_controller.getPecas();
				DefaultTableModel dft = pesquisa_controller.gerarDefaultTableModelPeca(pecas_encontradas);
				this.frame.getResultados_table().setModel(dft);
				this.frame.getResultados_table().repaint();
			}
			else{
				if(this.frame.getRdbtnCodigo().isSelected()){
					// Pesquisa por código
					ArrayList<Peca> pecas_encontradas = pesquisa_controller.pesquisarPeca(Integer.parseInt(this.frame.getPesquisa_text_field().getText()), PesquisaController.pesquisa_todas);
					DefaultTableModel dft = pesquisa_controller.gerarDefaultTableModelPeca(pecas_encontradas);
					this.frame.getResultados_table().setModel(dft);
					this.frame.getResultados_table().repaint();
				}
				else if(this.frame.getRdbtnTipo().isSelected()){
					// Pesquisa por tipo
					ArrayList<Peca> pecas_encontradas = pesquisa_controller.pesquisarPeca(this.frame.getPesquisa_text_field().getText(), PesquisaController.pesquisa_todas);
					System.out.println("BotaoPesquisarPecaAL >> Encontrou " + pecas_encontradas.size() + " pecas");
					DefaultTableModel dft = pesquisa_controller.gerarDefaultTableModelPeca(pecas_encontradas);
					this.frame.getResultados_table().setModel(dft);
					this.frame.getResultados_table().repaint();
				}else{
					// Erro
					MensagemFrame msg = new MensagemFrame("Selecione um filtro de pesquisa.");
					msg.setVisible(true);
				}
			}
		}
	}

}
