package vista;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controlador.App;

public class PanelJugador extends JPanel{
	
	public PanelTablero tablero;
	public JPanel estadisticas;
	
	private JLabel label1;
	private JLabel puntaje;
	
	public PanelJugador(){
		this.setBounds(0, 0, 600, 450);
		this.setLayout(null);
		this.setBackground(Color.black);
		tablero = new PanelTablero();
		estadisticas = new JPanel();
		tablero.setBounds(5, 5, 400, 400);
		estadisticas.setBounds(410, 5, 170, 400);
		estadisticas.setBorder(BorderFactory.createLineBorder(Color.green));
		estadisticas.setBackground(Color.BLACK);
		estadisticas.setLayout(null);
		
		label1 = new JLabel();
		label1.setBounds(15, 15, 100, 10);
		label1.setText("Jugador 1");
		label1.setForeground(Color.green);
		
		puntaje = new JLabel();
		puntaje.setBounds(15, 40, 100, 10);
		puntaje.setForeground(Color.green);
	//	if(App.getApp()!=null)
		puntaje.setText("0");
		estadisticas.add(label1);
		estadisticas.add(puntaje);
		this.add(tablero);
		this.add(estadisticas);
	}
	
	public void setPuntaje(String s){
		puntaje.setText(s);
	}
}
