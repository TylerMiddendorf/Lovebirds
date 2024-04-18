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
     * @return true if block sucessful
     */
    public boolean blockUser(Profile user){
        return profileHandler.blockUser(user);
    }

    /*
     * calls dismissUser in Profile Hanlder
     * @param user
     * @return true if dismiss sucessful
     */
    public boolean dismissUser(Profile user){
        return profileHandler.dismissUser(user);
    }

}