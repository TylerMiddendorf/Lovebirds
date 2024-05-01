package com.lovebirds;

public class MySQLFactory extends GeneralFactory {

    @Override
    public Database getDatabase(String dbType) {
        return new MySQLDatabase();
    }
    
    @Override
    public ChatMediator getMediator(String chatType) {
        return new ChatMediatorMySQL();
    }

    @Override
    public MediaOperation getMedia(String mediaType) {
        return new MediaOperationMySQL();
    }
    
    @Override
    public ProfileOperation getProfile(String profileType) {
        MySQLDatabase mySQLDB = new MySQLDatabase();
        return new ProfileOperationMySQL(mySQLDB);
    }
    
}




