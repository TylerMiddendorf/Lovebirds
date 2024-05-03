package com.lovebirds;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;


public class ChatMediatorMySQL extends ChatMediator{ // 


    private MySQLDatabase db;

    public ChatMediatorMySQL(MySQLDatabase db) {
        this.db = db;
    }
    
    public boolean createChat(String message, int SenderID, int RecieverID) {
        try {
            db.connect();
            Connection dbConn = db.getConnection();
            String sql = "INSERT INTO PREFERENCES(SENDER, RECIPIENT, MESSAGE) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = dbConn.prepareStatement(sql);
            pstmt.setInt(1, SenderID);
            pstmt.setInt(2, RecieverID);
            pstmt.setString(3, message);
            pstmt.executeQuery();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Chat readChat() {
        return new Chat();
    }

    public boolean updateChat() {
        return true;
    }

    public boolean deleteChat() {
        return true;
    }
    
    
}