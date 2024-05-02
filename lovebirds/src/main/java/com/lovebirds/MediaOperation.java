package com.lovebirds;

public abstract class MediaOperation {
    
    private Database db;
    public abstract boolean createPhoto(Photo photo, String album, int UID);
    public abstract Photo readPhoto();
    public abstract boolean deletePhoto();
    public abstract Album createAlbum();
    public abstract Album readAlbum();
    public abstract boolean updateAlbum();
    public abstract boolean deleteAlbum();
}
