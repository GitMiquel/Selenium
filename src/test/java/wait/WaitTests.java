package wait;

import base.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class WaitTests extends BaseTest {

    @Test
    public void waitUntilHiddenCheck(){
        var loadingPage1 = homePage.clickDynamicLoading().clickExample1();
        loadingPage1.clickStart();
        assertEquals(loadingPage1.getLoadedText(), "Hello World!", "Incorrect Loaded Text");
    }


    @Test
    public void waitUntilPresentCheck(){
        var loadingPage2 = homePage.clickDynamicLoading().clickExample2();
        loadingPage2.clickStart();
        assertEquals(loadingPage2.getLoadedText(), "Hello World!", "Incorrect Loaded Text");
    }
}