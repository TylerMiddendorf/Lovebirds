package com.lovebirds;

// Class photo

public class Photo {

    private String photoID;
    private String filePath; 
    private String fileName;
    private String fileFormat;

    public Photo() {
        
    }

    public Photo(String photoId, String filePath, String fileName, String fileFormat) {
        this.photoID = photoId;
        this.filePath = filePath;
        this.fileName = fileName;
        this.fileFormat = fileFormat;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }   

    public String getFileName() {
        return fileName;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
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