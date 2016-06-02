package modelo;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;


public class Tablero implements KeyListener {

	private final static int TAM = 25;
	private int tablero[][];
	private Snake jugador1;
	private Snake jugador2;
	private Point comida;

	public Tablero(Snake jugador1) {
		this.jugador1 = jugador1;
		this.jugador2 = null;
		tablero = new int[TAM][TAM];
		limpiar_tablero();
		actualizar_tablero();
	}

	public Tablero(Snake jugador1, Snake jugador2) {
		this.jugador1 = jugador1;
		this.jugador2 = jugador2;
		tablero = new int[TAM][TAM];
		limpiar_tablero();
		actualizar_tablero();
	}

	public void limpiar_tablero() {
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero.length; j++) {
				tablero[i][j] = 0;
			}
		}
	}

	public void actualizar_tablero() {
		if (jugador2 == null) {
			tablero[jugador1.getCabeza().x][jugador1.getCabeza().y] = 1;
			for (Point p : jugador1.getCola())
				tablero[p.x][p.y] = 1;
		} else {
			tablero[jugador1.getCabeza().x][jugador1.getCabeza().y] = 1;
			for (Point p : jugador1.getCola())
				tablero[p.x][p.y] = 1;
			tablero[jugador2.getCabeza().x][jugador2.getCabeza().y] = 2;
			for (Point p : jugador2.getCola())
				tablero[p.x][p.y] = 2;
		}
		if (comida != null)
			tablero[comida.x][comida.y] = 3;
		else
			ponerComida();
	}

	public void ponerComida() {
		Random rand = new Random();
		int x;
		int y;
		if (comida == null) {
			x = rand.nextInt(TAM);
			y = rand.nextInt(TAM);
			if (tablero[x][y] == 0)
				comida = new Point(x, y);
		}
	}
	
	public void comer(){
		if(jugador2==null){
			if(jugador1.getCabeza().equals(comida)){
				comida = null;
				jugador1.setCola();	
				jugador1.aumentarPuntaje();
				System.out.println(jugador1.getPuntaje());
			}
		}else{
			if(jugador1.getCabeza().equals(comida)){
				comida = null;
				jugador1.setCola();
			}
			if(jugador2.getCabeza().equals(comida)){
				comida = null;
				jugador2.setCola();
			}
		}
		jugador1.mover();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (jugador2 == null) 
			jugador1.keyPressed(e);			
		else {
			jugador1.keyPressed(e);
			jugador2.keyPressed(e);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void imprimirTablero() {
		for (int j = 0; j < tablero.length; j++) {
			for (int i = 0; i < tablero.length; i++) {
				System.out.print(tablero[i][j]);
			}
			System.out.println();
		}
	}
	
	public int[][] getTablero() {
		return tablero;
	}
	/*

	public static void main(String[] args) {
		Snake jugador1 = new Snake(new Point(4, 4), 1);

		Tablero tab = new Tablero(jugador1);
		tab.imprimirTablero();
		Scanner s = new Scanner(System.in);
		int jugada = 0;
		while (true) {
			jugada = s.nextInt();
			tab.jugador1.mover(jugada);
			tab.comer();
			tab.limpiar_tablero();  
			tab.actualizar_tablero();
			tab.imprimirTablero();

		}
	}*/
}
