package shifting;

import base.BaseTest;
import org.testng.annotations.Test;

public class ShiftingContentTests extends BaseTest {

    /**
     * Test checking for the presence of elements within the DOM, that render differently every time the page is refreshed
     */

    @Test
    public void menuCountTests(){
        var shiftingContentPage = homePage.clickShiftingContent();
        shiftingContentPage.example1Click();
        System.out.println(shiftingContentPage.getMenuElements().size());

    }
}
