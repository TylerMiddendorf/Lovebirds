package com.lovebirds;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MatchmakerOperationMySQL extends MatchmakerOperation{

    private MySQLDatabase db;

    public MatchmakerOperationMySQL(MySQLDatabase db) {
        this.db = db;
    }

    //not finished, do something with rating as well. call rating with -1 if not searching rating.
    public ArrayList<Profile> readProfilesThatMatchPreferences(Profile profile, double rating) {
        ArrayList<Profile> suggestedUsers = new ArrayList<Profile>();

        Preferences userPreferences = profile.getPreferences();
        String preferredGender = userPreferences.getPreferredGender();

        if(rating == -1)
        {
            if(!preferredGender.equals("Both"))
            {
                try {
                    this.db.connect();
                    Connection dbConn = db.getConnection();
                    String sql = "SELECT * FROM PROFILE WHERE AGE BETWEEN ? AND ? AND WEIGHT BETWEEN ? AND ? AND HEIGHT BETWEEN ? AND ? AND GENDER = ?";
                    PreparedStatement pstmt = dbConn.prepareStatement(sql);
                    pstmt.setInt(1, userPreferences.getMinAge());
                    pstmt.setInt(2, userPreferences.getMaxAge());
                    pstmt.setInt(3, userPreferences.getMinWeight());
                    pstmt.setInt(4, userPreferences.getMaxWeight());
                    pstmt.setInt(5, userPreferences.getMinHeight());
                    pstmt.setInt(6, userPreferences.getMaxHeight());
                    pstmt.setString(7, userPreferences.getPreferredGender());
                    ResultSet rs = pstmt.executeQuery();

                    return suggestedUsers;
                } catch (SQLException e) {
                    System.out.println("Could not create profile.");
                    return null;
                }
            }
            else // if it does = both, dont query gender
            {
                try 
                {
                    this.db.connect();
                    Connection dbConn = db.getConnection();
                    String sql = "SELECT * FROM PROFILE WHERE AGE BETWEEN ? AND ? AND WEIGHT BETWEEN ? AND ? AND HEIGHT BETWEEN ? AND ?";
                    PreparedStatement pstmt = dbConn.prepareStatement(sql);
                    pstmt.setInt(1, userPreferences.getMinAge());
                    pstmt.setInt(2, userPreferences.getMaxAge());
                    pstmt.setInt(3, userPreferences.getMinWeight());
                    pstmt.setInt(4, userPreferences.getMaxWeight());
                    pstmt.setInt(5, userPreferences.getMinHeight());
                    pstmt.setInt(6, userPreferences.getMaxHeight());
                    ResultSet rs = pstmt.executeQuery();

                    return suggestedUsers;
                } catch (SQLException e) {
                    System.out.println("Could not create profile.");
                    return null;
                }
            }
        } else // filter with rating
        {
            if(!preferredGender.equals("Both"))
            {
                try {
                    this.db.connect();
                    Connection dbConn = db.getConnection();
                    String sql = "SELECT * FROM PROFILE WHERE AGE BETWEEN ? AND ? AND WEIGHT BETWEEN ? AND ? AND HEIGHT BETWEEN ? AND ? AND GENDER = ?";
                    PreparedStatement pstmt = dbConn.prepareStatement(sql);
                    pstmt.setInt(1, userPreferences.getMinAge());
                    pstmt.setInt(2, userPreferences.getMaxAge());
                    pstmt.setInt(3, userPreferences.getMinWeight());
                    pstmt.setInt(4, userPreferences.getMaxWeight());
                    pstmt.setInt(5, userPreferences.getMinHeight());
                    pstmt.setInt(6, userPreferences.getMaxHeight());
                    pstmt.setString(7, userPreferences.getPreferredGender());
                    ResultSet rs = pstmt.executeQuery();

                    return suggestedUsers;
                } catch (SQLException e) {
                    System.out.println("Could not create profile.");
                    return null;
                }
            }
            else // if it does = both, dont query gender
            {
                try 
                {
                    this.db.connect();
                    Connection dbConn = db.getConnection();
                    String sql = "SELECT * FROM PROFILE WHERE AGE BETWEEN ? AND ? AND WEIGHT BETWEEN ? AND ? AND HEIGHT BETWEEN ? AND ?";
                    PreparedStatement pstmt = dbConn.prepareStatement(sql);
                    pstmt.setInt(1, userPreferences.getMinAge());
                    pstmt.setInt(2, userPreferences.getMaxAge());
                    pstmt.setInt(3, userPreferences.getMinWeight());
                    pstmt.setInt(4, userPreferences.getMaxWeight());
                    pstmt.setInt(5, userPreferences.getMinHeight());
                    pstmt.setInt(6, userPreferences.getMaxHeight());
                    ResultSet rs = pstmt.executeQuery();

                    return suggestedUsers;
                } catch (SQLException e) {
                    System.out.println("Could not create profile.");
                    return null;
                }
            }
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

            Profile newProfile = new Profile(userID, email, username, password, firstName, lastName);
            newProfile.setAge(age);
            newProfile.setHeight(height);
            newProfile.setWeight(weight);
            newProfile.setGender(gender);
            newProfile.setProfilePicture(profilePic);
            return newProfile;
            
        } catch (SQLException e) {
            System.out.println("Could not create profile.");
            return null;
        }
        
    }
    
}
