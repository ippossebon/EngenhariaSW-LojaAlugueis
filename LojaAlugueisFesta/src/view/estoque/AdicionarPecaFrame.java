package view.estoque;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import view.Operacoes;

public class AdicionarPecaFrame extends JFrame {

	private JPanel contentPane;
	private JTextField outro_text_field;

	public AdicionarPecaFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 508, 206);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(17, 20, 47, 16);
		contentPane.add(lblTipo);
		
		JLabel lblOutro = new JLabel("Outro:");
		lblOutro.setEnabled(false);
		lblOutro.setBounds(244, 20, 61, 16);
		contentPane.add(lblOutro);
		
		outro_text_field = new JTextField();
		outro_text_field.setEditable(false);
		outro_text_field.setBounds(292, 14, 205, 28);
		contentPane.add(outro_text_field);
		outro_text_field.setColumns(10);
		
		JComboBox<String> tipo_combobox = new JComboBox<String>();
		tipo_combobox.addItem("Gravata normal");
		tipo_combobox.addItem("Gravata borboleta");
		tipo_combobox.addItem("Terno com corte italiano");
		tipo_combobox.addItem("Terno com corte inglês");
		tipo_combobox.addItem("Terno com corte tradicional");
		tipo_combobox.addItem("Fraque");
		tipo_combobox.addItem("Calça social básica");
		tipo_combobox.addItem("Calça social larga");
		tipo_combobox.addItem("Calça social em microfibra");
		tipo_combobox.addItem("Camisa social de colarinha com pontas abertas");
		tipo_combobox.addItem("Camisa social de colarinha com presilha");
		tipo_combobox.addItem("Camisa social de colarinha arredondado");
		tipo_combobox.addItem("Vestido longo");
		tipo_combobox.addItem("Vestido longo bordado");
		tipo_combobox.addItem("Vestido curto");
		tipo_combobox.addItem("Vestido curto bordado");
		tipo_combobox.addItem("Sapato feminino");
		tipo_combobox.addItem("Sapato masculino");
		tipo_combobox.addItem("Outro");
		tipo_combobox.setBounds(63, 16, 169, 27);
		tipo_combobox.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if (tipo_combobox.getSelectedItem().toString().equals("Outro")){
					lblOutro.setEnabled(true);
					outro_text_field.setEditable(true);
				}
			}
		});
		contentPane.add(tipo_combobox);
		
		JLabel lblTamanho = new JLabel("Tamanho:");
		lblTamanho.setBounds(17, 62, 83, 16);
		contentPane.add(lblTamanho);
		
		JFormattedTextField tamanho_text_field = new JFormattedTextField(Operacoes.aplicaMascara("##"));
		tamanho_text_field.setBounds(112, 56, 120, 28);
		contentPane.add(tamanho_text_field);
		
		JLabel lblValorr = new JLabel("Valor (R$):");
		lblValorr.setBounds(17, 103, 83, 16);
		contentPane.add(lblValorr);
		
		JFormattedTextField valor_text_field = new JFormattedTextField(Operacoes.aplicaMascara("###.##"));
		valor_text_field.setBounds(112, 97, 120, 28);
		contentPane.add(valor_text_field);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(381, 149, 117, 29);
		contentPane.add(btnOk);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(17, 149, 117, 29);
		contentPane.add(btnCancelar);
	}
}
