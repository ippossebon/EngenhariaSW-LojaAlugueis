package controller.actionlisteners.pesquisa;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import model.Cliente;
import model.Funcionario;
import model.Peca;
import view.MensagemFrame;
import view.inicial.FuncionarioFrame;
import controller.OperacoesDefaultTableModel;
import controller.PesquisaController;
import database.Database;
import database.DatabaseController;

public class BotaoPesquisarAL implements ActionListener{
	private FuncionarioFrame frame;
	
	public BotaoPesquisarAL (FuncionarioFrame frame){
		this.frame = frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		PesquisaController pesquisa_controller = new PesquisaController();
		
		try {

			if (this.frame.getRdbtnPeca().isSelected()){ // Pesquisa por peça
				
				if (this.frame.getPesquisa_text_field().getText().isEmpty()){
					DatabaseController db = new DatabaseController(Database.getInstance());
					
					if (this.frame.getRdbtnDisponiveis().isSelected()){
						ArrayList<Peca> pecas_encontradas = db.getPecasDisponiveis();
						DefaultTableModel dft = OperacoesDefaultTableModel.gerarDefaultTableModelPeca(pecas_encontradas);
						this.frame.getResultados_table().setModel(dft);
						this.frame.getResultados_table().repaint();
					}
					else if (this.frame.getRdbtnAlugadas().isSelected()){
						ArrayList<Peca> pecas_encontradas = db.getPecasAlugadas();
						DefaultTableModel dft = OperacoesDefaultTableModel.gerarDefaultTableModelPeca(pecas_encontradas);
						this.frame.getResultados_table().setModel(dft);
						this.frame.getResultados_table().repaint();
						
					}
					else if(this.frame.getRdbtnTodas().isSelected()){
						ArrayList<Peca> pecas_encontradas = db.getPecas();
						DefaultTableModel dft = OperacoesDefaultTableModel.gerarDefaultTableModelPeca(pecas_encontradas);
						this.frame.getResultados_table().setModel(dft);
						this.frame.getResultados_table().repaint();
					}
				}
				else{
					if (this.frame.getRdbtnDisponiveis().isSelected()){
						// Pesquisa pelo tipo informado em todas as peças disponíveis.
						ArrayList<Peca> pecas_encontradas = pesquisa_controller.pesquisarPeca(this.frame.getPesquisa_text_field().getText(), PesquisaController.pesquisa_disponiveis);
						DefaultTableModel dft = OperacoesDefaultTableModel.gerarDefaultTableModelPeca(pecas_encontradas);
						this.frame.getResultados_table().setModel(dft);
						this.frame.getResultados_table().repaint();
						
					}else if(this.frame.getRdbtnAlugadas().isSelected()){
						// Pesquisa pelo tipo informado em todas as peças alugadas.
						ArrayList<Peca> pecas_encontradas = pesquisa_controller.pesquisarPeca(this.frame.getPesquisa_text_field().getText(), PesquisaController.pesquisa_alugadas);
						DefaultTableModel dft = OperacoesDefaultTableModel.gerarDefaultTableModelPeca(pecas_encontradas);
						this.frame.getResultados_table().setModel(dft);
						this.frame.getResultados_table().repaint();
						
					}else if (this.frame.getRdbtnTodas().isSelected()){
						// Pesquisa pela palavra em todo o banco de dados
						ArrayList<Peca> pecas_encontradas = pesquisa_controller.pesquisarPeca(this.frame.getPesquisa_text_field().getText(), PesquisaController.pesquisa_todas);
						DefaultTableModel dft = OperacoesDefaultTableModel.gerarDefaultTableModelPeca(pecas_encontradas);
						this.frame.getResultados_table().setModel(dft);
						this.frame.getResultados_table().repaint();
					}
				}
			}
			else if (this.frame.getRdbtnCliente().isSelected()){ // Pesquisa por cliente
				
				if (this.frame.getPesquisa_text_field().getText().isEmpty()){
					// Lista todos os clientes.
					DatabaseController db = new DatabaseController(Database.getInstance());
					ArrayList<Cliente> clientes_encontrados = db.getClientes();
					DefaultTableModel dft = OperacoesDefaultTableModel.gerarDefaultTableModelCliente(clientes_encontrados);
					this.frame.getResultados_table().setModel(dft);
					this.frame.getResultados_table().repaint();
				
				}
				else{
					if (this.frame.getRdbtnNome().isSelected()){
						// Pesquisa cliente pelo nome
						ArrayList<Cliente> clientes_encontrados = pesquisa_controller.pesquisarClientePorNome(this.frame.getPesquisa_text_field().getText());
						DefaultTableModel dft = OperacoesDefaultTableModel.gerarDefaultTableModelCliente(clientes_encontrados);
						this.frame.getResultados_table().setModel(dft);
						this.frame.getResultados_table().repaint();
						
					}
					else if (this.frame.getRdbtnCpf().isSelected()){
						// Pesquisa cliente pelo cpf
						ArrayList<Cliente> clientes_encontrados = pesquisa_controller.pesquisarClientePorCPF(this.frame.getPesquisa_text_field().getText());
						DefaultTableModel dft = OperacoesDefaultTableModel.gerarDefaultTableModelCliente(clientes_encontrados);
						this.frame.getResultados_table().setModel(dft);
						this.frame.getResultados_table().repaint();
					}
					else{
						MensagemFrame msg = new MensagemFrame("Erro: Selecione um filtro.");
						msg.setVisible(true);
					}
				}
			}
			else if(this.frame.getRdbtnFuncionario().isSelected()){ // Pesquisa por funcionário
				
				if(this.frame.getPesquisa_text_field().getText().isEmpty()){
					// Lista todos os clientes.
					DatabaseController db = new DatabaseController(Database.getInstance());
					ArrayList<Funcionario> funcionarios_encontrados = db.getFuncionarios();
					DefaultTableModel dft = OperacoesDefaultTableModel.gerarDefaultTableModelFuncionario(funcionarios_encontrados);
					this.frame.getResultados_table().setModel(dft);
					this.frame.getResultados_table().repaint();
				}
				else{
					if (this.frame.getRdbtnNome().isSelected()){
						// Pesquisa funcionario pelo nome
						ArrayList<Funcionario> funcionarios_encontrados = pesquisa_controller.pesquisarFuncionarioPorNome(this.frame.getPesquisa_text_field().getText());
						DefaultTableModel dft = OperacoesDefaultTableModel.gerarDefaultTableModelFuncionario(funcionarios_encontrados);
						this.frame.getResultados_table().setModel(dft);
						this.frame.getResultados_table().repaint();
						
					}
					else if (this.frame.getRdbtnCpf().isSelected()){
						// Pesquisa funcionario pelo cpf
						ArrayList<Funcionario> funcionarios_encontrados = pesquisa_controller.pesquisarFuncionarioPorCPF(this.frame.getPesquisa_text_field().getText());
						DefaultTableModel dft = OperacoesDefaultTableModel.gerarDefaultTableModelFuncionario(funcionarios_encontrados);
						this.frame.getResultados_table().setModel(dft);
						this.frame.getResultados_table().repaint();
						
					}
					else{
						MensagemFrame msg = new MensagemFrame("Erro: Selecione um filtro.");
						msg.setVisible(true);
					}
				}
			}
			else{
				MensagemFrame msg = new MensagemFrame("Erro: Selecione uma opção de pesquisa.");
				msg.setVisible(true);
			}
		} catch (IllegalArgumentException exception) {
			MensagemFrame msg = new MensagemFrame("Não foram encontrados resultados para esta pesquisa.");
			msg.setVisible(true);
		}
	}
}

