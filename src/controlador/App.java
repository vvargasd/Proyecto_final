package controlador;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.Timer;

import modelo.Snake;
import modelo.Tablero;
import vista.Ventana;

public class App implements ActionListener{
	
	private Tablero tablero;
	private Snake jugador1;
	private Snake jugador2;
	private static App app = new App();
	private Timer time;
	private Ventana ventana;
	private boolean control = false;
	
	public App(){
		
	}	
	
	public static App getApp() {
		return app;
	}

	public Snake getJugador1() {
		return jugador1;
	}

	public void setJugador1(Snake jugador1) {
		this.jugador1 = jugador1;
	}

	public Snake getJugador2() {
		return jugador2;
	}

	public void setJugador2(Snake jugador2) {
		this.jugador2 = jugador2;
	}

	public Tablero getTablero() {
		return tablero;
	}
	
	public void ejecutar(){
		
		jugador1 = new Snake(new Point(4, 4), 1);
		tablero = new Tablero(jugador1);
		ventana = new Ventana();
		time = new Timer(100, this);
		time.start();
	}


	public static void main(String[] args) {
		App.app.ejecutar();
	}

	
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(control==true)
		App.app.tablero.keyPressed(e);
		control = false;
	}
	
	public int getPuntaje(){
		int puntaje = App.getApp().getJugador1().getPuntaje();
		return puntaje;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		control = true;
		if(App.app.jugador2 == null){
			tablero.comer();
			tablero.limpiar_tablero();
			tablero.actualizar_tablero();
			ventana.menu.uno.setPuntaje(""+getPuntaje());
			ventana.menu.uno.tablero.repaint();
			ventana.menu.uno.repaint();
		}
		
	}

}
