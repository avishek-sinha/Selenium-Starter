package demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
//Selenium Imports
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

public class TestCases {
    static ChromeDriver driver;
    // FirefoxDriver driver;

    public static ChromeDriver TestCasesInitializer() {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        // WebDriverManager.firefoxdriver().timeout(30).setup();
        driver = new ChromeDriver();
        // driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver;
    }

    public void endTest() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();
    }

    public void testCase01() {        
        Automate_search_amazon amazon = new Automate_search_amazon();
        amazon.search_amazon_on_google();
        
        // // Navigate to URL https://www.google.com/
        // driver.get("https://www.google.com/");
        // // Click on Search Bar Using Locator "Name" q
        // driver.findElementByName("q").click();
        // // Type in "amazon" in Search bar Using Locator "Name" q
        // driver.findElementByName("q").sendKeys("amazon");
        // // Click on Google Search Button Using Locator "XPath" (//input[@value='Google
        // // Search'])[1]
        // driver.findElementByXPath("(//input[@value='Google Search'])[1]").click();
        // // Validate Amazon.in in search result Using Locator "XPath"
        // // h3[text()='Amazon.in']
        // boolean isDisplayed = driver.findElementByXPath("//h3[text()='Amazon.in']").isDisplayed();
        // System.out.println(isDisplayed);
    }

    public void testCase02() {
        // Navigate to URL https://in.bookmyshow.com/explore/home/chennai
        driver.get("https://in.bookmyshow.com/explore/home/chennai");
        // Locate the locator for hyperlink by using Using Locator "Tag Name" a
        int count = driver.findElementsByTagName("a").size();
        List<WebElement> links = driver.findElementsByTagName("a");
        // Get count of the hyperlinks Using Locator "Tag Name" a
        System.out.println("Count of links: " + links.size());
        // System.out.println(count);
    }

    public void testcase03() throws InterruptedException {
        // Navigate to URL https://www.linkedin.com/
        driver.get("https://www.linkedin.com/");
        // Type "Email or phone: in Username textbox Using Locator "Name" session_key
        driver.findElementByName("session_key").sendKeys("avisheksinha90@gmail.com");
        // Type "Password" in password textbox Using Locator "Name" session_password
        driver.findElementByName("session_password").sendKeys("Admin135$");
        // Click on "Sign in" button Using Locator "XPath" //button[@type='submit']
        driver.findElementByXPath("//button[@type='submit']").click();
        // Print the count of "Who's viewed your profile" Using Locator "XPath"
        // //*[contains(text(),'viewed your
        // profile')]/../../following-sibling::div//strong
        String viewedProfile = driver
                .findElement(
                        By.xpath("//*[contains(text(),'viewed your profile')]/../../following-sibling::div//strong"))
                .getText();
        System.out.println("Who's viewed your profile: " + viewedProfile);
        // Print the count of "Impressions of your post" Using Locator "XPath"
        // //*[text()='Impressions of your post']/../../following-sibling::div//strong
        String impressionPost = driver
                .findElement(By.xpath("//*[text()='Impressions of your post']/../../following-sibling::div//strong"))
                .getText();
        System.out.println("Impressions of your post: " + impressionPost);
        // Click on "Start a post" button Using Locator "XPath"
        // //button[contains(@class,'share-box-feed-entry__trigger')]
        driver.findElementByXPath("//button[contains(@class,'share-box-feed-entry__trigger')]").click();

        // Check "Connection only" options is selected Using locator "XPath"
        // button[contains(@aria-label,'Current setting: Connections.')]
        if (driver
                .findElementByXPath("(//span[@class='share-state-change-button__label'])[2]")
                .getText().equals("Anyone")
                || driver
                        .findElementByXPath(
                                "(//span[@class='share-state-change-button__label'])[2]")
                        .getText().equals("No one")) {
            // Click on button to change visiblity option Using Locator "XPath"
            // //button[contains(@aria-label,'Update the setting')]
            driver.findElementByXPath("//button[contains(@aria-label,'Update the setting')]").click();
            // Select "Connections only" option Using Locator "XPath"
            // //button[@id='CONNECTIONS_ONLY']
            driver.findElementByXPath("//button[@id='CONNECTIONS_ONLY']").click();
            // Click on "Save" button Using Locator "XPath"
            // //button[contains(@class,'share-box-footer__primary-btn artdeco')]
            driver.findElement(By.xpath("//button[contains(@class,'share-box-footer__primary-btn artdeco')]")).click();
        }

        // Type message in textbox Using Locator "XPath" //div[@data-placeholder='What
        // do you want to talk about?']
        driver.findElementByXPath("//div[@data-placeholder='What do you want to talk about?']").sendKeys("SDLC");
        Thread.sleep(1000);
        // Click on "Post" button Using Locator "XPath"
        // //button[contains(@class,'share-actions__primary-action artdeco-button')]
        driver.findElementByXPath("//button[contains(@class,'share-actions__primary-action artdeco-button')]")
                .click();
        // Verify that "Post successful" message is displayed Using Locator "XPath"
        // //*[text()='Post successful.']
        boolean isDisplayed = driver.findElementByXPath("//*[text()='Post successful.']").isDisplayed();
        System.out.println("Post is posted successfully: " + isDisplayed);
    }

    public void testcase04() throws InterruptedException {
        // Navigate to URL https://www.google.com/
        driver.get("https://www.google.com/");
        // Click on Search Bar Using Locator "Name" q
        driver.findElementByName("q").click();
        // Type in "Avishek" in Search bar Using Locator "Name" q
        driver.findElementByName("q").sendKeys("avishek");
        // Click on Google Search Button Using Locator "XPath" (//input[@value='Google
        // Search'])[1]
        driver.findElementByXPath("(//input[@value='Google Search'])[1]").click();
        // Count of links in the search result with name Using Locator "XPath"
        // //h3[text()='Avishek']
        int count = driver.findElements(By.partialLinkText("avishek")).size();
        System.out.println("The count of links in the search result with name avishek: " + count);
    }

    public void testcase05() throws InterruptedException {
        // Navigate to URL https://in.bookmyshow.com/explore/home/chennai
        driver.get("https://in.bookmyshow.com/explore/home/chennai");
        // Click on the right arrow button to scroll right Using Locator "XPath"
        // (//div[@class='sc-lnhrs7-7 faepMR'])[1]
        driver.findElementByXPath("(//div[@class='sc-lnhrs7-7 faepMR'])[1]").click();
        Thread.sleep(1000);
        // Get the image URLs for all the “Recommended Movies” Using Locator "XPath"
        // //h2[text()='Recommended Movies']/../../../following-sibling::div//a
        List<WebElement> listUrl = driver
                .findElementsByXPath("//h2[text()='Recommended Movies']/../../../following-sibling::div//a");
        System.out.println("Number of images url: " + listUrl.size());
        List<WebElement> listUrls = driver
                .findElementsByXPath("//h2[text()='Recommended Movies']/../../../following-sibling::div//a");
        for (int i = 0; i < listUrls.size(); i++) {
            System.out.println(listUrls.get(i).getAttribute("href"));
        }

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0,350)", "");
        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0,350)", "");
        Thread.sleep(2000);
        // Print Name & Language of the 2nd item in the “Premiere” list Using Locator
        // "XPath"
        // (//h2[text()='Premieres']/../../../following-sibling::div//a)[2]//div/following-sibling::div[2]//div/div
        List<WebElement> premiere = driver.findElementsByXPath(
                "(//h2[text()='Premieres']/../../../following-sibling::div//a)[2]//div/following-sibling::div[2]//div/div");
        for (int i = 0; i < premiere.size(); i++) {
            System.out.println(listUrls.get(i).getText());
        }
    }

    public void testcase06() throws InterruptedException, AWTException {
        // Navigate to URL https://www.linkedin.com/
        driver.get("https://www.linkedin.com/");
        // Type "Email or phone: in Username textbox Using Locator "Name" session_key
        driver.findElementByName("session_key").sendKeys("avisheksinha90@gmail.com");
        // Type "Password" in password textbox Using Locator "Name" session_password
        driver.findElementByName("session_password").sendKeys("Admin135$");
        // Click on "Sign in" button Using Locator "XPath" //button[@type='submit']
        driver.findElementByXPath("//button[@type='submit']").click();
        // Click on "Photo" button Using Locator "XPath" //button[@aria-label='Add a
        // photo']
        driver.findElementByXPath("//button[@aria-label='Add a photo']").click();
        Thread.sleep(2000);

        // Select the photo with the help of Robot Class
        StringSelection s = new StringSelection("C:\\Users\\hp\\Downloads\\shiva.jpg");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);
        Robot robot = new Robot(); // Robot class throws AWT Exception
        robot.delay(1000);

        robot.keyPress(KeyEvent.VK_CONTROL); // Press ctrl+v
        robot.keyPress(KeyEvent.VK_V); // Press ctrl+v

        robot.keyRelease(KeyEvent.VK_V); // Release ctrl+v
        robot.keyRelease(KeyEvent.VK_CONTROL); // Release ctrl+v
        // robot.keyPress(KeyEvent.VK_ENTER);
        robot.delay(1000);
        // robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_ENTER); // Press Enter
        robot.keyRelease(KeyEvent.VK_ENTER); // Release Enter
        robot.delay(2000);
        // Click on the"Done" button Using Locator "XPath"
        // //div[@class='share-box-footer__main-actions']//button[2]
        driver.findElementByXPath("//div[@class='share-box-footer__main-actions']//button[2]").click();
        // Click on "Post" button Using Locator "XPath"
        // //button[contains(@class,'share-actions__primary-action artdeco-button')]
        driver.findElementByXPath("//button[contains(@class,'share-actions__primary-action artdeco-button')]").click();
        // Verify that "Post successful" message is displayed Using Locator "XPath"
        // //*[text()='Post successful.']
        boolean isDisplayed = driver.findElementByXPath("//*[text()='Post successful.']").isDisplayed();
        System.out.println("Post is posted successfully: " + isDisplayed);
    }

    public void testcase07() {
        // Navigate to URL https://the-internet.herokuapp.com/nested_frames
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        // Switch to top frame
        driver.switchTo().frame("frame-top");
        // Switch to left frame
        driver.switchTo().frame("frame-left");
        // Search for the Top Left frame in html code Using Locator "XPath"
        // //body[contains(text(),'LEFT')]
        String leftText = driver.findElementByXPath("//body[contains(text(),'LEFT')]").getText();
        // Print the text present in Top Left frame
        System.out.println("First Text: " + leftText);

        // Switch to parent frame
        driver.switchTo().parentFrame();
        // Switch to middle frame
        driver.switchTo().frame("frame-middle");
        // Search for the Top middle frame in html code Using Locator "XPath"
        // //div[contains(text(),'MIDDLE')]
        String middleText = driver.findElementByXPath("//div[contains(text(),'MIDDLE')]").getText();
        // Print the text present in Top middle frame
        System.out.println("Second Text: " + middleText);

        // Switch to parent frame
        driver.switchTo().parentFrame();
        // Switch to right frame
        driver.switchTo().frame("frame-right");
        // Search for the Top right frame in html code Using Locator "XPath"
        // //body[contains(text(),'RIGHT')]
        String rightText = driver.findElementByXPath("//body[contains(text(),'RIGHT')]").getText();
        // Print the text present in Top middle frame
        System.out.println("Third Text: " + rightText);

        // Switch to default frame
        driver.switchTo().defaultContent();
        // Switch to bottom frame
        driver.switchTo().frame("frame-bottom");
        // Search for the Below frame in html code Using Locator "XPath"
        // //body[contains(text(),'BOTTOM')]
        String belowText = driver.findElementByXPath("//body[contains(text(),'BOTTOM')]").getText();
        // Print the text present in Below frame
        System.out.println("Fourth Text: " + belowText);
    }

    public void testcase08() throws InterruptedException {
        //Navigate to URL  https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open
        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");
        //Switch to frame Using Locator "Name" iframeResult
        driver.switchTo().frame("iframeResult");
        //Click on the "Try it" button Using Locator "XPath" //button[text()='Try it']
        driver.findElementByXPath("//button[contains(text(),'Try it')]").click();
        //Handle the window using "Window Handles"
        Set<String> handles = driver.getWindowHandles();
        //System.out.println(handles.size());
        driver.switchTo().window(handles.toArray(new String[handles.size()])[1]);
        //get the current URL
        String strUrl = driver.getCurrentUrl();
        //Take screenshot using "takeScreenshot" method
        takeScreenshot(driver, "newUrl", "w3school");
        //Get the title of the page
        String strTitle = driver.getTitle();
        System.out.println("URL of the new Tab: "+strUrl);
        System.out.println("Title of the new Tab: "+strTitle);
        //Close the newly opened window
        driver.close();
        //Thread.sleep(5000);
        //Switch to old opened window
        driver.switchTo().window(handles.toArray(new String[handles.size()])[0]);
    }

    public void testcase09() throws InterruptedException {
        // Navigate to URL https://www.imdb.com/chart/top
        driver.get("https://www.imdb.com/chart/top");
        //Get the text of highest rated movie on IMDB Using Locator "XPath" (//td[@class='titleColumn'])[1]//a
        String highestRatedMovie = driver.findElementByXPath("(//td[@class='titleColumn'])[1]//a").getText();
        //Print the highest rated movie on IMDB  
        System.out.println("The highest rated movie on IMDb: " + highestRatedMovie);
        
        //Get the number of movies included in the table Using Locator "XPath" //td[@class='titleColumn']
        int noOfMovies = driver.findElementsByXPath("//td[@class='titleColumn']").size();
        //Print the no. of movies included in the table  
        System.out.println("Number of movies included in the table: " + noOfMovies);

        //Click the dropdown of sort by option Using Locator "XPath" //select[@id='lister-sort-by-options']
        driver.findElementByXPath("//select[@id='lister-sort-by-options']").click();
        //Select the "Release Date" option from the dropdown Using Locator "XPath" //select[@id='lister-sort-by-options']/option[3]
        driver.findElementByXPath("//select[@id='lister-sort-by-options']/option[3]").click();
        //Get the last movies sorted in the list Using Locator "XPath" (//td[@class='titleColumn'])[250]//a
        String oldestMovie = driver.findElementByXPath("(//td[@class='titleColumn'])[250]//a").getText();
        //Print the Oldest movie on the list  
        System.out.println("Oldest movie on the list: "+oldestMovie);      
        
        //Get the first movies sorted in the list Using Locator "XPath" (//td[@class='titleColumn'])[1]//a
        String mostRecent = driver.findElementByXPath("(//td[@class='titleColumn'])[1]//a").getText();
        //Print the most recent movie on the list  
        System.out.println("The most recent movie on the list: "+mostRecent);  

        //Click the dropdown of sort by option Using Locator "XPath" //select[@id='lister-sort-by-options']
        driver.findElementByXPath("//select[@id='lister-sort-by-options']").click();
        //Select the "No. of ratings" option from the dropdown Using Locator "XPath" //select[@id='lister-sort-by-options']/option[4]
        driver.findElementByXPath("//select[@id='lister-sort-by-options']/option[4]").click();
        //Get the first movies sorted in the list Using Locator "XPath" (//td[@class='titleColumn'])[1]//a
        String highestRated = driver.findElementByXPath("(//td[@class='titleColumn'])[1]//a").getText();
        //Print the movie has the most user ratings  
        System.out.println("Movie has the most user ratings: "+highestRated);  
    }
    public static void takeScreenshot(WebDriver driver, String screenshotType, String description) {
        try {
            File theDir = new File("/screenshots");
            if (!theDir.exists()) {
                theDir.mkdirs();
            }
            String timestamp = String.valueOf(java.time.LocalDateTime.now());
            //System.out.println(timestamp);
            timestamp = timestamp.replace(':',' ');
            String fileName = String.format("screenshot_%s_%s_%s.png", timestamp, screenshotType, description);
            TakesScreenshot scrShot = ((TakesScreenshot) driver);
            File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
            File DestFile = new File("screenshots/" + fileName);
            FileUtils.copyFile(SrcFile, DestFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
