package Day9_05092020;

import Resuable_Classes.Reusable_Library;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.ArrayList;

public class Statefarm_Test {

    public static void main(String[] args) throws InterruptedException, IOException {

        //driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        ArrayList<String> zipCode = new ArrayList<>();
        zipCode.add("11218");
        zipCode.add("11219");
        ArrayList<String> productType = new ArrayList<>();
        productType.add("Homeowners");
        productType.add("Auto");


        //decared and defined the webdriver from setDriver return method
        WebDriver driver = Reusable_Library.setDriver();

        for(int i=0;i<productType.size();i++) {

            //navigate to mortgage calculator home page
            driver.navigate().to("https://www.statefarm.com");

            Thread.sleep(2500);

            //call my reusable method to compare title
            Reusable_Library.verifyTitle(driver, "Auto, Life Insurance");
            //call my reusable method to select product drop down
            Reusable_Library.dropdownByText(driver, "//*[@id='popDropdown']", productType.get(i), "Product Dropdown");
            //call my reusable method to enter a zipcode
            Thread.sleep(1500);
            Reusable_Library.userKeys(driver, "//input[@id='quote-main-zip-code-input']", zipCode.get(i), "Zipcode");
            //call my reusable method to click on quote
            Reusable_Library.click(driver, "//*[text()='Start Quote']", "Start Quote");

            //Thread.sleep(2000);
            //capture the result
            //a requirement we added to handle some scenarios based on product type on the drop down
            if(productType.get(i).equals("Homeowners")) {
                String textResult = Reusable_Library.captureText(driver, "//h1[contains(text(),'Quote')]", "Homeowner Quote");
                String[] testArray = textResult.split(" ");
                System.out.println("My Array result is " + testArray[0]);
            } else if(productType.get(i).equals("Auto")){
               Reusable_Library.captureText(driver, "//*[@id='btnExisting']", "Car Auto Text");
            }

        }//end of for

       // driver.quit();

    }//end of main



}//end of java class
