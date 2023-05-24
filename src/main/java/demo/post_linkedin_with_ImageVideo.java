package demo;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.chrome.ChromeDriver;

public class post_linkedin_with_ImageVideo {
    ChromeDriver driver;
    public void post_on_linkedin_with_Image_or_Video() throws InterruptedException, AWTException{
        System.out.println("Start test case: Post on linkedin with Image or Video");
        this.driver = TestCases.TestCasesInitializer();
        // Navigate to URL https://www.linkedin.com/
        driver.get("https://www.linkedin.com/");
        // Type "Email or phone: in Username textbox Using Locator "Name" session_key
        driver.findElementByName("session_key").sendKeys("xxxxx@gmail.com");
        // Type "Password" in password textbox Using Locator "Name" session_password
        driver.findElementByName("session_password").sendKeys("xxxxx");
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
    
}
