package js;

import base.BaseTest;
import org.testng.annotations.Test;

public class JavaScriptTests extends BaseTest {

    /**
     * Test that executes a JavaScript script to scroll a table from the DOM into window view
     */

    @Test
    public void testScrollToTable(){
        homePage.clickLargeAndDeepDom().scrollToTable();
    }

    /**
     * Test that executes a JavaScript script to scroll to an element that is not immediately present within the DOM
     * until scrolled to
     */

    @Test
    public void testScrollToFifthParagraph(){
        homePage.clickInfiniteScroll().scrollToParagraph(5);
    }
}