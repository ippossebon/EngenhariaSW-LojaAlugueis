package view;

import javax.swing.text.MaskFormatter;

public class Operacoes {

	public Operacoes(){
		
	}
	
	public static MaskFormatter aplicaMascara(String Mascara){
	    MaskFormatter F_Mascara = new MaskFormatter();
	    try{
	        F_Mascara.setMask(Mascara); // Atribui a mascara
	        F_Mascara.setPlaceholderCharacter(' '); // Caractere para preencimento 
	    }
	    catch (Exception excecao) {
	    excecao.printStackTrace();
	    } 
	    return F_Mascara;
	}
}
