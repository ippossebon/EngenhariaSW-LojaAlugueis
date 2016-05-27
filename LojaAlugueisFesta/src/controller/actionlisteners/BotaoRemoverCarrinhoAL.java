package controller.actionlisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

import view.aluguel.NovoAluguelFrame;

public class BotaoRemoverCarrinhoAL implements ActionListener{

	private NovoAluguelFrame frame;

	public BotaoRemoverCarrinhoAL(NovoAluguelFrame frame){
		this.frame = frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int linha_item_selecionado = this.frame.getCarrinho_table().getSelectedRow();
		
		if(linha_item_selecionado != -1){
			DefaultTableModel dft_carrinho = (DefaultTableModel) this.frame.getCarrinho_table().getModel();
			dft_carrinho.removeRow(linha_item_selecionado);
			this.frame.getCarrinho_table().repaint();
		}
		
	}
	
	
}
