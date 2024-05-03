package com.lovebirds;

import java.lang.*;

@SuppressWarnings("unused") public abstract class MediaOperation {
    
    private Database db;
    public abstract boolean createPhoto(String path, String albumName, int userID, String photoName);
    public abstract Photo readPhoto(int userID, String albumName, String photoName);
    public abstract boolean deletePhoto(int userID, String albumName, String photoName);
    public abstract Album readAlbum(int userID, String albumName);
    public abstract boolean updateAlbum(int userID, String albumName, String newAlbumName);
    public abstract boolean deleteAlbum(int userID, String albumName);
}
