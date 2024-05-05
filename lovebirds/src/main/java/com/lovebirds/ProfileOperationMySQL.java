package com.lovebirds;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ProfileOperationMySQL extends ProfileOperation{  

    /*
     * Need to add params to these functions as well as chain the functions in profilehandler to these
     */

    private MySQLDatabase db;

    public ProfileOperationMySQL(MySQLDatabase db) {
        this.db = db;
    }

    public boolean createProfile(Profile profile) {

        try {
            this.db.connect();
            Connection dbConn = db.getConnection();
            String sql = "INSERT INTO lovebirds_schema.PROFILE (USERNAME, EMAIL, FIRST_NAME, LAST_NAME, PROFILE_PICTURE, AGE, HEIGHT, WEIGHT, GENDER, PASSWORD) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
            pstmt.executeUpdate();
            pstmt.close();
            return true;
            
        } catch (SQLException e) {
            System.out.println("Could not create profile. Please try again.");
            return false;
        }
            
    }

    public Profile readProfile(int userID) {

        try {
            this.db.connect();
            Connection dbConn = db.getConnection();
            String sql = "SELECT * FROM lovebirds_schema.PROFILE WHERE USER_ID = ?";
            PreparedStatement pstmt = dbConn.prepareStatement(sql);
            pstmt.setInt(1, userID);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            
            String username = rs.getString(2);
            String email = rs.getString(3);
            String firstName = rs.getString(4);
            String lastName = rs.getString(5);
            String profilePic = rs.getString(6);
            int age = rs.getInt(7);
            int height = rs.getInt(8);
            int weight = rs.getInt(9);
            String gender = rs.getString(10);
            String password = rs.getString(11);
            Profile newProfile = new Profile(userID, username, email, firstName, lastName, profilePic, age, height, weight, gender, password);
            return newProfile;
            
        } catch (SQLException e) {
            System.out.println("Could not log in to profile.");
            return null;
        }
        
    }

    public boolean updateProfile(Profile profile) {

        try {
            this.db.connect();
            Connection dbConn = db.getConnection();
            String sql = "UPDATE lovebirds_schema.PROFILE SET USERNAME = ?, EMAIL = ?, FIRST_NAME = ?, LAST_NAME = ?, PROFILE_PICTURE = ?, AGE = ?, WEIGHT = ?, HEIGHT = ?, GENDER = ?, PASSWORD = ? WHERE USER_ID = ?";
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
            pstmt.setInt(11, profile.getProfileID());
            pstmt.executeUpdate();
            return true;
            
        } catch (SQLException e) {
            System.out.println("Could not update profile.");
            return false;
        }
        
    }

    public boolean deleteProfile(int userID) {

        deletePreferences(userID);

        try {
            this.db.connect();
            Connection dbConn = db.getConnection();
            String sql = "DELETE FROM lovebirds_schema.PROFILE WHERE USER_ID = ?";
            PreparedStatement pstmt = dbConn.prepareStatement(sql);
            pstmt.setInt(1, userID);
            pstmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println(e.getSQLState());
            System.out.println(e.getNextException());
            System.out.println(e.getMessage());
            System.out.println("Profile could not be deleted.");
            return false;
        }
    }

    public boolean createPreferences(int userID, Preferences newPref) {

        try {
            this.db.connect();
            Connection dbConn = db.getConnection();
            String sql = "INSERT INTO lovebirds_schema.PREFERENCES(USER_ID, MIN_HEIGHT, MAX_HEIGHT, MIN_WEIGHT, MAX_WEIGHT, MIN_AGE, MAX_AGE, PREFERRED_GENDER) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = dbConn.prepareStatement(sql);
            pstmt.setInt(1, userID);
            pstmt.setInt(2, newPref.getMinHeight());
            pstmt.setInt(3, newPref.getMaxHeight());
            pstmt.setInt(4, newPref.getMinWeight());
            pstmt.setInt(5, newPref.getMaxWeight());
            pstmt.setInt(6, newPref.getMinAge());
            pstmt.setInt(7, newPref.getMaxAge());
            pstmt.setString(8, newPref.getPreferredGender());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getSQLState());
            System.out.println(e.getMessage());
            System.out.println("Could not create preferences.");
            return false;
        }
    }

    public Preferences readPreferences(int userID) {
        try {
            this.db.connect();
            Connection dbConn = db.getConnection();
            String sql = "SELECT * FROM lovebirds_schema.PREFERENCES WHERE USER_ID = ?";
            PreparedStatement pstmt = dbConn.prepareStatement(sql);
            pstmt.setInt(1, userID);
            ResultSet rs = pstmt.executeQuery();
            rs.next();

            int minHeight = rs.getInt(2);
            int maxHeight = rs.getInt(3);
            int minWeight = rs.getInt(4);
            int maxWeight = rs.getInt(5);
            int minAge = rs.getInt(6);
            int maxAge = rs.getInt(7);
            String preferredGender = rs.getString(8);
            Preferences newPreferences = new Preferences(preferredGender, minHeight, maxHeight, minWeight, maxWeight, minAge, maxAge);
            return newPreferences;

        } catch (SQLException e) {
            System.out.println("Could not create preferences.");
            return null;
        }
    }

    public boolean updatePreferences(int userID, Preferences newPref) {
        try {
            this.db.connect();
            Connection dbConn = db.getConnection();
            String sql = "UPDATE lovebirds_schema.PREFERENCES SET MIN_HEIGHT = ? AND MAX_HEIGHT = ? AND MIN_AGE = ? AND MAX_AGE = ? AND MAX_WEIGHT = ? AND MIN_WEIGHT = ? AND PREFERRED_GENDER = ? WHERE USER_ID = ?";
            PreparedStatement pstmt = dbConn.prepareStatement(sql);
            pstmt.setInt(1, newPref.getMinHeight());
            pstmt.setInt(2, newPref.getMaxHeight());
            pstmt.setInt(3, newPref.getMinAge());
            pstmt.setInt(4, newPref.getMaxAge());
            pstmt.setInt(5, newPref.getMaxWeight());
            pstmt.setInt(6, newPref.getMinWeight());
            pstmt.setString(7, newPref.getPreferredGender());
            pstmt.setInt(8, userID);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Could not update preferences.");
            return false;
        }
    }

    public boolean deletePreferences(int userID) {
        try {
            this.db.connect();
            Connection dbConn = db.getConnection();
            String sql = "DELETE FROM lovebirds_schema.PREFERENCES WHERE USER_ID = ?";
            PreparedStatement pstmt = dbConn.prepareStatement(sql);
            pstmt.setInt(1, userID);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Could not delete preferences.");
            return false;
        }
    }
}
