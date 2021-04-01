package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogoPreguntas extends JDialog {

    private DialogoPreguntasListener listener;


    private JLabel lblPregunta;
    private JTextField txtPrgunta;

    private JLabel lblRespuesta1;
    private JTextField txtRespuesta1;

    private JLabel lblRespuesta2;
    private JTextField txtRespuesta2;

    private JLabel lblRespuesta3;
    private JTextField txtRespuesta3;

    private JLabel lblRespuesta4;
    private JTextField txtRespuesta4;

    private JComboBox cbbRespuestaCorrecta;
    private String[] respuestas;
    private JLabel lblRespusetaCorrecta;


    private JComboBox cbbMateria;
    private String[] materias;
    private JLabel lblMaterias;


    private JButton btnAceptar;
    private JButton btnCancelar;


    public DialogoPreguntas(JFrame parent) {
        super(parent, "Nueva pregunta", true);
        super.setSize(282, 364);
        super.setLocationRelativeTo(parent);
        super.setLayout(new FlowLayout());
        super.getContentPane().setBackground(Color.CYAN);

        lblPregunta = new JLabel("Pregunta:");
        txtPrgunta = new JTextField(15);

        lblRespuesta1 = new JLabel("Respuesta 1");
        txtRespuesta1 = new JTextField(15);

        lblRespuesta2 = new JLabel("Respuesta 2");
        txtRespuesta2 = new JTextField(15);

        lblRespuesta3 = new JLabel("Respuesta 3");
        txtRespuesta3 = new JTextField(15);

        lblRespuesta4 = new JLabel("Respuesta 4");
        txtRespuesta4 = new JTextField(15);

        lblRespusetaCorrecta = new JLabel("Selecciona la respuesta correcta");
        respuestas = new String[]{"Respuesta 1", "Respuesta 2", "Respuesta 3", "Respuesta 4"};
        cbbRespuestaCorrecta = new JComboBox(respuestas);
        cbbRespuestaCorrecta.setSelectedIndex(-1);


        materias = new String[]{"INVESTIGACION DE OPERACIONES", "ECUACIONES DIFERENCIALES", "PROGRAMACION"};
        cbbMateria = new JComboBox(materias);
        cbbMateria.setSelectedIndex(-1);
        lblMaterias = new JLabel("Selecciona la materia");

        btnAceptar = new JButton("Aceptar");
        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                listener.aceptarButtonClick();
            }
        });

        btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                listener.cancelarButtonClick();
            }
        });

        super.add(lblPregunta);
        super.add(txtPrgunta);

        super.add(lblRespuesta1);
        super.add(txtRespuesta1);

        super.add(lblRespuesta2);
        super.add(txtRespuesta2);

        super.add(lblRespuesta3);
        super.add(txtRespuesta3);

        super.add(lblRespuesta4);
        super.add(txtRespuesta4);

        super.add(lblRespusetaCorrecta);
        super.add(cbbRespuestaCorrecta);

        super.add(lblMaterias);
        super.add(cbbMateria);

        super.add(btnAceptar);
        super.add(btnCancelar);
    }

    public void setListener(DialogoPreguntasListener listener) {
        this.listener = listener;
    }

    public void clean() {
        txtRespuesta1.setText("");
        txtRespuesta2.setText("");
        txtRespuesta3.setText("");
        txtRespuesta4.setText("");

    }
}
