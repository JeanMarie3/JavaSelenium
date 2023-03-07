package baseSelenium;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(TypesListeners.class)
public class JavaSeleniumTest extends BaseSeleniumTest {

    @Test(priority = 1, enabled = true)
    public void testGoogleSearch() throws InterruptedException {
        TestCases testCase = new JavaSelenium(webDriver);
        testCase.urls(urlGoogle);
        testCase.GoogleSearch();


    }

    @Test(priority = 2, enabled = true)
    public void testGuru99Search() throws InterruptedException {
        TestCases testCase = new JavaSelenium(webDriver);
        testCase.urls(urlGuru99);
        testCase.Guru99Search();
    }

    @Test(priority = 3, enabled = true)
    public void testGithubLoginDemo() {
        TestCases testCases = new JavaSelenium(webDriver);
        testCases.GithubLoginDemo();
    }

    @Test(priority = 4, enabled = true)
    public void testLoggedInUser() {
        TestCases testCases = new JavaSelenium(webDriver);
        testCases.LoggedInUser();
    }

    @Test(priority = 5, enabled = true)
    public void testPopupAlertWindowHandling() {
        TestCases testCases = new JavaSelenium(webDriver);
        testCases.PopupAlertWindowHandling();
    }

    @Test(priority = 6,  enabled = true)
    public void testPrintCookie() {
        TestCases testCases = new JavaSelenium(webDriver);
        testCases.PrintCookie();
    }


    @Test
    public void testOtherSeleniumFeatures() {
        TestCases testCase = new JavaSelenium(webDriver);
        testCase.urls(urlGoogle);
        testCase.OtherSeleniumFeatures();
    }
}