package controller;

import database.Database;
import database.DatabaseController;

public class Main {

	public static DatabaseController database_controller;
	
	public static void main(){
		Database db = new Database();
		database_controller = new DatabaseController(db);
		
		PesquisaController pesquisa_controller = new PesquisaController();
		AluguelController aluguel_controller = new AluguelController();
	}
}
