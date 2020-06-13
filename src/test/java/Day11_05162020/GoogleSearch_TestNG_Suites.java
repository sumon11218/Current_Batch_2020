package Day11_05162020;

import Resuable_Classes.Reusable_Library;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.ArrayList;

public class GoogleSearch_TestNG_Suites {
    //when using annotation method your local driver
    //must be declared outside so i can call it
    //on all my annotation method
    WebDriver driver;
    String getURl;

    ArrayList cars = new ArrayList();

    @BeforeSuite
    public void callDriver() throws IOException, InterruptedException {
        Reporter.log("Setting up driver");
        driver = Reusable_Library.setDriver();
    }//end of BeforeMethod


    @Test
    public void searchIngoogle() throws InterruptedException {
        driver.navigate().to("https://www.google.com");
        Thread.sleep(2000);
        //enter keyword car on my search field
        Reusable_Library.userKeys(driver, "//*[@name='q']", "Cars", "Search Field");
        //click on submit
        Reusable_Library.submit(driver, "//*[@name='btnK']", "Google Search Button");
        Thread.sleep(2000);
        //capture the current url for search result page
        getURl = driver.getCurrentUrl();
    }//end of test priority 1

    //when you use dependsOnMethods in your @Test that means your second test is dependant
    //on your first test if first test fails second test will be skipped
    //if all test has priorities they might or might not be dependant on each other
    @Test(dependsOnMethods = "searchIngoogle")
    public void captureTheResult() throws InterruptedException {
        //Thread.sleep(2000);
        driver.navigate().to(getURl);
        Thread.sleep(2000);
        //capture text and print out the search number
        String searchResult = Reusable_Library.captureText(driver,"//*[@id='result-stats']","Search Results");
        //split the text and print the number
        String[] arraySearch = searchResult.split(" ");
        System.out.println("My search number for car is " + arraySearch[1]);
    }//end of google test

    @AfterSuite
    public void quitDriver(){
        driver.quit();

    }//end of Aftermethod



}//end of java class
