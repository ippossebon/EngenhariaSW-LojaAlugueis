package controller;

import java.util.ArrayList;

import model.Aluguel;
import model.Cliente;
import model.Data;
import model.Funcionario;
import model.Peca;
import view.LoginFrame;
import database.DatabaseController;

public class PesquisaController {
	
	public PesquisaController(){
		
	}
	
	public ArrayList<Cliente> pesquisarClientePorNome(String nome){
		
		DatabaseController database_controller = new DatabaseController(LoginFrame.database);
		ArrayList<Cliente> resultado = new ArrayList<Cliente>();
		
		for (Cliente c : database_controller.getClientes()){
			if (c.getNome().equals(nome)){
				resultado.add(c);
			}
		}
		return resultado;
	}
	
	public ArrayList<Cliente> pesquisarClientePorCPF(String cpf){
		
		DatabaseController database_controller = new DatabaseController(LoginFrame.database);
		ArrayList<Cliente> resultado = new ArrayList<Cliente>();
		
		for (Cliente c : database_controller.getClientes()){
			if (c.getCpf().equals(cpf)){
				resultado.add(c);
				return resultado;
			}
		}
		return resultado;
	}
	
	public ArrayList<Funcionario> pesquisarFuncionarioPorCPF(String cpf){
		
		DatabaseController database_controller = new DatabaseController(LoginFrame.database);
		ArrayList<Funcionario> resultado = new ArrayList<Funcionario>();
		
		for (Funcionario f : database_controller.getFuncionarios()){
			if (f.getCpf().equals(cpf)){
				resultado.add(f);
				return resultado;
			}
		}
		
		return null;
	}
	
	public ArrayList<Peca> pesquisarPeca(int codigo, int filtro){
		
		DatabaseController database_controller = new DatabaseController(LoginFrame.database);
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
		
		DatabaseController database_controller = new DatabaseController(LoginFrame.database);
		ArrayList<Peca> resultado = new ArrayList<Peca>();
		
		for (Peca p : database_controller.getPecas()){
			if (p.getTipo().equals(tipo)){
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
	
	/* Retorna os alugueis relativos ao intervalo estabelecido. Se a data de inicio estiver vazia, retorna todos os alugueis que têm a mesma data de
	 * fim. Se a data de início estiver vazia, retorna todos os alugueis que têm início na mesma data.*/
	public ArrayList<Aluguel> pesquisarAluguelPorData(Data data_inicio, Data data_fim){
		
		DatabaseController database_controller = new DatabaseController(LoginFrame.database);
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
		
		DatabaseController database_controller = new DatabaseController(LoginFrame.database);
		ArrayList<Aluguel> resultado = new ArrayList<Aluguel>();
		
		for (Aluguel a : database_controller.getAlugueis()){
			if (a.getCpf_cliente().equals(cpf)){
				resultado.add(a);
			}
		}
		
		return resultado;
	}
	
	public boolean existeFuncionario(String cpf){
		
		DatabaseController database_controller = new DatabaseController(LoginFrame.database);
		for (Funcionario f : database_controller.getFuncionarios()){
			if (f.getCpf().equals(cpf)){
				return true;
			}
		}
		return false;
	}
	
	public boolean existeCliente(String cpf){
		
		DatabaseController database_controller = new DatabaseController(LoginFrame.database);
		for (Cliente c : database_controller.getClientes()){
			if (c.getCpf().equals(cpf)){
				return true;
			}
		}
		return false;
	}
	
	
}
