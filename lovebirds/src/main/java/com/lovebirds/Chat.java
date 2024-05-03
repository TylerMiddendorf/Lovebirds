package com.lovebirds;

public class Chat{
    private int userProfile1;
    private int userProfile2;
    private String[] messages;
    private String[] timestamps;


    public Chat() {
        
    }

    public void addMessage(String message, String timestamp)
    {
        String[] newMessages = new String[messages.length + 1];
        String[] newtimestamps = new String[timestamps.length + 1];
        for(int i=0; i<messages.length; i++){
            newMessages[i] = messages[i];
            newtimestamps[i] = timestamps[i];
        }
        newMessages[messages.length] = message;
        newtimestamps[timestamps.length] = timestamp;
        //write the message
    }

    public boolean deleteMessage(double timestamp)
    {
        //delete the message at a specific timestamp
        return true;
    }

     // Setter and Getter for userProfile1
     public void setUserProfile1(int userProfile1) {
        this.userProfile1 = userProfile1;
    }

    public int getUserProfile1() {
        return userProfile1;
    }

    // Setter and Getter for userProfile2
    public void setUserProfile2(int userProfile2) {
        this.userProfile2 = userProfile2;
    }

    public int getUserProfile2() {
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
    public void setTimestamps(String[] timestamps) {
        this.timestamps = timestamps;
    }

    public String[] getTimestamps() {
        return timestamps;
    }
    
}