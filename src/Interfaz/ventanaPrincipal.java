package Interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.File;
import java.util.Collection;

import javax.swing.JDialog;
import javax.swing.JFrame;

import uniandes.dpoo.taller4.modelo.RegistroTop10;
import uniandes.dpoo.taller4.modelo.Tablero;
import uniandes.dpoo.taller4.modelo.Top10;

public class ventanaPrincipal extends JFrame{
	
    private PanelTamañoDificultad PanelNorth;
    private PanelOpciones PanelEast;
    private PanelJava2D PanelCenter;
    private PanelJugadasJugador PanelSouth;
    private Tablero tablero;
    private Top10 top10;
    
    
	public ventanaPrincipal(){
		
		setSize( 750, 600 );
        setTitle( "LightsOut" );
        setDefaultCloseOperation( EXIT_ON_CLOSE );
        
        PanelNorth = new PanelTamañoDificultad(this);
        PanelNorth.setBackground(new Color(173, 216, 230));
        
        
        tablero = new Tablero( 5 );
        PanelCenter = new PanelJava2D( tablero.darTablero( ), tablero ,this);
        
        PanelEast = new PanelOpciones(this);
        
        PanelSouth = new PanelJugadasJugador(this);
        
        
        add(PanelCenter, BorderLayout.CENTER);
        add(PanelNorth, BorderLayout.NORTH);
        add(PanelEast, BorderLayout.EAST);
        add(PanelSouth, BorderLayout.SOUTH);
        
	
	}
	
	
	public void CambiarTablero(int tamañoTa) {
		
		tablero = new Tablero(tamañoTa);
		remove(PanelCenter);
	    PanelCenter = new PanelJava2D(tablero.darTablero(), tablero,this);
	    add(PanelCenter, BorderLayout.CENTER);
	    
	    PanelNorth.actualizarSeleccion(tamañoTa);
	    PanelSouth.actualizarJugadas(0);
	    revalidate();
	    repaint();
	}
	
	public void cambiarPuntaje() {
		int jugadas = tablero.darJugadas();
		PanelSouth.actualizarJugadas(jugadas);
		
	}
	
	public void reiniciarJuego() {
	       tablero.reiniciar();
	       PanelSouth.actualizarJugadas(0);
	       revalidate();
		   repaint();
			
		}
	
	public void MostrarListaTop() {
	    JDialog ventanaSecundaria = new JDialog(this, "Ventana Secundaria", true); // El tercer parámetro (true) crea un JDialog modal
	    ventanaSecundaria.setSize(300, 400);
	    ventanaSecundaria.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE); // Usa JDialog.DISPOSE_ON_CLOSE
	    top10 = new Top10();

	    File archivoCSV = new File("./data/top10.csv");
	    top10.cargarRecords(archivoCSV);
	    Collection<RegistroTop10> registros = top10.darRegistros();
	    ListaTop PanelCenter = new ListaTop(registros);
	    ventanaSecundaria.add(PanelCenter, BorderLayout.CENTER);
	    ventanaSecundaria.setLocationRelativeTo(this); // Centra la ventana secundaria con respecto a la ventana principal
	    ventanaSecundaria.setVisible(true);
	}	
    
	public static void main(String[] args){
		ventanaPrincipal ventana = new ventanaPrincipal();
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
	}

}
