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
    
    
    public boolean createPhoto(String path, String albumName, String photoName, int UID) {
        
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(path));
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getLocalizedMessage());
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
            String sql = "INSERT INTO lovebirds_schema.IMAGES(USER_ID, ALBUM_NAME, PHOTO, PHOTO_NAME) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = dbConn.prepareStatement(sql);
            pstmt.setInt(1, UID);
            pstmt.setString(2, albumName);
            pstmt.setBlob(3,  is);
            pstmt.setString(4, photoName);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Could not create image. Please try again.");
            System.out.println(e.getSQLState());
            System.out.println(e.getErrorCode());
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean uploadPhoto(String path, String albumName, String photoName, int UID) {

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
            String sql = "INSERT INTO lovebirds_schema.IMAGES ALBUM_NAME = ? AND PHOTO = ? AND PHOTO_NAME = ? WHERE USER_ID = ?";
            PreparedStatement pstmt = dbConn.prepareStatement(sql);
            pstmt.setString(1, albumName);
            pstmt.setBlob(2,  is);
            pstmt.setString(3, photoName);
            pstmt.setInt(4, UID);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Could not create image. Please try again.");
            System.out.println(e.getSQLState());
            System.out.println(e.getErrorCode());
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Photo readPhoto(int userID,String album,String photo_name) {
        try{
            this.db.connect();
            Connection dbConn = db.getConnection();
            String sql = "SELECT FROM lovebirds_schema.IMAGES WHERE USER_ID = ? AND PHOTO = ? AND PHOTONAME = ?";
            PreparedStatement pstmt = dbConn.prepareStatement(sql);
            pstmt.setInt(1, userID);
            pstmt.setString(2, album);
            pstmt.setString(3, photo_name);

            ResultSet rs = pstmt.executeQuery();
            rs.next();
            byte image[] = rs.getBytes(3);
            String photoName = rs.getString(4);

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
            String sql = "DELETE FROM lovebirds_schema.IMAGES WHERE USER_ID = ? AND ALBUM_NAME = ? AND PHOTO_NAME = ?";
            PreparedStatement pstmt = dbConn.prepareStatement(sql);
            pstmt.setInt(1, userID);
            pstmt.setString(2, albumName);
            pstmt.setString(3, photoName);
            pstmt.executeUpdate();
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
            String sql = "SELECT * FROM lovebirds_schema.IMAGES WHERE USER_ID = ? AND ALBUM_NAME = ?";
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
            System.out.println(e.getSQLState());
            System.out.println(e.getNextException());
            System.out.println(e.getMessage());
            return null;
        }
    }

    public boolean updateAlbum(int userID, String albumName, String newAlbumName) {
        try{
            this.db.connect();
            Connection dbConn = db.getConnection();
            String sql = "UPDATE lovebirds_schema.IMAGES SET ALBUM_NAME = ? WHERE USER_ID = ? AND ALBUM_NAME = ?";
            PreparedStatement pstmt = dbConn.prepareStatement(sql);
            pstmt.setString(1, newAlbumName);
            pstmt.setInt(2, userID);
            pstmt.setString(3, albumName); 
            pstmt.executeUpdate();
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
            String sql = "DELETE FROM lovebirds_schema.IMAGES WHERE ALBUM_NAME = ? AND USER_ID = ?";
            PreparedStatement pstmt = dbConn.prepareStatement(sql);
            pstmt.setString(1, albumName);
            pstmt.setInt(2, userID);
            pstmt.executeUpdate();
            return true;
        } catch(SQLException e){
            System.out.println("Could not updateAlbum. Please try again.");
            return false;
        }
    }



}
