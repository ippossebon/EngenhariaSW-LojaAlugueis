package view;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controller.PesquisaController;
import javax.swing.UIManager;

public class FuncionarioFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable resultados_table;

	public FuncionarioFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 688, 562);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(110, 18, 400, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Pesquisar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(522, 18, 166, 29);
		contentPane.add(btnNewButton);
		
		JLabel lblPesquisa = new JLabel("Pesquisa:");
		lblPesquisa.setBounds(36, 22, 61, 16);
		contentPane.add(lblPesquisa);
		
		JButton btnCadastrarCliente = new JButton("Cadastrar cliente");
		btnCadastrarCliente.setBounds(522, 95, 166, 29);
		contentPane.add(btnCadastrarCliente);
		
		JButton btnNovoFuncionrio = new JButton("Cadastrar funcionário");
		btnNovoFuncionrio.setBounds(522, 136, 166, 29);
		contentPane.add(btnNovoFuncionrio);
		
		JButton btnNovoAluguel = new JButton("Novo aluguel");
		btnNovoAluguel.setBounds(522, 218, 166, 29);
		contentPane.add(btnNovoAluguel);
		
		JButton btnRegistrarPagamento = new JButton("Registrar pagamento");
		btnRegistrarPagamento.setBounds(522, 177, 166, 29);
		contentPane.add(btnRegistrarPagamento);
		
		JLabel lblResultados = new JLabel("Resultados");
		lblResultados.setBounds(36, 95, 73, 16);
		contentPane.add(lblResultados);
		
		JLabel lblFiltrarPor = new JLabel("Filtrar por:");
		lblFiltrarPor.setBounds(36, 122, 84, 16);
		contentPane.add(lblFiltrarPor);
		
		JRadioButton rdbtnNome = new JRadioButton("Nome");
		rdbtnNome.setToolTipText("Pessoa");
		rdbtnNome.setBounds(110, 153, 84, 23);
		contentPane.add(rdbtnNome);
		
		JRadioButton rdbtnCpf = new JRadioButton("CPF");
		rdbtnNome.setToolTipText("Pessoa");
		rdbtnCpf.setBounds(216, 153, 73, 23);
		contentPane.add(rdbtnCpf);
		
		JRadioButton rdbtnTipo = new JRadioButton("Tipo");
		rdbtnNome.setToolTipText("Peça");
		rdbtnTipo.setBounds(110, 118, 141, 23);
		contentPane.add(rdbtnTipo);
		
		JRadioButton rdbtnDisponiveis = new JRadioButton("Disponíveis");
		rdbtnNome.setToolTipText("Peça");
		rdbtnDisponiveis.setBounds(216, 118, 141, 23);
		contentPane.add(rdbtnDisponiveis);
		
		JRadioButton rdbtnAlugadas = new JRadioButton("Alugadas");
		rdbtnNome.setToolTipText("Peça");
		rdbtnAlugadas.setBounds(349, 118, 141, 23);
		contentPane.add(rdbtnAlugadas);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(6, 80, 682, 12);
		contentPane.add(separator);
		
		JRadioButton rdbtnPeca = new JRadioButton("Peça");
		rdbtnPeca.setBounds(110, 50, 73, 23);
		contentPane.add(rdbtnPeca);
		
		JRadioButton rdbtnPessoa = new JRadioButton("Pessoa");
		rdbtnPessoa.setBounds(216, 50, 141, 23);
		contentPane.add(rdbtnPessoa);
		
		// Testar!!
		rdbtnPeca.addActionListener(new UpdateOptions(rdbtnPeca, rdbtnPessoa, rdbtnNome, rdbtnCpf, rdbtnTipo, rdbtnDisponiveis, rdbtnAlugadas));
		rdbtnPessoa.addActionListener(new UpdateOptions(rdbtnPeca, rdbtnPessoa, rdbtnNome, rdbtnCpf, rdbtnTipo, rdbtnDisponiveis, rdbtnAlugadas));
		
		resultados_table = new JTable();
		resultados_table.setBackground(SystemColor.window);
		resultados_table.setBorder(new LineBorder(UIManager.getColor("Button.shadow")));
		resultados_table.setBounds(36, 184, 474, 330);
		contentPane.add(resultados_table);
	}
}

class UpdateOptions implements ActionListener{
	private JRadioButton button_peca;
	private JRadioButton button_pessoa;
	private JRadioButton b_nome;
	private JRadioButton b_cpf;
	private JRadioButton b_tipo;
	private JRadioButton b_disponiveis;
	private JRadioButton b_alugadas;
	
	public UpdateOptions(JRadioButton button_peca, JRadioButton button_pessoa, JRadioButton b_nome, JRadioButton b_cpf, JRadioButton b_tipo, JRadioButton b_disp, JRadioButton b_alug){
		this.button_peca = button_peca;
		this.button_pessoa = button_pessoa;
		this.b_nome = b_nome;
		this.b_cpf = b_cpf;
		this.b_cpf = b_tipo;
		this.b_disponiveis = b_disp;
		this.b_alugadas = b_alug;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (this.button_peca.isSelected()){
			this.b_nome.setEnabled(false);
			this.b_cpf.setEnabled(false);
		}
		
		if(this.button_pessoa.isSelected()){
			this.b_tipo.setEnabled(false);
			this.b_disponiveis.setEnabled(false);
			this.b_alugadas.setEnabled(false);
		}
		
	}
}

class ActionBotaoPesquisar implements ActionListener{
	private JRadioButton button_peca;
	private JRadioButton button_pessoa;
	private JRadioButton b_nome;
	private JRadioButton b_cpf;
	private JRadioButton b_tipo;
	private JRadioButton b_disponiveis;
	private JRadioButton b_alugadas;
	private JTextField text;
	
	public ActionBotaoPesquisar (JTextField text, JRadioButton button_peca, JRadioButton button_pessoa, JRadioButton b_nome, JRadioButton b_cpf, JRadioButton b_tipo, JRadioButton b_disp, JRadioButton b_alug){
		this.button_peca = button_peca;
		this.button_pessoa = button_pessoa;
		this.b_nome = b_nome;
		this.b_cpf = b_cpf;
		this.b_cpf = b_tipo;
		this.b_disponiveis = b_disp;
		this.b_alugadas = b_alug;
		this.text = text;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		PesquisaController pesquisa_controller = new PesquisaController();
		
		if (this.button_peca.isSelected()){
			// Pesquisa por peça
			
			if (this.b_tipo.isSelected()){
				if (this.b_disponiveis.isSelected()){
					//pesquisa pela palavra
					
				}else if(this.b_alugadas.isSelected()){
					// pesquisa pela palavra
					
				}else{
					// Pesquisa pela palavra em todo o banco de dados
				}
			}
			else{
				if (this.b_disponiveis.isSelected()){
					//pesquisa pela palavra
					
				}else if(this.b_alugadas.isSelected()){
					// pesquisa pela palavra
					
				}
			}
		}
		else if (this.button_pessoa.isSelected()){ // Pesquisa por pessoa
			if (this.b_nome.isSelected()){
				// Pesquisa pessoa pelo nome
				
			}else if (this.b_cpf.isSelected()){
				// Pesquisa pessoa pelo cpf
				
			}else{
				MensagemErroFrame msg = new MensagemErroFrame("Selecione um filtro.");
				msg.setVisible(true);
			}
		}
		else{
			MensagemErroFrame msg = new MensagemErroFrame("Selecione uma opção de pesquisa.");
			msg.setVisible(true);
		}
		
	}
	
}
