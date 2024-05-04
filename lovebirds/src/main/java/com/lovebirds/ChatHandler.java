package com.lovebirds;

public class ChatHandler extends Handler {

    //set user id in database to admin account
    public boolean clearConversation(int userID)
    {   
        return FactoryProducer.getSQLFactory().getMediator("MySQL").deleteChat(profile.getProfileID(), userID); // conversation has been cleared
    }

    public boolean sendMessage(String message, int userID)
    {
        return FactoryProducer.getSQLFactory().getMediator("MySQL").createChat(message, profile.getProfileID(), userID); // message has been sent
    }
}