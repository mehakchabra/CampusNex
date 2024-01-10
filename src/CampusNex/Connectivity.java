package CampusNex;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;


public class Connectivity {
    Connection connection;
    Statement statement;
    Connectivity(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql:///CampusNex","root", "Mehak@33Chabra");
            statement = connection.createStatement();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
