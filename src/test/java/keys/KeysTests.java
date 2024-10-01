package keys;

import base.BaseTest;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class KeysTests extends BaseTest {

    /**
     * Test to check specific Key Presses, interaction with the input field not a requirement
     */

    @Test
    public void testBackSpace(){
        var keyPage = homePage.clickKeyPresses();
        keyPage.enterText("X" + Keys.BACK_SPACE);
        assertEquals(keyPage.getResult(), "You entered: BACK_SPACE");
    }

    /**
     * Test checking a continuous sequence of key presses
     * a validation step can be added to check for the input text
     */

    @Test
    public void testSectionSign(){
        var keyPage = homePage.clickKeyPresses();
        keyPage.enterSectionSign();
    }


}
