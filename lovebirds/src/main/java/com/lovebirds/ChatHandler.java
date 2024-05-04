package com.lovebirds;

public class ChatHandler extends Handler {

    //set user id in database to admin account
    public boolean clearConversation(int userID)
    {   
        Profile currentProfile = getProfile();
        return true; // conversation has been cleared
    }

    public boolean sendMessage(String message, int userID)
    {
        Profile currentProfile = getProfile();
        return true; // message has been sent
    }
}