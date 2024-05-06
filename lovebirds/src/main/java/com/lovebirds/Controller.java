package com.lovebirds;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Controller {
    
    private MediaHandler mediaHandler;
    private MatchmakerHandler matchmakerHandler;
    private ProfileHandler profileHandler;
    private ChatHandler chatHandler;
    
    public Controller(){
        mediaHandler = new MediaHandler();
        matchmakerHandler = new MatchmakerHandler();
        profileHandler = new ProfileHandler();
        chatHandler = new ChatHandler();
    }

    /**
     * calls retrieveSugUsers from Matchmaker Handler
     * @param id
     * @return suggestedUsers
     */
    public ArrayList<Profile> retrieveSugUsers(int rating) {
        ArrayList<Profile> suggestedUsers = matchmakerHandler.retrieveSugUsers(rating);
        return suggestedUsers;
    }

    /**
     * calls retrieveSugProfile from Matchmaker Handler
     * @param id
     * @return suggestedProfile
     */
    public Profile retrieveSugProfile(int id) { 
        Profile suggestedProfile = null; //matchmakerHandler.retrieveSugProfile(id);
        return suggestedProfile;
    }

    /**
     * calls filterUsers from Matchmaker Handler
     * @param filter
     * @return filtered
     */
    public ArrayList<Profile> filterUsers(String filter) { 
        ArrayList<Profile> filtered = matchmakerHandler.filterUsers(filter);
        return filtered;
    }


    /**
     * calls retrieveStatistics from Matchmaker Handler
     * @param stat
     * @return statistics
     */
    public boolean retrieveStatistics() {
        boolean statistics = matchmakerHandler.retrieveStatistics();
        return statistics;
    }

    /**
     * calls createProfile from Profile Handler
     * @preturn newProfile
     */
    public boolean createProfile(String username, String email, String firstName, String lastName, String profilePicture, int age, int height, int weight, String gender, String password) {
        Profile newProfile = new Profile(username, email, firstName, lastName, profilePicture, age, height, weight, gender, password);
        boolean created = profileHandler.createProfile(newProfile);
        return created;
    }

    /**
     * calls editProfile in Profile Handler
     * @param profile
     * @return editedProfile
     */
    public boolean editProfile(String elementToEdit, String editedElement){
        boolean editedProfile = profileHandler.editProfile(elementToEdit, editedElement);
        return editedProfile;
    }    

    /**
     * THIS NEEDS FIXED to take param
     * @param
     * @return
     */
    public boolean deleteProfile() {
        boolean deletedProfile = profileHandler.deleteProfile();
        return deletedProfile;
    }

    /**
     * calls rateUser in Profile Handler
     * @param user
     * @return rating
     */
    public boolean rateUser(int recipientID, int rating) {
        boolean rated = matchmakerHandler.rateUser(recipientID, rating);
        return rated;
    }

    /**
     * calls likeUser in Profile Handler
     * @param user
     * @return true if likeUser successful
     */
    public boolean changeRelationship(int recipientID, String relationship) {
        return matchmakerHandler.updateRelationship(recipientID, relationship);
    }

    /*

    private String preferredGender;
    private int minHeight;
    private int maxHeight;
    private int minWeight;
    private int maxWeight;
    private int minAge;
    private int maxAge;

    */

    /**
     * THIS NEEDS FIXED to take parm
     * Also add createPreferences method in ProfileHandler
     */
    public boolean createPreferences(int userID, int minHeight, int maxHeight, int minWeight, int maxWeight, int minAge, int maxAge, String preferredGender) {
        boolean created = profileHandler.createPreferences(userID, minHeight, maxHeight, minWeight, maxWeight, minAge, maxAge, preferredGender);
        return created;
    }

    /**
     * calls editPreferences in profile handler
     * @param user
     * @return true if preferences have been edited/updated
     */
    public boolean editPreferences(String elementToEdit, int editedElement) {
        boolean editedPreferences = profileHandler.editPreferences(elementToEdit, editedElement);
        return editedPreferences;
    }

    public boolean deletePreferences() {
        boolean deletedPreferences = profileHandler.deletePreferences();
        return deletedPreferences;
    }


    /**
     * calls clearConversation in Chat Handler
     * return true if clearConversation successful
     */
    public boolean clearConversation(int recieverID) {
        boolean created = chatHandler.clearConversation(recieverID);
        return created;
    }

    /**
     * calls sendMessage in Chat Handler
     * return true if sendMessage successful
     */
    public boolean sendMessage(String message, int recieverID) {
        boolean created = chatHandler.sendMessage(message, recieverID);
        return created;
    }

    /*
    MediaHandler has been created to encapsulate the Photo and Album methods,
    needs to be updated. I'm just commenting this out to prevent the errors.
    */

    public boolean createPhoto(String path, String albumName, String photoName){
        mediaHandler.createPhoto(path, albumName, photoName);
        return true;
    }
    
    public boolean uploadPhoto(String path, String albumName, String photoName){
        mediaHandler.uploadPhoto(path, albumName, photoName);
        return true;
    }

    
    public boolean deletePhoto(){
        //return mediaHandler.deletePhoto();
        return true;
    }

    
    public boolean editAlbum(String albumName, String newAlbumName){
        boolean edited = mediaHandler.editAlbum(albumName, newAlbumName);
        return true;
    }

   
    public boolean deleteAlbum(){
        //return mediaHandler.deleteAlbum();
        return true;
    }


    /**
     * handles login of account
     * @param username and password
     * @returns int exception handling?
     */
    public int logIn(String username, String password)
    {
        return Authentication.authenticateLogIn(username, password);
    }

    public Profile initializeProfile(int userID)
    {
        Profile profile = profileHandler.initializeProfile(userID);
        return profile;
    } 

    /**
     * handles logout of account
     */
    public boolean logOut() {
        return true;
    }

    /***
     * invokes forgot password in Authentication
     * @param email - user's email
     * @param username - user's username
     * @param newPassword - new password user wants
     * @return true if Profile found and password updated, false if Profile not found
     */
    public boolean forgotPassword(String email, String username, String newPassword) {
        boolean authenticated = Authentication.authenticateForgotPassword(email, username, newPassword);
        return authenticated;
    }

    public String[] getMessages(int recieverID) {
        return chatHandler.getMessages(recieverID);
    }

    public String[] getMatched(){
        return chatHandler.getMatched();
    }

    public int getChatUser(int index){
        return chatHandler.getUser(index);
    }

    public BufferedImage getImage(int userID){
        return mediaHandler.getImage(userID);
    }

    /**
     * invokes getProfileDetails in handler
     * @return profile toString
     */
    public String getProfileDetails(){
        return profileHandler.getProfileDetails();
    }

}