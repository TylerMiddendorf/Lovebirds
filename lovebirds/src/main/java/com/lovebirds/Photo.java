package com.lovebirds;

// Class photo

public class Photo {

    private String photoName;
    private byte photo[]; 
    private String fileFormat;

    public Photo() {
        
    }

    public Photo(String photoName, byte photo[], String fileFormat) {
        this.photoName = photoName;
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

    public void setPhotoID(String photoName) {
        this.photoName = photoName;
    }

    public String getPhotoName() {
        return photoName;
    }

    
}