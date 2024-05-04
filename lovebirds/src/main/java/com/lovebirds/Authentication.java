package com.lovebirds;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Authentication {

    public static Database db;
    /*
     * handles login of account
     * @param username and password
     * @returns int exception handling?
     */
    public static int authenticateLogIn(String username, String password)
    {

        try {

            db = FactoryProducer.getSQLFactory().getDatabase("MySQL");
            db.connect();
            Connection dbConn = db.getConnection();
            String sql = "SELECT * FROM lovebirds_schema.PROFILE WHERE USERNAME = ? AND PASSWORD = ?";
            PreparedStatement pstmt = dbConn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            if(rs.getFetchSize() < 1) {
                return -1;
            }

            int userID = rs.getInt(0);
            return userID;

        } catch (SQLException e) {
            System.out.println(e.getSQLState());
            System.out.println(e.getNextException());
            System.out.println(e.getMessage());
            System.out.println("Could not log into the profile with the profile information provided.\nPlease try again.");
            return -1;
        }
    }

    /**
     * Searches for profile record in database with user entered information
     * @param email - user's email
     * @param username - user's username
     * @param newPassword - new password user wants
     * @return true if the Profile is found, false if otherwise 
     */
    public static boolean authenticateForgotPassword(String email, String username, String newPassword){
        
        try {

            // Check if the profile is found 
            db = FactoryProducer.getSQLFactory().getDatabase("MySQL");
            db.connect();
            Connection dbConn = db.getConnection();
            String sql = "SELECT * FROM PROFILE WHERE EMAIL = ? AND USERNAME = ?";
            PreparedStatement pstmt = dbConn.prepareStatement(sql);
            pstmt.setString(1, email);
            pstmt.setString(2, username);
            ResultSet rs = pstmt.executeQuery();

            // If the user is not found, then the ResultSet will fetch 0 rows
            if(rs.getFetchSize() == 0) {
                return false;
            }

            int userID = rs.getInt(0);
            String firstName = rs.getString(3);
            String lastName = rs.getString(4);
            String profilePic = rs.getString(5);
            int age = rs.getInt(6);
            int height = rs.getInt(7);
            int weight = rs.getInt(8);
            String gender = rs.getString(9);

            String sqlUpdate = "UPDATE PROFILE SET USERNAME = ? AND FIRSTNAME = ? AND LASTNAME = ? AND HEIGHT = ? AND WEIGHT = ? AND AGE = ? AND GENDER = ? AND PROFILEPICTURE = ? WHERE USER_ID = ?";
            PreparedStatement updatePstmt = dbConn.prepareStatement(sqlUpdate);
            updatePstmt.setInt(0, userID);
            updatePstmt.setString(1, username);
            updatePstmt.setString(2, email);
            updatePstmt.setString(3, firstName);
            updatePstmt.setString(4, lastName);
            updatePstmt.setString(5, profilePic);
            updatePstmt.setInt(6, age);
            updatePstmt.setInt(7, height);
            updatePstmt.setInt(8, weight);
            updatePstmt.setString(9, gender);
            updatePstmt.setString(10, newPassword);
            updatePstmt.executeQuery();
            return true;
            
        } catch (SQLException e) {
            System.out.println("Could not find profile to update password. Please try again");
            return false;
        }

    }
}
