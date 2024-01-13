package CampusNex;

import javax.swing.*;
import java.awt.*;

public class About extends JFrame {
    About(){

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/VIT.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(350,10,200,200);
        add(img);

        JLabel heading = new JLabel("<html>VIT </br>Bhopal University</html>");
        heading.setBounds(70,20,300,130);
        heading.setFont(new Font("Tahoma", Font.BOLD,30));
        add(heading);

        JLabel name = new JLabel("Mehak Chabra");
        name.setBounds(30,280,550,40);
        name.setFont(new Font("Tahoma", Font.BOLD,30));
        add(name);

        JLabel contact = new JLabel("mehak.chabra2020@vitbhopal.ac.in");
        contact.setBounds(30,320,550,40);
        contact.setFont(new Font("Tahoma", Font.BOLD,20));
        add(contact);

        setSize(600,500);
        setLocation(300,100);
        getContentPane().setBackground(new Color(252,228,210));
        setLayout(null);
        setVisible(true);

    }
    public static void main(String[] args) {
        new About();
    }
}
