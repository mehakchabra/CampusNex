package CampusNex;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class StudentDetails extends JFrame implements ActionListener {
    Choice choice;
    JTable table;
    JButton search,print,update,add,cancel;
    StudentDetails(){
        getContentPane().setBackground(new Color(210,252,218));

        JLabel heading = new JLabel("Search By Roll Number");
        heading.setBounds(20,20,150,20);
        add(heading);

        choice = new Choice();
        choice.setBounds(180,20,150,20);
        add(choice);

        try{
            Connectivity c = new Connectivity();
            ResultSet resultSet = c.statement.executeQuery("Select * from student");
            while(resultSet.next()){
                choice.add(resultSet.getString("roll"));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        table = new JTable();
        try{
            Connectivity c = new Connectivity();
            ResultSet resultSet = c.statement.executeQuery("Select * from student");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }
        catch (Exception e){
            e.printStackTrace();
        }

        JScrollPane jc = new JScrollPane(table);
        jc.setBounds(0,100,900,600);
        add(jc);

        search = new JButton("Search");
        search.setBounds(20,70,80,20);
        search.addActionListener(this);
        add(search);

        print = new JButton("Print");
        print.setBounds(120,70,80,20);
        print.addActionListener(this);
        add(print);

        add = new JButton("Add");
        add.setBounds(220,70,80,20);
        add.addActionListener(this);
        add(add);

        update = new JButton("Update");
        update.setBounds(320,70,80,20);
        update.addActionListener(this);
        add(update);

        cancel = new JButton("Cancel");
        cancel.setBounds(420,70,80,20);
        cancel.addActionListener(this);
        add(cancel);


        setSize(850, 650);
        setLocation(250, 0);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == search){
            String q = "select * from student where roll = '"+choice.getSelectedItem()+"'";
            try{
                Connectivity c = new Connectivity();
                ResultSet resultSet = c.statement.executeQuery(q);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));
            }
            catch (Exception E){
                E.printStackTrace();
            }
        } else if (e.getSource() == print) {
            try {
                table.print();
            }
            catch (Exception E){
                E.printStackTrace();
            }
        }
        else if (e.getSource() == add) {
            setVisible(false);
            new AddStudent();
        } else if (e.getSource() == update) {

        }
        else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new StudentDetails();
    }
}
