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
            String sql = "INSERT INTO PREFERENCES(SENDER, RECIPIENT, MESSAGE) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = dbConn.prepareStatement(sql);
            //pstmt.setInt(3, chat.getSe);
            //pstmt.setInt(3, photoName);
            //pstmt.setString(3, photoName);
            
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