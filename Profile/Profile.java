public class Profile {
    private String profileID;
    private String emailAddress;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private int height;
    private int weight;
    private int age;
    private String gender;
    private String sexuality;
    private Photo profilePicture;
    private Preferences preferences;

    public Profile(String profileID, String emailAddress, String username, String password, String firstName, String lastName, int height, int weight,
    int age, String gender, String sexuality, Photo profilePicture, Preferences preferences) {
        this.profileID = profileID;
        this.emailAddress = emailAddress;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.height = height;
        this.weight = weight;
        this.age = age;
        this.gender = gender;
        this.sexuality = sexuality;
        this.profilePicture = profilePicture;
        this.preferences = preferences;
    }

    public void enterEmail(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void createUsername(String username) {
        this.username = username;
    }

    public void createPassword(String password) {
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setSexuality(String sexuality) {
        this.sexuality = sexuality;
    }

    public void setProfilePicture(Photo profilePicture) {
        this.profilePicture = profilePicture;
    }

    public void setPreferences(String preferredGender, String preferredSexuality, int minHeight, int maxHeight, int minWeight, int maxWeight, int minAge, int maxAge) {
        this.preferences.setPreferredGender(preferredGender);
        this.preferences.setPreferredSexuality(preferredSexuality);
        this.preferences.setMinHeight(minHeight);
        this.preferences.setMaxHeight(maxHeight);
        this.preferences.setMinWeight(minWeight);
        this.preferences.setMaxWeight(maxWeight);
        this.preferences.setMinAge(minAge);
        this.preferences.setMaxAge(maxAge);
    }
    
}
