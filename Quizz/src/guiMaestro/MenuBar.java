package guiMaestro;

import exepciones.ArchivoInvalidoExeption;
import exepciones.CargarArchivoExption;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuBar extends JMenuBar {
    JMenuBar menu = new JMenuBar();

    JMenu mmPreguntas;
    JMenu mmAyuda;

    JMenuItem miNuevaPregunta;
    JMenuItem miGuardar;
    JMenuItem miEliminarPregunta;
    JMenuItem miSalir;

    JMenuItem miAcercaDe;
    private MenuListener listener;

    public MenuBar(){

        mmPreguntas = new JMenu("Preguntas");
        mmAyuda = new JMenu("Ayuda");

        miNuevaPregunta = new JMenuItem("Nueva pregunta");
        miNuevaPregunta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                listener.nuevaPreguntaButtonClick();
            }
        });

        miGuardar = new JMenuItem("Guardar");
        miGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    listener.guardarButtonClick();
                } catch (ArchivoInvalidoExeption archivoInvalidoExeption) {
                    archivoInvalidoExeption.printStackTrace();
                } catch (CargarArchivoExption cargarArchivoExption) {
                    cargarArchivoExption.printStackTrace();
                }
            }
        });

        miEliminarPregunta = new JMenuItem("Eliminar Pregunta");
        miEliminarPregunta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                listener.eliminarButtonClick();
            }
        });

        miSalir = new JMenuItem("Salir");
        miSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                listener.salirButtonClick();
            }
        });


        miAcercaDe = new JMenuItem("Acerca de..");
        miAcercaDe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                listener.acercaDeButtonClick();
            }
        });


        mmPreguntas.add(miNuevaPregunta);


        mmPreguntas.add(miGuardar);
        mmPreguntas.add(miEliminarPregunta);
        mmPreguntas.add(new JSeparator());
        mmPreguntas.add(miSalir);

        mmAyuda.add(miAcercaDe);

        this.add(mmPreguntas);
        this.add(mmAyuda);



    }

    public void setListener(MenuListener listener) {
        this.listener = listener;
    }

}