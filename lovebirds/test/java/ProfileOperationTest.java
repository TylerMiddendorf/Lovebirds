import org.junit.Assert;
import org.junit.Test;

import com.lovebirds.Authentication;
import com.lovebirds.FactoryProducer;
import com.lovebirds.Profile;
import com.lovebirds.Preferences;
import com.lovebirds.ProfileOperation;


public class ProfileOperationTest {
    // Marco Hernandez's unit tests: testCreateProfile and testDeleteProfile
    /*
     * Test if a profile was successfully created - Create profile use case
     */
    @Test
    public void testCreateProfile() {
        ProfileOperation profileOperation = FactoryProducer.getSQLFactory().getProfile("MySQL");
        int profileID = 1;
        String email = "email1@gmail.com", username = "username1", password = "password1", first = "firstn", last = "lastn";
        Profile newProfile = new Profile(profileID, email, username, password, first, last);
        boolean created = profileOperation.createProfile(newProfile);
        Assert.assertEquals(true, created);
    }

    /*
     * Test if a profile was successfully deleted - Delete profile use case
     */
    @Test
    public void testDeleteProfile() {
        ProfileOperation profileOperation = FactoryProducer.getSQLFactory().getProfile("MySQL");
        int profileID = 1;
        String email = "email@gmail.com", username = "user", password = "pass", first = "first", last = "last";
        Profile newProfile = new Profile(profileID, email, username, password, first, last);
        boolean deleted = profileOperation.deleteProfile(profileID);
        Assert.assertEquals(true, deleted);
    }

    // Ian Gowland's unit test: testUpdateProfile() and testCreatePreferences()
    /*
     * Test if a profile was successfully updated - Edit profile use case
     */
    @Test
    public void testUpdateProfile() {
        ProfileOperation profileOperation = FactoryProducer.getSQLFactory().getProfile("MySQL");
        int profileID = 1;
        String email = "email@gmail.com", username = "user", password = "pass", first = "first", last = "last";
        Profile newProfile = new Profile(profileID, email, username, password, first, last);
        boolean updated = profileOperation.updateProfile(newProfile);
        Assert.assertEquals(true, updated);
    }

    /*
     * Test if preferences were successfully created - Create preferences use case
     */
    @Test
    public void testCreatePreferences() {
        ProfileOperation profileOperation = FactoryProducer.getSQLFactory().getProfile("MySQL");
        String preferredGender = "Male";
        int userID = 1, minHeight = 0, maxHeight = 2000, minWeight = 0, maxWeight = 2000, minAge = 18, maxAge = 2000;
        String email = "email@gmail.com", username = "username", password = "password", first = "first", last = "last";
        Profile newProfile = new Profile(userID, email, username, password, first, last);
        boolean createdProfile = profileOperation.createProfile(newProfile);
        int uid = Authentication.authenticateLogIn(username, password);
        Preferences newPref = new Preferences(preferredGender, minHeight, maxHeight, minWeight, maxWeight, minAge, maxAge);
        boolean created = profileOperation.createPreferences(uid, newPref);
        Assert.assertEquals(true, created);
    }
    
    // Jacob Spaide's unit tests: testUpdatePreferences() and testDeletePreferences()
    /*
     * Test if preferences were successfully updated - Edit preferences use case
     */
    @Test
    public void testUpdatePreferences() {
        ProfileOperation profileOperation = FactoryProducer.getSQLFactory().getProfile("MySQL");
        String preferredGender = "Male";
        int userID = 1, minHeight = 1, maxHeight = 200, minWeight = 1, maxWeight = 200, minAge = 19, maxAge = 200;
        String email = "email@gmail.com", username = "username", password = "password", first = "first", last = "last";
        int uid = Authentication.authenticateLogIn(username, password);
        Preferences newPref = new Preferences(preferredGender, minHeight, maxHeight, minWeight, maxWeight, minAge, maxAge);
        boolean updated = profileOperation.updatePreferences(uid, newPref);
        Assert.assertEquals(true, updated);
    }

    /*
     * Test if preferences were successfully deleted - Delete preferences use case
     */
    @Test
    public void testDeletePreferences() {
        ProfileOperation profileOperation = FactoryProducer.getSQLFactory().getProfile("MySQL");
        String email = "email@gmail.com", username = "username", password = "password", first = "first", last = "last";
        int uid = Authentication.authenticateLogIn(username, password);
        boolean deleted = profileOperation.deletePreferences(uid);
        Assert.assertEquals(true, deleted);
    }
}
