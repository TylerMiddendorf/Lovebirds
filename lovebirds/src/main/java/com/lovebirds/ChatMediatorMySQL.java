package com.lovebirds;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class ChatMediatorMySQL extends ChatMediator{ // 


    private MySQLDatabase db;

    public ChatMediatorMySQL(MySQLDatabase db) {
        this.db = db;
    }
    
    public boolean createChat(String message, int SenderID, int RecieverID) {
        try {
            db.connect();
            Connection dbConn = db.getConnection();
            String sql = "INSERT INTO lovebirds_schema.MESSAGE(SENDER, RECIPIENT, MESSAGE) VALUES (?, ?, ?, ?)";
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

    public boolean deleteChat(int userID) {
         try {
            this.db.connect();
            Connection dbConn = db.getConnection();
            String sql = "DELETE FROM lovebirds_schema.MESSAGE WHERE USER_ID = ?";
            PreparedStatement pstmt = dbConn.prepareStatement(sql);
            pstmt.setInt(1, userID);
            return true;
        } catch (SQLException e) {
            System.out.println("Could not delete preferences.");
            return false;
        }
    }
    
    
}