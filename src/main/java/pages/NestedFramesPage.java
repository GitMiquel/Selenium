package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class NestedFramesPage {

    private WebDriver driver;
    private String parentFrame = "frame-top";
    private String leftFrame = "frame-left";
    private String bottomFrame = "frame-bottom";
    private By body = By.tagName("body");


    public NestedFramesPage(WebDriver driver){
        this.driver = driver;
    }

    public String leftFrameTextSelector(){
        driver.switchTo().frame(parentFrame);
        driver.switchTo().frame(leftFrame);
        String text = getFrameText();
        driver.switchTo().parentFrame();
        driver.switchTo().parentFrame();
        return text;
    }

    public String bottomFrameTextSelector(){
        driver.switchTo().frame(bottomFrame);
        String text = getFrameText();
        driver.switchTo().parentFrame();
        return text;
    }

    public String getFrameText(){
        return driver.findElement(body).getText();
    }

}
