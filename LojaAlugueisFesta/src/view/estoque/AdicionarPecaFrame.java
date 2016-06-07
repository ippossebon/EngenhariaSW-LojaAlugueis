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
import controller.actionlisteners.estoque.BotaoAdicionarPecaAL;

public class AdicionarPecaFrame extends JFrame {

	private JPanel contentPane;
	private JTextField outro_text_field;
	private JComboBox<String> tipo_combobox;
	private JFormattedTextField tamanho_text_field;
	public JTextField getOutro_text_field() {
		return outro_text_field;
	}

	public void setOutro_text_field(JTextField outro_text_field) {
		this.outro_text_field = outro_text_field;
	}

	public JComboBox<String> getTipo_combobox() {
		return tipo_combobox;
	}

	public void setTipo_combobox(JComboBox<String> tipo_combobox) {
		this.tipo_combobox = tipo_combobox;
	}

	public JFormattedTextField getTamanho_text_field() {
		return tamanho_text_field;
	}

	public void setTamanho_text_field(JFormattedTextField tamanho_text_field) {
		this.tamanho_text_field = tamanho_text_field;
	}

	public JFormattedTextField getValor_text_field() {
		return valor_text_field;
	}

	public void setValor_text_field(JFormattedTextField valor_text_field) {
		this.valor_text_field = valor_text_field;
	}

	private JFormattedTextField valor_text_field;

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
		
		tipo_combobox = new JComboBox<String>();
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
		
		tamanho_text_field = new JFormattedTextField(Operacoes.aplicaMascara("##"));
		tamanho_text_field.setBounds(112, 56, 120, 28);
		contentPane.add(tamanho_text_field);
		
		JLabel lblValorr = new JLabel("Valor (R$):");
		lblValorr.setBounds(17, 103, 83, 16);
		contentPane.add(lblValorr);
		
		valor_text_field = new JFormattedTextField(Operacoes.aplicaMascara("###.##"));
		valor_text_field.setBounds(112, 97, 120, 28);
		contentPane.add(valor_text_field);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(381, 149, 117, 29);
		btnOk.addActionListener(new BotaoAdicionarPecaAL(this));
		contentPane.add(btnOk);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(17, 149, 117, 29);
		btnCancelar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				dispose();
			}
		});
		contentPane.add(btnCancelar);
	}
}
