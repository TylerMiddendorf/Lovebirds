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

     // Setter and Getter for userProfile1
     public void setUserProfile1(Profile userProfile1) {
        this.userProfile1 = userProfile1;
    }

    public Profile getUserProfile1() {
        return userProfile1;
    }

    // Setter and Getter for userProfile2
    public void setUserProfile2(Profile userProfile2) {
        this.userProfile2 = userProfile2;
    }

    public Profile getUserProfile2() {
        return userProfile2;
    }

    // Setter and Getter for messages
    public void setMessages(String[] messages) {
        this.messages = messages;
    }

    public String[] getMessages() {
        return messages;
    }

    // Setter and Getter for timestamps
    public void setTimestamps(double[] timestamps) {
        this.timestamps = timestamps;
    }

    public double[] getTimestamps() {
        return timestamps;
    }
    
}