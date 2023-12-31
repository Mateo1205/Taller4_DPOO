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


public class PanelTamaņoDificultad extends JPanel implements ActionListener{
   
	private JPanel panelTamaņo;
	private ventanaPrincipal principal;
	private JComboBox<String> cajaTamaņo;
	private JRadioButton cdDifi1; 
    private JRadioButton cdDifi2; 
    private JRadioButton cdDifi3; 
    
    
	public PanelTamaņoDificultad(ventanaPrincipal principalP) {
	   
	   principal = principalP;
       panelTamaņo = new JPanel();
       panelTamaņo.setBackground(new Color(173, 216, 230));
       add(panelTamaņo);
       
       panelTamaņo.setLayout(new GridLayout(1,6));//Se crea el Panel con las filas y columnas a usar dentro de esta
       
       JLabel lblTamaņo = new JLabel("Tamaņo : ");
       panelTamaņo.add(lblTamaņo);
       
       String[] opciones = {"5x5","6x6","7x7"};
       cajaTamaņo = new JComboBox<>(opciones);
       panelTamaņo.add(cajaTamaņo);
       
       
       panelTamaņo.add(Box.createVerticalStrut(10));
       
       ButtonGroup grupoDificultad = new ButtonGroup();
       
       JLabel lblDificultad = new JLabel("Dificultad: ");
       panelTamaņo.add(lblDificultad);
       
       cdDifi1 = new JRadioButton("Dificil");
       cdDifi2 = new JRadioButton("Medio");
       cdDifi3 = new JRadioButton("Facil");
       
       grupoDificultad.add(cdDifi1);
       grupoDificultad.add(cdDifi2);
       grupoDificultad.add(cdDifi3);
       
       
       
       cdDifi1.setBackground(new Color(173, 216, 230)); // Establecer fondo azul para los JRadioButton
       cdDifi2.setBackground(new Color(173, 216, 230));
       cdDifi3.setBackground(new Color(173, 216, 230));
       
       panelTamaņo.add(cdDifi1);
       panelTamaņo.add(cdDifi2);
       panelTamaņo.add(cdDifi3);
       
       cajaTamaņo.addActionListener( this );
       cdDifi1.addActionListener( this );
       cdDifi2.addActionListener( this );
       cdDifi3.addActionListener( this );

	}
	
	public void actualizarSeleccion(int tamaņo) {
	    String seleccion = tamaņo + "x" + tamaņo;
	    cajaTamaņo.setSelectedItem(seleccion);
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
