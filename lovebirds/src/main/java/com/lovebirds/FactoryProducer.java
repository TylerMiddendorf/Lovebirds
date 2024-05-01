package com.lovebirds;

public class FactoryProducer {
    
    public static Database getDatabase(String type) {
        switch(type) {
            case "mySQL":
                return new MySQLDatabase();
            default:
                return null;
        }
    }

    public static ChatMediator getMediator(String type) {
        switch(type) {
            case "mySQL":
                return new ChatMediatorMySQL();
            default:
                return null;
        }
    }

    public static MediaOperation getMedia(String type) {
        switch(type) {
            case "mySQL":
                return new MediaOperationMySQL();
            default:
                return null;
        }
    }

    public static ProfileOperation getProfile(String type) {
        switch(type) {
            case "mySQL":
                //return new ProfileOperationMySQL();
            default:
                return null;
        }
    }
}


