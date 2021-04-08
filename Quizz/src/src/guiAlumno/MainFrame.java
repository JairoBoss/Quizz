package guiAlumno;

import control.ControllerAlumno;
import exepciones.ArchivoInvalidoExeption;
import exepciones.CargarArchivoExption;
import model.Pregunta;
import model.Respuesta;
import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private PanelPreguntas pnlPreguntas;
    private PanelContador pnlContador;
    private PanelInferior panelInferior;
    private ControllerAlumno oControl;

    public MainFrame() throws CargarArchivoExption, ArchivoInvalidoExeption {


        super("EXAMEN");

        Pregunta a = new Pregunta("Cuanto es 2 + 2","Geo");
        a.setRespuesta(new Respuesta("1",false));
        a.setRespuesta(new Respuesta("2",false));
        a.setRespuesta(new Respuesta("3",false));
        a.setRespuesta(new Respuesta("4",false));
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setSize(834, 454);

        oControl = new ControllerAlumno();
        pnlContador = new PanelContador();
        panelInferior = new PanelInferior();

        panelInferior.setListener(new PanelInferiorListener() {
            @Override
            public void btnSiguienteButtonClick() {
                MainFrame.this.remove(pnlPreguntas);
                //pnlPreguntas = new PanelPreguntas(oControl.obtenerPregunta());
                listenerOP();



                MainFrame.this.add(pnlPreguntas, BorderLayout.CENTER);

                SwingUtilities.updateComponentTreeUI(MainFrame.this);
            }
        });


        listenerOP();

        super.add(pnlPreguntas, BorderLayout.CENTER);
        super.add(pnlContador, BorderLayout.NORTH);
        super.add(panelInferior, BorderLayout.SOUTH);

        super.setVisible(true);

    }


    public static void main(String[] args) throws ArchivoInvalidoExeption, CargarArchivoExption {
        new MainFrame();

    }

    public void listenerOP(){
        pnlPreguntas = new PanelPreguntas(oControl.obtenerPregunta());

        pnlPreguntas.setListener(new PanelPreguntasActionListener() {

            @Override
            public void rbRespuesta1Click() {
                oControl.Calificacion(0);
            }

            @Override
            public void rbRespuesta2Click() {
                oControl.Calificacion(1);
            }

            @Override
            public void rbRespuesta3Click() {
                oControl.Calificacion(2);
            }

            @Override
            public void rbRespuesta4Click() {
                oControl.Calificacion(3);
            }
        });

    }
}
