package guiMaestro;

import exepciones.ArchivoInvalidoExeption;
import exepciones.CargarArchivoExption;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FiltrarComboBox extends JPanel {

    JComboBox preguntasCB;
    JLabel lblFiltrar;
    JButton btnBuscar;

    FiltrarComboBoxListener listener;

    public FiltrarComboBox(String[] respuestas){
        lblFiltrar = new JLabel("Filtrar por materia");

        preguntasCB = new JComboBox(respuestas);
        preguntasCB.setSelectedIndex(-1);


        btnBuscar = new JButton("Filtrar");
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    listener.btnBuscarButtonClick((String) preguntasCB.getSelectedItem());
                } catch (ArchivoInvalidoExeption | CargarArchivoExption archivoInvalidoExeption) {
                    archivoInvalidoExeption.printStackTrace();
                }
                preguntasCB.setSelectedIndex(-1);
            }
        });


        this.add(lblFiltrar);
        this.add(preguntasCB);

        this.add(btnBuscar);


    }

    public void setListener(FiltrarComboBoxListener listener) {
        this.listener = listener;
    }
}
