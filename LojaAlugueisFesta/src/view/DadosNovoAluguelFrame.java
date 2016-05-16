package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class DadosNovoAluguelFrame extends JFrame {

	private JPanel contentPane;

	public DadosNovoAluguelFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 351, 334);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCPFCliente = new JLabel("CPF cliente:");
		lblCPFCliente.setBounds(6, 12, 81, 16);
		contentPane.add(lblCPFCliente);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(118, 6, 219, 28);
		contentPane.add(formattedTextField);
		
		JLabel lblDataDeIncio = new JLabel("Data de início:");
		lblDataDeIncio.setBounds(6, 52, 98, 16);
		contentPane.add(lblDataDeIncio);
		
		JFormattedTextField formattedTextField_1 = new JFormattedTextField();
		formattedTextField_1.setBounds(118, 46, 219, 28);
		contentPane.add(formattedTextField_1);
		
		JFormattedTextField formattedTextField_2 = new JFormattedTextField();
		formattedTextField_2.setBounds(118, 86, 219, 28);
		contentPane.add(formattedTextField_2);
		
		JLabel lblDataDeFim = new JLabel("Data de fim:");
		lblDataDeFim.setBounds(6, 92, 81, 16);
		contentPane.add(lblDataDeFim);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 140, 331, 117);
		contentPane.add(scrollPane);
		
		JLabel lblItens = new JLabel("Itens:");
		lblItens.setBounds(6, 120, 61, 16);
		contentPane.add(lblItens);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(6, 269, 117, 29);
		contentPane.add(btnOk);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(228, 269, 117, 29);
		contentPane.add(btnCancelar);
	}

}
