package Interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

import uniandes.dpoo.taller4.modelo.Tablero;


public class PanelTamañoDificultad extends JPanel implements ActionListener{
   
	private JPanel panelTamaño;
	private ventanaPrincipal principal;
	private JComboBox<String> cajaTamaño;
	private JRadioButton cdDifi1; 
    private JRadioButton cdDifi2; 
    private JRadioButton cdDifi3; 
    
    
	public PanelTamañoDificultad(ventanaPrincipal principalP) {
	   
	   principal = principalP;
       panelTamaño = new JPanel();
       panelTamaño.setBackground(new Color(173, 216, 230));
       add(panelTamaño);
       
       panelTamaño.setLayout(new GridLayout(1,6));//Se crea el Panel con las filas y columnas a usar dentro de esta
       
       JLabel lblTamaño = new JLabel("Tamaño : ");
       panelTamaño.add(lblTamaño);
       
       String[] opciones = {"5x5","6x6","7x7"};
       cajaTamaño = new JComboBox<>(opciones);
       panelTamaño.add(cajaTamaño);
       
       
       panelTamaño.add(Box.createVerticalStrut(10));
       
       ButtonGroup grupoDificultad = new ButtonGroup();
       
       JLabel lblDificultad = new JLabel("Dificultad: ");
       panelTamaño.add(lblDificultad);
       
       cdDifi1 = new JRadioButton("Dificil");
       cdDifi2 = new JRadioButton("Medio");
       cdDifi3 = new JRadioButton("Facil");
       
       grupoDificultad.add(cdDifi1);
       grupoDificultad.add(cdDifi2);
       grupoDificultad.add(cdDifi3);
       
       
       
       cdDifi1.setBackground(new Color(173, 216, 230)); // Establecer fondo azul para los JRadioButton
       cdDifi2.setBackground(new Color(173, 216, 230));
       cdDifi3.setBackground(new Color(173, 216, 230));
       
       panelTamaño.add(cdDifi1);
       panelTamaño.add(cdDifi2);
       panelTamaño.add(cdDifi3);
       
       cajaTamaño.addActionListener( this );
       cdDifi1.addActionListener( this );
       cdDifi2.addActionListener( this );
       cdDifi3.addActionListener( this );

	}
	
	public void actualizarSeleccion(int tamaño) {
	    String seleccion = tamaño + "x" + tamaño;
	    cajaTamaño.setSelectedItem(seleccion);
	}
	
	public void actionPerformed( ActionEvent e )
    {
		 if (e.getSource() instanceof JComboBox) {
	            
	            JComboBox<String> cajaTam = (JComboBox<String>) e.getSource();
	            String seleccion = (String) cajaTam.getSelectedItem();
	            String[] tam = seleccion.split("x");
	            int tamaInt = Integer.parseInt(tam[0]);
	            if (seleccion.equals("5x5")) {
	            	cdDifi3.setSelected(true);
	            	
	            }else if(seleccion.equals("6x6")) {
	            	cdDifi2.setSelected(true);
	            }else if(seleccion.equals("7x7")) {
	            	cdDifi1.setSelected(true);
	            }
	            
	            principal.CambiarTablero(tamaInt);
	            
	    }else if(e.getSource( )== cdDifi1) {
	    	principal.CambiarTablero(7);
	    }else if(e.getSource( )== cdDifi2) {
	    	principal.CambiarTablero(6);
	    }else if(e.getSource( )== cdDifi3) {
	    	principal.CambiarTablero(5);
	    }
       
    }
}
