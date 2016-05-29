package controller;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import model.Aluguel;
import model.Cliente;
import model.Data;
import model.Funcionario;
import model.Peca;
import database.Database;
import database.DatabaseController;

public class PesquisaController {
	
	public static int pesquisa_todas = 0;
	public static int pesquisa_disponiveis = 1;
	public static int pesquisa_alugadas = 2;
	
	public PesquisaController(){
		
	}
	
	public ArrayList<Cliente> pesquisarClientePorNome(String nome){
		
		DatabaseController database_controller = new DatabaseController(Database.getInstance());
		ArrayList<Cliente> resultado = new ArrayList<Cliente>();
		
		for (Cliente c : database_controller.getClientes()){
			if (c.getNome().toLowerCase().contains(nome.toLowerCase())){
				resultado.add(c);
			}
		}
		return resultado;
	}
	
	public ArrayList<Cliente> pesquisarClientePorCPF(String cpf){
		
		DatabaseController database_controller = new DatabaseController(Database.getInstance());
		ArrayList<Cliente> resultado = new ArrayList<Cliente>();
		
		for (Cliente c : database_controller.getClientes()){
			if (c.getCpf().equals(cpf)){
				resultado.add(c);
				return resultado;
			}
		}
		return resultado;
	}
	
	public ArrayList<Funcionario> pesquisarFuncionarioPorNome(String nome){
		
		DatabaseController database_controller = new DatabaseController(Database.getInstance());
		ArrayList<Funcionario> resultado = new ArrayList<Funcionario>();
		
		for (Funcionario f : database_controller.getFuncionarios()){
			if (f.getNome().toLowerCase().contains(nome.toLowerCase())){
				resultado.add(f);
			}
		}
		return resultado;
	}
	
	public ArrayList<Funcionario> pesquisarFuncionarioPorCPF(String cpf){
		
		DatabaseController database_controller = new DatabaseController(Database.getInstance());
		ArrayList<Funcionario> resultado = new ArrayList<Funcionario>();
		
		for (Funcionario f : database_controller.getFuncionarios()){
			if (f.getCpf().equals(cpf)){
				resultado.add(f);
				return resultado;
			}
		}
		
		return resultado;
	}
	
	public ArrayList<Peca> pesquisarPeca(int codigo, int filtro){
		
		DatabaseController database_controller = new DatabaseController(Database.getInstance());
		ArrayList<Peca> resultado = new ArrayList<Peca>();
		
		for (Peca p : database_controller.getPecas()){
			if (p.getCodigo_peca() == codigo){
				if (filtro == 0){
					resultado.add(p);
				}else if (filtro == 1){
					if (p.isDisponivel()){
						resultado.add(p);
					}
				}else{
					if (!p.isDisponivel()){
						resultado.add(p);
					}
				}
			}
		}
		return resultado;
	}
	
	public ArrayList<Peca> pesquisarPeca(String tipo, int filtro){
		
		DatabaseController database_controller = new DatabaseController(Database.getInstance());
		ArrayList<Peca> resultado = new ArrayList<Peca>();
		
		for (Peca p : database_controller.getPecas()){
			if (p.getTipo().toLowerCase().contains(tipo.toLowerCase())){
				if (filtro == 0){
					resultado.add(p);
				}else if (filtro == 1){
					if (p.isDisponivel()){
						resultado.add(p);
					}
				}else{
					if (!p.isDisponivel()){
						resultado.add(p);
					}
				}
			}
		}
		return resultado;
	}
	
	public int getPecaIndex(int codigo){
		
		DatabaseController db_controller = new DatabaseController(Database.getInstance());
		
		for (int i = 0; i < db_controller.getPecas().size(); i++){
			if (db_controller.getPecas().get(i).getCodigo_peca() == codigo){
				return i;
			}
		}
		
		return -1;
	}
	
	/* Retorna os alugueis relativos ao intervalo estabelecido. Se a data de inicio estiver vazia, retorna todos os alugueis que têm a mesma data de
	 * fim. Se a data de início estiver vazia, retorna todos os alugueis que têm início na mesma data.*/
	public ArrayList<Aluguel> pesquisarAluguelPorData(Data data_inicio, Data data_fim){
		
		DatabaseController database_controller = new DatabaseController(Database.getInstance());
		ArrayList<Aluguel> resultado = new ArrayList<Aluguel>();
		
		if (data_inicio == null){
			for (Aluguel a: database_controller.getAlugueis()){
				if (a.getData_fim().isEqual(data_fim)){
					resultado.add(a);
				}
			}
		}
		else if (data_fim == null){
			for (Aluguel a: database_controller.getAlugueis()){
				if (a.getData_inicio().isEqual(data_inicio)){
					resultado.add(a);
				}
			}
		}
		else{
			for (Aluguel a: database_controller.getAlugueis()){
				if (a.getData_inicio().isEqual(data_inicio)){
					if (a.getData_fim().isEqual(data_fim)){
						resultado.add(a);
					}
				}
			}
			
		}
		
		return resultado;
	}
	
	public ArrayList<Aluguel> pesquisarAluguelPorCliente(String cpf){
		
		DatabaseController database_controller = new DatabaseController(Database.getInstance());
		ArrayList<Aluguel> resultado = new ArrayList<Aluguel>();
		
		for (Aluguel a : database_controller.getAlugueis()){
			if (a.getCpf_cliente().equals(cpf)){
				resultado.add(a);
			}
		}
		
		return resultado;
	}
	
	public boolean existeFuncionario(String cpf){
		DatabaseController database_controller = new DatabaseController(Database.getInstance());

		for (Funcionario f : database_controller.getFuncionarios()){
			if (f.getCpf().equals(cpf)){
				return true;
			}
		}
		return false;
	}
	
	public boolean existeCliente(String cpf){
		
		DatabaseController database_controller = new DatabaseController(Database.getInstance());

		for (Cliente c : database_controller.getClientes()){
			if (c.getCpf().equals(cpf)){
				return true;
			}
		}
		return false;
	}
	
	public DefaultTableModel gerarDefaultTableModelPeca(ArrayList<Peca> pecas_encontradas){
		
		if(pecas_encontradas.isEmpty()){
			return null;
		}
		
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
	
	public DefaultTableModel gerarDefaultTableModelCliente(ArrayList<Cliente> clientes_encontrados){
		
		if(clientes_encontrados.isEmpty()){
			return null;
		}
		
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
	
	public DefaultTableModel gerarDefaultTableModelFuncionario(ArrayList<Funcionario> funcionarios_encontrados){
		
		if(funcionarios_encontrados.isEmpty()){
			return null;
		}
		
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
