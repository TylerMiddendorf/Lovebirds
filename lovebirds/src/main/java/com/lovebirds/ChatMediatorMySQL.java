package com.lovebirds;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class ChatMediatorMySQL extends ChatMediator{ // 


    private MySQLDatabase db;

    public ChatMediatorMySQL(MySQLDatabase db) {
        this.db = db;
    }
    
    public boolean createChat(String message, int SenderID, int RecieverID) {
        try {
            db.connect();
            Connection dbConn = db.getConnection();
            String sql = "INSERT INTO lovebirds_schema.MESSAGE(SENDER, RECIPIENT, MESSAGE) VALUES (?, ?, ?)";
            PreparedStatement pstmt = dbConn.prepareStatement(sql);
            pstmt.setInt(1, SenderID);
            pstmt.setInt(2, RecieverID);
            pstmt.setString(3, message);
            pstmt.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Chat readChat(int senderID, int recieverID) {
        try {
            db.connect();
            Connection dbConn = db.getConnection();
            Chat newChat = new Chat();
            String sql = "SELECT * FROM lovebirds_schema.MESSAGE WHERE (RECIPIENT = ? AND WHERE SENDER = ?) or (RECIPIENT = ? AND WHERE SENDER = ?)";
            PreparedStatement pstmt = dbConn.prepareStatement(sql);
            pstmt.setInt(1, senderID);
            pstmt.setInt(2, recieverID);
            pstmt.setInt(3, recieverID);
            pstmt.setInt(4, senderID);
            ResultSet rs = pstmt.executeQuery();
            newChat.setUserProfile1(senderID);
            newChat.setUserProfile2(recieverID);
            while (rs.next()) {
                String timestamp = rs.getString(0);
                String message = rs.getString(3);
                newChat.addMessage(message, timestamp);
            }
            return newChat;
        } catch (Exception e) {
            return null;
        }
    }

    public boolean deleteChat(int senderID, int recieverID) {
         try {
            this.db.connect();
            Connection dbConn = db.getConnection();
            String sql = "DELETE FROM lovebirds_schema.MESSAGE WHERE USER_ID = ? AND RECEIVER_ID = ?";
            PreparedStatement pstmt = dbConn.prepareStatement(sql);
            pstmt.setInt(1, senderID);
            pstmt.setInt(1, recieverID);
            pstmt.executeUpdate();
            sql = "DELETE FROM lovebirds_schema.MESSAGE WHERE USER_ID = ? AND RECEIVER_ID = ?";
            pstmt = dbConn.prepareStatement(sql);
            pstmt.setInt(1, recieverID);
            pstmt.setInt(1, senderID);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Could not delete preferences.");
            return false;
        }
    }

    public ArrayList<Integer> readMatches(int userID){
        try {
            db.connect();
            Connection dbConn = db.getConnection();
            ArrayList<Integer> matches = new ArrayList<>();
            String sql = "SELECT * FROM lovebirds_schema.RATINGS WHERE SENDER = ? AND RELATIONSHIP = ?";
            PreparedStatement pstmt = dbConn.prepareStatement(sql);
            pstmt.setInt(1, userID);
            pstmt.setString(2, "Liked");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                matches.add(rs.getInt(2));  
            }
            return matches;
        } catch (Exception e) {
            return null;
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
    
}