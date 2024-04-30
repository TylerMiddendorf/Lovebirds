public abstract class Database {
    
    private String username;
    private String password;

    public Database(String dbType) {

        if(dbType.equals("MySQL")) {
            new MySQLDatabase();
        }

    }

    public Database connect(Database db) {
        return this;
    }
}
