package guiAlumno;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalificacionDialog extends JDialog {
    private JButton btnCerrar;
    private JLabel lblCalificacion;
    private JLabel lblRespuestasCorrectas;
    private guiAlumnoListener listener;

    public CalificacionDialog(JFrame parent, double calificacion, int respuestasCorrectas){
        super(parent, "Nueva pregunta", true);
        super.setSize(348, 114);
        super.setLocationRelativeTo(parent);
        super.setLayout(new FlowLayout());
        super.getContentPane().setBackground(Color.WHITE);

        lblRespuestasCorrectas = new JLabel("Tuviste un total de " + respuestasCorrectas + " respuestas correctas");
        lblCalificacion = new JLabel(String.format("Tu calificacion es de %.2f.",calificacion));
        btnCerrar = new JButton("Cerrar");

        btnCerrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                listener.cerrarButtonCLick();
            }
        });

        //this.setBorder(new EmptyBorder(10,30,20,10));


        this.add(lblRespuestasCorrectas);
        this.add(lblCalificacion);
        this.add(btnCerrar, BorderLayout.SOUTH);



    }

    public void setListener(guiAlumnoListener listener) {
        this.listener = listener;
    }
}
