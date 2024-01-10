package CampusNex;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JTextField textFieldName;
    JPasswordField passFieldName;
    JButton login, back;
    Login(){
        JLabel labelName = new JLabel("Username");
        labelName.setBounds(40, 20,100,20);
        add(labelName);

        textFieldName = new JTextField();
        textFieldName.setBounds(150,20,150,20);
        add(textFieldName);

        JLabel passName = new JLabel("Password");
        passName.setBounds(40, 70, 100, 20);
        add(passName);

        passFieldName = new JPasswordField();
        passFieldName.setBounds(150,70,150,20);
        add(passFieldName);

        login = new JButton("Login");
        login.setBounds(40,140,120,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        back = new JButton("Back");
        back.setBounds(180,140,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/second.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(350,20,200,200);
        add(img);

        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icon/loginback.png"));
        Image i22 = i11.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i22);
        JLabel image = new JLabel(i33);
        image.setBounds(0,0,600,300);
        add(image);

        setSize(600,300);
        setLocation(350,200);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == login){
            String username = textFieldName.getText();
            String password = passFieldName.getText();

            String query = "SELECT * FROM login WHERE username = '"+username+"' AND password = '"+password+"'";
            try{
                Connectivity c = new Connectivity();
                ResultSet resultSet = c.statement.executeQuery(query);
                if(resultSet.next()){
                    setVisible(false);
                    //next class
                    new main_next();
                }
                else {
                    JOptionPane.showMessageDialog(null,"Invalid Username or Password");
                }
            }
            catch (Exception E){
                E.printStackTrace();
            }
        }
        else{
            setVisible(false);
        }
    }
}
