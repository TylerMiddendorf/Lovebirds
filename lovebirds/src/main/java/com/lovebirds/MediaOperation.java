package com.lovebirds;

public abstract class MediaOperation {
    
    public abstract Photo createPhoto(Photo photo);
    public abstract Photo readPhoto();
    public abstract boolean updatePhoto();
    public abstract boolean deletePhoto();
    public abstract Album createAlbum();
    public abstract Album readAlbum();
    public abstract boolean updateAlbum();
    public abstract boolean deleteAlbum();
}
