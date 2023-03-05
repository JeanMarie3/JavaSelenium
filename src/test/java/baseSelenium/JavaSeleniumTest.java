package baseSelenium;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(TypesListeners.class)
public class JavaSeleniumTest extends BaseSeleniumTest {

    TestCases testCases2 = new JavaSelenium(webDriver);
    @Test(priority = 1, enabled = true)
    public void testGoogleSearch() throws InterruptedException {
        TestCases testCases = new JavaSelenium(webDriver);
        testCases.GoogleSearch();

        // Initialize and wait till element(link) became clickable - timeout in 10 seconds
//        WebElement button = new WebDriverWait(driver, Duration.ofSeconds(30))
//                .until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='btnLogin']")));

    }

    @Test(priority = 2, enabled = true)
    public void testGuru99Search() throws InterruptedException {
        TestCases testCases = new JavaSelenium(webDriver);
        testCases.Guru99Search();
    }

    @Test(priority = 3, enabled = true)
    public void testGithubLoginDemo() {
        TestCases testCases = new JavaSelenium(webDriver);
        testCases.GithubLoginDemo();
    }

    @Test(priority = 4, enabled = false)
    public void testLoggedInUser() {
        TestCases testCases = new JavaSelenium(webDriver);
        testCases.LoggedInUser();
    }

    @Test(priority = 5, enabled = false)
    public void testPopupAlertWindowHandling() {
        TestCases testCases = new JavaSelenium(webDriver);
        testCases.PopupAlertWindowHandling();
    }

    @Test(priority = 6,  enabled = true)
    public void testPrintCookie() {
        TestCases testCases = new JavaSelenium(webDriver);
        testCases.PrintCookie();
    }

}