package com.lovebirds;

public class ChatHandler extends Handler {

    //set user id in database to admin account
    public boolean clearConversation()
    {   
        Profile currentProfile = getProfile();
        return true; // conversation has been cleared
    }

    public boolean sendMessage(String message)
    {
        Profile currentProfile = getProfile();
        return true; // message has been sent
    }
}