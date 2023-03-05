package baseSelenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseSeleniumTest {
    //String basUrl;
    protected WebDriver webDriver;

    @BeforeClass
    public static void prepareWebDriver() {

        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
    }

    @BeforeMethod
    public void setUp() {
        createWebDriver();
    }

    @AfterMethod
    public void afterEachBaseSeleniumTest() throws InterruptedException {
        if (webDriver != null) {
            TimeUnit.SECONDS.sleep(2);
            webDriver.quit();
        }
    }

    private void createWebDriver() {
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless");
        //driver.manage().window().maximize();
        options.addArguments("start-maximized");
        options.setHeadless(false);
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        //options.addArguments("--window-size=1920,1200");
        //options.addArguments("--incognito");

        //options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        //options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        //options.setPageLoadStrategy(PageLoadStrategy.NONE);
        String userProfile = "C:\\Users\\klamnlo\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 6";
        options.addArguments("user-data-dir=" + userProfile);
        webDriver = new ChromeDriver(options);
    }
}
