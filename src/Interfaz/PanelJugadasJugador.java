package Interfaz;

import java.awt.GridLayout;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.NumberFormatter;
import java.text.NumberFormat;
import java.text.ParseException;

public class PanelJugadasJugador extends JPanel {

    private JPanel PanelSur;
    private JLabel lblJugadas;
    private JFormattedTextField txtJugadas;
    private JLabel lblJugador;
    private JTextField txtJugador;
    private ventanaPrincipal table;


    public PanelJugadasJugador(ventanaPrincipal ventanaPrincipal) {
    	table = ventanaPrincipal;
        PanelSur = new JPanel();
        PanelSur.setLayout(new GridLayout(1, 5));

        lblJugadas = new JLabel("Jugadas: ");
        PanelSur.add(lblJugadas);

        NumberFormat format = NumberFormat.getInstance();
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setValueClass(Integer.class);
        formatter.setMinimum(0);
        formatter.setMaximum(Integer.MAX_VALUE);
        formatter.setAllowsInvalid(false);
        txtJugadas = new JFormattedTextField(formatter);
        txtJugadas.setEditable(false);
        txtJugadas.setValue(0);
        PanelSur.add(txtJugadas);

        lblJugador = new JLabel("Jugador: ");
        PanelSur.add(lblJugador);

        txtJugador = new JTextField();
        PanelSur.add(txtJugador);

        add(PanelSur);
    }

    
    public void actualizarJugadas(int jugadas2) {
      
        txtJugadas.setValue(jugadas2);
        revalidate();
 	   repaint();
    }
}