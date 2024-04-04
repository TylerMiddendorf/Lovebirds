public class ProfileHandler{
    private Profile profile;

    public ProfileHandler()
    {
        this.profile = null;
    }

    public Profile createProfile()
    {
        Profile profile = null; // input the username and other data?

        return profile;
    }

    public Profile editProfile(Profile profile)
    {
        //edit the profile

        return profile;
    }

    public boolean deleteProfile(Profile profile)
    {
        // delete the profile from the database?
        profile = null;

        return true; // profile deleted 
    }

    public boolean blockUser(Profile user)
    {
        // take user out of the profiles matches forever

        return true; // user has been blocked
    }

    public boolean dismissUser(Profile user)
    {
        // take user out of the profiles matches

        return true; // user has been dismissed
    }

    public int rateUser(Profile user)
    {
        int rating = 0;
        //prompt for rating, set rating

        return rating;
    }

    public boolean likeUser(Profile user)
    {
        boolean liked = false;
        // user may or may not like the user, if they do then turn true
        return liked;
    }

    public boolean clearConversation()
    {
        return true; // conversation has been cleared
    }

    public boolean sendMessage()
    {
        return true; // message has been sent
    }

    public boolean unmatchUser(Profile user)
    {
        return true; // user has been unmatched
    }


     
}
