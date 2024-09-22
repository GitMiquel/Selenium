package base;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
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


    @BeforeClass
    public void SetUp(){
        MyCustomListener listener = new MyCustomListener();
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver = new EventFiringDecorator<>(listener).decorate(driver);
        goToHomepage();
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    @BeforeMethod
    public void goToHomepage(){
        driver.get("https://the-internet.herokuapp.com/");
        homePage = new HomePage(driver);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

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

    public WindowManager getWindowManager(){

        return new WindowManager(driver);
    }

    private ChromeOptions getChromeOptions(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        return options;
    }

    private void setCookie(){
        Cookie cookie = new Cookie.Builder("Miquel", "123")
                .domain("the-internet.herokuapp.com")
                .build();
        driver.manage().addCookie(cookie);
    }


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
