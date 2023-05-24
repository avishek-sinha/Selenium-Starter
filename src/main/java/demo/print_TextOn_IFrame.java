package demo;

import org.openqa.selenium.chrome.ChromeDriver;

public class print_TextOn_IFrame {
    ChromeDriver driver;
    public void getTextFromIFrame(){
        System.out.println("Start Test case: Get all the text printed on IFrame");
        this.driver = TestCases.TestCasesInitializer();
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
    
}
