package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class FecharFrameAL implements ActionListener{

	private JFrame frame;
	
	public FecharFrameAL(JFrame f){
		this.frame = f;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.frame.dispose();
	}

}
