package CampusNex;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame implements Runnable{
    Thread t;
    Splash(){
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/first.png"));
        Image i2 = i1.getImage().getScaledInstance(900, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        add(img);

        t = new Thread(this);
        t.start();
        setVisible(true);

        int x = 1;
        for(int i=2; i<=500; i+=4, x+=1){
            setLocation(500 - ((i+x)/2), 250 -(i/2));
            setSize(i+x*3, i+x/2);

            try{
                Thread.sleep(10);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public void run(){
        try{
            Thread.sleep(5000);
            setVisible(false);
            //another class
            new Login();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Splash();
    }
}
