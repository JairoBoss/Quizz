package guiAlumno;


import control.Controller;
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

        int x = 0;

        pnlContador = new PanelContador();
        panelInferior = new PanelInferior();

        panelInferior.setListener(new PanelInferiorListener() {
            @Override
            public void btnSiguienteButtonClick() {
                MainFrame.this.remove(pnlPreguntas);
                pnlPreguntas = new PanelPreguntas(oControl.obtenerPregunta());
                MainFrame.this.add(pnlPreguntas,BorderLayout.CENTER);
                SwingUtilities.updateComponentTreeUI(MainFrame.this);
            }
        });
        pnlPreguntas = new PanelPreguntas(oControl.obtenerPregunta());
        System.out.println(oControl.noPreguntas());
        super.add(pnlPreguntas, BorderLayout.CENTER);
        super.add(pnlContador, BorderLayout.NORTH);
        super.add(panelInferior, BorderLayout.SOUTH);

        super.setVisible(true);

    }


    public static void main(String[] args) throws ArchivoInvalidoExeption, CargarArchivoExption {
       new MainFrame();

    }

    private void noPregunta(){

    }
}
