package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class search_name_onGoogle {
    ChromeDriver driver;

    public void countLinkWithName() {
        System.out.println("Start test case: search name with my links on google");
        this.driver = TestCases.TestCasesInitializer();
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

}
