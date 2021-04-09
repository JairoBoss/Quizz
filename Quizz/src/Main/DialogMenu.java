package Main;

import exepciones.ArchivoInvalidoExeption;
import exepciones.CargarArchivoExption;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogMenu extends JDialog {
    private JButton btnAddPreguntas;
    private JButton btnAnswer;
    private DialogMenuListener listener;

    public DialogMenu(JFrame parent){

        super(parent, "Submenu", true);
        super.setLocationRelativeTo(parent);
        super.setSize(348, 114);
        super.setLayout(new FlowLayout());
        btnAddPreguntas = new JButton("AñadirPreguntas");
        btnAnswer = new JButton("Responder examen");

        btnAddPreguntas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    listener.addPreguntaButtonClick();
                } catch (ArchivoInvalidoExeption archivoInvalidoExeption) {
                    archivoInvalidoExeption.printStackTrace();
                } catch (CargarArchivoExption cargarArchivoExption) {
                    cargarArchivoExption.printStackTrace();
                }
            }
        });

        btnAnswer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                listener.answerButtonClick();
            }
        });

        this.add(btnAddPreguntas, BorderLayout.WEST);
        this.add(btnAnswer,BorderLayout.EAST);
    }

    public void setListener(DialogMenuListener listener) {
        this.listener = listener;
    }
}
