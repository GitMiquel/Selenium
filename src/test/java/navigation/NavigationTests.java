package navigation;

import base.BaseTest;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pages.DynamicLoadingExample2Page;

public class NavigationTests extends BaseTest {

    /**
     * Test checking different navigation interactions with the browser page
     */

    @Test
    public void testNavigator(){
        homePage.clickDynamicLoading().clickExample1();
        getWindowManager().goBack();
        getWindowManager().refreshPage();
        getWindowManager().goForward();
        getWindowManager().goTo("https://youtube.com");
    }

    /**
     * Test checking the interaction with opening a new tab and switching to it
     */

    @Test
    public void testSwitchTab(){
        homePage.clickMultipleWindows().clickHere();
        getWindowManager().switchToTab("New Window");
    }

    /**
     * Test opening a new tab containing dynamically loading web Element that is not immediately present in the DOM
     */

    @Test
    public void testOpenOnNewTab(){
        homePage.clickDynamicLoading().rightClickExample2();
        getWindowManager().switchToNewHandle();
        DynamicLoadingExample2Page newTabPage = PageFactory.initElements(driver, DynamicLoadingExample2Page.class);
        System.out.println(newTabPage.presenceOfStart());



    }


}
