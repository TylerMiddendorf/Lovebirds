import java.beans.Transient;

import org.junit.Assert;
import org.junit.Test;

import com.lovebirds.Authentication;
import com.lovebirds.Controller;
import com.lovebirds.FactoryProducer;
import com.lovebirds.Profile;
import com.lovebirds.Preferences;
import com.lovebirds.ProfileOperation;




public class LogoutTest {
    
    @Test
    public void testLogout() {
        Controller controll = new Controller();
        Assert.assertEquals(true, controll.logOut());
    }

}
