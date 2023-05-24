package demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;


public class find_imageURL_Bookmyshow {
    ChromeDriver driver;
    public void findURLInBookmyshow() throws InterruptedException{
        System.out.println("Start test case: Find Image URL in bookmyshow website");
        this.driver = TestCases.TestCasesInitializer();
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

}
