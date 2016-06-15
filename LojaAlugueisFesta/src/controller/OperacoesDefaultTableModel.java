package controller;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import model.Aluguel;
import model.Cliente;
import model.Funcionario;
import model.Peca;
import model.RegistroReceita;
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
		
		ArrayList<Integer> ids_aluguel = new ArrayList<Integer>();
		ArrayList<String> datas_entrega = new ArrayList<String>();
		
		DefaultTableModel dft = new DefaultTableModel();
		
		for (Aluguel a: alugueis){
			ids_aluguel.add(a.getId());
			datas_entrega.add(a.getData_fim().gerarString());
		}
		
		dft.addColumn("ID", ids_aluguel.toArray());
		dft.addColumn("Data de entrega", datas_entrega.toArray());
		
		return dft;
	}
	
	public static DefaultTableModel gerarDefaultTableModelQtdAlugueis(ArrayList<Aluguel> alugueis){
		if (alugueis.isEmpty()){
			return null;
		}
		
		ArrayList<String> datas = new ArrayList<String>();
		ArrayList<Integer> qtds = new ArrayList<Integer>();
		
		DefaultTableModel dft = new DefaultTableModel();
		
		String iterador_data = alugueis.get(0).getData_inicio().gerarString();
		datas.add(iterador_data);
		int cont_alugueis = 1;
		for(Aluguel a: alugueis){
			if(a.getData_inicio().gerarString() != iterador_data){
				qtds.add(cont_alugueis);
				cont_alugueis = 1;
				iterador_data = a.getData_inicio().gerarString();
				datas.add(iterador_data);
			}
			else {
				cont_alugueis++;
			}
		}
		qtds.add(cont_alugueis);
		datas.add("Total");
		qtds.add(alugueis.size());
		
		dft.addColumn("Data", datas.toArray());
		dft.addColumn("Quantidade de Alugu�is", qtds.toArray());
		
		return dft;
	}
	
	public static DefaultTableModel gerarDefaultTableModelAlugueisPorPeca(){
		DefaultTableModel dft = new DefaultTableModel();
		Vector<String> rowData = new  Vector<String>();
		rowData.add("ID pe�a");
		rowData.add("Tipo");
		rowData.add("Tamanho");
		rowData.add("Alugu�is");
		
		dft.addRow(rowData);
		
		return dft;
	}
	
	public static void addDefaultTableModelAlugueisPorPeca(Peca peca, int qtd_alugueis, DefaultTableModel dft){
		Vector<String> rowData = new  Vector<String>();
		rowData.add(Integer.toString(peca.getCodigo_peca()));
		rowData.add(peca.getTipo());
		rowData.add(Integer.toString(peca.getTamanho()));
		rowData.add(Integer.toString(qtd_alugueis));
		
		dft.addRow(rowData);
	}
	
	public static DefaultTableModel gerarDefaultTableModelReceita(ArrayList<RegistroReceita> registro_receita, double total_receita){
		if(registro_receita.isEmpty()){
			return null;
		}
		
		ArrayList<String> data_receita = new ArrayList<String>();
		ArrayList<Double> valor_receita = new ArrayList<Double>();
		
		DefaultTableModel dft = new DefaultTableModel();
		
		for(RegistroReceita r: registro_receita){
			data_receita.add(r.getData().gerarString());
			valor_receita.add(r.getValor());
		}
		data_receita.add("Total");
		valor_receita.add(total_receita);
		
		dft.addColumn("Data", data_receita.toArray());
		dft.addColumn("Valor", valor_receita.toArray());

		return dft;
	}
}
