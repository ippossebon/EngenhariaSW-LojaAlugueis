package controller.actionlisteners.aluguel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

import view.aluguel.DadosNovoAluguelFrame;

public class BotaoRemoverPecaCarrinhoAL implements ActionListener{

	private DadosNovoAluguelFrame frame;
	
	public BotaoRemoverPecaCarrinhoAL(DadosNovoAluguelFrame frame){
		this.frame = frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int linha_item_selecionado = this.frame.getItens_table().getSelectedRow();
		
		if(linha_item_selecionado != -1){
			DefaultTableModel dft_carrinho = (DefaultTableModel) this.frame.getItens_table().getModel();
			dft_carrinho.removeRow(linha_item_selecionado);
			this.frame.getItens_table().repaint();
		}
	}

}
