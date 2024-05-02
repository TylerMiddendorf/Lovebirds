package com.lovebirds;

import java.net.ConnectException;
import java.sql.Connection;

public class Authentication {
    public static Database db;
    /*
     * handles login of account
     * @param username and password
     * @returns int exception handling?
     */
    public static int logIn(String username, String password)
    {
        //db = FactoryProducer.getDatabase();
        return 0;
    }

    /*
     * handles logout of account
     */
    public void logOut(){

    }

    /**
     * Searches for profile record in database with user entered information
     * @param email - user's email
     * @param username - user's username
     * @return Profile object
     */
    public static Profile authenticateForgotPassword(String email, String username){
        db = FactoryProducer.getSQLFactory().getDatabase("MySQL");
        db.connect();
        Connection dbConn = db.getConnection();
        
        return null;
    }
}
