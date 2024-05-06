package com.lovebirds;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MatchmakerOperationMySQL extends MatchmakerOperation {

    private MySQLDatabase db;

    public MatchmakerOperationMySQL(MySQLDatabase db) {
        this.db = db;
    }

    // if not calling with rating, call with -1
    public ArrayList<Profile> readProfilesThatMatchPreferences(Preferences userPreferences, double rating) {
        ArrayList<Profile> suggestedUsers = new ArrayList<Profile>();

        String preferredGender = userPreferences.getPreferredGender();

        if(rating == -1)
        {
            if(!preferredGender.equals("Both"))
            {
                try {
                    this.db.connect();
                    Connection dbConn = db.getConnection();
                    String sql = "SELECT * FROM lovebirds_schema.PROFILE WHERE AGE BETWEEN ? AND ? AND WEIGHT BETWEEN ? AND ? AND HEIGHT BETWEEN ? AND ? AND GENDER = ?";
                    PreparedStatement pstmt = dbConn.prepareStatement(sql);
                    pstmt.setInt(1, userPreferences.getMinAge());
                    pstmt.setInt(2, userPreferences.getMaxAge());
                    pstmt.setInt(3, userPreferences.getMinWeight());
                    pstmt.setInt(4, userPreferences.getMaxWeight());
                    pstmt.setInt(5, userPreferences.getMinHeight());
                    pstmt.setInt(6, userPreferences.getMaxHeight());
                    pstmt.setString(7, userPreferences.getPreferredGender());
                    ResultSet rs = pstmt.executeQuery();

                    while(rs.next())
                    {
                        int userID = rs.getInt(1);
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

                        Profile newProfile = new Profile(userID, email, username, password, firstName, lastName);
                        newProfile.setAge(age);
                        newProfile.setHeight(height);
                        newProfile.setWeight(weight);
                        newProfile.setGender(gender);
                        newProfile.setProfilePicture(profilePic);

                        suggestedUsers.add(newProfile);

                    }

                    return suggestedUsers;
                } catch (SQLException e) {
                    System.out.println("Could not create profile 1. " + e.getMessage());
                    return null;
                }
            }
            else // if it does = both, dont query gender
            {
                try 
                {
                    this.db.connect();
                    Connection dbConn = db.getConnection();
                    String sql = "SELECT * FROM lovebirds_schema.PROFILE WHERE AGE BETWEEN ? AND ? AND WEIGHT BETWEEN ? AND ? AND HEIGHT BETWEEN ? AND ?";
                    PreparedStatement pstmt = dbConn.prepareStatement(sql);
                    pstmt.setInt(1, userPreferences.getMinAge());
                    pstmt.setInt(2, userPreferences.getMaxAge());
                    pstmt.setInt(3, userPreferences.getMinWeight());
                    pstmt.setInt(4, userPreferences.getMaxWeight());
                    pstmt.setInt(5, userPreferences.getMinHeight());
                    pstmt.setInt(6, userPreferences.getMaxHeight());
                    ResultSet rs = pstmt.executeQuery();

                    while(rs.next())
                    {
                        int userID = rs.getInt(1);
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

                        Profile newProfile = new Profile(userID, email, username, password, firstName, lastName);
                        newProfile.setAge(age);
                        newProfile.setHeight(height);
                        newProfile.setWeight(weight);
                        newProfile.setGender(gender);
                        newProfile.setProfilePicture(profilePic);

                        suggestedUsers.add(newProfile);

                    }

                    return suggestedUsers;
                } catch (SQLException e) {
                    System.out.println("Could not create profile 2.");
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
                    String sql = "SELECT * FROM lovebirds_schema.PROFILE WHERE AGE BETWEEN ? AND ? AND WEIGHT BETWEEN ? AND ? AND HEIGHT BETWEEN ? AND ? AND GENDER = ?";
                    PreparedStatement pstmt = dbConn.prepareStatement(sql);
                    pstmt.setInt(1, userPreferences.getMinAge());
                    pstmt.setInt(2, userPreferences.getMaxAge());
                    pstmt.setInt(3, userPreferences.getMinWeight());
                    pstmt.setInt(4, userPreferences.getMaxWeight());
                    pstmt.setInt(5, userPreferences.getMinHeight());
                    pstmt.setInt(6, userPreferences.getMaxHeight());
                    pstmt.setString(7, userPreferences.getPreferredGender());
                    ResultSet rs = pstmt.executeQuery();

                    while(rs.next())
                    {
                        int userID = rs.getInt(1);
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

                        Profile newProfile = new Profile(userID, email, username, password, firstName, lastName);
                        newProfile.setAge(age);
                        newProfile.setHeight(height);
                        newProfile.setWeight(weight);
                        newProfile.setGender(gender);
                        newProfile.setProfilePicture(profilePic);

                        suggestedUsers.add(newProfile);

                    }

                    return suggestedUsers;
                } catch (SQLException e) {
                    System.out.println("Could not create profile 3.");
                    return null;
                }
            }
            else // if it does = both, dont query gender
            {
                try 
                {
                    this.db.connect();
                    Connection dbConn = db.getConnection();
                    String sql = "SELECT * FROM lovebirds_schema.PROFILE WHERE AGE BETWEEN ? AND ? AND WEIGHT BETWEEN ? AND ? AND HEIGHT BETWEEN ? AND ?";
                    PreparedStatement pstmt = dbConn.prepareStatement(sql);
                    pstmt.setInt(1, userPreferences.getMinAge());
                    pstmt.setInt(2, userPreferences.getMaxAge());
                    pstmt.setInt(3, userPreferences.getMinWeight());
                    pstmt.setInt(4, userPreferences.getMaxWeight());
                    pstmt.setInt(5, userPreferences.getMinHeight());
                    pstmt.setInt(6, userPreferences.getMaxHeight());
                    ResultSet rs = pstmt.executeQuery();

                    while(rs.next())
                    {
                        int userID = rs.getInt(1);
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

                        Profile newProfile = new Profile(userID, email, username, password, firstName, lastName);
                        newProfile.setAge(age);
                        newProfile.setHeight(height);
                        newProfile.setWeight(weight);
                        newProfile.setGender(gender);
                        newProfile.setProfilePicture(profilePic);

                        suggestedUsers.add(newProfile);

                    }

                    return suggestedUsers;
                } catch (SQLException e) {
                    System.out.println("Could not create profile 4.");
                    return null;
                }
            }
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

    public boolean rateUser(int userID, int recipientID, int rating) {
        try {
            this.db.connect();
            Connection dbConn = db.getConnection();
            String sql = "INSERT INTO lovebirds_schema.RATINGS(USER_ID, RECIPIENT_ID, RATING) VALUES (?, ?, ?)";
            PreparedStatement pstmt = dbConn.prepareStatement(sql);
            pstmt.setInt(1, userID);
            pstmt.setInt(2, recipientID);
            pstmt.setInt(3, rating);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getSQLState());
            System.out.println(e.getMessage());
            System.out.println("Could not rate user.");
            return false;
        }    
    }

    public boolean relationship(int userID, int recipientID, String relationship){
        try {
            this.db.connect();
            Connection dbConn = db.getConnection();
            String sql = "UPDATE lovebirds_schema.RATINGS SET RELATIONSHIP = ? WHERE USER_ID = ? and RECIPIENT_ID = ?";
            PreparedStatement pstmt = dbConn.prepareStatement(sql);
            pstmt.setString(1, relationship);
            pstmt.setInt(2, userID);
            pstmt.setInt(3, recipientID);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getSQLState());
            System.out.println(e.getMessage());
            System.out.println("Could not add a relationship to user.");
            return false;
        }  
    }

    /**
     * This needs testing!!!
     */
    public boolean retrieveStatistics(int userID){
        try {

            int updatedRating = 0;
            int count = 0;

            this.db.connect();
            Connection dbConn = db.getConnection();
            String sql = "SELECT * FROM lovebirds_schema.RATINGS WHERE RECIPIENT_ID = ?";
            PreparedStatement pstmt = dbConn.prepareStatement(sql);
            pstmt.setInt(1, userID);

            ResultSet rs = pstmt.executeQuery();

            while(rs.next())
            {
                int rating = rs.getInt(3);

                updatedRating += rating;
                count++;
            }

            double average = updatedRating/count;
            
            System.out.println("\nYour average rating is " + average + ".");

            return true;

        } catch (SQLException e) {
            System.out.println(e.getSQLState());
            System.out.println(e.getMessage());
            System.out.println("Could not retrieve your average rating");
            return false;
        }
    }

    public boolean deleteAllRelationships(int userID){
        try{
            this.db.connect();
            Connection dbConn = db.getConnection();
            String sql = "DELETE FROM lovebirds_schema.RATINGS WHERE USER_ID = ? OR RECIPIENT_ID = ?";
            PreparedStatement pstmt = dbConn.prepareStatement(sql);
            pstmt.setInt(1, userID);
            pstmt.setInt(2, userID);
            pstmt.executeUpdate();
            return true;
        } catch(SQLException e){
            System.out.println("Could not delete image. Please try again.");
            return false;
        }
    }

    /**
     * this needs userID and recipientID parameters for matches searching for matches in the database!!!
     * ^also change taken parameters in MatchmakerOperation.java
     * this returns true if the user has already rated target user
     */
    public boolean alreadyRatedUser(int userID, int recipientID){
        try {

            this.db.connect();
            Connection dbConn = db.getConnection();
            String sql = "SELECT * FROM lovebirds_schema.RATINGS WHERE RECIPIENT_ID = ? AND USER_ID = ?";
            PreparedStatement pstmt = dbConn.prepareStatement(sql);
            pstmt.setInt(1, recipientID);
            pstmt.setInt(2, userID);

            ResultSet rs = pstmt.executeQuery();

            //while there is an entry of user rating the target user
            while(rs.next())
            {
                System.out.println("You have already rated this user.");
                return true;
            }
            return false;
            

        } catch (SQLException e) {
            System.out.println(e.getSQLState());
            System.out.println(e.getMessage());
            System.out.println("Could not retrieve your average rating");
            return false;
        }
    }


}
