package lovebirds.src.main.java.com.lovebirds;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLDatabase extends Database {

    private String username;
    private String password;
    private Connection conn;

    public MySQLDatabase() {
        username = "root";
        conn = null;
    }

    public boolean connect(String password) {

        String path = "jdbc:mysql://localhost:3306/lovebirds_schema";

        try {
            conn = DriverManager.getConnection(path, username, password);
            return true;
        } catch (SQLException e) {
           
            System.out.println(e.getSQLState());
            System.out.println(e.getMessage());
            //System.out.println("Could not connect to database.");
            return false;
        }
    
    }  

    public Connection getConnection() {
        return conn;
    }

    public String getUsername() {
        return username;
    }  
    
    public static void main(String[] args) {
        MySQLDatabase db = new MySQLDatabase();
        System.out.println(db.connect("Root123!@#"));
    }
}

