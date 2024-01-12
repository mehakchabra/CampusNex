package CampusNex;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AddStudent extends JFrame implements ActionListener {
    Random ran = new Random();
    long f4 = Math.abs((ran.nextLong() % 9000L) + 1000L);
    JLabel stu;
    JDateChooser sdob;
    JTextField studentName, studentFatherName, textAddress, textPhone, textEmail, textM10, textM12, textAADHAR;
    JComboBox courseBox, branchBox;
    JButton submit,cancel;
    AddStudent(){
        getContentPane().setBackground(new Color(128,176,255));

        //heading
        JLabel heading = new JLabel("New Student Details");
        heading.setBounds(270,30,500,50);
        heading.setFont(new Font("serif",Font.BOLD,30));
        add(heading);

        //name
        JLabel name = new JLabel("Name");
        name.setBounds(50,150,100,30);
        name.setFont(new Font("serif",Font.BOLD,20));
        add(name);

        studentName = new JTextField();
        studentName.setBounds(185,150,200,30);
        add(studentName);


        //father name
        JLabel fName = new JLabel("Father Name");
        fName.setBounds(440,150,200,30);
        fName.setFont(new Font("serif",Font.BOLD,20));
        add(fName);

        studentFatherName = new JTextField();
        studentFatherName.setBounds(575,150,200,30);
        add(studentFatherName);

        //employee id
        JLabel stuId = new JLabel("Roll No.");
        stuId.setBounds(50,200,200,30);
        stuId.setFont(new Font("serif",Font.BOLD,20));
        add(stuId);

        stu = new JLabel("2024"+f4);
        stu.setBounds(200,200,200,30);
        stu.setFont(new Font("serif",Font.BOLD,20));
        add(stu);

        //Date of Birth
        JLabel dob = new JLabel("Date of Birth");
        dob.setBounds(440,200,200,30);
        dob.setFont(new Font("serif",Font.BOLD,20));
        add(dob);

        sdob = new JDateChooser();
        sdob.setBounds(575,200,200,30);
        add(sdob);

        //address
        JLabel address = new JLabel("Address");
        address.setBounds(50,250,200,30);
        address.setFont(new Font("serif",Font.BOLD,20));
        add(address);

        textAddress = new JTextField();
        textAddress.setBounds(185,250,200,30);
        add(textAddress);

        //phone number
        JLabel phone = new JLabel("Phone");
        phone.setBounds(440,250,200,30);
        phone.setFont(new Font("serif",Font.BOLD,20));
        add(phone);

        textPhone = new JTextField();
        textPhone.setBounds(575,250,200,30);
        add(textPhone);

        //email
        JLabel email = new JLabel("Email");
        email.setBounds(50,300,200,30);
        email.setFont(new Font("serif",Font.BOLD,20));
        add(email);

        textEmail = new JTextField();
        textEmail.setBounds(185,300,200,30);
        add(textEmail);

        //10th marks
        JLabel m10 = new JLabel("Class X(%)");
        m10.setBounds(440,300,200,30);
        m10.setFont(new Font("serif",Font.BOLD,20));
        add(m10);

        textM10 = new JTextField();
        textM10.setBounds(575,300,200,30);
        add(textM10);

        //12th marks
        JLabel m12 = new JLabel("Class XII(%)");
        m12.setBounds(440,350,200,30);
        m12.setFont(new Font("serif",Font.BOLD,20));
        add(m12);

        textM12 = new JTextField();
        textM12.setBounds(575,350,200,30);
        add(textM12);

        //12th marks
        JLabel aadhar = new JLabel("AADHAR ");
        aadhar.setBounds(50,350,200,30);
        aadhar.setFont(new Font("serif",Font.BOLD,20));
        add(aadhar);

        textAADHAR = new JTextField();
        textAADHAR.setBounds(185,350,200,30);
        add(textAADHAR);

        //Qualification
        JLabel degree = new JLabel("Course");
        degree.setBounds(50,400,200,30);
        degree.setFont(new Font("serif",Font.BOLD,20));
        add(degree);

        String Degree[] = {"B.Tech","BBA","BCA","BSC","MSC","MBS","MCA","M.Com.","BA","MA"};
        courseBox = new JComboBox(Degree);
        courseBox.setBounds(185,400,200,30);
        courseBox.setBackground(Color.WHITE);
        add(courseBox);

        //department
        JLabel branch = new JLabel("Branch");
        branch.setBounds(440,400,200,30);
        branch.setFont(new Font("serif",Font.BOLD,20));
        add(branch);

        String Branch[] = {"Computer Science", "Electronics", "Mechanical","Civil","IT"};
        branchBox = new JComboBox(Branch);
        branchBox.setBounds(575,400,200,30);
        branchBox.setBackground(Color.WHITE);
        add(branchBox);

        //submit button
        submit = new JButton("Submit");
        submit.setBounds(250,500,120,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        //cancel button
        cancel = new JButton("Cancel");
        cancel.setBounds(450,500,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);


        setSize(850, 650);
        setLocation(250, 0);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == submit){
            //facultyName, facultyFatherName, textAddress, textPhone, textEmail, textM10, textM12, textAADHAR;
            String name = studentName.getText();
            String fname = studentFatherName.getText();
            String rollno = stu.getText();
            String dob = ((JTextField) sdob.getDateEditor().getUiComponent()).getText();
            String address = textAddress.getText();
            String phone = textPhone.getText();
            String email = textEmail.getText();
            String x = textM10.getText();
            String xii = textM12.getText();
            String aadhar = textAADHAR.getText();
            String degree = (String) courseBox.getSelectedItem();
            String branch = (String) branchBox.getSelectedItem();

            try {

                String q = "INSERT INTO student VALUES('"+name+"','"+fname+"', '"+rollno+"', '"+dob+"','"+address+"', '"+phone+"', '"+email+"','"+x+"', '"+xii+"', '"+aadhar+"', '"+degree+"', '"+branch+"')";
                Connectivity c = new Connectivity();
                c.statement.executeUpdate(q);
                JOptionPane.showMessageDialog(null,"Details Inserted");
                setVisible(false);

            }
            catch (Exception E){
                E.printStackTrace();
            }
        }
        else{
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddStudent();
    }
}
