package demo;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
//Selenium Imports
import org.openqa.selenium.WebElement;

public class LinkedIn_post {
    ChromeDriver driver;

    public void linkedin_post_connectionOnly() throws InterruptedException {
        System.out.println("Start test case: linkedIn Post");
        this.driver = TestCases.TestCasesInitializer();
        // Navigate to URL https://www.linkedin.com/
        driver.get("https://www.linkedin.com/");
        // Type "Email or phone: in Username textbox Using Locator "Name" session_key
        driver.findElementByName("session_key").sendKeys("xxxxx@gmail.com");
        // Type "Password" in password textbox Using Locator "Name" session_password
        driver.findElementByName("session_password").sendKeys("xxxxxx");
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
        // if (driver
        //         .findElementByXPath("(//span[@class='share-state-change-button__label'])[2]")
        //         .getText().equals("Anyone")
        //         || driver
        //                 .findElementByXPath(
        //                         "(//span[@class='share-state-change-button__label'])[2]")
        //                 .getText().equals("No one")) {
        //     // Click on button to change visiblity option Using Locator "XPath"
        //     // //button[contains(@aria-label,'Update the setting')]
        //     driver.findElementByXPath("//button[contains(@aria-label,'Update the setting')]").click();
        //     // Select "Connections only" option Using Locator "XPath"
        //     // //button[@id='CONNECTIONS_ONLY']
        //     driver.findElementByXPath("//button[@id='CONNECTIONS_ONLY']").click();
        //     // Click on "Save" button Using Locator "XPath"
        //     // //button[contains(@class,'share-box-footer__primary-btn artdeco')]
        //     driver.findElement(By.xpath("//button[contains(@class,'share-box-footer__primary-btn artdeco')]")).click();
        // }

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

}
