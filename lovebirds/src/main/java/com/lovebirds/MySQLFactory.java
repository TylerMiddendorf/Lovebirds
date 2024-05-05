package com.lovebirds;

public class MySQLFactory extends GeneralFactory {

    private MySQLDatabase mySQLDB = new MySQLDatabase();

    @Override
    public Database getDatabase(String type) {
        switch(type) {
            case "MySQL":
                return mySQLDB;
            default:
                return null;
        }
    }

    @Override
    public ChatMediator getMediator(String type) {
        switch(type) {
            case "MySQL":
                return new ChatMediatorMySQL(mySQLDB);
            default:
                return null;
        }
    }

    @Override
    public MediaOperation getMedia(String type) {
        switch(type) {
            case "MySQL":
                return new MediaOperationMySQL(mySQLDB);
            default:
                return null;
        }
    }

    @Override
    public ProfileOperation getProfile(String type) {
        switch(type) {
            case "MySQL":
                return new ProfileOperationMySQL(mySQLDB);
            default:
                return null;
        }
    }

    @Override
    public MatchmakerOperation getMatchmaker(String type) {
        switch(type) {
            case "MySQL":
                return new MatchmakerOperationMySQL(mySQLDB);
            default:
                return null;
        }
    }
    
}




