package com.lovebirds;

import java.sql.Connection;
import java.lang.*;

@SuppressWarnings("unused") public abstract class Database {
    
    private String username;
    private String password;
    private Connection conn;
    public abstract boolean connect();
    public abstract Connection getConnection();

}
