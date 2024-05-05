package com.lovebirds;

public class ChatHandler extends Handler {

    //set user id in database to admin account
    public boolean clearConversation(int userID)
    {   
        return FactoryProducer.getSQLFactory().getMediator("MySQL").deleteChat(profile.getProfileID(), userID); // conversation has been cleared
    }

    public boolean sendMessage(String message, int userID)
    {
        return FactoryProducer.getSQLFactory().getMediator("MySQL").createChat(profile.getFirstName() + ": " + message, profile.getProfileID(), userID); // message has been sent
    }

    public String[] getMessages(int userID){
        Chat chat = FactoryProducer.getSQLFactory().getMediator("MySQL").readChat(userID, profile.getProfileID());
        String[] messages = new String[chat.getMessages().length];
        for(int i = 0; i < chat.getMessages().length;i++){
            messages[i] = chat.getMessages()[i] + "\n" + chat.getTimestamps();
        }
        return messages;
    }

    public String[] getMatched(){
        
        return new String[0];
    }

    public int getUser(int index){
        return 0;
    }
}