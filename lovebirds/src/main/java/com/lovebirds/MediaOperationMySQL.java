package com.lovebirds;

import java.awt.image.*;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.imageio.*;

public class MediaOperationMySQL extends MediaOperation { // 

    private MySQLDatabase db;

    public MediaOperationMySQL(MySQLDatabase db) {
        this.db = db;
    }
    
    
    public boolean createPhoto(Photo photo, String album, int UID) {
        
        String path = photo.getFilePath();
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
            String sql = "INSERT INTO MESSAGES(USERID, ALBUMNAME, PHOTO) VALUES (?, ?, ?)";
            PreparedStatement pstmt = dbConn.prepareStatement(sql);
            pstmt.setInt(1, UID);
            pstmt.setString(2, album);
            pstmt.setBlob(3,  is);
            
        } catch (SQLException e) {
            System.out.println("Could not create image. Please try again.");
            return false;
        }
    
        return true;
    }

    public Photo readPhoto(int userID) {
        this.db.connect();
        Connection dbConn = db.getConnection();
        return null;
    }

    public boolean deletePhoto(int userID) {
        this.db.connect();
        Connection dbConn = db.getConnection();
        return true;
    }

    public Album createAlbum(int userID, String albumName) {
        this.db.connect();
        Connection dbConn = db.getConnection();
        return null;
    }

    public Album readAlbum(int userID, String albumName) {
        this.db.connect();
        Connection dbConn = db.getConnection();
        return new Album(null, null);
    }

    public boolean updateAlbum(int userID, String albumName) {
        this.db.connect();
        Connection dbConn = db.getConnection();
        return true;
    }

    public boolean deleteAlbum(int userID, String albumName) {
        this.db.connect();
        Connection dbConn = db.getConnection();
        return true;
    }

}
