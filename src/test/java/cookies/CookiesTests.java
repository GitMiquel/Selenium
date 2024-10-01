package cookies;

import base.BaseTest;
import org.testng.annotations.Test;

public class CookiesTests extends BaseTest {

    /**
     * Simple Test of Cookie deletion and search
     */

    @Test
    public void cookieDeletionTest(){
        homePage.deleteCookie("optimizelyBuckets");
        homePage.checkCookie("optimizelyBuckets");
    }
}
