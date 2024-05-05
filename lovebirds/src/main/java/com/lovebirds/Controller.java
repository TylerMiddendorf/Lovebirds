package com.lovebirds;

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

    /*
     * calls retrieveSugUsers from Matchmaker Handler
     * @param id
     * @return suggestedUsers
     */
    public ArrayList<Profile> retrieveSugUsers(int id) {
        ArrayList<Profile> suggestedUsers = matchmakerHandler.retrieveSugUsers(id);
        return suggestedUsers;
    }

    /*
     * calls retrieveSugProfile from Matchmaker Handler
     * @param id
     * @return suggestedProfile
     */
    public ArrayList<Profile> retrieveSugProfile(int id) { 
        ArrayList<Profile> suggestedProfile = matchmakerHandler.retrieveSugProfile(id);
        return suggestedProfile;
    }

    /*
     * calls filterUsers from Matchmaker Handler
     * @param filter
     * @return filtered
     */
    public ArrayList<Profile> filterUsers(String filter) { 
        ArrayList<Profile> filtered = matchmakerHandler.filterUsers(filter);
        return filtered;
    }


    /*
     * calls retrieveStatistics from Matchmaker Handler
     * @param stat
     * @return statistics
     */
    public ArrayList<String> retrieveStatistics(String stat) {
        ArrayList<String> statistics = matchmakerHandler.retrieveStatistics(stat);
        return statistics;
    }

    /*
     * calls createProfile from Profile Handler
     * @preturn newProfile
     */
    public boolean createProfile(String username, String email, String firstName, String lastName, String profilePicture, int age, int height, int weight, String gender, String password) {
        Profile newProfile = new Profile(username, email, firstName, lastName, profilePicture, age, height, weight, gender, password);
        boolean created = profileHandler.createProfile(newProfile);
        return created;
    }

    /*
     * calls editProfile in Profile Handler
     * @param profile
     * @return editedProfile
     */
    public boolean editProfile(String elementToEdit, String editedElement){
        boolean editedProfile = profileHandler.editProfile(elementToEdit, editedElement);
        return editedProfile;
    }    

    /*
     * THIS NEEDS FIXED to take param
     * @param
     * @return
     */
    public boolean deleteProfile() {
        boolean deletedProfile = profileHandler.deleteProfile();
        return deletedProfile;
    }

    /*
     * calls blockUser in Profile Handler
     * @param user
     * @return true if block successful
     */
    public boolean blockUser(Profile user) {
        return profileHandler.blockUser(user);
    }

    /*
     * calls dismissUser in Profile Hanlder
     * @param user
     * @return true if dismissUser successful
     */
    public boolean dismissUser(Profile user) {
        return profileHandler.dismissUser(user);
    }

    /*
     * calls rateUser in Profile Handler
     * @param user
     * @return rating
     */
    public boolean rateUser(Profile user) {
        return profileHandler.rateUser(user);
    }

    /*
     * calls likeUser in Profile Handler
     * @param user
     * @return true if likeUser successful
     */
    public boolean likeUser(Profile user) {
        return profileHandler.likeUser(user);
    }

    /*
     * calls unmatchUnser in Profile Handler
     * @param user
     * @return true if unmatchUser successful
     */
    public boolean unmatchUser(Profile user) {
        return profileHandler.unmatchUser(user);
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

    /*
     * THIS NEEDS FIXED to take parm
     * Also add createPreferences method in ProfileHandler
     */
    public boolean createPreferences(int userID, int minHeight, int maxHeight, int minWeight, int maxWeight, int minAge, int maxAge, String preferredGender) {
        boolean created = profileHandler.createPreferences(userID, minHeight, maxHeight, minWeight, maxWeight, minAge, maxAge, preferredGender);
        return created;
    }

    /*
     * calls editPreferences in profile handler
     * @param user
     * @return true if preferences have been edited/updated
     */
    public boolean editPreferences(Profile user) {
        boolean created = profileHandler.editPreferences(user);
        return created;
    }

    public boolean deletePreferences() {
        boolean deletedPreferences = profileHandler.deletePreferences();
        return deletedPreferences;
    }


    /*
     * calls clearConversation in Chat Handler
     * return true if clearConversation successful
     */
    public boolean clearConversation(int recieverID) {
        boolean created = chatHandler.clearConversation(recieverID);
        return created;
    }

    /*
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
    
    public Photo uploadPhoto(){
        return mediaHandler.uploadPhoto();
    }

    
    public boolean deletePhoto(){
        return mediaHandler.deletePhoto();
    }

    
    public boolean editAlbum(){
        return  mediaHandler.editAlbum();
    }

   
    public boolean deleteAlbum(){
        return albumHandler.deleteAlbum();
    }

  
    public Album createAlbum(){
        return mediaHandler.createAlbum();
    }

    */

    /*
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

    /*
     * handles logout of account
     */
    public void logOut() {
        
    }

    /**
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
    

}