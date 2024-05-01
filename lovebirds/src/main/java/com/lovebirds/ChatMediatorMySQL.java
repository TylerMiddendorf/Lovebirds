package com.lovebirds;

public class ChatMediatorMySQL extends ChatMediator{ // 


    private MySQLDatabase db;

    public ChatMediatorMySQL(MySQLDatabase db) {
        this.db = db;
    }
    
    public Chat createChat(Chat chat) {
        return new Chat();
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