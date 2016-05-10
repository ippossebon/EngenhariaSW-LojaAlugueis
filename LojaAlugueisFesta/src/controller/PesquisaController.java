package controller;

import java.util.ArrayList;

import model.Aluguel;
import model.Cliente;
import model.Data;
import model.Peca;

public class PesquisaController {
	
	public PesquisaController(){
		
	}
	
	public ArrayList<Cliente> pesquisarClientePorNome(String nome){
		
		ArrayList<Cliente> resultado = new ArrayList<Cliente>();
		
		for (Cliente c : Main.database_controller.getClientes()){
			if (c.getNome().equals(nome)){
				resultado.add(c);
			}
		}
		return resultado;
	}
	
	public ArrayList<Cliente> pesquisarClientePorCPF(String cpf){
		
		ArrayList<Cliente> resultado = new ArrayList<Cliente>();
		
		for (Cliente c : Main.database_controller.getClientes()){
			if (c.getCpf().equals(cpf)){
				resultado.add(c);
				return resultado;
			}
		}
		return resultado;
	}
	
	public ArrayList<Peca> pesquisarPeca(int codigo, int filtro){
		
		ArrayList<Peca> resultado = new ArrayList<Peca>();
		
		for (Peca p : Main.database_controller.getPecas()){
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
		
		ArrayList<Peca> resultado = new ArrayList<Peca>();
		
		for (Peca p : Main.database_controller.getPecas()){
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
		
		ArrayList<Aluguel> resultado = new ArrayList<Aluguel>();
		
		if (data_inicio == null){
			for (Aluguel a: Main.database_controller.getAlugueis()){
				if (a.getData_fim().isEqual(data_fim)){
					resultado.add(a);
				}
			}
		}
		else if (data_fim == null){
			for (Aluguel a: Main.database_controller.getAlugueis()){
				if (a.getData_inicio().isEqual(data_inicio)){
					resultado.add(a);
				}
			}
		}
		else{
			for (Aluguel a: Main.database_controller.getAlugueis()){
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
		
		ArrayList<Aluguel> resultado = new ArrayList<Aluguel>();
		
		for (Aluguel a : Main.database_controller.getAlugueis()){
			if (a.getCpf_cliente().equals(cpf)){
				resultado.add(a);
			}
		}
		
		return resultado;
	}
	
}
