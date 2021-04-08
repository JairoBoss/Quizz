package guiAlumno;

import exepciones.ArchivoInvalidoExeption;
import exepciones.CargarArchivoExption;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelInferior extends JPanel {
    private JButton btnSiguientePreguntar;
    private JLabel lblContador;
    private PanelInferiorListener listener;

    public PanelInferior(){
        this.setLayout(new BorderLayout());
        btnSiguientePreguntar = new JButton("Siguiente pregunta");
        btnSiguientePreguntar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                listener.btnSiguienteButtonClick();
            }
        });
        lblContador = new JLabel("01 de 30");

        this.setBackground(Color.GREEN);

        this.setBorder(new EmptyBorder(10,10,10,10));

        this.add(lblContador, BorderLayout.WEST);
        this.add(btnSiguientePreguntar, BorderLayout.EAST);

    }



    public void setListener(PanelInferiorListener listener) {
        this.listener = listener;
    }
}
