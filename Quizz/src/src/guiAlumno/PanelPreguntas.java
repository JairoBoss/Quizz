package guiAlumno;

import model.Pregunta;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelPreguntas extends JPanel {

    private JLabel lblPregunta;
    private JRadioButton rbRespuesta1;
    private JRadioButton rbRespuesta2;
    private JRadioButton rbRespuesta3;
    private JRadioButton rbRespuesta4;
    private ButtonGroup bgIncisos;
    private PanelPreguntasActionListener listener;

    public PanelPreguntas(Pregunta pregunta){

        this.setBackground(Color.WHITE);
        lblPregunta = new JLabel(pregunta.getPregunta());
        lblPregunta.setFont(new Font("Serif",Font.PLAIN,15));
        rbRespuesta1 = new JRadioButton("a)"+ pregunta.respuesta(0));
        rbRespuesta2 = new JRadioButton("b) "+ pregunta.respuesta(1));
        rbRespuesta3 = new JRadioButton("c) "+ pregunta.respuesta(2));
        rbRespuesta4 = new JRadioButton("d) "+ pregunta.respuesta(3));

        bgIncisos = new ButtonGroup();

        bgIncisos.add(rbRespuesta1);
        bgIncisos.add(rbRespuesta2);
        bgIncisos.add(rbRespuesta3);
        bgIncisos.add(rbRespuesta4);

        //Matriz
        GridLayout gridLayout = new GridLayout(5,1);
        gridLayout.setHgap(10);
        gridLayout.setVgap(40);
        this.setLayout(gridLayout);

        this.setBorder(new EmptyBorder(10,10,10,10));

        rbRespuesta1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                listener.rbRespuesta1Click();
            }
        });

        rbRespuesta2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                listener.rbRespuesta2Click();
            }
        });

        rbRespuesta3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                listener.rbRespuesta3Click();
            }
        });

        rbRespuesta4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                listener.rbRespuesta4Click();
            }
        });

        this.add(lblPregunta);
        this.add(rbRespuesta1);
        this.add(rbRespuesta2);
        this.add(rbRespuesta3);
        this.add(rbRespuesta4);

    }

    public void clean(){
        this.lblPregunta.setText("");
        this.rbRespuesta1.setText("");
        this.rbRespuesta2.setText("");
        this.rbRespuesta3.setText("");
        this.rbRespuesta4.setText("");
    }


    public void setListener(PanelPreguntasActionListener listener) {
        this.listener = listener;
    }
}