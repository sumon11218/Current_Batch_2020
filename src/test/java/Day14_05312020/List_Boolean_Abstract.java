package Day14_05312020;

import Resuable_Classes.Abstract_Class;
import Resuable_Classes.Reusable_Library_Loggers;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class List_Boolean_Abstract extends Abstract_Class {

    @Test
    public void yahoo_verification() throws InterruptedException {
        //navigate to yahoo home page
        logger.log(LogStatus.INFO,"Navigating to yahoo home page");
        driver.navigate().to("https://www.yahoo.com");
        //3 to 4 seconds for page to load
        Thread.sleep(3500);
        //I want to count all the links in yahoo homepage and print it
        logger.log(LogStatus.INFO,"Getting the List count for all links");
        List<WebElement> linkCount = driver.findElements(By.xpath("//*[contains(@class,'D(ib) Mstart(21px) Mend(17px)')]"));
        //verify if linkcount returns you 12 links
        if(linkCount.size() == 12){
            System.out.println("MY yahoo home page link count matches and it is " + linkCount.size());
            logger.log(LogStatus.PASS,"MY yahoo home page link count matches and it is " + linkCount.size());
        } else {
            System.out.println("MY yahoo home page link count doesn't matches and actual is " + linkCount.size());
            logger.log(LogStatus.FAIL,"MY yahoo home page link count doesn't matches and actual is " + linkCount.size());
        }//end of if else

        //click on Sign In link
        Reusable_Library_Loggers.click(driver,"//*[@id='header-signin-']","Sign In",logger);
        //wait few seconds
        Thread.sleep(3000);
        //verify the state of the checkbox is checked for stay signed in section
        boolean checkboxState = driver.findElement(By.xpath("//*[@id='persistent']")).isSelected();
        if(checkboxState == false){
            System.out.println("Checkbox is not selected by default");
            logger.log(LogStatus.FAIL,"Checkbox is not selected by default");
        } else {
            System.out.println("Checkbox is selected by default");
            logger.log(LogStatus.PASS,"Checkbox is selected by default");
        }//end of if else
    }//end of test method

}//end of java class
