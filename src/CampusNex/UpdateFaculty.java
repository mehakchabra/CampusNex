package CampusNex;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class UpdateFaculty extends JFrame implements ActionListener {
    JTextField textAddress,textPhone,textemail,textAadhar,texteducation,textdepartment;
    JLabel empText;
    JButton update, cancel;
    Choice choiceEID;
    UpdateFaculty(){

        getContentPane().setBackground(new Color(230,210,252));

        JLabel heading = new JLabel("Update Faculty Details");
        heading.setBounds(50,10,500,50);
        heading.setFont(new Font("serif",Font.BOLD,35));
        add(heading);

        JLabel empID = new JLabel("Select Employee Id");
        empID.setBounds(50,100,200,20);
        empID.setFont(new Font("serif", Font.BOLD,20));
        add(empID);

        choiceEID = new Choice();
        choiceEID.setBounds(250,100,200,20);
        add(choiceEID);

        try{
            Connectivity c = new Connectivity();
            ResultSet rs = c.statement.executeQuery("select * from teacher");
            while (rs.next()){
                choiceEID.add(rs.getString("empid"));
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

        JLabel empIDD = new JLabel("Employee ID");
        empIDD.setBounds(50,200,200,30);
        empIDD.setFont(new Font("serif",Font.BOLD,20));
        add(empIDD);

        empText = new JLabel();
        empText.setBounds(200,200,150,30);
        empText.setFont(new Font("serif",Font.BOLD,20));
        add(empText);

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

        texteducation = new JTextField();
        texteducation.setBounds(200,400,150,30);
        add(texteducation);


        JLabel Department = new JLabel("Department");
        Department.setBounds(400,400,200,30);
        Department.setFont(new Font("serif",Font.BOLD,20));
        add(Department);

        textdepartment = new JTextField();
        textdepartment.setBounds(600,400,150,30);
        add(textdepartment);

        try{
            Connectivity c = new Connectivity();
            String query = "select * from teacher where empid = '"+choiceEID.getSelectedItem()+"'";
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
                empText.setText(resultSet.getString("empid"));
                texteducation.setText(resultSet.getString("education"));
                textdepartment.setText(resultSet.getString("department"));
            }

        }catch (Exception E){
            E.printStackTrace();
        }

        choiceEID.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try {
                    Connectivity c = new Connectivity();
                    String query = "select * from teacher where empId = '"+choiceEID.getSelectedItem()+"'";
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
                        empText.setText(resultSet.getString("empid"));
                        texteducation.setText(resultSet.getString("education"));
                        textdepartment.setText(resultSet.getString("department"));
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
            String empid = empText.getText();
            String address = textAddress.getText();
            String phone = textPhone.getText();
            String email = textemail.getText();
            String education = texteducation.getText();
            String department = textdepartment.getText();

            try {
                String Q = "update teacher set address = '"+address+"', phone = '"+phone+"', email = '"+email+"', education = '"+education+"', department = '"+department+"' where empId = '"+empid+"'";
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
        new UpdateFaculty();
    }
}