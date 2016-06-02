package vista;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelDosJugadores extends JPanel{
	
	private JLabel test;
	
	public PanelDosJugadores(){
		setBounds(0, 0, 600, 450);
		this.setBackground(Color.black);
		test = new JLabel("PanelJugador");
		test.setForeground(Color.WHITE);
		this.add(test);
	}

}
