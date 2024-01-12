package CampusNex;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class FacultyLeaveDetails extends JFrame implements ActionListener {

    Choice choiceEmpID;
    JTable table;

    JButton search,print,cancel;

    FacultyLeaveDetails(){
        getContentPane().setBackground(new Color(250,231,243));

        JLabel heading = new JLabel("Search By Employee ID");
        heading.setBounds(20,20,150,20);
        add(heading);

        choiceEmpID = new Choice();
        choiceEmpID.setBounds(180,20,150,20);
        add(choiceEmpID);

        try{
            Connectivity c = new Connectivity();
            ResultSet resultSet = c.statement.executeQuery("select * from teacher");
            while (resultSet.next()){
                choiceEmpID.add(resultSet.getString("empid"));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        table = new JTable();
        try{
            Connectivity c = new Connectivity();
            ResultSet resultSet = c.statement.executeQuery("select * from teacherleave");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }
        catch (Exception e){
            e.printStackTrace();
        }

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0,100,900,600);
        add(scrollPane);

        search = new JButton("Search");
        search.setBounds(20,70,80,20);
        search.setBackground(new Color(115,96,223));
        search.setForeground(Color.WHITE);
        search.addActionListener(this);
        add(search);

        print = new JButton("Print");
        print.setBounds(120,70,80,20);
        print.setBackground(new Color(115,96,223));
        print.setForeground(Color.WHITE);
        print.addActionListener(this);
        add(print);

        cancel = new JButton("Cancel");
        cancel.setBounds(220,70,80,20);
        cancel.setBackground(new Color(115,96,223));
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);


        setSize(900,650);
        setLocation(200,10);
        setLayout(null);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == search){
            String q = "select * from teacherleave where empid = '"+choiceEmpID.getSelectedItem()+"'";
            try {
                Connectivity c = new Connectivity();
                ResultSet resultSet = c.statement.executeQuery(q);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));
            }
            catch (Exception E){
                E.printStackTrace();
            }
        } else if (e.getSource() == print) {
            try{
            table.print();
            }
            catch (Exception E){
                E.printStackTrace();
            }
        }
        else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new FacultyLeaveDetails();
    }
}
