package controller.actionlisteners.estoque;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

import view.MensagemFrame;
import view.estoque.EstoqueFrame;
import database.Database;
import database.DatabaseController;

public class BotaoRemoverDoEstoqueAL implements ActionListener{

	private EstoqueFrame frame;
	
	public BotaoRemoverDoEstoqueAL(EstoqueFrame f){
		this.frame = f;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int linha_item_selecionado = this.frame.getEstoque_table().getSelectedRow();
		
		try{
			DefaultTableModel dft_carrinho = (DefaultTableModel) this.frame.getEstoque_table().getModel();
			dft_carrinho.removeRow(linha_item_selecionado);
			
			DatabaseController database_controller = new DatabaseController(Database.getInstance());
			database_controller.removerPecaEstoque(Integer.parseInt(dft_carrinho.getValueAt(linha_item_selecionado, 0).toString()));
			
			this.frame.getEstoque_table().repaint();
		}
		catch(ArrayIndexOutOfBoundsException a){
			MensagemFrame msg = new MensagemFrame("Por favor, selecione um item para remover.");
			msg.setVisible(true);
		}
		
	}
}
