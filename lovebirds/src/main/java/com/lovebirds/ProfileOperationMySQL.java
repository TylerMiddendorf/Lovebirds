package com.lovebirds;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class ProfileOperationMySQL extends ProfileOperation{  

    /*
     * Need to add params to these functions as well as chain the functions in profilehandler to these
     */

    private MySQLDatabase db;

    public ProfileOperationMySQL(MySQLDatabase db) {
        this.db = db;
    }

    public boolean createProfile(Profile profile){

        try {

            this.db.connect();
            Connection dbConn = db.getConnection();
            String sql = "INSERT INTO PROFILE (USERNAME, EMAIL, FIRSTNAME, LASTNAME, PROFILEPICTURE, AGE, HEIGHT, WEIGHT, GENDER, PASSWORD) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = dbConn.prepareStatement(sql);
            pstmt.setString(1, profile.getUsername());
            pstmt.setString(2, profile.getEmail());
            pstmt.setString(3, profile.getFirstName());
            pstmt.setString(4, profile.getLastName());
            pstmt.setString(5, profile.getProfilePicture());
            pstmt.setInt(6, profile.getAge());
            pstmt.setInt(7, profile.getHeight());
            pstmt.setInt(8, profile.getWeight());
            pstmt.setString(9, profile.getGender());
            pstmt.setString(10, profile.getPassword());
            return true;
            
        } catch (SQLException e) {
            System.out.println("Could not create profile. Please try again.");
            return false;
        }
            

    }

    public Profile readProfile(int userID){
        return null;
    }

    public boolean updateProfile(Profile profile){
        return true;
    }

    public boolean deleteProfile(int userID){
        return true;
    }

    public Preferences createPreferences(int userID, Preferences newPref){
        return null;
    }

    public Preferences readPreferences(int userID){
        return null;
    }

    public boolean updatePreferences(int userID, Preferences newPref){
        return true;
    }

    public boolean deletePreferences(int userID){
        return true;
    }
}
