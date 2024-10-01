package context;

import base.BaseTest;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;


public class ContextMenuTests extends BaseTest {

    /**
     * Test checking a right click interaction with a Context Menu
     */

    @Test
    public void testContextMenu(){
        var contextMenuPage = homePage.clickContextMenu();
        contextMenuPage.clickBox();
        assertEquals(contextMenuPage.contextText(), "You selected a context menu", "Incorrect Context Message");
        contextMenuPage.dismissAlert();
    }

}
