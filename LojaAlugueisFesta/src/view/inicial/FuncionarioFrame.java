package view.inicial;

import java.awt.SystemColor;
import java.awt.event.KeyEvent;
import java.util.Observable;
import java.util.Observer;

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

import view.DadosClienteFrame;
import view.DadosPecaFrame;
import controller.actionlisteners.aluguel.SelecaoNovoAluguelAL;
import controller.actionlisteners.aluguel.SelecaoRegistrarDevolucaoAL;
import controller.actionlisteners.cadastro.SelecaoCadastrarClienteAL;
import controller.actionlisteners.cadastro.SelecaoCadastrarFuncionarioAL;
import controller.actionlisteners.pesquisa.BotaoPesquisarAL;
import controller.actionlisteners.pesquisa.SetFiltrosPecaAL;
import controller.actionlisteners.pesquisa.SetFiltrosPessoaAL;

public class FuncionarioFrame extends JFrame implements Observer{

	private JPanel contentPane;
	private JTextField pesquisa_text_field;
	private JTable resultados_table;
	private JMenuBar menu_bar;
	private JRadioButton rdbtnNome;
	private JRadioButton rdbtnCpf;
	private JRadioButton rdbtnTodas;
	private JRadioButton rdbtnDisponiveis;
	private JRadioButton rdbtnAlugadas;
	private JRadioButton rdbtnPeca;
	private JRadioButton rdbtnCliente;
	private JRadioButton rdbtnFuncionario;
	private JScrollPane resultados_scroll_pane;

	public FuncionarioFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 664, 645);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(null);
		
		this.pesquisa_text_field = new JTextField();
		this.pesquisa_text_field.setBounds(110, 29, 400, 28);
		contentPane.add(this.pesquisa_text_field);
		this.pesquisa_text_field.setColumns(10);
		
		JLabel lblPesquisa = new JLabel("Pesquisa:");
		lblPesquisa.setBounds(36, 35, 61, 16);
		this.contentPane.add(lblPesquisa);
		
		JLabel lblResultados = new JLabel("Resultados");
		lblResultados.setBounds(36, 116, 73, 16);
		this.contentPane.add(lblResultados);
		
		JLabel lblFiltrarPor = new JLabel("Filtrar por:");
		lblFiltrarPor.setBounds(36, 144, 84, 16);
		this.contentPane.add(lblFiltrarPor);
		
		this.rdbtnNome = new JRadioButton("Nome");
		this.rdbtnNome.setToolTipText("Pessoa");
		this.rdbtnNome.setBounds(110, 196, 84, 23);
		this.contentPane.add(this.rdbtnNome);
		
		this.rdbtnCpf = new JRadioButton("CPF");
		this.rdbtnCpf.setToolTipText("Pessoa");
		this.rdbtnCpf.setBounds(217, 196, 73, 23);
		this.contentPane.add(this.rdbtnCpf);
		
		this.rdbtnTodas = new JRadioButton("Todas");
		this.rdbtnTodas.setToolTipText("Peça");
		this.rdbtnTodas.setBounds(110, 161, 90, 23);
		this.contentPane.add(this.rdbtnTodas);
		
		this.rdbtnDisponiveis = new JRadioButton("Disponíveis");
		this.rdbtnDisponiveis.setToolTipText("Peça");
		this.rdbtnDisponiveis.setBounds(217, 161, 121, 23);
		this.contentPane.add(this.rdbtnDisponiveis);
		
		this.rdbtnAlugadas = new JRadioButton("Alugadas");
		this.rdbtnAlugadas.setToolTipText("Peça");
		this.rdbtnAlugadas.setBounds(348, 161, 95, 23);
		this.contentPane.add(this.rdbtnAlugadas);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(6, 104, 682, 12);
		contentPane.add(separator);
		
		this.rdbtnPeca = new JRadioButton("Peça");
		this.rdbtnPeca.setBounds(109, 69, 73, 23);
		this.contentPane.add(this.rdbtnPeca);
		
		this.rdbtnCliente = new JRadioButton("Cliente");
		this.rdbtnCliente.setBounds(217, 69, 90, 23);
		this.contentPane.add(this.rdbtnCliente);
		
		this.rdbtnFuncionario = new JRadioButton("Funcionário");
		this.rdbtnFuncionario.setBounds(348, 69, 141, 23);
		this.contentPane.add(this.rdbtnFuncionario);
		
		ButtonGroup button_group_pesquisa = new ButtonGroup();
		button_group_pesquisa.add(this.rdbtnPeca);
		button_group_pesquisa.add(this.rdbtnCliente);
		button_group_pesquisa.add(this.rdbtnFuncionario);
		
		ButtonGroup bg_filtro_pessoa = new ButtonGroup();
		bg_filtro_pessoa.add(this.rdbtnCpf);
		bg_filtro_pessoa.add(this.rdbtnNome);
		
		ButtonGroup bg_filtro_peca = new ButtonGroup();
		bg_filtro_peca.add(this.rdbtnAlugadas);
		bg_filtro_peca.add(this.rdbtnDisponiveis);
		bg_filtro_peca.add(this.rdbtnTodas);
		
		rdbtnPeca.addActionListener(new SetFiltrosPecaAL(rdbtnTodas, rdbtnDisponiveis, rdbtnAlugadas, rdbtnNome, rdbtnCpf));
		rdbtnCliente.addActionListener(new SetFiltrosPessoaAL(rdbtnTodas, rdbtnDisponiveis, rdbtnAlugadas, rdbtnNome, rdbtnCpf));
		rdbtnFuncionario.addActionListener(new SetFiltrosPessoaAL(rdbtnTodas, rdbtnDisponiveis, rdbtnAlugadas, rdbtnNome, rdbtnCpf));
		
		this.resultados_table = new JTable();
		this.resultados_table.setBackground(UIManager.getColor("InternalFrame.inactiveTitleBackground"));
		this.resultados_table.setBorder(new LineBorder(UIManager.getColor("Button.shadow")));
		this.resultados_table.setBounds(36, 231, 598, 330);
		this.resultados_table.addMouseListener(new java.awt.event.MouseAdapter() {
		    @Override
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		        int linha = resultados_table.rowAtPoint(evt.getPoint());
		        int coluna = resultados_table.columnAtPoint(evt.getPoint());
		        if (linha >= 0 && coluna >= 0) {
		        	
		        	// Verifica se a primeira coluna corresponde ao código de uma peça.
		        	if(resultados_table.getValueAt(linha, 0) instanceof Integer){
		        		DadosPecaFrame frame = new DadosPecaFrame(resultados_table.getValueAt(linha, 0).toString(), resultados_table.getValueAt(linha, 1).toString(), 
		        													resultados_table.getValueAt(linha, 2).toString(), resultados_table.getValueAt(linha, 4).toString(),
		        													resultados_table.getValueAt(linha, 3).toString(), resultados_table.getValueAt(linha, 5).toString());
		        		frame.setVisible(true);
		        		
		        	}
		        	/* Informações cliente */
		        	else if(resultados_table.getModel().getColumnName(5).equals("Status")){
		        		DadosClienteFrame frame = new DadosClienteFrame(resultados_table.getValueAt(linha, 0).toString(), resultados_table.getValueAt(linha, 1).toString(),
		        													resultados_table.getValueAt(linha, 2).toString(), resultados_table.getValueAt(linha, 3).toString(),
		        													resultados_table.getValueAt(linha, 4).toString(), resultados_table.getValueAt(linha, 5).toString());
		        		frame.setVisible(true);
		        	}
		        	/* Informações funcionário */
		        	else{
		        		DadosClienteFrame frame = new DadosClienteFrame(resultados_table.getValueAt(linha, 0).toString(), resultados_table.getValueAt(linha, 1).toString(),
																		resultados_table.getValueAt(linha, 2).toString(), resultados_table.getValueAt(linha, 3).toString(),
																		resultados_table.getValueAt(linha, 4).toString(), resultados_table.getValueAt(linha, 5).toString());
frame.setVisible(true);
		        	}
		        	
		        	
		        	
		        	
		        	// if funcionario
		        }
		    }
		});
		
		resultados_scroll_pane = new JScrollPane(resultados_table);
		resultados_scroll_pane.setBounds(36, 231, 598, 330);
		contentPane.add(resultados_scroll_pane);
		
		JButton btnNewButton = new JButton("Pesquisar");
		btnNewButton.addActionListener(new BotaoPesquisarAL(this));
		btnNewButton.setBounds(522, 30, 112, 29);
		contentPane.add(btnNewButton);
		
		this.menu_bar = new JMenuBar();
		this.menu_bar.setBorderPainted(false);
		this.menu_bar.setBackground(SystemColor.windowBorder);
		this.menu_bar.setBounds(0, 0, 132, 22);
		
	    /* Menu cadastro - Atalho: C */
	    JMenu cadastroMenu = new JMenu("Cadastro");
	    cadastroMenu.setMnemonic(KeyEvent.VK_C);
	    menu_bar.add(cadastroMenu);

	    JMenuItem itemCadastrarCliente = new JMenuItem("Cadastrar cliente...");
	    itemCadastrarCliente.addActionListener(new SelecaoCadastrarClienteAL());
	    cadastroMenu.add(itemCadastrarCliente);
	    
	    JMenuItem itemCadastrarFuncionario = new JMenuItem("Cadastrar funcionário...");
	    itemCadastrarFuncionario.addActionListener(new SelecaoCadastrarFuncionarioAL());
	    cadastroMenu.add(itemCadastrarFuncionario);
	    
	    /* Menu aluguel - Atalho: A */
	    JMenu aluguelMenu = new JMenu("Aluguel");
	    aluguelMenu.setMnemonic(KeyEvent.VK_A);
	    menu_bar.add(aluguelMenu);
	    
	    JMenuItem itemNovoAluguel = new JMenuItem("Novo aluguel...");
	    itemNovoAluguel.addActionListener(new SelecaoNovoAluguelAL());
	    aluguelMenu.add(itemNovoAluguel);
	    
	    JMenuItem itemRegistrarDevolucao = new JMenuItem("Registrar devolucao...");
	    itemRegistrarDevolucao.addActionListener(new SelecaoRegistrarDevolucaoAL());
	    aluguelMenu.add(itemRegistrarDevolucao);

	    this.setJMenuBar(menu_bar);
	}

	public JRadioButton getRdbtnNome() {
		return rdbtnNome;
	}

	public void setRdbtnNome(JRadioButton rdbtnNome) {
		this.rdbtnNome = rdbtnNome;
	}

	public JRadioButton getRdbtnCpf() {
		return rdbtnCpf;
	}

	public void setRdbtnCpf(JRadioButton rdbtnCpf) {
		this.rdbtnCpf = rdbtnCpf;
	}

	public JRadioButton getRdbtnTodas() {
		return rdbtnTodas;
	}

	public void setRdbtnTodas(JRadioButton rdbtnTodas) {
		this.rdbtnTodas = rdbtnTodas;
	}

	public JRadioButton getRdbtnDisponiveis() {
		return rdbtnDisponiveis;
	}

	public void setRdbtnDisponiveis(JRadioButton rdbtnDisponiveis) {
		this.rdbtnDisponiveis = rdbtnDisponiveis;
	}

	public JRadioButton getRdbtnAlugadas() {
		return rdbtnAlugadas;
	}

	public void setRdbtnAlugadas(JRadioButton rdbtnAlugadas) {
		this.rdbtnAlugadas = rdbtnAlugadas;
	}

	public JRadioButton getRdbtnPeca() {
		return rdbtnPeca;
	}

	public void setRdbtnPeca(JRadioButton rdbtnPeca) {
		this.rdbtnPeca = rdbtnPeca;
	}

	public JRadioButton getRdbtnCliente() {
		return rdbtnCliente;
	}

	public void setRdbtnCliente(JRadioButton rdbtnCliente) {
		this.rdbtnCliente = rdbtnCliente;
	}

	public JRadioButton getRdbtnFuncionario() {
		return rdbtnFuncionario;
	}

	public void setRdbtnFuncionario(JRadioButton rdbtnFuncionario) {
		this.rdbtnFuncionario = rdbtnFuncionario;
	}

	public JTextField getPesquisa_text_field() {
		return pesquisa_text_field;
	}

	public void setPesquisa_text_field(JTextField pesquisa_text_field) {
		this.pesquisa_text_field = pesquisa_text_field;
	}

	public JTable getResultados_table() {
		return resultados_table;
	}

	public void setResultados_table(JTable resultados_table) {
		this.resultados_table = resultados_table;
	}

	public JMenuBar getMenu_bar() {
		return menu_bar;
	}

	public void setMenu_bar(JMenuBar menu_bar) {
		this.menu_bar = menu_bar;
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
		System.out.println(" >>>>> Update FuncionarioFrame");
		resultados_table.repaint();
		resultados_scroll_pane.repaint();
	}
}

