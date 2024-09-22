package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;

    public HomePage (WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage clickFormAuthentication(){
        clickLink("Form Authentication");
        return new LoginPage(driver);
        // If this locator inside this method needed to be used in any other method,
        // it should be added at the global scope,
        // so the locator is not repeated across multiple methods
        // if the locator needed to change, it would have to be changed in multiple places,
        // making the framework more flakey and less easily scalable
    }

    public DropdownPage clickDropDown(){
        clickLink("Dropdown");
        return new DropdownPage(driver);
    }

    public HoversPage clickHovers(){
        clickLink("Hovers");
        return new HoversPage(driver);
    }

    public ShiftingContentPage clickShiftingContent(){
        clickLink("Shifting Content");
        return new ShiftingContentPage(driver);
    }

    public ForgotPasswordPage clickForgotPassword(){
        clickLink("Forgot Password");
        return new ForgotPasswordPage(driver);
    }

    public KeyPressesPage clickKeyPresses(){
        clickLink("Key Presses");
        return new KeyPressesPage(driver);
    }


    public HorizontalSliderPage clickHorizontalSlider(){
        clickLink("Horizontal Slider");
        return new HorizontalSliderPage(driver);
    }

    public JSAlertsPage clickJSAlerts(){
        clickLink("JavaScript Alerts");
        return new JSAlertsPage(driver);
    }

    public FileUploadPage clickUploadFile(){
        clickLink("File Upload");
        return new FileUploadPage(driver);
    }


    public ContextMenuPage clickContextMenu(){
        clickLink("Context Menu");
        return new ContextMenuPage(driver);
    }

    public WysiwygEditorPage clickWysiwygEditor(){
        clickLink("WYSIWYG Editor");
        return new WysiwygEditorPage(driver);
    }

    public FramesPage clickFramesPage(){
        clickLink("Frames");
        return new FramesPage(driver);
    }

    public DynamicLoadingPage clickDynamicLoading(){
        clickLink("Dynamic Loading");
        return new DynamicLoadingPage(driver);
    }

    public LargeAndDeepDomPage clickLargeAndDeepDom(){
        clickLink("Large & Deep DOM");
        return new LargeAndDeepDomPage(driver);
    }

    public InfiniteScrollPage clickInfiniteScroll(){
        clickLink("Infinite Scroll");
        return new InfiniteScrollPage(driver);
    }

    public MultipleWindowsPage clickMultipleWindows(){
        clickLink("Multiple Windows");
        return new MultipleWindowsPage(driver);
    }

    private void clickLink(String linkText){
        driver.findElement(By.linkText(linkText)).click();
    }


    public void deleteCookie(String cookie){
        driver.manage().deleteCookieNamed(cookie);
    }

    public void checkCookie(String cookie){
        Cookie existingCookie = driver.manage().getCookieNamed(cookie);
        if (existingCookie != null) {
            System.out.println("Cookie is present: " + existingCookie);
        } else {
            System.out.println("Cookie is not present.");
        }
    }

}
