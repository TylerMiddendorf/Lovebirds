package com.lovebirds;

import java.lang.*;
import java.util.ArrayList;

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

    public boolean createAlbum(String albumName, ArrayList album) {
        // need to discuss why MediaOperation does not have a createAlbum function
        Album newAlbum = new Album(albumName, album);
        MediaOperation mediaOperation = FactoryProducer.getSQLFactory().getMedia(albumName);
        boolean created = mediaOperation.createPhoto(albumName, albumName, profile.getProfileID());
        return created;
    }
    
}
