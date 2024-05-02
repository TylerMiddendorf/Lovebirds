package com.lovebirds;

public abstract class MediaOperation {
    
    private Database db;
    public abstract boolean createPhoto(Photo photo, String albumName, int userID);
    public abstract Photo readPhoto(int userID);
    public abstract boolean deletePhoto(int userID);
    public abstract Album createAlbum(int userID, String albumName);
    public abstract Album readAlbum(int userID, String albumName);
    public abstract boolean updateAlbum(int userID, String albumName);
    public abstract boolean deleteAlbum(int userID, String albumName);
}
