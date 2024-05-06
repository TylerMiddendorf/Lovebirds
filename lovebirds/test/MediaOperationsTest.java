import org.junit.Assert;
import org.junit.Test;

import com.lovebirds.Authentication;
import com.lovebirds.FactoryProducer;
import com.lovebirds.MediaOperationMySQL;
import com.lovebirds.Profile;
import com.lovebirds.Preferences;
import com.lovebirds.ProfileOperation;


public class MediaOperationsTest {
    @Test
    public void testCreateProfile() {
        MediaOperation MediaOperationOperation = FactoryProducer.getSQLFactory().getMedia("MySQL");
        int profileID = 1;
        String path = "test.png"; 
        String album = "pizza";
        String name = "test";
        int uid = 2;
        boolean created = mediaOperation.createPhoto(test.png, album, name,uid);
        Assert.assertEquals(true, created);
    }
    @Test
    public void testDeleteProfile() {
        MediaOperation MediaOperationOperation = FactoryProducer.getSQLFactory().getMedia("MySQL");
        int profileID = 1;
        String path = "test.png"; 
        String album = "pizza";
        String name = "test";
        int uid = 2;
        boolean created = mediaOperation.deletePhoto(uid, album, name);
        Assert.assertEquals(true, created);
    }

}
