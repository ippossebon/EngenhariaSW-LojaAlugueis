package view.aluguel;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import view.Operacoes;
import controller.EncaminhaPagamentoMultaAL;
import controller.FecharFrameAL;
import controller.actionlisteners.aluguel.ExibirAlugueisClienteAL;

public class SolicitarCPFClienteFrame extends JFrame {

	public static final int registrar_devolucao = 1;
	public static final int pagar_multa = 2;
	
	private JPanel contentPane;
	private JFormattedTextField cpf_text_field;
	

	public SolicitarCPFClienteFrame(int operacao) {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 291, 153);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCpfCliente = new JLabel("CPF cliente:");
		lblCpfCliente.setBounds(25, 25, 81, 16);
		contentPane.add(lblCpfCliente);
		
		cpf_text_field = new JFormattedTextField(Operacoes.aplicaMascara("###.###.###-##"));
		cpf_text_field.setBounds(118, 19, 153, 28);
		contentPane.add(cpf_text_field);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(154, 96, 117, 29);
		if (operacao == registrar_devolucao){
			setTitle("Registrar devolução");
			btnOk.addActionListener(new ExibirAlugueisClienteAL(this));
		}
		else if(operacao == pagar_multa){
			setTitle("Pagar multa");
			btnOk.addActionListener(new EncaminhaPagamentoMultaAL(this));
		}
		else{
			System.out.println("RegistrarDevolucaoFrame >> operacao inválida.");
		}
		
		contentPane.add(btnOk);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(6, 96, 117, 29);
		btnCancelar.addActionListener(new FecharFrameAL(this));
		contentPane.add(btnCancelar);
	}

	public JFormattedTextField getCpf_text_field() {
		return cpf_text_field;
	}

	public void setCpf_text_field(JFormattedTextField cpf_text_field) {
		this.cpf_text_field = cpf_text_field;
	}
}
