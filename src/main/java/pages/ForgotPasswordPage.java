package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPage {

    private WebDriver driver;
    private By emailField = By.id("email");
    private String email = "miquel.work@gmail.com";
    private By submitButton = By.id("form_submit");
    private By confirmationText = By.id("confirmation_text");


    public ForgotPasswordPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickEmailField(){
        driver.findElement(emailField).click();
    }

    public void enterEmail(){
        driver.findElement(emailField).sendKeys(this.email);
    }

    public void submitEmail(){
        driver.findElement(submitButton).click();
    }

    public String validateSubmission(){
        return driver.findElement(confirmationText).getText();
    }


}
