package view;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import controller.actionlisteners.relatorios.BotaoGerarRelatorioAL;

public class RelatoriosFrame extends JFrame implements Observer{

	private JPanel contentPane;
	private JTable resultados_table;
	private JComboBox<String> filtro_combo_box;
	private JFormattedTextField data_inicio_text_field;
	private JFormattedTextField data_fim_text_field;

	public JTable getResultados_table() {
		return resultados_table;
	}

	public void setResultados_table(JTable resultados_table) {
		this.resultados_table = resultados_table;
	}

	public JComboBox<String> getFiltro_combo_box() {
		return filtro_combo_box;
	}

	public void setFiltro_combo_box(JComboBox<String> filtro_combo_box) {
		this.filtro_combo_box = filtro_combo_box;
	}

	public JFormattedTextField getData_inicio_text_field() {
		return data_inicio_text_field;
	}

	public void setData_inicio_text_field(JFormattedTextField data_inicio_text_field) {
		this.data_inicio_text_field = data_inicio_text_field;
	}

	public JFormattedTextField getData_fim_text_field() {
		return data_fim_text_field;
	}

	public void setData_fim_text_field(JFormattedTextField data_fim_text_field) {
		this.data_fim_text_field = data_fim_text_field;
	}

	public RelatoriosFrame() {
		setTitle("Relatórios");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 610, 469);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFiltro = new JLabel("Filtrar por:");
		lblFiltro.setBounds(20, 25, 72, 16);
		contentPane.add(lblFiltro);
		
		filtro_combo_box = new JComboBox<String>();
		filtro_combo_box.setBounds(104, 21, 130, 27);
		contentPane.add(filtro_combo_box);
		filtro_combo_box.addItem("Alugueis efetuados");
		filtro_combo_box.addItem("Quantidade de alugueis");
		filtro_combo_box.addItem("Alugueis por peça");
		filtro_combo_box.addItem("Clientes bloqueados");
		filtro_combo_box.addItem("Lucro");
		
		JLabel lblPeriodo = new JLabel("Período:");
		lblPeriodo.setBounds(20, 72, 62, 16);
		contentPane.add(lblPeriodo);
		
		this.resultados_table = new JTable();
		JScrollPane resultados_scroll_pane = new JScrollPane(this.resultados_table);
		resultados_scroll_pane.setBounds(20, 394, 568, -280);
		contentPane.add(resultados_scroll_pane);
		
		data_inicio_text_field = new JFormattedTextField(Operacoes.aplicaMascara("##/##/####"));
		data_inicio_text_field.setBounds(104, 66, 102, 28);
		contentPane.add(data_inicio_text_field);
		
		JLabel lblAt = new JLabel("até:");
		lblAt.setBounds(227, 72, 30, 16);
		contentPane.add(lblAt);
		
		data_fim_text_field = new JFormattedTextField(Operacoes.aplicaMascara("##/##/####"));
		data_fim_text_field.setBounds(269, 66, 102, 28);
		contentPane.add(data_fim_text_field);
		
		JButton btnGerar = new JButton("Gerar relatório");
		btnGerar.setBounds(481, 411, 117, 29);
		btnGerar.addActionListener(new BotaoGerarRelatorioAL(this));
		contentPane.add(btnGerar);
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		resultados_table.repaint();
	}
}
