package demo;

import org.openqa.selenium.chrome.ChromeDriver;

public class Automate_imdb_ratings {
    ChromeDriver driver;
    public void automateIMDB(){
        System.out.println("Start Test Case: Automate the IMDB website");
        this.driver = TestCases.TestCasesInitializer();
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
    
}
