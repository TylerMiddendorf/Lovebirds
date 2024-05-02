package com.lovebirds;

public class ChatHandler extends Handler {

    //set user id in database to admin account
    public boolean clearConversation()
    {
        return true; // conversation has been cleared
    }

    public boolean sendMessage(String message)
    {
        return true; // message has been sent
    }
}