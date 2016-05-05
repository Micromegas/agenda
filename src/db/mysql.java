package db;

import java.sql.*;
import javax.swing.JOptionPane;

public class mysql{
    private static String user="root";
    private static String pass="21579097";
    private static String db="agenda";
    private static Connection Conn;
    public static Connection getConnect(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Conn = DriverManager.getConnection("jdbc:mysql://localhost/"+db,user,pass);
            System.out.println("Conexión establecida");
            //JOptionPane.showMessageDialog(null,"Conexión establecida");
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("Error de conexión");
            JOptionPane.showMessageDialog(null,"Error de conexión: " + e.getMessage());
        }
        return Conn;
    }
}