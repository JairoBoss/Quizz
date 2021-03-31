package gui;

import javax.swing.*;
import java.util.ArrayList;

public class RespuestasComboBox extends JPanel {

    JComboBox preguntasCB;
    JLabel lblFiltrar;
    JButton btnBuscar;

    public RespuestasComboBox(String[] respuestas){
        lblFiltrar = new JLabel("Filtrar por materia");

        preguntasCB = new JComboBox(respuestas);
        preguntasCB.setSelectedIndex(-1);

        btnBuscar = new JButton("Filtrar");

        this.add(lblFiltrar);
        this.add(preguntasCB);

        this.add(btnBuscar);


    }



}
