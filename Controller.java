import java.util.ArrayList;

class Controller{
    
    private AlbumHandler albumHandler;
    private MatchmakerHandler matchmakerHandler;
    private ProfileHandler profileHandler;
    private ChatHandler chatHandler;
    private PhotoHandler photoHandler;
    

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
     * THIS NEEDS FIXED to take parm
     * also add editPreference method in ProfileHandler
     */
    public boolean editPreferences(){
        return profileHandler.editPreference();
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
     * THIS NEEDS FIXED to take parm
     * calls uploadPhoto in Photo Handler
     * @param
     * @return
     */
    public Photo uploadPhoto(){
        return photoHandler.uploadPhoto();
    }

    /*
     * THIS NEEDS FIXED to take parm
     * calls deletePhoto in Photo Handler
     * @param
     * @return
     */
    public boolean deletePhoto(){
        return photoHandler.deletePhoto();
    }

    /*
     * THIS NEEDS FIXED to take parm
     * calls editAlbum in Album Handler
     * @param
     * @return true if editAlbum is successful
     */
    public boolean editAlbum(){
        return albumHandler.editAlbum();
    }

    /*
     * THIS NEEDS FIXED to take parm
     * calls deleteAlbum in Album Handler
     * @param
     * @return true if deleteAlbum is successful
     */
    public boolean deleteAlbum(){
        return albumHandler.deleteAlbum();
    }

    /*
     * MAYBE NEEDS FIXED to take param
     * calls createAlbum in Album Handler
     * @param
     * @return
     */
    public Album createAlbum(){
        return albumHandler.createAlbum();
    }
    

}