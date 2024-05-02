package com.lovebirds;

// Class photo

public class Photo {

    private String photoID;
    private byte photo[]; 
    private String fileFormat;

    public Photo() {
        
    }

    public Photo(String photoId, byte photo[], String fileFormat) {
        this.photoID = photoId;
        this.photo = photo;
        this.fileFormat = fileFormat;
    }

 


    public void setPhoto(byte photo[]) {
        this.photo = photo;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setFileFormat(String fileFormat) {
        this.fileFormat = fileFormat;
    }

    public String getFileFormat() {
        return fileFormat;
    }

    public void setPhotoID(String photoID) {
        this.photoID = photoID;
    }

    public String getPhotoID() {
        return photoID;
    }

    
}