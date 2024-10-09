package base;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.HomePage;
import utils.WindowManager;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.events.WebDriverListener;


public class BaseTest {
    public WebDriver driver;
    protected HomePage homePage;

    /**
     * Event listener below monitors and logs WebDriver events such as
     * Before or after clicking an element.
     * Before or after navigating to a page.
     * When an exception is thrown.
     * Before or after finding an element.
     */

    @BeforeClass
    public void SetUp(){
        MyCustomListener listener = new MyCustomListener();
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver(getChromeOptions());
        driver = new EventFiringDecorator<>(listener).decorate(driver);
        goToHomepage();
        //setCookie();
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    /**
     * Method to open the WebDriver on the Testing Homepage
     */

    @BeforeMethod
    public void goToHomepage(){
        driver.get("https://the-internet.herokuapp.com/");
        homePage = new HomePage(driver);
    }

    /**
     * Closing up the WebDriver
     */

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    /**
     * This method records test failures and takes a screenshot at the time of failure,
     * stores them as a PNG file in the resources/screenshots/ folder
     */

    @AfterMethod
    public void recordFailure(ITestResult result){
        if(ITestResult.FAILURE == result.getStatus())
        {
            var viewer = (TakesScreenshot)driver;
            File screenshot = viewer.getScreenshotAs(OutputType.FILE);
            try{
                Files.move(screenshot, new File("resources/screenshots/" + result.getName() + ".png"));
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    /**
     * Method calling WindowManager to handle browser windows and tabs
     */

    public WindowManager getWindowManager(){

        return new WindowManager(driver);
    }

    /**
     * Method for adding several chrome options, currently only infobars disabled being switched on
     */

    private ChromeOptions getChromeOptions(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        //options.addArguments("--headless");
        //options.addArguments("--window-size=1920,1080");
        return options;
    }

    /**
     * Cookie Builder Method being added on Test Start to the homepage
     */

    private void setCookie(){
        Cookie cookie = new Cookie.Builder("Miquel", "123")
                .domain("the-internet.herokuapp.com")
                .build();
        driver.manage().addCookie(cookie);
    }


    /**
     * Listener Class hosting methods to log before and after clicking on web elements
     */

    public class MyCustomListener implements WebDriverListener {

        @Override
        public void beforeClick(WebElement element) {
            System.out.println("Before clicking on: " + element);
        }

        @Override
        public void afterClick(WebElement element) {
            System.out.println("After clicking on: " + element);
        }

    }


}
