package CampusNex;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class UpdateStudent extends JFrame implements ActionListener {

    JTextField textAddress,textPhone,textemail,textAadhar,textdegree,textbranch;
    JLabel stuText;
    JButton update, cancel;
    Choice choiceRoll;

    UpdateStudent(){
        getContentPane().setBackground(new Color(230,210,252));

        JLabel heading = new JLabel("Update Student Details");
        heading.setBounds(50,10,500,50);
        heading.setFont(new Font("serif",Font.BOLD,35));
        add(heading);

        JLabel stuRoll = new JLabel("Select Roll Number");
        stuRoll.setBounds(50,100,200,20);
        stuRoll.setFont(new Font("serif", Font.BOLD,20));
        add(stuRoll);

        choiceRoll = new Choice();
        choiceRoll.setBounds(250,100,200,20);
        add(choiceRoll);

        try{
            Connectivity c = new Connectivity();
            ResultSet rs = c.statement.executeQuery("select * from student");
            while (rs.next()){
                choiceRoll.add(rs.getString("roll"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }


        JLabel name = new JLabel("Name");
        name.setBounds(50,150,100,30);
        name.setFont(new Font("serif",Font.BOLD,20));
        add(name);

        JLabel textName = new JLabel();
        textName.setBounds(200,150,150,30);
        add(textName);

        JLabel fname = new JLabel("Father Name");
        fname.setBounds(400,150,200,30);
        fname.setFont(new Font("serif",Font.BOLD,20));
        add(fname);

        JLabel textfather = new JLabel();
        textfather.setBounds(600,150,150,30);
        add(textfather);

        JLabel rollNO = new JLabel("Employee ID");
        rollNO.setBounds(50,200,200,30);
        rollNO.setFont(new Font("serif",Font.BOLD,20));
        add(rollNO);

        stuText = new JLabel();
        stuText.setBounds(200,200,150,30);
        stuText.setFont(new Font("serif",Font.BOLD,20));
        add(stuText);

        JLabel dob = new JLabel("Date of Birth");
        dob.setBounds(400,200,200,30);
        dob.setFont(new Font("serif",Font.BOLD,20));
        add(dob);

        JLabel dobdob = new JLabel();
        dobdob.setBounds(600,200,150,30);
        add(dobdob);

        JLabel address = new JLabel("Address");
        address.setBounds(50,250,200,30);
        address.setFont(new Font("serif",Font.BOLD,20));
        add(address);

        textAddress = new JTextField();
        textAddress.setBounds(200,250,150,30);
        add(textAddress);

        JLabel phone = new JLabel("Phone");
        phone.setBounds(400,250,200,30);
        phone.setFont(new Font("serif",Font.BOLD,20));
        add(phone);

        textPhone = new JTextField();
        textPhone.setBounds(600,250,150,30);
        add(textPhone);

        JLabel email = new JLabel("Email");
        email.setBounds(50,300,200,30);
        email.setFont(new Font("serif",Font.BOLD,20));
        add(email);

        textemail = new JTextField();
        textemail.setBounds(200,300,150,30);
        add(textemail);

        JLabel M10 = new JLabel("Class X (%)");
        M10.setBounds(400,300,200,30);
        M10.setFont(new Font("serif",Font.BOLD,20));
        add(M10);

        JLabel textM10 = new JLabel();
        textM10.setBounds(600,300,150,30);
        add(textM10);

        JLabel M12 = new JLabel("Class XII (%)");
        M12.setBounds(50,350,200,30);
        M12.setFont(new Font("serif",Font.BOLD,20));
        add(M12);

        JLabel textM12 = new JLabel();
        textM12.setBounds(200,350,150,30);
        add(textM12);

        JLabel AadharNo = new JLabel("Aadhar Number");
        AadharNo.setBounds(400,350,200,30);
        AadharNo.setFont(new Font("serif",Font.BOLD,20));
        add(AadharNo);

        textAadhar = new JTextField();
        textAadhar.setBounds(600,350,150,30);
        add(textAadhar);

        JLabel Qualification = new JLabel("Qualification");
        Qualification.setBounds(50,400,200,30);
        Qualification.setFont(new Font("serif",Font.BOLD,20));
        add(Qualification);

        textdegree = new JTextField();
        textdegree.setBounds(200,400,150,30);
        add(textdegree);


        JLabel Department = new JLabel("Department");
        Department.setBounds(400,400,200,30);
        Department.setFont(new Font("serif",Font.BOLD,20));
        add(Department);

        textbranch = new JTextField();
        textbranch.setBounds(600,400,150,30);
        add(textbranch);

        try{
            Connectivity c = new Connectivity();
            String query = "select * from student where roll = '"+choiceRoll.getSelectedItem()+"'";
            ResultSet resultSet = c.statement.executeQuery(query);
            while (resultSet.next()){
                textName.setText(resultSet.getString("name"));
                textfather.setText(resultSet.getString("fname"));
                dobdob.setText(resultSet.getString("dob"));
                textAddress.setText(resultSet.getString("address"));
                textPhone.setText(resultSet.getString("phone"));
                textemail.setText(resultSet.getString("email"));
                textM10.setText(resultSet.getString("class_x"));
                textM12.setText(resultSet.getString("class_xii"));
                textAadhar.setText(resultSet.getString("aadhar"));
                stuText.setText(resultSet.getString("roll"));
                textdegree.setText(resultSet.getString("degree"));
                textbranch.setText(resultSet.getString("branch"));
            }

        }catch (Exception E){
            E.printStackTrace();
        }

        choiceRoll.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try {
                    Connectivity c = new Connectivity();
                    String query = "select * from teacher where empId = '"+choiceRoll.getSelectedItem()+"'";
                    ResultSet resultSet = c.statement.executeQuery(query);
                    while (resultSet.next()) {
                        textName.setText(resultSet.getString("name"));
                        textfather.setText(resultSet.getString("fname"));
                        dobdob.setText(resultSet.getString("dob"));
                        textAddress.setText(resultSet.getString("address"));
                        textPhone.setText(resultSet.getString("phone"));
                        textemail.setText(resultSet.getString("email"));
                        textM10.setText(resultSet.getString("class_x"));
                        textM12.setText(resultSet.getString("class_xii"));
                        textAadhar.setText(resultSet.getString("aadhar"));
                        stuRoll.setText(resultSet.getString("empid"));
                        textdegree.setText(resultSet.getString("degree"));
                        textbranch.setText(resultSet.getString("branch"));
                    }
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });



        update = new JButton("Update");
        update.setBounds(300,500,120,30);
        update.setBackground(Color.black);
        update.setForeground(Color.white);
        update.addActionListener(this);
        add(update);

        cancel = new JButton("Cancel");
        cancel.setBounds(450,500,120,30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        add(cancel);

        setSize(830,650);
        setLocation(200,10);
        setLayout(null);
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == update){
            String rollno = stuText.getText();
            String address = textAddress.getText();
            String phone = textPhone.getText();
            String email = textemail.getText();
            String degree = textdegree.getText();
            String branch = textbranch.getText();

            try {
                String Q = "update teacher set address = '"+address+"', phone = '"+phone+"', email = '"+email+"', education = '"+degree+"', department = '"+branch+"' where roll = '"+rollno+"'";
                Connectivity c = new Connectivity();
                c.statement.executeUpdate(Q);

                JOptionPane.showMessageDialog(null, "Details Updated");
                setVisible(false);

            }catch (Exception E){
                E.printStackTrace();
            }
        }else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new UpdateStudent();
    }
}
