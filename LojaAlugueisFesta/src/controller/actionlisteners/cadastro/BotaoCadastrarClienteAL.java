package controller.actionlisteners.cadastro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JTextField;

import view.cadastro.CadastroFrame;
import controller.CadastroController;

public class BotaoCadastrarClienteAL implements ActionListener{
	
	private CadastroFrame frame;
	

	public BotaoCadastrarClienteAL(CadastroFrame frame){
		this.frame = frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		CadastroController cadastro_controller = new CadastroController();
		boolean sucesso = cadastro_controller.cadastraCliente(this.frame.getNomeTextField().getText(), this.frame.getCPFTextField().getText(),
																this.frame.getEmailTextField().getText(), this.frame.getTelefoneTextField().getText(),
																this.frame.getEnderecoTextField().getText());
		if (sucesso){
			this.frame.dispose();
		}
	}

}
