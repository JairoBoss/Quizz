package guiAlumno;

import control.ControllerAlumno;
import exepciones.*;
import model.Pregunta;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainFrame extends JFrame {

    private Integer respuestaSeleccionada = -1;
    private PanelPreguntas pnlPreguntas;
    private PanelContador pnlContador;
    private PanelInferior pnlInferior;
    private ControllerAlumno oControl;
    private ArrayList<Integer> respuestas;
    private CalificacionDialog calificacionDialog;

    public MainFrame(){
        super("EXAMEN");
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setSize(834, 454);

        try {
            oControl = new ControllerAlumno();
        } catch (ArchivoInvalidoExeption | CargarArchivoExption archivoInvalidoExeption) {
            JOptionPane.showMessageDialog(MainFrame.this,
                    archivoInvalidoExeption.getMessage(),
                    "Archivo corrompido",
                    JOptionPane.ERROR_MESSAGE
            );
        }


        pnlContador = new PanelContador();
        pnlInferior = new PanelInferior(oControl.noPreguntas());
        respuestas = new ArrayList<>();

        Pregunta a = oControl.obtenerPregunta();
        pnlPreguntas = new PanelPreguntas(a);
        añadirListener();

        pnlInferior.setListener(new PanelInferiorListener() {
            @Override
            public void btnSiguienteButtonClick() {
                pnlInferior.refresh(oControl.noPreguntas());
                Pregunta a = new Pregunta("","");
                a = oControl.obtenerPregunta();


                if (a != null){

                    MainFrame.this.remove(pnlPreguntas);

                    pnlPreguntas = new PanelPreguntas(a);
                    añadirListener();

                    respuestas.add(respuestaSeleccionada);

                    MainFrame.this.add(pnlPreguntas, BorderLayout.CENTER);
                    MainFrame.this.revalidate();
                    MainFrame.this.repaint();

                }else{

                    respuestas.add(respuestaSeleccionada);
                    for (int x:respuestas) {
                        oControl.checar(x);
                    }

                    calificacionDialog = new CalificacionDialog(MainFrame.this,
                            oControl.getCalificacion(),
                            oControl.getRespuestasCorrectas()
                    );
                    listnerCalificacion();
                    calificacionDialog.setVisible(true);
                }
            }
        });


        super.add(pnlContador, BorderLayout.NORTH);
        super.add(pnlPreguntas, BorderLayout.CENTER);
        super.add(pnlInferior, BorderLayout.SOUTH);
        super.setVisible(true);
    }

    public static void main(String[] args) {
        new MainFrame();
    }

    public void añadirListener(){
        pnlPreguntas.setListener(new PanelPreguntasActionListener() {
            @Override
            public void rbRespuesta1Click() {
                respuestaSeleccionada = 0;
            }

            @Override
            public void rbRespuesta2Click() {
                respuestaSeleccionada = 1;
            }

            @Override
            public void rbRespuesta3Click() {
                respuestaSeleccionada = 2;
            }

            @Override
            public void rbRespuesta4Click() {
                respuestaSeleccionada = 3;
            }
        });
    }

    public void listnerCalificacion(){
        calificacionDialog.setListener(new guiAlumnoListener() {
            @Override
            public void cerrarButtonCLick() {
                salir();
            }
        });
    }

    public void salir(){
        System.exit(0);
    }


}

