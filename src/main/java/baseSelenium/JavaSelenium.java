package baseSelenium;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class JavaSelenium implements TestCases {

    private WebDriver driver;

    public JavaSelenium(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public void GoogleSearch() throws InterruptedException {
        driver.get("https://www.google.com");
        WebElement p = driver.findElement(By.name("q"));
        TimeUnit.SECONDS.sleep(2);
        p.sendKeys("Selenium WebDriver Interview questions");
        p.submit();
    }

    @Override
    public void Guru99Search() throws InterruptedException {
        driver.get("http://demo.guru99.com/");
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
        new ChromeDriver((ChromeOptions) driver);
        WebElement element = driver.findElement(By.xpath("//input[@name='emailid']"));
        element.sendKeys("abc@gmail.com");
        WebElement button = driver.findElement(By.xpath("//input[@name='btnLogin']"));
        button.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement element_password = driver.findElement(By.id("password"));
        element_password.sendKeys("abc@gmail.com");

        WebElement loggedInUser = driver.findElement(By.id("username"));
        System.out.println(loggedInUser);
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

}

