package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuBar extends JMenuBar {
    JMenuBar menu = new JMenuBar();

    JMenu mmPreguntas;
    JMenu mmAyuda;

    JMenuItem miNuevaPregunta;
    JMenuItem miGuardar;
    JMenuItem miSalir;
    JMenuItem miAcercaDe;

    public MenuBar(){

        mmPreguntas = new JMenu("Preguntas");
        mmAyuda = new JMenu("Ayuda");

        miNuevaPregunta = new JMenuItem("Nueva pregunta");
        miSalir = new JMenuItem("Salir");
        miGuardar = new JMenuItem("Guardar");

        miAcercaDe = new JMenuItem("Acerca de..");

        mmPreguntas.add(miNuevaPregunta);
        /*miNuevaPregunta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });*/
        mmPreguntas.add(miGuardar);
        mmPreguntas.add(new JSeparator());
        mmPreguntas.add(miSalir);

        mmAyuda.add(miAcercaDe);

        this.add(mmPreguntas);
        this.add(mmAyuda);



    }
}
