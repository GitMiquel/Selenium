package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DropdownPage {

    private WebDriver driver;
    private By dropdown = By.id("dropdown");
    private By option1 = By.xpath("//*[@id=\"dropdown\"]/option[1]");
    private By option2 = By.xpath("//*[@id=\"dropdown\"]/option[2]");


    public DropdownPage(WebDriver driver){
        this.driver = driver;
    }

    public void expandDropdown(){
        WebElement dropdownElement = driver.findElement(dropdown);
        String script = "arguments[0].setAttribute('multiple', '');";
        ((JavascriptExecutor)driver).executeScript(script, dropdownElement);
    }

    public void selectOption1(){
        driver.findElement(option1).click();
    }

    public String checkSelection1(){
        WebElement option = driver.findElement(option1);
        boolean isSelected = option.isSelected();
        if (isSelected) {
            return "Option 1 is selected.";
        }
        return null;
    }





}
