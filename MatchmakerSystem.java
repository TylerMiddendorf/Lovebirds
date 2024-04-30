import java.util.ArrayList;

/*
 * Make a ProfilePool class to utilize the design pattern Rishi referenced. He 
 * emphasized that we should include topics from the lectures, so this would be
 * a way to include that in our project that we can report on and design. 
 */

public class MatchmakerSystem {
    
    private ArrayList<Profile> matches;

    // implement generateMatches and removeMatch methods below later
    public ArrayList generateMatches(Profile profile) {

        Preferences userPreferences = profile.getPreferences();
        int minAge = userPreferences.getMinAge();
        int maxAge = userPreferences.getMaxAge();
        int minWeight = userPreferences.getMinWeight();
        int maxWeight = userPreferences.getMaxAge();
        String preferredGender = userPreferences.getPreferredGender();
        
        ArrayList<Profile> matches = new ArrayList<Profile>();

        return matches;
    }

    // public void removeMatch(Profile profile) {
    
    // }


 }
