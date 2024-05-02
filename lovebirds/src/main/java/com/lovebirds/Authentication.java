package com.lovebirds;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.PreparableStatement;

public class Authentication {

    public static Database db;
    /*
     * handles login of account
     * @param username and password
     * @returns int exception handling?
     */
    public static int logIn(String username, String password)
    {
        //db = FactoryProducer.getDatabase();
        return 0;
    }

    /*
     * handles logout of account
     */
    public void logOut(){

    }

    /**
     * Searches for profile record in database with user entered information
     * @param email - user's email
     * @param username - user's username
     * @return Profile object
     */
    public static Profile authenticateForgotPassword(String email, String username){
        
        try {

            db = FactoryProducer.getSQLFactory().getDatabase("MySQL");
            db.connect();
            Connection dbConn = db.getConnection();
            String sql = "SELECT * FROM PROFILE WHERE EMAIL = ? AND USERNAME = ?";
            PreparedStatement pstmt = dbConn.prepareStatement(sql);
            pstmt.setString(1, email);
            pstmt.setString(2, username);
            ResultSet rs = pstmt.executeQuery();

            int userID = rs.getInt(0);
            String firstName = rs.getString(3);
            String lastName = rs.getString(4);
            String profilePic = rs.getString(5);
            int age = rs.getInt(6);
            int height = rs.getInt(7);
            int weight = rs.getInt(8);
            String gender = rs.getString(9);
            String password = rs.getString(10);

            Profile authenticated = new Profile(userID, email, username, password, firstName, lastName);
            return authenticated;
            
        } catch (SQLException e) {
            // TODO: handle exception
        }
           
        return null;
    }
}
