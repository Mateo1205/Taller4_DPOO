package Interfaz;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Collection;

import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import uniandes.dpoo.taller4.modelo.RegistroTop10;

public class ListaTop extends JPanel {
    
    private DefaultListModel<String> listModel;
    private JList<String> listaRegistros;

    public ListaTop(Collection<RegistroTop10> registros) {
        setLayout(new GridBagLayout());
        
        listModel = new DefaultListModel<>();
        listaRegistros = new JList<>(listModel);

        for (RegistroTop10 registro : registros) {
            listModel.addElement(registro.toString());
        }

        JScrollPane scrollPane = new JScrollPane(listaRegistros);
        
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 1.0;
        add(scrollPane, c);
    }

}
