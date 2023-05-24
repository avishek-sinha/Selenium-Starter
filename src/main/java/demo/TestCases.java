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
    }

    public void testCase02() {
        BookMyShow_count_hyperlink bookmyshow = new BookMyShow_count_hyperlink();
        bookmyshow.count_hyperlink_Bookmyshow();
    }

    public void testcase03() throws InterruptedException {
        LinkedIn_post lkdPost = new LinkedIn_post();
        lkdPost.linkedin_post_connectionOnly();        
    }

    public void testcase04() throws InterruptedException {
        search_name_onGoogle onGoogle = new search_name_onGoogle();
        onGoogle.countLinkWithName();
    }

    public void testcase05() throws InterruptedException {
        find_imageURL_Bookmyshow imageUrl = new find_imageURL_Bookmyshow();
        imageUrl.findURLInBookmyshow();
    }

    public void testcase06() throws InterruptedException, AWTException {
        post_linkedin_with_ImageVideo linkedInPost = new post_linkedin_with_ImageVideo();
        linkedInPost.post_on_linkedin_with_Image_or_Video();
    }

    public void testcase07() {
        print_TextOn_IFrame Iframe = new print_TextOn_IFrame();
        Iframe.getTextFromIFrame();
    }

    public void testcase08() throws InterruptedException {
        w3school_windowHandle windowHandle = new w3school_windowHandle();
        windowHandle.w3schoolWindowHandle();
    }

    public void testcase09() throws InterruptedException {
        Automate_imdb_ratings rating = new Automate_imdb_ratings();
        rating.automateIMDB(); 
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
