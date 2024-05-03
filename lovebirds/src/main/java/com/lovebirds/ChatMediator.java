package com.lovebirds;

import java.lang.*;

@SuppressWarnings("unused") public  abstract class ChatMediator {

     
    private Database db;
    public abstract boolean createChat(String message, int SenderID, int RecieverID);
    public abstract Chat readChat();
    public abstract boolean updateChat();
    public abstract boolean deleteChat();
    
}
