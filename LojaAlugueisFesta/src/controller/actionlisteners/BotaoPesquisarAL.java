package controller.actionlisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import model.Cliente;
import model.Funcionario;
import model.Peca;
import view.MensagemFrame;
import view.inicial.FuncionarioFrame;
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

		if (this.frame.getRdbtnPeca().isSelected()){ // Pesquisa por peça
			
			if (this.frame.getPesquisa_text_field().getText().isEmpty()){
				DatabaseController db = new DatabaseController(Database.getInstance());
				
				if (this.frame.getRdbtnDisponiveis().isSelected()){
					ArrayList<Peca> pecas_encontradas = db.getPecasDisponiveis();
					DefaultTableModel dft = gerarDefaultTableModelPeca(pecas_encontradas);
					this.frame.getResultados_table().setModel(dft);
					this.frame.getResultados_table().repaint();
				}
				else if (this.frame.getRdbtnAlugadas().isSelected()){
					ArrayList<Peca> pecas_encontradas = db.getPecasAlugadas();
					DefaultTableModel dft = gerarDefaultTableModelPeca(pecas_encontradas);
					this.frame.getResultados_table().setModel(dft);
					this.frame.getResultados_table().repaint();
					
				}
				else if(this.frame.getRdbtnTodas().isSelected()){
					ArrayList<Peca> pecas_encontradas = db.getPecas();
					DefaultTableModel dft = gerarDefaultTableModelPeca(pecas_encontradas);
					this.frame.getResultados_table().setModel(dft);
					this.frame.getResultados_table().repaint();
				}
			}
			else{
				if (this.frame.getRdbtnDisponiveis().isSelected()){
					// Pesquisa pelo tipo informado em todas as peças disponíveis.
					ArrayList<Peca> pecas_encontradas = pesquisa_controller.pesquisarPeca(this.frame.getPesquisa_text_field().getText(), PesquisaController.pesquisa_disponiveis);
					DefaultTableModel dft = gerarDefaultTableModelPeca(pecas_encontradas);
					this.frame.getResultados_table().setModel(dft);
					this.frame.getResultados_table().repaint();
					
				}else if(this.frame.getRdbtnAlugadas().isSelected()){
					// Pesquisa pelo tipo informado em todas as peças alugadas.
					ArrayList<Peca> pecas_encontradas = pesquisa_controller.pesquisarPeca(this.frame.getPesquisa_text_field().getText(), PesquisaController.pesquisa_alugadas);
					DefaultTableModel dft = gerarDefaultTableModelPeca(pecas_encontradas);
					this.frame.getResultados_table().setModel(dft);
					this.frame.getResultados_table().repaint();
					
				}else if (this.frame.getRdbtnTodas().isSelected()){
					// Pesquisa pela palavra em todo o banco de dados
					ArrayList<Peca> pecas_encontradas = pesquisa_controller.pesquisarPeca(this.frame.getPesquisa_text_field().getText(), PesquisaController.pesquisa_todas);
					DefaultTableModel dft = gerarDefaultTableModelPeca(pecas_encontradas);
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
				DefaultTableModel dft = gerarDefaultTableModelCliente(clientes_encontrados);
				this.frame.getResultados_table().setModel(dft);
				this.frame.getResultados_table().repaint();
			
			}
			else{
				if (this.frame.getRdbtnNome().isSelected()){
					// Pesquisa cliente pelo nome
					ArrayList<Cliente> clientes_encontrados = pesquisa_controller.pesquisarClientePorNome(this.frame.getPesquisa_text_field().getText());
					DefaultTableModel dft = gerarDefaultTableModelCliente(clientes_encontrados);
					this.frame.getResultados_table().setModel(dft);
					this.frame.getResultados_table().repaint();
					
				}
				else if (this.frame.getRdbtnCpf().isSelected()){
					// Pesquisa cliente pelo cpf
					ArrayList<Cliente> clientes_encontrados = pesquisa_controller.pesquisarClientePorCPF(this.frame.getPesquisa_text_field().getText());
					DefaultTableModel dft = gerarDefaultTableModelCliente(clientes_encontrados);
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
				DefaultTableModel dft = gerarDefaultTableModelFuncionario(funcionarios_encontrados);
				this.frame.getResultados_table().setModel(dft);
				this.frame.getResultados_table().repaint();
			}
			else{
				if (this.frame.getRdbtnNome().isSelected()){
					// Pesquisa funcionario pelo nome
					ArrayList<Funcionario> funcionarios_encontrados = pesquisa_controller.pesquisarFuncionarioPorNome(this.frame.getPesquisa_text_field().getText());
					DefaultTableModel dft = gerarDefaultTableModelFuncionario(funcionarios_encontrados);
					this.frame.getResultados_table().setModel(dft);
					this.frame.getResultados_table().repaint();
					
				}
				else if (this.frame.getRdbtnCpf().isSelected()){
					// Pesquisa funcionario pelo cpf
					ArrayList<Funcionario> funcionarios_encontrados = pesquisa_controller.pesquisarFuncionarioPorCPF(this.frame.getPesquisa_text_field().getText());
					DefaultTableModel dft = gerarDefaultTableModelFuncionario(funcionarios_encontrados);
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
		
	}
	
	private DefaultTableModel gerarDefaultTableModelPeca(ArrayList<Peca> pecas_encontradas){
		DefaultTableModel dft = new DefaultTableModel();
		
		ArrayList<Integer> codigos = new ArrayList<Integer>();
		ArrayList<String> tipos = new ArrayList<String>();
		ArrayList<Integer> tamanhos = new ArrayList<Integer>();
		ArrayList<String> status = new ArrayList<String>();
		ArrayList<Float> valores = new ArrayList<Float>();
		ArrayList<Integer> numero_alugueis = new ArrayList<Integer>();
		
		for(Peca p : pecas_encontradas){
			codigos.add(p.getCodigo_peca());
			tipos.add(p.getTipo());
			tamanhos.add(p.getTamanho());
			
			if (p.isDisponivel()){
				status.add("Disponível");
			}
			else{
				status.add("Alugada");
			}
			
			valores.add(p.getValor());
			numero_alugueis.add(p.getNumero_alugueis());
		}
		dft.addColumn("Código", codigos.toArray());
		dft.addColumn("Tipo", tipos.toArray());
		dft.addColumn("Tamanho", tamanhos.toArray());
		dft.addColumn("Status", status.toArray());
		dft.addColumn("Valor", valores.toArray());
		dft.addColumn("Número de alugueis", numero_alugueis.toArray());
		
		return dft;
	}
	
	private DefaultTableModel gerarDefaultTableModelCliente(ArrayList<Cliente> clientes_encontrados){
		DefaultTableModel dft = new DefaultTableModel();
		
		ArrayList<String> nomes = new ArrayList<String>();
		ArrayList<String> cpfs = new ArrayList<String>();
		ArrayList<String> emails = new ArrayList<String>();
		ArrayList<String> enderecos = new ArrayList<String>();
		ArrayList<String> telefones = new ArrayList<String>();
		ArrayList<String> status = new ArrayList<String>();
		
		for (Cliente c: clientes_encontrados){
			nomes.add(c.getNome());
			cpfs.add(c.getCpf());
			emails.add(c.getEmail());
			enderecos.add(c.getEndereco());
			telefones.add(c.getTelefone());
			
			if(c.isBloqueado()){
				status.add("Bloqueado");
			}
			else{
				status.add("Liberado");
			}
		}
		
		dft.addColumn("Nome", nomes.toArray());
		dft.addColumn("CPF", cpfs.toArray());
		dft.addColumn("E-mail", emails.toArray());
		dft.addColumn("Endereço", enderecos.toArray());
		dft.addColumn("Telefone", telefones.toArray());
		dft.addColumn("Status", status.toArray());
		
		return dft;
	}
	
	private DefaultTableModel gerarDefaultTableModelFuncionario(ArrayList<Funcionario> funcionarios_encontrados){
DefaultTableModel dft = new DefaultTableModel();
		
		ArrayList<String> nomes = new ArrayList<String>();
		ArrayList<String> cpfs = new ArrayList<String>();
		ArrayList<String> emails = new ArrayList<String>();
		ArrayList<String> enderecos = new ArrayList<String>();
		ArrayList<String> telefones = new ArrayList<String>();
		ArrayList<String> cargos = new ArrayList<String>();
		DatabaseController db = new DatabaseController(Database.getInstance());
		
		for (Funcionario f: funcionarios_encontrados){
			nomes.add(f.getNome());
			cpfs.add(f.getCpf());
			emails.add(f.getEmail());
			enderecos.add(f.getEndereco());
			telefones.add(f.getTelefone());
			
			if(db.isGerente(f.getCpf())){
				cargos.add("Gerente");
			}
			else{
				cargos.add("Funcionário");
			}
		}
		
		dft.addColumn("Nome", nomes.toArray());
		dft.addColumn("CPF", cpfs.toArray());
		dft.addColumn("E-mail", emails.toArray());
		dft.addColumn("Endereço", enderecos.toArray());
		dft.addColumn("Telefone", telefones.toArray());
		dft.addColumn("Cargo", cargos.toArray());
		
		return dft;
	}
}

