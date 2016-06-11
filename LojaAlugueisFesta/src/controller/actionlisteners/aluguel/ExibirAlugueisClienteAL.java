package controller.actionlisteners.aluguel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import model.Aluguel;
import view.MensagemFrame;
import view.aluguel.RegistrarDevolucaoFrame;
import view.aluguel.SelecionarAluguelDevolucaoFrame;
import controller.OperacoesDefaultTableModel;
import controller.PesquisaController;
import database.Database;
import database.DatabaseController;

public class ExibirAlugueisClienteAL implements ActionListener{

	private RegistrarDevolucaoFrame frame;
	
	public ExibirAlugueisClienteAL(RegistrarDevolucaoFrame frame){
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String cpf = this.frame.getCpf_text_field().getText();
		PesquisaController pesquisa_controller = new PesquisaController();
		
		if (pesquisa_controller.existeCliente(cpf)){
			DatabaseController db_controller = new DatabaseController(Database.getInstance());
			ArrayList<Aluguel> alugueis_cliente = new ArrayList<Aluguel>();
			
			for (Aluguel a : db_controller.getAlugueis()){
				if (a.getCpf_cliente().equals(cpf) && !a.isEntregue()){
					alugueis_cliente.add(a);
				}
			}
			
			if(alugueis_cliente.isEmpty()){
				MensagemFrame msg = new MensagemFrame("Este cliente não possui alugueis em andamento.");
				msg.setVisible(true);
			}
			else{
				SelecionarAluguelDevolucaoFrame frame = new SelecionarAluguelDevolucaoFrame(alugueis_cliente, OperacoesDefaultTableModel.gerarDefaultTableModelAlugueis(alugueis_cliente));
				frame.setVisible(true);
				this.frame.dispose();
			}
		}
		else{
			MensagemFrame msg = new MensagemFrame("Este cliente não está cadastrado no sistema.");
			msg.setVisible(true);
		}
	}

}
