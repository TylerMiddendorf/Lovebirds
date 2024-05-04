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


        return false;
        
    }

    public boolean editAlbum() {

        return false;

    }

    public boolean deleteAlbum() {


        return false;
    }

    public boolean createAlbum() {


        return false;
    }
    
}
