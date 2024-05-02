package com.lovebirds;

import java.util.ArrayList;

class Controller{
    
    private MediaHandler mediaHandler;
    private MatchmakerHandler matchmakerHandler;
    private ProfileHandler profileHandler;
    private ChatHandler chatHandler;
    
    public void Controller(){

    }

    /*
     * calls retrieveSugUsers from Matchmaker Handler
     * @param id
     * @return suggestedUsers
     */
    public ArrayList<Profile> retrieveSugUsers(int id){
        ArrayList<Profile> suggestedUsers = matchmakerHandler.retrieveSugUsers(id);
        return suggestedUsers;
    }

    /*
     * calls retrieveSugProfile from Matchmaker Handler
     * @param id
     * @return suggestedProfile
     */
    public ArrayList<Profile> retrieveSugProfile(int id){
        ArrayList<Profile> suggestedProfile = matchmakerHandler.retrieveSugProfile(id);
        return suggestedProfile;
    }

    /*
     * calls filterUsers from Matchmaker Handler
     * @param filter
     * @return filtered
     */
    public ArrayList<Profile> filterUsers(String filter){
        ArrayList<Profile> filtered = matchmakerHandler.filterUsers(filter);
        return filtered;
    }


    /*
     * calls retrieveStatistics from Matchmaker Handler
     * @param stat
     * @return statistics
     */
    public ArrayList<String> retrieveStatistics(String stat){
        ArrayList<String> statistics = matchmakerHandler.retrieveStatistics(stat);
        return statistics;
    }

    /*
     * calls createProfile from Profile Handler
     * @preturn newProfile
     */
    public Profile createProfile()
    {
        Profile newProfile = profileHandler.createProfile();
        return newProfile;
    }

    /*
     * calls editProfile in Profile Handler
     * @param profile
     * @return editedProfile
     */
    public Profile editProfile(Profile profile){
        Profile editedProfile = profileHandler.editProfile(profile);
        return editedProfile;
    }

    /*
     * THIS NEEDS FIXED to take param
     * @param
     * @return
     */
    public boolean deleteProfile(){
        return false;
    }

    /*
     * calls blockUser in Profile Handler
     * @param user
     * @return true if block successful
     */
    public boolean blockUser(Profile user){
        return profileHandler.blockUser(user);
    }

    /*
     * calls dismissUser in Profile Hanlder
     * @param user
     * @return true if dismissUser successful
     */
    public boolean dismissUser(Profile user){
        return profileHandler.dismissUser(user);
    }

    /*
     * calls rateUser in Profile Handler
     * @param user
     * @return rating
     */
    public int rateUser(Profile user){
        return profileHandler.rateUser(user);
    }

    /*
     * calls likeUser in Profile Handler
     * @param user
     * @return true if likeUser successful
     */
    public boolean likeUser(Profile user){
        return profileHandler.likeUser(user);
    }

    /*
     * calls unmatchUnser in Profile Handler
     * @param user
     * @return true if unmatchUser successful
     */
    public boolean unmatchUser(Profile user){
        return profileHandler.unmatchUser(user);
    }

    /*
     * THIS NEEDS FIXED to take parm
     * Also add createPreferences method in ProfileHandler
     */
    public Preferences createPreferences(){
        return profileHandler.createPreferences();
    }

    /*
     * calls editPreferences in profile handler
     * @param user
     * @return true if preferences have been edited/updated
     */
    public boolean editPreferences(Profile user){
        return profileHandler.editPreferences(user);
    }

    /*
     * calls clearConversation in Chat Handler
     * return true if clearConversation successful
     */
    public boolean clearConversation(){
        return chatHandler.clearConversation();
    }

    /*
     * calls sendMessage in Chat Handler
     * return true if sendMessage successful
     */
    public boolean sendMessage(String message){
        return chatHandler.sendMessage(message);
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
        return Authentication.logIn(username, password);
    }

    /*
     * handles logout of account
     */
    public void logOut(){

    }

    /**
     * invokes forgot password in Authentication
     * @param email - user's email
     * @param username - user's username
     * @param newPassword - new password user wants
     * @return Profile object
     */
    public Profile forgotPassword(String email, String username, String newPassword){
        Authentication.authenticateForgotPassword(email, username, newPassword);
        return null;
    }
    

}