package CampusNex;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class FacultyLeave extends JFrame implements ActionListener {

    Choice choiceEmpid, Time;

    JDateChooser setDate;
    JButton submit,cancel;
    FacultyLeave(){
        getContentPane().setBackground(new Color(210,232,252));

        JLabel heading = new JLabel("Apply Leave (Faculty)");
        heading.setBounds(120,20,300,30);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        add(heading);

        JLabel EmpIDSE = new JLabel("Search By Employee ID");
        EmpIDSE.setBounds(130,100,200,20);
        EmpIDSE.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(EmpIDSE);

        choiceEmpid = new Choice();
        choiceEmpid.setBounds(130,130,200,20);
        add(choiceEmpid);

        try{
            Connectivity c = new Connectivity();
            ResultSet resultSet = c.statement.executeQuery("select * from teacher");
            while (resultSet.next()){
                choiceEmpid.add(resultSet.getString("empid"));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        JLabel lblDate = new JLabel("Date");
        lblDate.setBounds(130,180,200,20);
        lblDate.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(lblDate);

        setDate = new JDateChooser();
        setDate.setBounds(130,210,200,25);
        add(setDate);

        JLabel time = new JLabel("Time Duration");
        time.setBounds(130,260,200,20);
        time.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(time);

        Time = new Choice();
        Time.setBounds(130,290,200,25);
        Time.add("Full Day");
        Time.add("Half Day");
        add(Time);

        submit = new JButton("Submit");
        submit.setBounds(120,350,100,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        //cancel button
        cancel = new JButton("Cancel");
        cancel.setBounds(260,350,100,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);


        setSize(500,500);
        setLocation(400,100);
        setLayout(null);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == submit){
            String empid = choiceEmpid.getSelectedItem();
            String date = ((JTextField) setDate.getDateEditor().getUiComponent()).getText();
            String duration = Time.getSelectedItem();
            String Q = "INSERT INTO teacherleave VALUES('"+empid+"', '"+date+"', '"+duration+"')";

            try{
                Connectivity c = new Connectivity();
                c.statement.executeUpdate(Q);
                JOptionPane.showMessageDialog(null,"Leave Confirm");
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
        new FacultyLeave();
    }
}
