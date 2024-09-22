package cookies;

import base.BaseTest;
import org.testng.annotations.Test;

public class CookiesTests extends BaseTest {


    @Test
    public void cookieDeletionTest(){
        homePage.deleteCookie("optimizelyBuckets");
        homePage.checkCookie("optimizelyBuckets");
    }
}
