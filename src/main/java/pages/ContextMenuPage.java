package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ContextMenuPage {

    private WebDriver driver;
    private By box = By.id("hot-spot");

    public ContextMenuPage(WebDriver driver){

        this.driver = driver;
    }

    public void clickBox(){
        Actions actions = new Actions(driver);
        actions.contextClick(driver.findElement(box)).perform();
    }

    public void dismissAlert(){
        Alert popup = driver.switchTo().alert();
        popup.accept();
    }

    public String contextText(){
       return driver.switchTo().alert().getText();
    }






}
