package com.lovebirds;

public class ChatMediatorMySQL  extends ChatMediator{ // 
    
    
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