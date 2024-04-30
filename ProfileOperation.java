public abstract class ProfileOperation {
    
    public abstract Profile createProfile(Profile profile);
    public abstract Profile readProfile(int userID);
    public abstract boolean updateProfile(Profile profile);
    public abstract boolean deleteProfile();
    public abstract Preferences createPreferences();
    public abstract Preferences readPreferences();
    public abstract boolean updatePreferences();
    public abstract boolean deletePreferences();



}
