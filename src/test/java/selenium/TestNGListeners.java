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
public class TestNGListeners {
    private WebDriver driver;
    private String baseUrl;
    private WebElement element;
    WebElement button;

    @BeforeMethod
    public void setUp() throws Exception {
        //New webdriver access
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();


        //Old webdriver access
        //System.setProperty("webdriver.gecko.driver", "C:\\Users\\klamnlo\\Downloads\\geckodriver-v0.29.1-win64\\geckodriver.exe");

        //Initializing webdriver for browser
        //driver = new FirefoxDriver();

        baseUrl = "https://www.google.com";
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


    }

    @Test(priority = 1)
    public void TestGoogle() throws Exception {

        //setting the driver executable
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\klamnlo\\source\\Drivers\\chromedriver_win32\\chromedriver.exe");

        //Initiating your chromedriver
        //WebDriver driver = new ChromeDriver();
        driver = new ChromeDriver();

        driver.get("https://www.google.com");
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

        // explicit wait condition
        //WebDriverWait explicitWait = new WebDriverWait(driver,30);

        // presenceOfElementLocated condition
        //explicitWait.until(ExpectedConditions.presenceOfElementLocated (By.cssSelector("h1")));
        //explicitWait.until(ExpectedConditions.presenceOfElementLocated (By.name("btnLogin")));

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

/*
    @Test()
    public static void main(String[] args) throws ClassNotFoundException {
        TestNG test = new TestNG();
        test.setTestClasses(new Class[] { ImplicitWaitTest.class });
        test.run();
    } */
/*
        / identify element
      WebElement p=driver.findElement(By.name("q"));
      //enter text with sendKeys() then apply submit()
      p.sendKeys("Selenium Java");

        // Explicit wait condition for search results
      WebDriverWait w = new WebDriverWait(driver, 5);
      w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul")));

        element = driver.findElement(By.className("gLFyf.gsfi"));
        element = driver.findElement(By.className("gLFyf gsfi"));
        button.click();
        element = driver.findElement(By.className("VfPpkd-vQzf8d"));
        button.click();
        element = driver.findElement(By.className("fake-editable"));

        element.sendKeys("Selenium WebDriver Interview questions");
        element.sendKeys(Keys.RETURN);
        List<WebElement> list = driver.findElements(By.className("_Rm"));
        System.out.println(list.size());
2. Test case
        // get the number of pages
   int size = driver.findElements(By.cssSelector("[valign='top'] > td")).size();
   for(int j = 1 ; j < size ; j++) {
       if (j > 1) {// we don't need to navigate to the first page
           driver.findElement(By.cssSelector("[aria-label='Page " + j + "']")).click(); // navigate to page number j
       }

       String pagesearch = driver.getCurrentUrl();

       List<WebElement> findElements = driver.findElements(By.xpath("//*[@id='rso']//h3/a"));
       System.out.println(findElements.size());

       for(int i=0;i<findElements.size();i++){
           findElements= driver.findElements(By.xpath("//*[@id='rso']//h3/a"));
           findElements.get(i).click();

           driver.navigate().to(pagesearch);
           JavascriptExecutor jse = (JavascriptExecutor) driver;
           //Scroll vertically downward by 250 pixels
           jse.executeScript("window.scrollBy(0,250)", "");
       }
   }
        */
