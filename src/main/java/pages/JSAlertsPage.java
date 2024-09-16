package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JSAlertsPage {
    private WebDriver driver;
    private By triggerAlertButton = By.xpath(".//button[text()='Click for JS Alert']");
    private By triggerConfirmButton = By.xpath(".//button[text()='Click for JS Confirm']");
    private By triggerPromptButton = By.xpath(".//button[text()='Click for JS Prompt']");
    private By results = By.id("result");

    public JSAlertsPage(WebDriver driver){
        this.driver = driver;
    }

    public String getResult(){
        return driver.findElement(results).getText();
    }

    public void triggerAlert(){
        driver.findElement(triggerAlertButton).click();
    }

    public void triggerConfirm(){
        driver.findElement(triggerConfirmButton).click();
    }

    public void triggerPrompt(){
        driver.findElement(triggerPromptButton).click();
    }

    /**#
     * Not a web element so we cant use findElement below
     */
    public void acceptAlert(){
        driver.switchTo().alert().accept();
    }

    public void dismissAlert(){
        driver.switchTo().alert().dismiss();
    }

    public void setInputAlert(String text){
        driver.switchTo().alert().sendKeys(text);
    }

    public String getAlertText(){
        return driver.switchTo().alert().getText();
    }




}
