package com.lovebirds;

public  abstract class ChatMediator {

    public abstract Chat createChat(Chat chat);
    public abstract Chat readChat();
    public abstract boolean updateChat();
    public abstract boolean deleteChat();
    
}
