package Day9_05092020;

import Resuable_Classes.Reusable_Library;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class Google_With_Reusable_Methods {

    public static void main(String[] args) throws IOException, InterruptedException {


       WebDriver driver = Reusable_Library.setDriver();

        //driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);

        //navigate to mortgage calculator home page
        driver.navigate().to("https://www.google.com");

        //call my reusable method to compare title
        Reusable_Library.verifyTitle(driver,"Google");
        //call my reusable method to enter a Search Field
        Reusable_Library.userKeys(driver,"//*[@name='q']","Cars","Search Field");
        //call my reusable method to submit on google search
        Reusable_Library.submit(driver,"//*[@name='btnK']","Google Search");
        
    }




}
