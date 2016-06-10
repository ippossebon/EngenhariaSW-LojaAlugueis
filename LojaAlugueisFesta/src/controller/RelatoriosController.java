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

public class RelatoriosController {

	public RelatoriosController(){
		
	}
	
	public void getRelatorioLucro(Data data_inicio, Data data_fim){
		
	}
	/*
	public ArrayList<Cliente> getClientesBloqueados(Data data_inicio, Data data_fim){
		
		DatabaseController database_controller = new DatabaseController(Database.getInstance());
		ArrayList<Cliente> resultado = new ArrayList<Cliente>();
		
		for (Cliente c : database_controller.getClientes()){
			if (c.isBloqueado()){
				if(){
					resultado.add(c);
				}
			}
		}
		
		return resultado;
	}
	*/
	public void getAlugueisEmAndamento(Data data_inicio, Data data_fim){
		
	}
	
	
}
