package com.lovebirds;

import java.util.ArrayList;

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
    private Photo profilePicture;
    private Preferences preferences;
    private ArrayList<Chat> chats;


    public Profile() {
        
    }

    /*
     * Constructor that only takes key values to create profile object
     * will use setters after object creatation to fill height, weight, age, gender, profilePicture, and preferences
     */
    public Profile(String profileID, String emailAddress, String username, String password, String firstName, String lastName) {
        this.profileID = profileID;
        this.emailAddress = emailAddress;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
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

    public void setProfilePicture(Photo profilePicture) {
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

    public String getProfileID() {
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

    public Photo getProfilePicture() {
        return profilePicture;
    }

    public Preferences getPreferences() {
        return preferences;
    }

    public ArrayList<Chat> getChats() {
        return chats;
    }
}