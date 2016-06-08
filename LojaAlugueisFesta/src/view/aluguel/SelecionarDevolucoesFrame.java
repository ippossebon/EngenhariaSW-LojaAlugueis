package view.aluguel;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import model.Aluguel;
import controller.FecharFrameAL;

public class SelecionarDevolucoesFrame extends JFrame {

	private JPanel contentPane;
	private ArrayList<Aluguel> alugueis_cliente;

	public SelecionarDevolucoesFrame(ArrayList<Aluguel> alugueis) {
		setTitle("Selecionar aluguel para devolução");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 448, 342);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAlugueisEmAndamento = new JLabel("Alugueis em andamento:");
		lblAlugueisEmAndamento.setBounds(18, 17, 171, 16);
		contentPane.add(lblAlugueisEmAndamento);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(18, 45, 406, 209);
		contentPane.add(scrollPane);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(307, 266, 117, 29);
		contentPane.add(btnOk);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(18, 266, 117, 29);
		btnCancelar.addActionListener(new FecharFrameAL(this));
		contentPane.add(btnCancelar);
	}
}
