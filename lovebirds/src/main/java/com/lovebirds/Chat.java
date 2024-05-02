package com.lovebirds;

public class Chat{
    private Profile userProfile1;
    private Profile userProfile2;
    private String[] messages;
    private double[] timestamps;


    public Chat() {
        
    }

    public void addMessage(String message)
    {
        //write the message
    }

    public boolean deleteMessage(double timestamp)
    {
        //delete the message at a specific timestamp
        return true;
    }

    public boolean sendMessage(String message)
    {
        return true;
    }

    
}