package sliders;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.HorizontalSliderPage;
import static org.testng.Assert.assertEquals;

public class HorizontalSliderTests extends BaseTest {

    /**
     * Test checking the functionality of a horizontal slider using key presses,
     * and checking the correct slider range
     */

    @Test
    public void HorizontalSliderCheckTest(){
        int arrowPresses = 8;
        var horizontalSliderPage = homePage.clickHorizontalSlider();
        horizontalSliderPage.sliderClick();
        horizontalSliderPage.sliderMove(arrowPresses);
        assertEquals(horizontalSliderPage.getRange(),horizontalSliderPage.arrowRange(), "Incorrect slider range");
    }
}
