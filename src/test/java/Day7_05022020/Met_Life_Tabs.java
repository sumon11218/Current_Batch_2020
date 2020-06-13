package Day7_05022020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;


public class Met_Life_Tabs {


    public static void main(String[] args) throws InterruptedException {

        //set the chrome path
        System.setProperty("webdriver.chrome.driver","src//Resource//chromedriver80.exe");
        //set some pre conditions using ChromeOptions
        ChromeOptions options = new ChromeOptions();
        //set the arguments you want for the driver
        options.addArguments("start-maximized","incognito");
        //now simply define your chrome driver
        WebDriver driver = new ChromeDriver(options);


        //navigate to met life home page
        driver.navigate().to("https://www.metlife.com");
        //wait few seconds

        Thread.sleep(3000);


        //click on Solutions tab
        try {
            driver.findElement(By.xpath("//*[contains(text(),'SOLUTIONS')]")).click();
        } catch (Exception e) {
            System.out.println("Unable to click on SOLUTIONS " + e);
        }//end of SOLUTIONS exception

        //put few seconds in between
        Thread.sleep(1000);

        //click on Take along link
        try {
            driver.findElement(By.xpath("//*[contains(text(),'MetLife TakeAlong Dental')]")).click();
        } catch (Exception e) {
            System.out.println("Unable to click on MetLife TakeAlong Dental " + e);
        }//end of MetLife TakeAlong Dental exception

        Thread.sleep(3500);

        //click on Enroll Now
        try {
            driver.findElement(By.xpath("//*[contains(text(),'Enroll Now')]")).click();
        } catch (Exception e) {
            System.out.println("Unable to click on Enroll Now " + e);
        }//end of Enroll Now exception

        //now define the ArrayList to handle all current window tabs that are open
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        //switch to second tab
        driver.switchTo().window(tabs.get(1));

        //enter your zip code
        try {
            driver.findElement(By.xpath("//*[@id='txtZipCode']")).sendKeys("11218");
        } catch (Exception e) {
            System.out.println("Unable to enter on Search Field " + e);
        }//end of Zip Code exception

        Thread.sleep(1500);

        //i want to close this tab
        //driver.close();

        //switch to previous tab
        driver.switchTo().window(tabs.get(0));

          //if another tab open we need redefine arraylist
         tabs = new ArrayList<>(driver.getWindowHandles());

    }//end of main





}//end of class
