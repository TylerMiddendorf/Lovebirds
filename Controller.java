import java.util.ArrayList;

class Controller{
    
    private AlbumHandler albumHandler;
    private MatchmakerHandler matchmakerHandler;
    private ProfileHandler profileHandler;
    private ChatHandler chatHandler;
    private PhotoHandler photoHandler;
    

    /*
     * calls retrieveSugUsers from Matchmaker handler
     * @param id
     * @return suggestedUsers
     */
    public ArrayList<Profile> retrieveSugUsers(int id){
        ArrayList<Profile> suggestedUsers = matchmakerHandler.retrieveSugUsers(id);
        return suggestedUsers;
    }

    /*
     * does stuff
     * @param id
     * @return suggestedProfile
     */
    public ArrayList<Profile> retrieveSugProfile(int id){
        ArrayList<Profile> suggestedProfile = matchmakerHandler.retrieveSugProfile(id);
        return suggestedProfile;
    }

}