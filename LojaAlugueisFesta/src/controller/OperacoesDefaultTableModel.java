package controller;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import model.Aluguel;
import model.Cliente;
import model.Funcionario;
import model.Peca;
import database.Database;
import database.DatabaseController;

public class OperacoesDefaultTableModel {

	public OperacoesDefaultTableModel(){
		
	}
	
	public static DefaultTableModel gerarDefaultTableModelPeca(ArrayList<Peca> pecas_encontradas){
		
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
	
	public static DefaultTableModel gerarDefaultTableModelCliente(ArrayList<Cliente> clientes_encontrados){
		
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
	
	public static DefaultTableModel gerarDefaultTableModelFuncionario(ArrayList<Funcionario> funcionarios_encontrados){
		
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
	
	public static DefaultTableModel gerarDefaultTableModelAlugueis(ArrayList<Aluguel> alugueis){
		if (alugueis.isEmpty()){
			return null;
		}
		
		ArrayList<String> codigo_pecas = new ArrayList<String>();
		ArrayList<String> datas_entrega = new ArrayList<String>();
		DatabaseController db_controller = new DatabaseController(Database.getInstance());
		DefaultTableModel dft = new DefaultTableModel();
		
		for (Aluguel a: alugueis){
			String codigos = " ";
			for(Peca p: a.getPecas()){
				codigos = codigos + " " + String.valueOf(p.getCodigo_peca());
			}
			System.out.println("GerarDefaultTableModelAlugueis >>> string de codigos de peça = \" " + codigos + "\"");
			String dia, mes, ano;
			
		}
		
		
		return dft;
	}
	
}
