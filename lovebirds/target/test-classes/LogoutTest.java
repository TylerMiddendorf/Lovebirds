import org.junit.Test;

import com.lovebirds.Controller;

import static org.junit.Assert.assertArrayEquals;

public class LogoutTest {

    @Test
    public void testSortedArray() {
        Controller controller = new Controller();
        boolean output = controller.logOut();
        assertEquals(true, output);
    }
}
