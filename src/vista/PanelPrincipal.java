package vista;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelPrincipal extends JPanel implements ActionListener{
	
	private final static int ANCHO = 150;
	private final static int ALTO = 40;
	private PanelDosJugadores dos;
	public PanelJugador uno;
	private JPanel menu;
	private JButton un_jugador;
	private JButton dos_jugadores;
	private JButton salir;	
	private JLabel snake;
	private ImageIcon imagen;
	
	
	public PanelPrincipal(){
		
		this.setLayout(null);
		menu = new JPanel();
		uno = new PanelJugador();
		dos = new PanelDosJugadores();
		uno.setVisible(false);
		dos.setVisible(false);
		
		menu.setBounds(0, 0, 600, 450);
		
		imagen = new ImageIcon("snake.png");
		snake = new JLabel();
		snake.setIcon(imagen);
		un_jugador = new JButton("Un jugador");
		dos_jugadores = new JButton("Dos jugadores");
		salir = new JButton("salir");
		menu.setLayout(null);
		
		snake.setBounds(60, 20, 486, 136);
		un_jugador.setBounds(menu.getWidth()/2 - ANCHO/2, 200, ANCHO, ALTO);
		dos_jugadores.setBounds(menu.getWidth()/2 - ANCHO/2, 250, ANCHO, ALTO);
		salir.setBounds(menu.getWidth()/2 - ANCHO/2, 300, ANCHO, ALTO);
		
		
		un_jugador.setBackground(Color.green);
		dos_jugadores.setBackground(Color.green);
		salir.setBackground(Color.green);
		
		un_jugador.setActionCommand("uno");
		un_jugador.addActionListener(this);
		
		dos_jugadores.setActionCommand("dos");
		dos_jugadores.addActionListener(this);
		
		salir.setActionCommand("tres");
		salir.addActionListener(this);
		
		un_jugador.setFocusable(false);
		dos_jugadores.setFocusable(false);
		salir.setFocusable(false);
		
		menu.setBackground(Color.black);
		
		menu.add(snake);
		menu.add(un_jugador);
		menu.add(dos_jugadores);
		menu.add(salir);
		
		this.add(menu);
		this.add(uno);
		this.add(dos);
	}	


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("uno")){			
			menu.setVisible(false);
			uno.setVisible(true);
		}else if(e.getActionCommand().equals("dos")){
			menu.setVisible(false);
			dos.setVisible(true);
		}else if(e.getActionCommand().equals("tres"))
			System.exit(0);
		
	}
	

}
