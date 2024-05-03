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
            System.out.println(e.getSQLState());
            System.out.println(e.getNextException());
            System.out.println("Could not create profile. Please try again.");
            return false;
        }
            
    }

    public Profile readProfile(int userID) {

        try {
            this.db.connect();
            Connection dbConn = db.getConnection();
            String sql = "SELECT * FROM PROFILE WHERE USER_ID = ?";
            PreparedStatement pstmt = dbConn.prepareStatement(sql);
            pstmt.setInt(1, userID);
            ResultSet rs = pstmt.executeQuery();

            String username = rs.getString(1);
            String email = rs.getString(2);
            String firstName = rs.getString(3);
            String lastName = rs.getString(4);
            String profilePic = rs.getString(5);
            int age = rs.getInt(6);
            int height = rs.getInt(7);
            int weight = rs.getInt(8);
            String gender = rs.getString(9);
            String password = rs.getString(10);
            Profile newProfile = new Profile(username, email, firstName, lastName, profilePic, age, height, weight, gender, password);
            return newProfile;
            
        } catch (SQLException e) {
            System.out.println("Could not find profile.");
            return null;
        }
        
    }

    public boolean updateProfile(Profile profile) {

        try {
            this.db.connect();
            Connection dbConn = db.getConnection();
            String sql = "UPDATE PROFILE SET USERNAME = ? AND FIRSTNAME = ? AND LASTNAME = ? AND HEIGHT = ? AND WEIGHT = ? AND AGE = ? AND GENDER = ? AND PROFILEPICTURE = ? WHERE USER_ID = ?";
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
            pstmt.executeQuery();
            return true;
            
        } catch (SQLException e) {
            System.out.println("Could not update profile.");
            return false;
        }
        
    }

    public boolean deleteProfile(int userID) {

        try {
            this.db.connect();
            Connection dbConn = db.getConnection();
            String sql = "DELETE FROM Profile WHERE USER_ID = ?";
            PreparedStatement pstmt = dbConn.prepareStatement(sql);
            pstmt.setInt(1, userID);
            pstmt.executeQuery();
            return true;

        } catch (SQLException e) {
            System.out.println("Profile could not be deleted.");
            return false;
        }
       
    }

    public boolean createPreferences(int userID, Preferences newPref) {

        try {
            this.db.connect();
            Connection dbConn = db.getConnection();
            String sql = "INSERT INTO PREFERENCES(USERID, PREFERREDGENDER, MINHEIGHT, MAXHEIGHT, MINWEIGHT, MAXWEIGHT, MINAGE, MAXAGE) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = dbConn.prepareStatement(sql);
            pstmt.setInt(1, userID);
            pstmt.setString(2, newPref.getPreferredGender());
            pstmt.setInt(3, newPref.getMinHeight());
            pstmt.setInt(4, newPref.getMaxHeight());
            pstmt.setInt(5, newPref.getMinWeight());
            pstmt.setInt(6, newPref.getMaxWeight());
            pstmt.setInt(7, newPref.getMinAge());
            pstmt.setInt(8, newPref.getMaxAge());
            pstmt.executeQuery();
            return true;
        } catch (SQLException e) {
            System.out.println("Could not create preferences.");
            return false;
        }
    }

    public Preferences readPreferences(int userID) {
        try {
            this.db.connect();
            Connection dbConn = db.getConnection();
            String sql = "SELECT * FROM PREFERNECES WHERE USER_ID = ?";
            PreparedStatement pstmt = dbConn.prepareStatement(sql);
            pstmt.setInt(1, userID);
            ResultSet rs = pstmt.executeQuery();

            String preferredGender = rs.getString(0);
            int minHeight = rs.getInt(1);
            int maxHeight = rs.getInt(2);
            int minWeight = rs.getInt(3);
            int maxWeight = rs.getInt(4);
            int minAge = rs.getInt(5);
            int maxAge = rs.getInt(6);
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
            String sql = "UPDATE PREFERENCES SET MinHeight = ? AND MaxHeight = ? AND MinAge = ? AND MaxAge = ? AND MaxWeight = ? AND MinWeight = ? AND PreferedGender = ? AND WHERE USER_ID = ?";
            PreparedStatement pstmt = dbConn.prepareStatement(sql);
            pstmt.setInt(1, newPref.getMinHeight());
            pstmt.setInt(2, newPref.getMaxHeight());
            pstmt.setInt(3, newPref.getMinAge());
            pstmt.setInt(4, newPref.getMaxAge());
            pstmt.setInt(5, newPref.getMaxWeight());
            pstmt.setInt(6, newPref.getMinWeight());
            pstmt.setString(7, newPref.getPreferredGender());
            pstmt.setInt(8, userID);
            pstmt.executeQuery();
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
            String sql = "DELETE FROM Preferences WHERE USER_ID = ?";
            PreparedStatement pstmt = dbConn.prepareStatement(sql);
            pstmt.setInt(1, userID);
            return true;
        } catch (SQLException e) {
            System.out.println("Could not delete preferences.");
            return false;
        }
    }
}
