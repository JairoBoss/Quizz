package Main;

import exepciones.ArchivoInvalidoExeption;
import exepciones.CargarArchivoExption;
import guiAlumno.MainFrame;
import guiMaestro.PrincipalFrame;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {


    private Login login;
    private Botones botnes;
    private DialogMenu dialogMenu;

    public Main(){

        super("Login");
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setSize(416, 473);
        dialogMenu = new DialogMenu(this);

        login = new Login();
        botnes = new Botones();
        botnes.setListener(new BotonesListener() {
            @Override
            public void loginButtonClick() {
                dialogMenu.setVisible(true);

            }

            @Override
            public void cancelarButtonClick() {
                System.exit(0);
            }
        });

        dialogMenu.setListener(new DialogMenuListener() {
            @Override
            public void addPreguntaButtonClick() throws ArchivoInvalidoExeption, CargarArchivoExption {
                Main.this.setVisible(false);
                new PrincipalFrame();
            }

            @Override
            public void answerButtonClick() {
                Main.this.setVisible(false);
                new MainFrame();

            }
        });

        super.add(login, BorderLayout.CENTER);
        super.add(botnes, BorderLayout.SOUTH);
        super.setVisible(true);




    }




    public static void main(String[] args) {
        new Main();
    }
}
