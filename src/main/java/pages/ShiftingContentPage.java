package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ShiftingContentPage {

    private WebDriver driver;
    private By example1 = By.xpath("//*[@id=\"content\"]/div/a[1]");

    public ShiftingContentPage (WebDriver driver) {
        this.driver = driver;
    }

    public void example1Click(){
        driver.findElement(example1).click();
    }

    public List<WebElement> getMenuElements(){
        return driver.findElements(By.tagName("li"));
    }

}
