package hover;

import base.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class HoverTests extends BaseTest {

    /**
     * Test checking a Hovering interaction that will trigger a caption
     * Checking the caption triggered upon hover
     * Checking and selecting a link displayed while hovering
     * Clicking on the link and validating the url
     */

    @Test
    public void testHoverUser1(){
        var hoversPage = homePage.clickHovers();
        var caption = hoversPage.hoverOverFigure(1);
        assertTrue(caption.isCaptionDisplayed(), "Caption is not displayed");
        assertEquals(caption.getTitle(), "name: user1", "Caption title is incorrect");
        assertEquals(caption.getLinkText(), "View Profile", "Link text is incorrect");
        assertTrue(caption.getLink().endsWith("/users/1"), "Link is incorrect");
    }
}
