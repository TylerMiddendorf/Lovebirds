package com.lovebirds;

import java.sql.Connection;

public abstract class Database {
    
    private String username;
    private String password;
    private Connection conn;
    public abstract boolean connect(String password);
    public abstract Connection getConnection();

}
