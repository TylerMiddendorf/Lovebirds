package lovebirds.src.main.java.com.lovebirds;

import java.sql.Connection;

public abstract class Database {
    
    private String username;
    private String password;
    private Connection conn;
    public abstract boolean connect();
    public abstract Connection getConnection();

}
