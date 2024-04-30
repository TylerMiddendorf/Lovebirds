package lovebirds.src.main.java.com.lovebirds;

import java.util.ArrayList;

// Album class
public class Album {

    private String albumName;
    private int photoCount;
    private ArrayList<Photo> album;

    public Album(String albumName, ArrayList<Photo> album){
        this.albumName = albumName;
        this.photoCount = album.size();
        this.album = album;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void addPhoto(Photo toAdd) {
        this.album.add(toAdd);
        this.photoCount++;
    }

    public void addPhotos(ArrayList<Photo> toAdd) {
        for(int i = 0; i < toAdd.size(); i++) {
            this.addPhoto(toAdd.get(i));
        }
    }

    public Photo getPhoto(String photoID) {
        int i = 0;
        boolean isFound = false;
        Photo found = null;
        while(i < album.size() && !isFound) {
            String currentID = album.get(i).getPhotoID();
            if(currentID.equals(photoID)) {
                found = album.get(i);
                isFound = true;
            }
            i++;
        }
        if(!isFound) {
            // the Photo variable found is still set to null and will return null
            System.out.println("Photo not found with that ID.");
        } 
        return found;
    }

    

    public int getPhotoCount() {
        return photoCount;
    }
    
}
