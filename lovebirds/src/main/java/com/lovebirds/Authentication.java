package com.lovebirds;

public class Authentication {
    Database db;
    /*
     * handles login of account
     * @param username and password
     * @returns int exception handling?
     */
    static public int logIn(String username, String password)
    {
        //db = FactoryProducer.getDatabase();
        return 0;
    }

    /*
     * handles logout of account
     */
    public void logOut(){

    }

    /*
     * allows user to change password
     * @param newPass
     * @return string confirmation message?
     */
    public String forgotPassword(String newPass){
        return null;
    }
}
