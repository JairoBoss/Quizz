package guiMaestro;

import control.Controller;
import exepciones.ArchivoInvalidoExeption;
import exepciones.CargarArchivoExption;
import model.Pregunta;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FiltradasDialogo extends JDialog  {
    private FiltradasTable table;
    private Controller aux;
    private JTable tabla;
    private JButton btnSalir;



    public FiltradasDialogo(JFrame parent,ArrayList<Pregunta> preguntas) throws CargarArchivoExption, ArchivoInvalidoExeption {
        super(parent, "Filtrado", true);
        this.setSize(1123,161);

        aux = new Controller();
        aux.cast(preguntas);
        table = new FiltradasTable(aux);
        tabla = new JTable(table);
/*
        resizeColumnWidth(tabla);
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);*/
        btnSalir = new JButton("Salir");
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
            salir();
            }
        });

        super.add(new JScrollPane(tabla), BorderLayout.CENTER);
        super.add(btnSalir, BorderLayout.SOUTH);
        //this.pack();

    }

    private void salir() {
        this.setVisible(false);
    }

    public void resizeColumnWidth(JTable table) {
        final TableColumnModel columnModel = table.getColumnModel();
        for (int column = 0; column < table.getColumnCount(); column++) {
            int width = 15; // Min width
            for (int row = 0; row < table.getRowCount(); row++) {
                TableCellRenderer renderer = table.getCellRenderer(row, column);
                Component comp = table.prepareRenderer(renderer, row, column);
                width = Math.max(comp.getPreferredSize().width +1 , width);
            }
            if(width > 300)
                width=300;
            columnModel.getColumn(column).setPreferredWidth(width);
        }
    }


}
