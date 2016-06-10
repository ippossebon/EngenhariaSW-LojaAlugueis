package controller.actionlisteners.aluguel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

import view.aluguel.NovoAluguelFrame;

public class BotaoAdicionarCarrinhoAL implements ActionListener{

	private NovoAluguelFrame frame;
	
	public BotaoAdicionarCarrinhoAL(NovoAluguelFrame frame){
		this.frame = frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// TODO Auto-generated method stub
		int linha_item_selecionado = this.frame.getResultados_table().getSelectedRow();
		DefaultTableModel dft_carrinho = (DefaultTableModel) this.frame.getCarrinho_table().getModel();
		
		if(this.frame.getResultados_table().getValueAt(linha_item_selecionado, 3).toString().equals("Disponível") &&
				! itemJaNoCarrinho(dft_carrinho, this.frame.getResultados_table().getValueAt(linha_item_selecionado, 0).toString()) ){
			
			dft_carrinho.addRow(new Object[]{this.frame.getResultados_table().getModel().getValueAt(linha_item_selecionado, 0).toString(), 
									this.frame.getResultados_table().getModel().getValueAt(linha_item_selecionado, 1).toString(), 
									this.frame.getResultados_table().getModel().getValueAt(linha_item_selecionado, 2).toString(),
									this.frame.getResultados_table().getModel().getValueAt(linha_item_selecionado, 3).toString(),
									this.frame.getResultados_table().getModel().getValueAt(linha_item_selecionado, 4).toString(),
									this.frame.getResultados_table().getModel().getValueAt(linha_item_selecionado, 5).toString()});
			
			this.frame.getCarrinho_table().setModel(dft_carrinho);
			this.frame.getCarrinho_table().repaint();
		}
		
	}

	private boolean itemJaNoCarrinho(DefaultTableModel dft, String codigo){
		
		for (int i = 0; i < dft.getRowCount(); i++){
			if (dft.getValueAt(i, 0).toString().equals(codigo)){
				return true;
			}
		}
		
		return false;
	}
}
