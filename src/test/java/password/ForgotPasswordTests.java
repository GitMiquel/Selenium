package password;

import base.BaseTest;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class ForgotPasswordTests extends BaseTest {
    /**
     * Test does not work as clicking the submit button at the moment results in a 500
     */
    @Test
    public void retrievePasswordTest(){
        var forgotPasswordPage = homePage.clickForgotPassword();
        forgotPasswordPage.clickEmailField();
        forgotPasswordPage.enterEmail();
        forgotPasswordPage.submitEmail();
        assertEquals(forgotPasswordPage.validateSubmission(), "Your e-mail's been sent!", "Incorrect email submitted");
    }
}
