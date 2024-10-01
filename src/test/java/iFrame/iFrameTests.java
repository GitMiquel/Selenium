package iFrame;

import base.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class iFrameTests extends BaseTest {

    /**
     * Test inputting a set of 3 indented strings of text in a Text Editor contained within an iFrame
     */

    @Test
    public void testWysiwyg(){
        var editorPage = homePage.clickWysiwygEditor();
        editorPage.clearTextArea();

        String text1 = "My ";
        String text2 = "Selenium";
        String text3 = " Project.";

        editorPage.setTextArea(text1);
        editorPage.decreaseIndention();
        editorPage.setTextArea(text2);
        editorPage.decreaseIndention();
        editorPage.setTextArea(text3);

        assertEquals(editorPage.getTextFromEditor(), text1+text2+text3, "Incorrect editor text");
    }
}