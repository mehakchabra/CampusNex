package CampusNex;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AddFaculty extends JFrame implements ActionListener {
    Random ran = new Random();
    long f4 = Math.abs((ran.nextLong() % 9000L) + 1000L);
    JLabel emp;
    JDateChooser cdob;
    JTextField facultyName, facultyFatherName, textAddress, textPhone, textEmail, textM10, textM12, textAADHAR;
    JComboBox courseBox, departmentBox;
    JButton submit,cancel;

    AddFaculty(){
        getContentPane().setBackground(new Color(166,164,252));

        //heading
        JLabel heading = new JLabel("New Teacher Details");
        heading.setBounds(270,30,500,50);
        heading.setFont(new Font("serif",Font.BOLD,30));
        add(heading);

        //name
        JLabel name = new JLabel("Name");
        name.setBounds(50,150,100,30);
        name.setFont(new Font("serif",Font.BOLD,20));
        add(name);

        facultyName = new JTextField();
        facultyName.setBounds(185,150,200,30);
        add(facultyName);


        //father name
        JLabel fName = new JLabel("Father Name");
        fName.setBounds(440,150,200,30);
        fName.setFont(new Font("serif",Font.BOLD,20));
        add(fName);

        facultyFatherName = new JTextField();
        facultyFatherName.setBounds(575,150,200,30);
        add(facultyFatherName);

        //employee id
        JLabel empId = new JLabel("Employee ID");
        empId.setBounds(50,200,200,30);
        empId.setFont(new Font("serif",Font.BOLD,20));
        add(empId);

        emp = new JLabel("1502"+f4);
        emp.setBounds(200,200,200,30);
        emp.setFont(new Font("serif",Font.BOLD,20));
        add(emp);

        //Date of Birth
        JLabel dob = new JLabel("Date of Birth");
        dob.setBounds(440,200,200,30);
        dob.setFont(new Font("serif",Font.BOLD,20));
        add(dob);

        cdob = new JDateChooser();
        cdob.setBounds(575,200,200,30);
        add(cdob);

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
        m12.setBounds(50,350,200,30);
        m12.setFont(new Font("serif",Font.BOLD,20));
        add(m12);

        textM12 = new JTextField();
        textM12.setBounds(185,350,200,30);
        add(textM12);

        //12th marks
        JLabel aadhar = new JLabel("AADHAR ");
        aadhar.setBounds(440,350,200,30);
        aadhar.setFont(new Font("serif",Font.BOLD,20));
        add(aadhar);

        textAADHAR = new JTextField();
        textAADHAR.setBounds(575,350,200,30);
        add(textAADHAR);

        //Qualification
        JLabel qualification = new JLabel("Qualification");
        qualification.setBounds(50,400,200,30);
        qualification.setFont(new Font("serif",Font.BOLD,20));
        add(qualification);

        String course[] = {"B.Tech","BBA","BCA","BSC","MSC","MBS","MCA","M.Com.","BA","MA"};
        courseBox = new JComboBox(course);
        courseBox.setBounds(185,400,200,30);
        courseBox.setBackground(Color.WHITE);
        add(courseBox);

        //department
        JLabel department = new JLabel("Department");
        department.setBounds(440,400,200,30);
        department.setFont(new Font("serif",Font.BOLD,20));
        add(department);

        String Department[] = {"Computer Science", "Electronics", "Mechanical","Civil","IT"};
        departmentBox = new JComboBox(Department);
        departmentBox.setBounds(575,400,200,30);
        departmentBox.setBackground(Color.WHITE);
        add(departmentBox);

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
            String name = facultyName.getText();
            String fname = facultyFatherName.getText();
            String empid = emp.getText();
            String dob = ((JTextField) cdob.getDateEditor().getUiComponent()).getText();
            String address = textAddress.getText();
            String phone = textPhone.getText();
            String email = textEmail.getText();
            String x = textM10.getText();
            String xii = textM12.getText();
            String aadhar = textAADHAR.getText();
            String course = (String) courseBox.getSelectedItem();
            String department = (String) departmentBox.getSelectedItem();

            try {

                String q = "INSERT INTO teacher VALUES('"+name+"','"+fname+"', '"+empid+"', '"+dob+"','"+address+"', '"+phone+"', '"+email+"','"+x+"', '"+xii+"', '"+aadhar+"', '"+course+"', '"+department+"')";
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
        new AddFaculty();
    }
}
