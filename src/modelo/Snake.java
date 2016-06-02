package modelo;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Snake {

	private Point cabeza;
	private ArrayList<Point> cola;
	private int direccion;
	private int jugador;
	private int tam_cola = 2;
	private int puntaje = 0;
	private final static int ARRIBA = 1;
	private final static int ABAJO = 3;
	private final static int IZQUIERDA = 4;
	private final static int DERECHA = 2;

	public Snake(Point cabeza, int jugador) {
		cola = new ArrayList<Point>();
		this.jugador = jugador;
		this.cabeza = cabeza;
		if (jugador == 1) {
			cola.add(new Point(cabeza.x - 2, cabeza.y));
			cola.add(new Point(cabeza.x - 1, cabeza.y));
		} else {
			cola.add(new Point(cabeza.x + 2, cabeza.y));
			cola.add(new Point(cabeza.x + 1, cabeza.y));
		}
	}

	public void mover() {

		switch (direccion) {
		case ARRIBA:
			if (casillaLibre(cabeza.x, cabeza.y - 1)) {
				if (cabeza.y > 0) {
					cola.add(new Point(cabeza));
					cabeza.y -= 1;
				} else {
					cola.add(new Point(cabeza));
					cabeza.y += 24;
				}
			} else {
				System.exit(0);
			}
			break;
		case 2:
			if (casillaLibre(cabeza.x + 1, cabeza.y)) {
				if (cabeza.x < 24) {
					cola.add(new Point(cabeza));
					cabeza.x += 1;
				} else {
					cola.add(new Point(cabeza));
					cabeza.x -= 24;
				}
			} else {
				System.exit(0);
			}
			break;
		case 3:
			if (casillaLibre(cabeza.x, cabeza.y + 1)) {
				if (cabeza.y < 24) {
					cola.add(new Point(cabeza));
					cabeza.y += 1;
				} else {
					cola.add(new Point(cabeza));
					cabeza.y -= 24;
				}
			} else {
				System.exit(0);
			}
			break;
		case 4:
			if (casillaLibre(cabeza.x - 1, cabeza.y)) {
				if (cabeza.x > 0) {
					cola.add(new Point(cabeza));
					cabeza.x -= 1;
				} else {
					cola.add(new Point(cabeza));
					cabeza.x += 24;
				}

			} else {
				System.exit(0);
			}
			break;
		}
		if (cola.size() > tam_cola) {
			cola.remove(0);
		}
	}

	private boolean casillaLibre(int x, int y) {
		for (Point point : cola) {
			if (point.equals(new Point(x, y))) {
				return false;
			}
		}
		return true;
	}

	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int key = e.getKeyCode();
		if (jugador == 1) {
			switch (key) {
			case KeyEvent.VK_UP:
				if (direccion != ABAJO)
					direccion = ARRIBA;
				break;
			case KeyEvent.VK_RIGHT:
				if (direccion != IZQUIERDA)
					direccion = DERECHA;
				break;
			case KeyEvent.VK_DOWN:
				if (direccion != ARRIBA)
					direccion = ABAJO;
				break;
			case KeyEvent.VK_LEFT:
				if (direccion != DERECHA)
					direccion = IZQUIERDA;
				break;
			}
		} else {
			switch (key) {
			case KeyEvent.VK_W:
				if (direccion != ABAJO)
					direccion = ARRIBA;
				break;
			case KeyEvent.VK_D:
				if (direccion != IZQUIERDA)
					direccion = DERECHA;
				break;
			case KeyEvent.VK_S:
				if (direccion != ARRIBA)
					direccion = ABAJO;
				break;
			case KeyEvent.VK_A:
				if (direccion != DERECHA)
					direccion = IZQUIERDA;
				break;
			}
		}
	}

	public Point getCabeza() {
		return cabeza;
	}

	public ArrayList<Point> getCola() {
		return cola;
	}
	
	public void setCola(){
		tam_cola++;
	}
	
	public int getPuntaje() {
		return puntaje;
	}

	public void aumentarPuntaje(){
		puntaje+=10;
	}

	public void mover(int dir) {
		direccion = dir;
		switch (direccion) {
		case ARRIBA:
			if (casillaLibre(cabeza.x, cabeza.y - 1)) {
				if (cabeza.y > 0) {
					cola.add(new Point(cabeza));
					cabeza.y -= 1;
				} else {
					cola.add(new Point(cabeza));
					cabeza.y += 24;
				}
			} else {
				System.exit(0);
			}
			break;
		case DERECHA:
			if (casillaLibre(cabeza.x + 1, cabeza.y)) {
				if (cabeza.x < 24) {
					cola.add(new Point(cabeza));
					cabeza.x += 1;
				} else {
					cola.add(new Point(cabeza));
					cabeza.x -= 24;
				}
			} else {
				System.exit(0);
			}
			break;
		case ABAJO:
			if (casillaLibre(cabeza.x, cabeza.y + 1)) {
				if (cabeza.y < 24) {
					cola.add(new Point(cabeza));
					cabeza.y += 1;
				} else {
					cola.add(new Point(cabeza));
					cabeza.y -= 24;
				}
			} else {
				System.exit(0);
			}
			break;
		case IZQUIERDA:
			if (casillaLibre(cabeza.x - 1, cabeza.y)) {
				if (cabeza.x > 0) {
					cola.add(new Point(cabeza));
					cabeza.x -= 1;
				} else {
					cola.add(new Point(cabeza));
					cabeza.x += 24;
				}
				break;
			} else {
				System.exit(0);
			}
		}
		if (cola.size() > tam_cola) {
			cola.remove(0);
		}
	}
}
