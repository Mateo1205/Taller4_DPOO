package Interfaz;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import uniandes.dpoo.taller4.modelo.Tablero;

public class PanelJava2D extends JPanel implements MouseListener{
	
	private boolean[][] tablero;
	private Tablero Table;
	private ventanaPrincipal princi;
	
	public PanelJava2D(boolean[][] tableroP, Tablero TableP,ventanaPrincipal princiP) {
		
		princi = princiP;
		tablero = tableroP;
		Table = TableP;
		add(new JLabel(  "                                   "));
	    addMouseListener( this );
	}

	public void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    Graphics2D g2d = (Graphics2D) g;
	    int ancho = getWidth();
	    int alto = getHeight();
	    int ladoTablero = tablero.length;

	    int anchoCasilla = ancho / ladoTablero;
	    int altoCasilla = alto / ladoTablero;

	    ImageIcon imagenAmarilla = new ImageIcon("./data/luz.png");

	    for (int i = 0; i < ladoTablero; i++) {
	        for (int j = 0; j < ladoTablero; j++) {
	            Rectangle2D.Double rect = new Rectangle2D.Double(i * anchoCasilla, j * altoCasilla, anchoCasilla, altoCasilla);

	            if (tablero[i][j]) {
	                g.setColor(Color.YELLOW);
	                g2d.fill(rect);
	                g.setColor(Color.BLACK);
	                g2d.draw(rect);
	                Image imagen = imagenAmarilla.getImage();
	                g2d.drawImage(imagen, (int) rect.getX(), (int) rect.getY(), (int) rect.getWidth(), (int) rect.getHeight(), null);
	            } else {
	                g.setColor(Color.GRAY);
	                g2d.fill(rect);
	                g.setColor(Color.BLACK);
	                g2d.draw(rect);
	            }
	        }
	    }
	}
	
	@Override
	public void mouseClicked( MouseEvent e )
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mousePressed( MouseEvent e )
    {
        int click_x = e.getX();
        int click_y = e.getY();
        int[] casilla = convertirCoordenadasACasilla(click_x, click_y);

        Table.jugar(casilla[0], casilla[1]);
        princi.cambiarPuntaje();
        repaint();
    }

    private int[] convertirCoordenadasACasilla(int x, int y)
    {
    int ancho = getWidth();
 	int alto = getHeight();
 	int ladoTablero = tablero.length;
 	    
 	    
 	int anchoCasilla = ancho / ladoTablero;
 	int altoCasilla = alto / ladoTablero;
 	
    int fila = (int) (x / anchoCasilla);
    int columna = (int) (y / altoCasilla);
    
    return new int[] { fila, columna };
    }

    @Override
    public void mouseReleased( MouseEvent e )
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseEntered( MouseEvent e )
    {
        // no se implementa
    }

    @Override
    public void mouseExited( MouseEvent e )
    {
        // no se implementa
        
    }

	public void actualizarPanelJuego() {
		
		
	}
    
}
