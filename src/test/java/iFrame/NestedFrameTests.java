package iFrame;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class NestedFrameTests extends BaseTest {


    private String leftFrameText = "LEFT";
    private String bottomFrameText = "BOTTOM";

    /**
     * Test sequentially interacting with a set of nested frames
     * and checking the output text upon frame selection
     */

    @Test
        public void checkFrameText(){
        var nestedFramePage = homePage.clickFramesPage().clickNestedFrames();
        nestedFramePage.leftFrameTextSelector();
        nestedFramePage.bottomFrameTextSelector();
        assertEquals(nestedFramePage.leftFrameTextSelector(), leftFrameText, "Incorrect Left Frame Text");
        assertEquals(nestedFramePage.bottomFrameTextSelector(), bottomFrameText, "Incorrect Bottom Frame Text");
    }
}
