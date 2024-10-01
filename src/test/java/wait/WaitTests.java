package wait;

import base.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class WaitTests extends BaseTest {

    /**
     * Test including a wait for the invisibility of a present element in the DOM to be absent
     */

    @Test
    public void waitUntilHiddenCheck(){
        var loadingPage1 = homePage.clickDynamicLoading().clickExample1();
        loadingPage1.clickStart();
        assertEquals(loadingPage1.getLoadedText(), "Hello World!", "Incorrect Loaded Text");
    }

    /**
     * Test including a wait for the visibility of an element not immediately present in the DOM
     */

    @Test
    public void waitUntilPresentCheck(){
        var loadingPage2 = homePage.clickDynamicLoading().clickExample2();
        loadingPage2.clickStart();
        assertEquals(loadingPage2.getLoadedText(), "Hello World!", "Incorrect Loaded Text");
    }
}