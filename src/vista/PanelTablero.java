package vista;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import controlador.App;

public class PanelTablero extends JPanel{	
	
	public void margenes(Graphics g){
		g.drawLine(0, 0, 0, 400);
		g.drawLine(0, 0, 400, 0);
		g.drawLine(399, 0, 399, 399);
		g.drawLine(0, 399, 399, 399);
		for(int i = 0; i < 25; i++)
			g.drawLine(0, i*16, 400, i*16);
		for(int i = 0; i < 25; i++)
			g.drawLine(i*16, 0, i*16, 400);
	}
	
	public void pintarEscenario(Graphics g){
		int copia[][] = App.getApp().getTablero().getTablero();
		for (int i = 0; i < copia.length; i++) {
			for (int j = 0; j < copia.length; j++) {
				if(copia[i][j] == 1)
					g.fillRect(i*16, j*16, 16, 16);
				if(copia[i][j] == 3)
					g.fillRect(i*16, j*16, 16, 16);
			}
		}
		
	}
	public void paintComponent(Graphics g){
		g.setColor(Color.green);
		margenes(g);
		pintarEscenario(g);
		
	}
}
