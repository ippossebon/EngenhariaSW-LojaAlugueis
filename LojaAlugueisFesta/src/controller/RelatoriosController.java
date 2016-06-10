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
//----------------------------------
import controller.AluguelController;
//----------------------------------
public class RelatoriosController {

	public RelatoriosController(){
		
	}
	
	public void getRelatorioReceita(String data_inicio, String data_fim){
		
		DatabaseController database_controller = new DatabaseController(Database.getInstance());
		
		
		
	}

	/*
	public ArrayList<Cliente> getClientesBloqueados(Data data_inicio, Data data_fim){
=======
	
	/*--------------------Retorna Valor Total de Receita Acumulada neste per�odo--------------------------*/
	public float calculaTotalReceita(String data_inicio, String data_fim){
		
		float resultado = 0;
		for(Aluguel a: this.getAlugueis(data_inicio, data_fim)){
			resultado += a.getValor_total();
			if(a.isEntregue()){
				resultado += a.getValor_multa();
			}
		}
		
		
		return resultado;
	}
	
	/*--------------------Retorna Lista com Clientes Bloqueados--------------------------*/
	public ArrayList<Cliente> getClientesBloqueados(String data_inicio, String data_fim){
		
		DatabaseController database_controller = new DatabaseController(Database.getInstance());
		ArrayList<Cliente> resultado = new ArrayList<Cliente>();
		int data_bloqueio;//data em que o cliente foi bloqueado
		
		Data periodo_inicio = new Data(data_inicio);
		Data periodo_fim = new Data(data_fim);
		
		//------Bloqueando Clientes para teste
		int i = 1;
		for(Cliente t: database_controller.getClientes()){
			t.setBloqueado(true);
			i++;
			if (i>15){
				break;
			}
		}
		
		//-------Efetuando alugu�is para os Clientes para Teste
		AluguelController aluguel_controller = new AluguelController();
		i = 1;
		int ano = 1990;
		ArrayList<Integer> codigos_pecas;
		for(Cliente t2: database_controller.getClientes()){
			codigos_pecas = new ArrayList<Integer>();
			codigos_pecas.add(i+3);
			aluguel_controller.alugarPeca(codigos_pecas, t2.getCpf(), "01/01/1989", "01/01/"+Integer.toString(ano));
			ano++;
			i++;
			if (i>15){
				break;
			}
		}
		
		//-------Seleciona os Clientes Bloqueados (falta implementa��o de compara��o de datas)
		for (Cliente c : database_controller.getClientes()){
			if (c.isBloqueado()){
				for(Aluguel a: database_controller.getAlugueis()){
					//data_bloqueio = a.getData_fim().converteDataParaDia();
					if(c.getCpf().equals(a.getCpf_cliente())){
						//if(data_bloqueio >= periodo_inicio.converteDataParaDia() && data_bloqueio <= periodo_fim.converteDataParaDia()){
							resultado.add(c);
						//}
						//else {break;}
					}
					
				}
			}
		}
		
		return resultado;
	}
	
	/*--------------------Retorna Lista com Alugueis em andamento--------------------------*/
	public ArrayList<Aluguel> getAlugueisEmAndamento(String data_inicio, String data_fim){
		
		DatabaseController database_controller = new DatabaseController(Database.getInstance());
		ArrayList<Aluguel> resultado = new ArrayList<Aluguel>();
		
		for(Aluguel a:database_controller.getAlugueis()){
			if(a.getData_entrega() == null){
				resultado.add(a);
			}
		}
		
		return resultado;
		
	}
	
	/*--------------------Retorna Lista com Todos os Alugu�is neste per�odo--------------------------*/
	public ArrayList<Aluguel> getAlugueis (String data_inicio, String data_fim){
		
		DatabaseController database_controller = new DatabaseController(Database.getInstance());
		ArrayList<Aluguel> resultado = new ArrayList<Aluguel>();
		Data periodo_inicio = new Data(data_inicio);
		Data periodo_fim = new Data(data_fim);
		
		for (Aluguel a: database_controller.getAlugueis()){
			//if (a.getData_inicio().converteDataParaDia() >= periodo_inicio.converteDataParaDia() && a.getData_inicio().converteDataParaDia() <= periodo_fim.converteDataParaDia()){
				resultado.add(a);
			//}
		}
		
		return resultado;
	}
	
	
}
