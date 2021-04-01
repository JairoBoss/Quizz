/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import control.Controller;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

import model.Materia;
import model.Pregunta;
import model.Respuesta;
import javax.swing.*;
/**
 *
 * @author Megabit
 */
public class PrincipalFrame extends JFrame {

    private MenuBar baresito;

    private DialogoPreguntas dlgPreguntas;

    private JTable tblPreguntas;
    private Controller control;
    private PreguntasTableModel modelPreguntas;

    private RespuestasComboBox answer;

    public PrincipalFrame(){
        super("EXAMEN");
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setSize(500, 300);
        super.setLayout(new BorderLayout());
        super.setLocationRelativeTo(null);

        dlgPreguntas = new DialogoPreguntas(this);
        dlgPreguntas.setListener(new DialogoPreguntasListener() {
            @Override
            public void aceptarButtonClick() {
                dlgPreguntas.clean();
            }

            @Override
            public void cancelarButtonClick() {
                dlgPreguntas.clean();
                dlgPreguntas.setVisible(false);
            }
        });

        baresito = new MenuBar();
        baresito.setListener(new MenuListener() {
            @Override
            public void nuevaPreguntaButtonClick() {
                System.out.println("Nueva pregunta");
                dlgPreguntas.setVisible(true);
            }

            @Override
            public void guardarButtonClick() {
                System.out.println("Guardar");
            }

            @Override
            public void salirButtonClick() {
                System.exit(0);

                System.out.println("Saliendo ...");
            }

            @Override
            public void acercaDeButtonClick() {
                System.out.println("Acerca de ....");
            }
        });

        control = new Controller();

        control.addPregunta(new Pregunta("¿Cual es la capital de wakanda?", "GEOGRAFIA"));

        control.inciso(0, new Respuesta("Wakanda", false));
        control.inciso(0, new Respuesta("Oaxaca", false));
        control.inciso(0, new Respuesta("No tiene capital", false));
        control.inciso(0, new Respuesta("Birnin Zana", true));

        control.addPregunta(new Pregunta("Cuanto es 1 + 1", "MATEMATICAS"));

        control.inciso(1, new Respuesta("2", true));
        control.inciso(1, new Respuesta("6548", false));
        control.inciso(1, new Respuesta("963", false));
        control.inciso(1, new Respuesta("741", false));

       control.addPregunta(new Pregunta("Quien descubrio america?", "HISTORIA"));

        control.inciso(2, new Respuesta("6548", false));
        control.inciso(2, new Respuesta("963", false));
        control.inciso(2, new Respuesta("Una persona", true));
        control.inciso(2, new Respuesta("741", false));


        control.addPregunta(new Pregunta("Que es una variable?", "PROGRAMACION"));

        control.inciso(3, new Respuesta("UwU", false));
        control.inciso(3, new Respuesta("No", false));
        control.inciso(3, new Respuesta("Si", false));
        control.inciso(3, new Respuesta("Espacio reservado en la memoria", true));

        String[] res = {
          "ESPAÑOL", "MATEMATICAS", "GEOGRAFIA", "HISTORIA", "PROGRAMACION"
        };
        answer = new RespuestasComboBox(res);

        modelPreguntas = new PreguntasTableModel(control);
        tblPreguntas = new JTable(modelPreguntas);


        super.add(baresito, BorderLayout.NORTH);
        super.add(new JScrollPane(tblPreguntas), BorderLayout.CENTER);

        super.add(answer, BorderLayout.SOUTH);
        super.setVisible(true);

    }


    public static void main(String args[]){

        new PrincipalFrame();

/*

        Controller controlador = new Controller();

        controlador.addPregunta(new Pregunta("Cuanto es 10 + 2"));

        controlador.inciso(0, new Respuesta("CERO", false));
        controlador.inciso(0, new Respuesta("UNO", false));
        controlador.inciso(0, new Respuesta("DOS", false));
        controlador.inciso(0, new Respuesta("12", true));

        controlador.addPregunta(new Pregunta("AAAAAAAAAA"));

        controlador.inciso(1, new Respuesta("456", true));
        controlador.inciso(1, new Respuesta("6548", false));
        controlador.inciso(1, new Respuesta("963", false));
        controlador.inciso(1, new Respuesta("741", false));

        */
/*for (int i = 0; i < controlador.noPreguntas(); i++) {
            System.out.println(String.format("Pregunta no[%d]: %s", i,controlador.getPregunta(i)));
            for (int j = 0; j < 4; j++) {
                System.out.println(controlador.respuesta(i,j));

            }

        }

        controlador.contestar();*//*


        String[] x = controlador.respuestasString(1);

        System.out.println("Tuviste un total de " + controlador.getCorrectas() + " aciertos");
*/





    }
}
