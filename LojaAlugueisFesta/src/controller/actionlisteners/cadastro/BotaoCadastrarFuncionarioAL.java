package controller.actionlisteners.cadastro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.MensagemFrame;
import view.cadastro.CadastroFuncionarioFrame;
import controller.CadastroController;

public class BotaoCadastrarFuncionarioAL implements ActionListener{
	
	private CadastroFuncionarioFrame frame;
	
	public BotaoCadastrarFuncionarioAL(CadastroFuncionarioFrame frame){
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		CadastroController cadastro_controller = new CadastroController();
		boolean sucesso = false;
		
		if(this.frame.getRdbtnFuncionrio().isSelected()){
			sucesso = cadastro_controller.cadastraFuncionario(this.frame.getNome_text_field().getText(), this.frame.getCPFTextField().getText(),
					this.frame.getEmail_text_field().getText(), this.frame.getTelefone_text_field().getText(),
					this.frame.getEndereco_text_field().getText(), this.frame.getPasswordField().getText(),
					this.frame.getConfirmacao_senha_field().getText(), false);
			
		}
		else if(this.frame.getRdbtnGerente().isSelected()){
			sucesso = cadastro_controller.cadastraFuncionario(this.frame.getNome_text_field().getText(), this.frame.getCPFTextField().getText(),
					this.frame.getEmail_text_field().getText(), this.frame.getTelefone_text_field().getText(),
					this.frame.getEndereco_text_field().getText(), this.frame.getPasswordField().getText(),
					this.frame.getConfirmacao_senha_field().getText(), true);
			
		}else{
			MensagemFrame msg = new MensagemFrame("Selecione o cargo do funcionário.");
			msg.setVisible(true);
		} 
		
		if (sucesso){
			this.frame.dispose();
		}
	}

}
