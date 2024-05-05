package com.lovebirds;

import java.lang.*;
import java.util.ArrayList;

@SuppressWarnings("unused") public  abstract class ChatMediator {

    
    private Database db;
    public abstract boolean createChat(String message, int SenderID, int RecieverID);
    public abstract Chat readChat(int senderID, int recieverID);
    public abstract boolean deleteChat(int senderID, int recieverID);
    public abstract ArrayList<Integer> readMatches(int userID);
    public abstract Profile readProfile(int userID);
    
}
