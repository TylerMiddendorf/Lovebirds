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
    
    public Chat createChat(Chat chat) {
        try {
            db.connect();
            Connection dbConn = db.getConnection();
            String sql = "INSERT INTO PREFERENCES(TIMESTAMP, SENDER, RECIPIENT, MESSAGE) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pstmt = dbConn.prepareStatement(sql);
            Date date = new Date();
            
            return new Chat();
        } catch (Exception e) {
            return null;
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