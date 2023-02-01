package selenium;

public class notes {


}

// explicit wait condition
//WebDriverWait explicitWait = new WebDriverWait(driver,30);

// presenceOfElementLocated condition
//explicitWait.until(ExpectedConditions.presenceOfElementLocated (By.cssSelector("h1")));
//explicitWait.until(ExpectedConditions.presenceOfElementLocated (By.name("btnLogin")));


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

