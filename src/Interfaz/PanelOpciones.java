package Interfaz;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;


import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import uniandes.dpoo.taller4.modelo.Tablero;

public class PanelOpciones extends JPanel implements ActionListener{
	
	private ventanaPrincipal tablero;
    private JPanel panelBotones;
	private JButton btnNuevo;
	private JButton btnReiniciar;
	private JButton btnTop;
	private JButton btnNewPlayer;
	
	
	public PanelOpciones(ventanaPrincipal principalP) {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		tablero = principalP;
		
		panelBotones = new JPanel();
		panelBotones.setLayout(new GridLayout(8,1));
	
		
		btnNuevo = new JButton("NUEVO");
		btnReiniciar = new JButton("REINICIAR");
		btnTop = new JButton("TOP-10");
		btnNewPlayer = new JButton("CAMBIAR JUGADOR");
		
		Color colorBlue = new Color(173, 216, 230);
		
		btnNuevo.setBackground(colorBlue);
		btnReiniciar.setBackground(colorBlue);
		btnTop.setBackground(colorBlue);
		btnNewPlayer.setBackground(colorBlue);
		
		
	
		panelBotones.add(btnNuevo);
		panelBotones.add(new JLabel());
		panelBotones.add(btnReiniciar);
		panelBotones.add(new JLabel());
		panelBotones.add(btnTop);
		panelBotones.add(new JLabel());
		panelBotones.add(btnNewPlayer);
		
		
		add(Box.createVerticalGlue()); // Espacio en blanco arriba de panelBotones
        add(panelBotones);
        add(Box.createVerticalGlue());
        
        btnNuevo.addActionListener(this);
        btnReiniciar.addActionListener(this);
        btnTop.addActionListener(this);
	
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource( )== btnNuevo) {
       
			tablero.CambiarTablero(5);
           
        }else if (e.getSource( )==btnReiniciar) {
        	
        	tablero.reiniciarJuego();
        	
        }else if(e.getSource( )== btnTop) {
        	
        	tablero.MostrarListaTop();
        	
        }
       
		
	}

}
