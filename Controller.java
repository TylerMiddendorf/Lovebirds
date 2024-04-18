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
     * @return suggested
     */
    public ArrayList<Profile> retrieveSugUsers(int id){
        ArrayList<Profile> suggested = matchmakerHandler.retrieveSugUsers(id);
        return suggested;
    }

}