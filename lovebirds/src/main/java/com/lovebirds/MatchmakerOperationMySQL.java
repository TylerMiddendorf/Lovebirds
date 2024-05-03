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

    public ArrayList<Profile> readProfilesThatMatchPreferences(Profile profile) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readProfilesThatMatchPreferences'");
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
