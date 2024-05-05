package com.lovebirds;

import java.sql.Blob;
import java.util.ArrayList;

public class Profile {
    private int profileID;
    private String emailAddress;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private int height;
    private int weight;
    private int age;
    private String gender;
    private String profilePicture;
    private Preferences preferences;
    private ArrayList<Chat> chats;


    public Profile() {
        
    }

    public Profile(int profileID, String emailAddress, String username, String password, String firstName, String lastName) {
        this.emailAddress = emailAddress;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.profileID = profileID;
    }

    /*
     * Constructor that only takes key values to create profile object
     * will use setters after object creatation to fill height, weight, age, gender, profilePicture, and preferences
     */
    public Profile(String username, String email, String firstName, String lastName, String profilePicture, int age, int height, int weight, String gender, String password) {
        this.emailAddress = email;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.gender = gender;
        this.profilePicture = profilePicture;
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

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public void setPreferences(String preferredGender, int minHeight, int maxHeight, int minWeight, int maxWeight, int minAge, int maxAge) {
        this.preferences.setPreferredGender(preferredGender);
        this.preferences.setMinHeight(minHeight);
        this.preferences.setMaxHeight(maxHeight);
        this.preferences.setMinWeight(minWeight);
        this.preferences.setMaxWeight(maxWeight);
        this.preferences.setMinAge(minAge);
        this.preferences.setMaxAge(maxAge);
    }

    public void setChats(ArrayList<Chat> chats) {
        this.chats = chats;
    }

    public int getProfileID() {
        return profileID;
    }

    public String getEmail() {
        return emailAddress;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public Preferences getPreferences() {
        return preferences;
    }

    public ArrayList<Chat> getChats() {
        return chats;
    }

    /**
     * toString for profile elements
     */
    public String toString()
    {
        String one = "\nUser Details Below\n";
        String two = "Username: " + username + "\n";
        String three = "Email Address: " + emailAddress + "\n";
        String four = "Password: " + password + "\n";
        String five = "First Name: " + firstName + "\n";
        String six = "Last Name: " + lastName + "\n";
        String seven = "Height: " + height + "\n";
        String eight = "Weight: " + weight + "\n";
        String nine = "Age: " + age + "\n";
        String ten = "Gender: " + gender + "\n";
        String eleven = "Profile Picture: " + profilePicture;

        return one + two + three + four + five + six + seven + eight + nine + ten + eleven;
    }
}
