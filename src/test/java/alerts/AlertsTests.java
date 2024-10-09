package alerts;

import base.BaseTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertEquals;
import static org.testng.asserts.SoftAssert.*;

public class AlertsTests extends BaseTest {

    /**
     * Test Checking that a Javascript alert has been triggered and accepted
     */
    @Test
    public void testAcceptAlert() {
        var alertsPage = homePage.clickJSAlerts();
        alertsPage.triggerAlert();
        alertsPage.acceptAlert();
        assertEquals(alertsPage.getResult(), "You successfully clicked an alert", "Incorrect Result Text");
    }

    /**
     * Test Checking the text within a Javascript alert and that it can be successfully dismissed
     */

    @Test
    public void testGetAlertText() {
        var alertsPage = homePage.clickJSAlerts();
        alertsPage.triggerConfirm();
        String text = alertsPage.getAlertText();
        alertsPage.dismissAlert();
        assertEquals(text, "I am a JS Confirm", "Incorrect Alert Text");
    }

    /**
     * Test Checking the interaction with a text input field within a Javascript alert
     */

    @Test
    public void testSetInputAlert(){
        SoftAssert softAssert = new SoftAssert();
        var alertsPage = homePage.clickJSAlerts();
        String text = "My Selenium Project";

        alertsPage.triggerPrompt();
        alertsPage.setInputAlert(text);
        alertsPage.acceptAlert();
        softAssert.assertEquals(alertsPage.getResult(), "You entered: " + text, "Incorrect Results Text");
        softAssert.assertAll();
    }
}
