package demo;
import java.util.List;
import org.openqa.selenium.chrome.ChromeDriver;
//Selenium Imports
import org.openqa.selenium.WebElement;

public class BookMyShow_count_hyperlink {
    ChromeDriver driver;
    public void count_hyperlink_Bookmyshow(){
        System.out.println("Start Test case: count hyperlinks on bookmyshow");
        this.driver = TestCases.TestCasesInitializer();
        // Navigate to URL https://in.bookmyshow.com/explore/home/chennai
        driver.get("https://in.bookmyshow.com/explore/home/chennai");
        // Locate the locator for hyperlink by using Using Locator "Tag Name" a
        int count = driver.findElementsByTagName("a").size();
        List<WebElement> links = driver.findElementsByTagName("a");
        // Get count of the hyperlinks Using Locator "Tag Name" a
        System.out.println("Count of links: " + links.size());
        // System.out.println(count);
    }
    
}
