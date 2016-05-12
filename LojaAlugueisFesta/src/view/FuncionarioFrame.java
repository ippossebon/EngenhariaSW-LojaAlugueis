package view;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import view.actionlisteners.UpdateOptionsActionListener;

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
		btnCadastrarCliente.setBounds(522, 184, 166, 29);
		contentPane.add(btnCadastrarCliente);
		
		JButton btnNovoFuncionrio = new JButton("Cadastrar funcionário");
		btnNovoFuncionrio.setBounds(522, 225, 166, 29);
		contentPane.add(btnNovoFuncionrio);
		
		JButton btnNovoAluguel = new JButton("Novo aluguel");
		btnNovoAluguel.setBounds(522, 307, 166, 29);
		contentPane.add(btnNovoAluguel);
		
		JButton btnRegistrarPagamento = new JButton("Registrar pagamento");
		btnRegistrarPagamento.setBounds(522, 266, 166, 29);
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
		
		JRadioButton rdbtnTodas = new JRadioButton("Todas");
		rdbtnNome.setToolTipText("Peça");
		rdbtnTodas.setBounds(110, 118, 90, 23);
		contentPane.add(rdbtnTodas);
		
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
		
		JRadioButton rdbtnFuncionario = new JRadioButton("Funcionário");
		rdbtnFuncionario.setBounds(348, 50, 141, 23);
		contentPane.add(rdbtnFuncionario);
		
		ButtonGroup button_group_pesquisa = new ButtonGroup();
		button_group_pesquisa.add(rdbtnPeca);
		button_group_pesquisa.add(rdbtnPessoa);
		button_group_pesquisa.add(rdbtnFuncionario);
		
		ButtonGroup bg_filtro_pessoa = new ButtonGroup();
		bg_filtro_pessoa.add(rdbtnCpf);
		bg_filtro_pessoa.add(rdbtnNome);
		
		ButtonGroup bg_filtro_peca = new ButtonGroup();
		bg_filtro_peca.add(rdbtnAlugadas);
		bg_filtro_peca.add(rdbtnDisponiveis);
		bg_filtro_peca.add(rdbtnTodas);
		
		/* Testar!! */
		rdbtnPeca.addActionListener(new UpdateOptionsActionListener(rdbtnPeca, rdbtnPessoa, rdbtnFuncionario, rdbtnNome, rdbtnCpf, rdbtnTodas, rdbtnDisponiveis, rdbtnAlugadas));
		rdbtnPessoa.addActionListener(new UpdateOptionsActionListener(rdbtnPeca, rdbtnPessoa, rdbtnFuncionario, rdbtnNome, rdbtnCpf, rdbtnTodas, rdbtnDisponiveis, rdbtnAlugadas));
		rdbtnFuncionario.addActionListener(new UpdateOptionsActionListener(rdbtnPeca, rdbtnPessoa, rdbtnFuncionario, rdbtnNome, rdbtnCpf, rdbtnTodas, rdbtnDisponiveis, rdbtnAlugadas));
		
		resultados_table = new JTable();
		resultados_table.setBackground(SystemColor.window);
		resultados_table.setBorder(new LineBorder(UIManager.getColor("Button.shadow")));
		resultados_table.setBounds(36, 184, 474, 330);
		contentPane.add(resultados_table);		
	}
}

