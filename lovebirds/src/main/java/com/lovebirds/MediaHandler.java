package com.lovebirds;

import java.lang.*;

@SuppressWarnings("unused") public class MediaHandler extends Handler {

    public boolean uploadPhoto(String path, String albumName) {
        // int userID = getProfile().getProfileID();
        // String albumName = "";
        // return false;
        MediaOperation mediaOperation = FactoryProducer.getSQLFactory().getMedia("MySQL");
        boolean created = mediaOperation.createPhoto(path, albumName, profile.getProfileID());
        return created;
    }

    public boolean deletePhoto() {

        int userID = getProfile().getProfileID();
        return false;
        
    }

    public boolean editAlbum() {

        int userID = getProfile().getProfileID();
        return false;

    }

    public boolean deleteAlbum() {

        int userID = getProfile().getProfileID();
        return false;
    }

    public boolean createAlbum() {

        int userID = getProfile().getProfileID();
        return false;
    }
    
}
