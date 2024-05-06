package com.lovebirds;

import java.lang.*;
import java.util.ArrayList;

@SuppressWarnings("unused") public class MediaHandler extends Handler {

    /*
    public abstract boolean createPhoto(String path, String albumName, int userID);
    public abstract Photo readPhoto(int userID, String albumName, String photoName);

    public abstract Album readAlbum(int userID, String albumName);
    public abstract boolean updateAlbum(int userID, String albumName, String newAlbumName);
    public abstract boolean deleteAlbum(int userID, String albumName);
     */

    public boolean uploadPhoto(String path, String albumName, String photoName) {
        // int userID = getProfile().getProfileID();
        // String albumName = "";
        // return false;
        MediaOperation mediaOperation = FactoryProducer.getSQLFactory().getMedia("MySQL");
        boolean created = mediaOperation.createPhoto(path, albumName, photoName, profile.getProfileID());
        return created;
    }

    public boolean deletePhoto(String albumName, String photoName) {

        MediaOperation mediaOperation = FactoryProducer.getSQLFactory().getMedia("MySQL");
        boolean created = mediaOperation.deletePhoto(profile.getProfileID(), albumName, photoName);
        return created;
    }

    public boolean editAlbum(String albumName, String newAlbumName) {

        MediaOperation mediaOperation = FactoryProducer.getSQLFactory().getMedia("MySQL");
        boolean updated = mediaOperation.updateAlbum(profile.getProfileID(), albumName, newAlbumName);
        return updated;
    }

    public boolean deleteAlbum(String albumName) {

        MediaOperation mediaOperation = FactoryProducer.getSQLFactory().getMedia("MySQL");
        boolean updated = mediaOperation.deleteAlbum(profile.getProfileID(), albumName);
        return updated;
    }
    
}
