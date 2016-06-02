package vista;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import controlador.App;

public class Ventana extends JFrame implements KeyListener{
	
	private Dimension dim;
	public PanelPrincipal menu;
	
	
	public Ventana(){
		super("Snake");
		menu = new PanelPrincipal();
 		dim = Toolkit.getDefaultToolkit().getScreenSize();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setSize(600, 450);
		addKeyListener(this);
		setFocusable(true);
		setLocation(dim.width / 2 - getWidth() / 2, dim.height / 2 - getHeight() / 2);
		add(menu);
		
	}


	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		App.getApp().keyPressed(e);
		
		menu.uno.tablero.repaint();
		menu.uno.estadisticas.repaint();
		menu.uno.repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}
	
	
}
