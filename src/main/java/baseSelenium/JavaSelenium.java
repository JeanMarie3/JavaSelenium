package baseSelenium;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class JavaSelenium implements TestCases {

    private WebDriver driver;

    public JavaSelenium(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public void GoogleSearch() throws InterruptedException {
        WebElement p = driver.findElement(By.name("q"));
        p.sendKeys("Selenium WebDriver Interview questions");
        p.submit();

    }

    @Override
    public void Guru99Search() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        WebElement element = driver.findElement(By.xpath("//input[@name='emailid']"));
        element.sendKeys("abc@gmail.com");
        TimeUnit.SECONDS.sleep(2);
        WebElement button = driver.findElement(By.xpath("//input[@name='btnLogin']"));
        button.click();
    }

    @Override
    public void GithubLoginDemo() {

        driver.get("https://github.com/login");
        WebElement element = driver.findElement(By.id("login_field"));
        element.sendKeys("abc@gmail.com");

        WebElement element_password = driver.findElement(By.id("password"));
        element_password.sendKeys("abc@gmail.com");
        WebElement button = driver.findElement(By.xpath("//input[@name='commit']"));
        button.click();

    }

    @Override
    public void LoggedInUser() {
        driver.get("http://demo.guru99.com/");
        WebElement element = driver.findElement(By.xpath("//input[@name='emailid']"));
        element.sendKeys("abc@gmail.com");
        WebElement button = driver.findElement(By.xpath("//input[@name='btnLogin']"));
        button.click();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        String expectedUrl= driver.getCurrentUrl();
        String loggedInUser = driver.findElement(By.xpath("//td[normalize-space()='Atharv@12']")).getText();
        System.out.println(loggedInUser);
        Assert.assertEquals(loggedInUser, "Atharv@12");
    }

    @Override
    public void PopupAlertWindowHandling() {
//        driver = new ChromeDriver();

        // Alert Message handling
        driver.get("http://demo.guru99.com/test/delete_customer.php");
        driver.findElement(By.name("cusid")).sendKeys("53920");
        driver.findElement(By.name("submit")).submit();
        // Switching to Alert
        Alert alert = driver.switchTo().alert();
        // Capturing alert message.
        String alertMessage = driver.switchTo().alert().getText();
        // Displaying alert message
        System.out.println(alertMessage);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Accepting alert
        alert.accept();
    }

    @Override
    public void PrintCookie() {
        Set<Cookie> cookiesList = driver.manage().getCookies();
        for (Cookie getcookies : cookiesList) {
            System.out.println(getcookies);
            // identify element
            WebElement t=driver.findElement(By.xpath("//img[@class='tp-logo']"));
            // get src attribute with getAttribute()
            System.out.println("Src attribute is : " + t.getAttribute("src"));
        }

    }

    @Override
    public void OtherSeleniumFeatures() {
        String expectedUrl= driver.getCurrentUrl();
        System.out.println(expectedUrl);
//        WebElement p = driver.findElement(By.name("q"));
        // Wait for a specific element to be visible on the page
        WebElement p = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
        p.sendKeys("Selenium WebDriver Interview questions");
        p.submit();



        //
//        WebElement waitUntil = driver.findElement(By.cssSelector("div[class='FPdoLc lJ9FBc'] input[name='btnK']"));
//        new WebDriverWait(driver, 30)
//                .until(ExpectedConditions.visibilityOf(waitUntil));
        // Initialize and wait till element(link) became clickable - timeout in 10 seconds
        //.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='btnLogin']")));

    }

    @Override
    public void urls(String url) {
        driver.get(url);
    }

}

