package com.lovebirds;

import java.awt.image.*;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.imageio.*;

public class MediaOperationMySQL extends MediaOperation { // 

    private MySQLDatabase db;

    public MediaOperationMySQL(MySQLDatabase db) {
        this.db = db;
    }
    
    
    public boolean createPhoto(String path, String album, int UID, String Photo_name) {
        
       
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(path));
        }
        catch (Exception e) {
            return false;
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        try {
            ImageIO.write(image, "png", baos);
        }
        catch(Exception e) {
            return false;
        }
        InputStream is = new ByteArrayInputStream(baos.toByteArray());
        //Blob blFile = new javax.sql.rowset.serial.SerialBlob(baos.toByteArray());
        //setBlob(int parameterIndex, InputStream is)
        try {
            this.db.connect();
            Connection dbConn = db.getConnection();
            String sql = "INSERT INTO MESSAGES(USERID, ALBUMNAME, PHOTO, PHOTONAME) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = dbConn.prepareStatement(sql);
            pstmt.setInt(1, UID);
            pstmt.setString(2, album);
            pstmt.setBlob(3,  is);
            pstmt.executeQuery();
            return true;
        } catch (SQLException e) {
            System.out.println("Could not create image. Please try again.");
            return false;
        }
    }

    public Photo readPhoto(int userID,String album,String photo_name) {
        try{
            this.db.connect();
            Connection dbConn = db.getConnection();
            String sql = "SELECT FROM Images WHERE USER_ID = ? AND PHOTO = ? AND PHOTONAME = ?";
            PreparedStatement pstmt = dbConn.prepareStatement(sql);
            pstmt.setInt(1, userID);
            pstmt.setString(2, album);
            pstmt.setString(3, photo_name);

            ResultSet rs = pstmt.executeQuery();
            int UID = rs.getInt(0);
            String albumName = rs.getString(1);
            byte image[] = rs.getBytes(2);
            String photoName = rs.getString(3);

            
            Photo photo = new Photo(photoName, image , "png");
            return photo;
        } catch(SQLException e){
            System.out.println("Could not retrieve image. Please try again.");
            return null;
        }
    }

    public boolean deletePhoto(int userID, String albumName, String photoName) {
        try{
            this.db.connect();
            Connection dbConn = db.getConnection();
            String sql = "DELETE FROM Images WHERE USER_ID = ? AND ALBUMNAME = ? AND PHOTONAME = ?";
            PreparedStatement pstmt = dbConn.prepareStatement(sql);
            pstmt.setInt(1, userID);
            pstmt.setString(2, albumName);
            pstmt.setString(3, photoName);
            pstmt.executeQuery();
            return true;
        } catch(SQLException e){
            System.out.println("Could not delete image. Please try again.");
            return false;
        }
        
    }


    public Album readAlbum(int userID, String albumName) {
        try{
            this.db.connect();
            Connection dbConn = db.getConnection();
            ArrayList<Photo> photos = new ArrayList<>();
            String sql = "SELECT * FROM WHERE USER_ID = ? AND ALBUM_NAME = ?";
            PreparedStatement pstmt = dbConn.prepareStatement(sql);
            pstmt.setInt(1, userID);
            pstmt.setString(2, albumName);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                byte image[] = rs.getBytes(2);
                String photoName = rs.getString(3);            
                Photo photo = new Photo(photoName, image , "png");
                photos.add(photo);
            }
            return new Album(albumName, photos);
        } catch(SQLException e){
            return null;
        }
    }

    public boolean updateAlbum(int userID, String albumName, String newAlbumName) {
        try{
            this.db.connect();
            Connection dbConn = db.getConnection();
            String sql = "UPDATE IMAGES SET ALBUM_NAME = ? WHERE USER_ID = ? AND ALBUM_NAME = ?";
            PreparedStatement pstmt = dbConn.prepareStatement(sql);
            pstmt.setString(1, albumName);
            pstmt.setInt(2, userID);
            pstmt.setString(3, newAlbumName); 
            pstmt.executeQuery();
            return true;
        } catch(SQLException e){
            System.out.println("Could not updateAlbum. Please try again.");
            return false;
        }
        
    }

    public boolean deleteAlbum(int userID, String albumName) {
        try{
            this.db.connect();
            Connection dbConn = db.getConnection();
            String sql = "DELETE FROM IMAGES WHERE ALBUMNAME = ? AND USER_ID = ?";
            PreparedStatement pstmt = dbConn.prepareStatement(sql);
            pstmt.setString(1, albumName);
            pstmt.setInt(2, userID);
            pstmt.executeQuery();
            return true;
        } catch(SQLException e){
            System.out.println("Could not updateAlbum. Please try again.");
            return false;
        }
    }



}
