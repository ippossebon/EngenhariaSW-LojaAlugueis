package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class RelatoriosFrame extends JFrame {

	private JPanel contentPane;

	public RelatoriosFrame() {
		setTitle("Relatórios");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 504, 432);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setBounds(20, 25, 72, 16);
		contentPane.add(lblCategoria);
		
		JComboBox categorias_combo_box = new JComboBox();
		categorias_combo_box.setBounds(104, 21, 130, 27);
		contentPane.add(categorias_combo_box);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setBounds(276, 25, 40, 16);
		contentPane.add(lblData);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(328, 21, 130, 27);
		contentPane.add(comboBox);
		
		JScrollPane resultados_scroll_pane = new JScrollPane();
		resultados_scroll_pane.setBounds(20, 394, 438, -306);
		contentPane.add(resultados_scroll_pane);
	}
}
