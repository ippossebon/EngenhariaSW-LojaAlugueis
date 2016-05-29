package controller.actionlisteners.estoque;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.estoque.AlterarValorPecaFrame;
import view.estoque.EstoqueFrame;

public class BotaoAlterarPrecoPecaAL implements ActionListener{

	private EstoqueFrame frame;
	
	public BotaoAlterarPrecoPecaAL(EstoqueFrame f){
		this.frame = f;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int linha_item_selecionado = this.frame.getEstoque_table().getSelectedRow();
		String codigo = this.frame.getEstoque_table().getModel().getValueAt(linha_item_selecionado, 0).toString();
		String valor = this.frame.getEstoque_table().getModel().getValueAt(linha_item_selecionado, 3).toString();
		String tipo = this.frame.getEstoque_table().getModel().getValueAt(linha_item_selecionado, 1).toString();
		
		AlterarValorPecaFrame f = new AlterarValorPecaFrame(codigo, tipo, valor);
		f.setVisible(true);
	}

}
