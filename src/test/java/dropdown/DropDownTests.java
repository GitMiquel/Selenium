package dropdown;

import base.BaseTest;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class DropDownTests extends BaseTest {

    @Test
    public void optionSelection1Check(){
        var dropdownPage = homePage.clickDropDown();
        dropdownPage.expandDropdown();
        dropdownPage.selectOption1();
        dropdownPage.checkSelection1();
        assertEquals(dropdownPage.checkSelection1(), "Option 1 is selected.", "Incorrect Option selected");
    }
}
