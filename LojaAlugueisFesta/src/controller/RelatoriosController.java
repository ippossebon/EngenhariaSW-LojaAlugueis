package controller;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import model.Aluguel;
import model.Cliente;
import model.Data;
import model.Funcionario;
import model.Peca;
import model.RegistroReceita;
import database.Database;
import database.DatabaseController;
//----------------------------------
import controller.AluguelController;
//----------------------------------
public class RelatoriosController {

	public RelatoriosController(){
		
	}
	
	public ArrayList<RegistroReceita> getRelatorioReceita(String data_inicio, String data_fim){
		
		DatabaseController database_controller = new DatabaseController(Database.getInstance());
		ArrayList<RegistroReceita> resultado = new ArrayList<RegistroReceita>();
		Data periodo_inicio = new Data(data_inicio);
		Data periodo_fim = new Data(data_fim);
		
		for(RegistroReceita r: database_controller.getReceita()){
			if(r.getData().converteDataParaDia() >= periodo_inicio.converteDataParaDia() && r.getData().converteDataParaDia() <= periodo_fim.converteDataParaDia()){
				resultado.add(r);
			}
		}
		
		return resultado;
		
	}
	
	public int getValorTotalReceita(String data_inicio, String data_fim){

		DatabaseController database_controller = new DatabaseController(Database.getInstance());
		int resultado = 0;
		Data periodo_inicio = new Data(data_inicio);
		Data periodo_fim = new Data(data_fim);
		
		for(RegistroReceita r: database_controller.getReceita()){
			if(r.getData().converteDataParaDia() >= periodo_inicio.converteDataParaDia() && r.getData().converteDataParaDia() <= periodo_fim.converteDataParaDia()){
				resultado += r.getValor();
			}
		}
		
		return resultado;
	}

	/*
	public ArrayList<Cliente> getClientesBloqueados(Data data_inicio, Data data_fim){
=======
	
	/*--------------------Retorna Lista com Clientes Bloqueados--------------------------*/
	public ArrayList<Cliente> getClientesBloqueados(String data_inicio, String data_fim){
		
		DatabaseController database_controller = new DatabaseController(Database.getInstance());
		ArrayList<Cliente> resultado = new ArrayList<Cliente>();
		int data_bloqueio;//data em que o cliente foi bloqueado
		
		Data periodo_inicio = new Data(data_inicio);
		Data periodo_fim = new Data(data_fim);
		
		
		//-------Seleciona os Clientes Bloqueados (falta implementa��o de compara��o de datas)
		for (Cliente c : database_controller.getClientes()){
			if (c.isBloqueado()){
				for(Aluguel a: database_controller.getAlugueis()){
					data_bloqueio = a.getData_fim().converteDataParaDia();
					if(c.getCpf().equals(a.getCpf_cliente())){
						if(data_bloqueio >= periodo_inicio.converteDataParaDia() && data_bloqueio <= periodo_fim.converteDataParaDia()){
							resultado.add(c);
						}
						else {break;}
					}
					
				}
			}
		}
		
		return resultado;
	}
	
	/*--------------------Retorna Lista com Alugueis em andamento--------------------------
	public ArrayList<Aluguel> getAlugueisEmAndamento(String data_inicio, String data_fim){
		
		DatabaseController database_controller = new DatabaseController(Database.getInstance());
		ArrayList<Aluguel> resultado = new ArrayList<Aluguel>();
		
		for(Aluguel a:database_controller.getAlugueis()){
			if(a.getData_entrega() == null){
				resultado.add(a);
			}
		}
		
		return resultado;
		
	}*/
	
	/*--------------------Retorna Lista com Todos os Alugu�is neste per�odo--------------------------*/
	public ArrayList<Aluguel> getAlugueisEmAndamento (String data_inicio, String data_fim){
		
		DatabaseController database_controller = new DatabaseController(Database.getInstance());
		ArrayList<Aluguel> resultado = new ArrayList<Aluguel>();
		Data periodo_inicio = new Data(data_inicio);
		Data periodo_fim = new Data(data_fim);
		
		for (Aluguel a: database_controller.getAlugueis()){
			if (a.getData_inicio().converteDataParaDia() >= periodo_inicio.converteDataParaDia() && a.getData_inicio().converteDataParaDia() <= periodo_fim.converteDataParaDia()){
				resultado.add(a);
			}
		}
		
		return resultado;
	}
	
	public ArrayList<Aluguel> getAlugueisPorPeca (Peca peca, String data_inicio, String data_fim){
		DatabaseController database_controller = new DatabaseController(Database.getInstance());
		ArrayList<Aluguel> resultado = new ArrayList<Aluguel>();
		Data periodo_inicio = new Data(data_inicio);
		Data periodo_fim = new Data(data_fim);
		
		for (Aluguel a: database_controller.getAlugueis()){
			if (a.getData_inicio().converteDataParaDia() >= periodo_inicio.converteDataParaDia() && a.getData_inicio().converteDataParaDia() <= periodo_fim.converteDataParaDia()){
				for(Peca p: a.getPecas()){
					if (p.getCodigo_peca() == peca.getCodigo_peca()){
						resultado.add(a);
					}
				}
			}
		}
		
		return resultado;
	}
}
