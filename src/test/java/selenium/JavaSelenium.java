package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Listeners(TypesListeners.class)
public class JavaSelenium {
    private WebDriver driver;
    private String baseUrl;
    private WebElement element;
    private WebElement button;
    @BeforeMethod
    public void setUp() throws Exception {
        //New webdriver access
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();

        //Old webdriver access
        //System.setProperty("webdriver.gecko.driver", "C:\\Users\\klamnlo\\Downloads\\geckodriver-v0.29.1-win64\\geckodriver.exe");

        baseUrl = "https://www.google.com";
    }

    @Test(priority = 1)
    public void TestGoogle() throws Exception {

        //setting the driver executable
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\klamnlo\\source\\Drivers\\chromedriver_win32\\chromedriver.exe");

        //Initiating your chromedriver
        //WebDriver driver = new ChromeDriver();
        driver = new ChromeDriver();
        driver.get(baseUrl);
        //driver.get("https://www.google.com");
        TimeUnit.SECONDS.sleep(10);
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //element = driver.findElement(By.id("lst-ib"));
        WebElement p = driver.findElement(By.name("q"));
        p.sendKeys("Selenium WebDriver Interview questions");
        //driver.findElement(By.name("btnK")).click();
        p.submit();
        driver.manage().window().maximize();

        }

    @Test(priority = 2 , enabled=true)
    public void TestGuru99() throws Exception {
        driver = new FirefoxDriver();

        driver.get("http://demo.guru99.com/");
        WebElement element=driver.findElement(By.xpath("//input[@name='emailid']"));
        element.sendKeys("abc@gmail.com");

        // Initialize and wait till element(link) became clickable - timeout in 10 seconds
        WebElement button = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='btnLogin']")));
        TimeUnit.SECONDS.sleep(4);
//        FluentWait wait = new FluentWait(driver);
//        wait.until(ExpectedConditions.alertIsPresent());

        //WebElement button=driver.findElement(By.xpath("//input[@name='btnLogin']"));
        button.click();
        //Example Of Implicit Wait Command
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Static waiting
        TimeUnit.SECONDS.sleep(3);
        driver.quit();

    }

    @Test(priority = 1, enabled=true)
    public void GithubLoginDemo() throws Exception {

        driver.get("https://github.com/login");
        WebElement element=driver.findElement(By.id("login_field"));
        element.sendKeys("abc@gmail.com");

        WebElement element_password=driver.findElement(By.id("password"));
        element_password.sendKeys("abc@gmail.com");

        WebElement button=driver.findElement(By.xpath("//*[@id='login']/div[4]/form/div/input[12]"));
        button.click();
        //Example Of Implicit Wait Command
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Static waiting
        TimeUnit.SECONDS.sleep(10);

    }

    public void LoggedInUser(){

        WebDriver driver = new ChromeDriver();
        WebElement loggedInUser = driver.findElement(By.id("username"));

    }

    @AfterMethod
    public void tearDown() throws Exception {
        //driver.quit();
        //closing the browser
        //driver.close();
    }


}
