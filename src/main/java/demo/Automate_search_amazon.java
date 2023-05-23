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

public class Automate_search_amazon extends TestCases {
    ChromeDriver driver;

    public void search_amazon_on_google() {
        System.out.println("Start Test case: search amazon on Google Page");
        this.driver = TestCases.TestCasesInitializer();
        // Navigate to URL https://www.google.com/
        driver.get("https://www.google.com/");
        // Click on Search Bar Using Locator "Name" q
        driver.findElementByName("q").click();
        // Type in "amazon" in Search bar Using Locator "Name" q
        driver.findElementByName("q").sendKeys("amazon");
        // Click on Google Search Button Using Locator "XPath" (//input[@value='Google
        // Search'])[1]
        driver.findElementByXPath("(//input[@value='Google Search'])[1]").click();
        // Validate Amazon.in in search result Using Locator "XPath"
        // h3[text()='Amazon.in']
        boolean isDisplayed = driver.findElementByXPath("//h3[text()='Amazon.in']").isDisplayed();
        System.out.println(isDisplayed);
    }
}
