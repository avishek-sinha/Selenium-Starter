package demo;

import java.io.File;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class w3school_windowHandle {
    ChromeDriver driver;
    public void w3schoolWindowHandle(){
        System.out.println("Start Test Case: Window Handle in w3school");
        this.driver = TestCases.TestCasesInitializer();
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
