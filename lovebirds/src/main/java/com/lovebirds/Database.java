package lovebirds.src.main.java.com.lovebirds;

public abstract class Database {
    
    private String username;
    private String password;
    public abstract Database connect();
}
