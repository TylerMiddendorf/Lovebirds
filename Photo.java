public class Photo {

    private String photoID;
    private String filePath; 
    private String fileName;
    private String fileFormat;

    public Photo(String photoId, String filePath, String fileName, String fileFormat) {
        this.photoID = photoId;
        this.filePath = filePath;
        this.fileName = fileName;
        this.fileFormat = fileFormat;
    }

    public void setFileName(String name) {
        this.fileName = fileName;
    }   

    public String getFileName() {
        return fileName;
    }

    public void setFilePath(String fileParh) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }

    public String getFileFormat() {
        return fileFormat;
    }

    public String getPhotoID() {
        return photoID;
    }

    
}