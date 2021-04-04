/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import control.Controller;

import java.awt.BorderLayout;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

import exepciones.ArchivoInvalidoExeption;
import exepciones.CargarArchivoExption;
import exepciones.GuardarArchivoExeption;
import model.Materia;
import model.Pregunta;
import model.Respuesta;

import javax.swing.*;

/**
 * @author Megabit
 */
public class PrincipalFrame extends JFrame {

    private MenuBar baresito;

    private DialogoPreguntas dlgPreguntas;

    private JTable tblPreguntas;
    private Controller control;
    private PreguntasTableModel modelPreguntas;

    private RespuestasComboBox answer;

    private EliminarPreguntaDialogo eliminarPreguntaDialogo;

    public PrincipalFrame() throws CargarArchivoExption, ArchivoInvalidoExeption {
        super("EXAMEN");
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setSize(500, 300);
        super.setLayout(new BorderLayout());
        super.setLocationRelativeTo(null);
        String[] res = {
                "ESPAÑOL", "MATEMATICAS", "GEOGRAFIA", "HISTORIA", "PROGRAMACION"
        };
                
        


        try {
            control = new Controller();
        } catch (ArchivoInvalidoExeption ex) {
            JOptionPane.showMessageDialog(PrincipalFrame.this,
                    ex.getMessage(),
                    "Archivo corrompido",
                    JOptionPane.ERROR_MESSAGE);
        } catch (CargarArchivoExption ex) {
            JOptionPane.showMessageDialog(PrincipalFrame.this,
                    ex.getMessage(),
                    "Archivo corrompido",
                    JOptionPane.ERROR_MESSAGE);
        }
        
        modelPreguntas = new PreguntasTableModel(control);
        tblPreguntas = new JTable(modelPreguntas);
        
        answer = new RespuestasComboBox(res);
        

        eliminarPreguntaDialogo = new EliminarPreguntaDialogo(this);
        eliminarPreguntaDialogo.setListener(new EliminarPreguntaListener() {
            @Override
            public void eliminarButtonClick(String noControl) {

                JOptionPane.showMessageDialog(PrincipalFrame.this, control.eliminarPregunta(noControl), "Eliminar", JOptionPane.INFORMATION_MESSAGE);
                modelPreguntas.fireTableDataChanged();
                eliminarPreguntaDialogo.setVisible(false);
            }

            @Override
            public void cancelarButtonClick() {

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
            public void guardarButtonClick() throws ArchivoInvalidoExeption, CargarArchivoExption {
                control.guardar();
            }

            @Override
            public void eliminarButtonClick() {

                eliminarPreguntaDialogo.setVisible(true);
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



        dlgPreguntas = new DialogoPreguntas(this, res);
        dlgPreguntas.setListener(new DialogoPreguntasListener() {
            @Override
            public void aceptarButtonClick(Pregunta pregunta, Respuesta uno, Respuesta dos, Respuesta tres, Respuesta cuatro) {

                control.addPregunta(pregunta);
                control.inciso(control.getPreguntas().size() - 1, uno);
                control.inciso(control.getPreguntas().size() - 1, dos);
                control.inciso(control.getPreguntas().size() - 1, tres);
                control.inciso(control.getPreguntas().size() - 1, cuatro);


                modelPreguntas.fireTableDataChanged();
                dlgPreguntas.setVisible(false);
                dlgPreguntas.clean();
            }

            @Override
            public void cancelarButtonClick() {
                dlgPreguntas.clean();
                dlgPreguntas.setVisible(false);
            }
        });

     

        


        super.add(baresito, BorderLayout.NORTH);
        super.add(new JScrollPane(tblPreguntas), BorderLayout.CENTER);

        super.add(answer, BorderLayout.SOUTH);
        super.setVisible(true);

    }

    public static void main(String args[]) throws ArchivoInvalidoExeption, CargarArchivoExption {
        new PrincipalFrame();
    }
}