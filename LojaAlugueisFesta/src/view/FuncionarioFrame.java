package view;

import java.awt.SystemColor;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controller.actionlisteners.SelecaoCadastrarClienteAL;
import controller.actionlisteners.SelecaoCadastrarFuncionarioAL;
import controller.actionlisteners.SelecaoNovoAluguelAL;
import controller.actionlisteners.SelecaoRegistrarDevolucaoAL;
import controller.actionlisteners.SetFiltrosPecaAL;
import controller.actionlisteners.SetFiltrosPessoaAL;
import controller.actionlisteners.BotaoPesquisarAL;

public class FuncionarioFrame extends JFrame {

	private JPanel contentPane;
	private JTextField pesquisa_text_field;
	private JTable resultados_table;
	private JMenuBar menu_bar;

	public FuncionarioFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 664, 645);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		pesquisa_text_field = new JTextField();
		pesquisa_text_field.setBounds(110, 29, 400, 28);
		contentPane.add(pesquisa_text_field);
		pesquisa_text_field.setColumns(10);
		
		JLabel lblPesquisa = new JLabel("Pesquisa:");
		lblPesquisa.setBounds(36, 35, 61, 16);
		contentPane.add(lblPesquisa);
		
		JLabel lblResultados = new JLabel("Resultados");
		lblResultados.setBounds(36, 116, 73, 16);
		contentPane.add(lblResultados);
		
		JLabel lblFiltrarPor = new JLabel("Filtrar por:");
		lblFiltrarPor.setBounds(36, 144, 84, 16);
		contentPane.add(lblFiltrarPor);
		
		JRadioButton rdbtnNome = new JRadioButton("Nome");
		rdbtnNome.setToolTipText("Pessoa");
		rdbtnNome.setBounds(110, 196, 84, 23);
		contentPane.add(rdbtnNome);
		
		JRadioButton rdbtnCpf = new JRadioButton("CPF");
		rdbtnNome.setToolTipText("Pessoa");
		rdbtnCpf.setBounds(217, 196, 73, 23);
		contentPane.add(rdbtnCpf);
		
		JRadioButton rdbtnTodas = new JRadioButton("Todas");
		rdbtnNome.setToolTipText("Peça");
		rdbtnTodas.setBounds(110, 161, 90, 23);
		contentPane.add(rdbtnTodas);
		
		JRadioButton rdbtnDisponiveis = new JRadioButton("Disponíveis");
		rdbtnNome.setToolTipText("Peça");
		rdbtnDisponiveis.setBounds(217, 161, 121, 23);
		contentPane.add(rdbtnDisponiveis);
		
		JRadioButton rdbtnAlugadas = new JRadioButton("Alugadas");
		rdbtnNome.setToolTipText("Peça");
		rdbtnAlugadas.setBounds(348, 161, 95, 23);
		contentPane.add(rdbtnAlugadas);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(6, 104, 682, 12);
		contentPane.add(separator);
		
		JRadioButton rdbtnPeca = new JRadioButton("Peça");
		rdbtnPeca.setBounds(109, 69, 73, 23);
		contentPane.add(rdbtnPeca);
		
		JRadioButton rdbtnCliente = new JRadioButton("Cliente");
		rdbtnCliente.setBounds(217, 69, 90, 23);
		contentPane.add(rdbtnCliente);
		
		JRadioButton rdbtnFuncionario = new JRadioButton("Funcionário");
		rdbtnFuncionario.setBounds(348, 69, 141, 23);
		contentPane.add(rdbtnFuncionario);
		
		ButtonGroup button_group_pesquisa = new ButtonGroup();
		button_group_pesquisa.add(rdbtnPeca);
		button_group_pesquisa.add(rdbtnCliente);
		button_group_pesquisa.add(rdbtnFuncionario);
		
		ButtonGroup bg_filtro_pessoa = new ButtonGroup();
		bg_filtro_pessoa.add(rdbtnCpf);
		bg_filtro_pessoa.add(rdbtnNome);
		
		ButtonGroup bg_filtro_peca = new ButtonGroup();
		bg_filtro_peca.add(rdbtnAlugadas);
		bg_filtro_peca.add(rdbtnDisponiveis);
		bg_filtro_peca.add(rdbtnTodas);
		
		/* Testar!! */
		rdbtnPeca.addActionListener(new SetFiltrosPecaAL(rdbtnTodas, rdbtnDisponiveis, rdbtnAlugadas, rdbtnNome, rdbtnCpf));
		rdbtnCliente.addActionListener(new SetFiltrosPessoaAL(rdbtnTodas, rdbtnDisponiveis, rdbtnAlugadas, rdbtnNome, rdbtnCpf));
		rdbtnFuncionario.addActionListener(new SetFiltrosPessoaAL(rdbtnTodas, rdbtnDisponiveis, rdbtnAlugadas, rdbtnNome, rdbtnCpf));
		

		resultados_table = new JTable();
		resultados_table.setBackground(UIManager.getColor("InternalFrame.inactiveTitleBackground"));
		resultados_table.setBorder(new LineBorder(UIManager.getColor("Button.shadow")));
		resultados_table.setBounds(36, 231, 598, 330);
		
		JScrollPane resultados_scroll_pane = new JScrollPane(resultados_table);
		resultados_scroll_pane.setBounds(36, 231, 598, 330);
		contentPane.add(resultados_scroll_pane);
		
		JButton btnNewButton = new JButton("Pesquisar");
		btnNewButton.addActionListener(new BotaoPesquisarAL(resultados_table, pesquisa_text_field, rdbtnPeca, rdbtnCliente, rdbtnFuncionario, rdbtnNome, rdbtnCpf, rdbtnTodas, rdbtnDisponiveis, rdbtnAlugadas));
		btnNewButton.setBounds(522, 30, 112, 29);
		contentPane.add(btnNewButton);
		
		menu_bar = new JMenuBar();
		menu_bar.setBorderPainted(false);
		menu_bar.setBackground(SystemColor.windowBorder);
		menu_bar.setBounds(0, 0, 132, 22);
		
	    /* Menu cadastro - Atalho: C */
	    JMenu cadastroMenu = new JMenu("Cadastro");
	    cadastroMenu.setMnemonic(KeyEvent.VK_C);
	    menu_bar.add(cadastroMenu);

	    JMenuItem itemCadastrarCliente = new JMenuItem("Cadastrar cliente");
	    itemCadastrarCliente.addActionListener(new SelecaoCadastrarClienteAL());
	    cadastroMenu.add(itemCadastrarCliente);
	    
	    JMenuItem itemCadastrarFuncionario = new JMenuItem("Cadastrar funcionário");
	    itemCadastrarFuncionario.addActionListener(new SelecaoCadastrarFuncionarioAL());
	    cadastroMenu.add(itemCadastrarFuncionario);
	    
	    /* Menu aluguel - Atalho: A */
	    JMenu aluguelMenu = new JMenu("Aluguel");
	    aluguelMenu.setMnemonic(KeyEvent.VK_A);
	    menu_bar.add(aluguelMenu);
	    
	    JMenuItem itemNovoAluguel = new JMenuItem("Novo aluguel");
	    itemNovoAluguel.addActionListener(new SelecaoNovoAluguelAL());
	    aluguelMenu.add(itemNovoAluguel);
	    
	    JMenuItem itemRegistrarDevolucao = new JMenuItem("Registrar devolucao");
	    itemRegistrarDevolucao.addActionListener(new SelecaoRegistrarDevolucaoAL());
	    aluguelMenu.add(itemRegistrarDevolucao);

	    this.setJMenuBar(menu_bar);
	}
}

