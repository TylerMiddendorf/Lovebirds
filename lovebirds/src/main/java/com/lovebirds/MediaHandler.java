package com.lovebirds;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.*;
import java.util.ArrayList;

import javax.imageio.ImageIO;

@SuppressWarnings("unused") public class MediaHandler extends Handler {

    /*
    public abstract boolean createPhoto(String path, String albumName, int userID);
    public abstract Photo readPhoto(int userID, String albumName, String photoName);

    public abstract Album readAlbum(int userID, String albumName);
    public abstract boolean updateAlbum(int userID, String albumName, String newAlbumName);
    public abstract boolean deleteAlbum(int userID, String albumName);
     */

     public boolean createPhoto(String path, String albumName, String photoName) {
        // int userID = getProfile().getProfileID();
        // String albumName = "";
        // return false;
        MediaOperation mediaOperation = FactoryProducer.getSQLFactory().getMedia("MySQL");
        boolean created = mediaOperation.createPhoto(path, albumName, photoName, profile.getProfileID());
        return created;
    }

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

    public BufferedImage getImage(int userID){
        InputStream is = new ByteArrayInputStream(FactoryProducer.getSQLFactory().getMedia("MySQL").readPhoto(userID,"ProfilePicture","ProfilePicture").getPhoto());
        return ImageIO.read(is);
        
    }
    
}
