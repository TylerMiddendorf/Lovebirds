package com.lovebirds;



public abstract class GeneralFactory {
    
    public abstract Database getDatabase(String dbType);
    public abstract ChatMediator getMediator(String chatType);
    public abstract MediaOperation getMedia(String mediaType);
    public abstract ProfileOperation getProfile(String profileType);
}


