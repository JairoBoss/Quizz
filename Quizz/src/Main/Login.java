package Main;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Login extends JPanel {
    private JTextField txtUser;
    private JLabel lblUser;
    private JPasswordField txtContraseña;
    private JLabel lblUContraseña;
    private JLabel lblImg;

    public Login(){
        txtUser = new JTextField(15);
        lblUser = new JLabel("Usuario");

        txtContraseña = new JPasswordField(15);
        lblUContraseña = new JLabel("Contraseña");

        ImageIcon imageIcon = new ImageIcon("src/Imagenes/login.png");

        lblImg = new JLabel();
        lblImg.setIcon(new ImageIcon(imageIcon.getImage().getScaledInstance(150,150, Image.SCALE_SMOOTH)));
        //lblImg.setBounds(10,80,200,200);

        /*GridLayout gridLayout = new GridLayout(1,1);
        gridLayout.setHgap(10);
        gridLayout.setVgap(40);
        this.setLayout(gridLayout);*/

        this.setBorder(new EmptyBorder(30,100,20,100));


        this.add(lblImg);
        this.add(lblUser);
        this.add(txtUser, BorderLayout.WEST);
        this.add(lblUContraseña);
        this.add(txtContraseña);
    }
}
