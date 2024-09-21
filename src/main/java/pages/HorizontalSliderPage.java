package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;

public class HorizontalSliderPage {

    private WebDriver driver;
    private int arrowPresses;
    private By slider = By.cssSelector(".sliderContainer input");
    private By range = By.id("range");

    public HorizontalSliderPage(WebDriver driver){
        this.driver = driver;
    }

    public void sliderClick(){
        /**  Didnt work
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(slider), 1, 0).click().perform();
         **/
        /**
         * This one works, even though in debug mode it looks like it doesn't
         */
        driver.findElement(slider).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value = 0;", driver.findElement(slider));
    }

    public void sliderMove(int arrowPresses){
        this.arrowPresses = arrowPresses;
        for (int i = 0; i < arrowPresses; i++){
            driver.findElement(slider).sendKeys(Keys.ARROW_RIGHT);
        }
    }

    public int arrowRange(){
        return arrowPresses/2;
    }

    public int getRange (){
        return Integer.parseInt(driver.findElement(range).getText());
    }




}
