package view;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

public class MensagemFrame extends JFrame {

	private JPanel contentPane;

	public MensagemFrame(String mensagem) {
		setTitle("Mensagem");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 340, 183);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeFrame();
			}
		});
		btnOk.setBounds(186, 118, 117, 29);
		contentPane.add(btnOk);
		
		JTextPane mensagemTextPane = new JTextPane();
		mensagemTextPane.setBackground(SystemColor.window);
		mensagemTextPane.setBounds(62, 40, 241, 66);
		mensagemTextPane.setText(mensagem);
		contentPane.add(mensagemTextPane);
	}
	
	private void closeFrame(){
		super.dispose();
	}
}
