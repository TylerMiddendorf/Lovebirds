package com.lovebirds;

import java.lang.*;

@SuppressWarnings("unused") public class MediaHandler extends Handler {

    public boolean uploadPhoto(Photo photo) {

        int userID = getProfile().getProfileID();
        String albumName = "";
        return false;

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
