package com.lovebirds;

public class MediaOperationMySQL extends MediaOperation { // 

    private MySQLDatabase db;

    public MediaOperationMySQL(MySQLDatabase db) {
        this.db = db;
    }
    
    
    public Photo createPhoto(Photo photo) {
        return null;
    }

    public Photo readPhoto() {
        return null;
    }

    public boolean updatePhoto() {
        return true;
    }

    public boolean deletePhoto() {
        return true;
    }

    public Album createAlbum() {
        return null;
    }

    public Album readAlbum() {
        return null;
    }

    public boolean updateAlbum() {
        return true;
    }

    public boolean deleteAlbum() {
        return true;
    }

}
