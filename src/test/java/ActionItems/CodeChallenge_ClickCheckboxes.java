package ActionItems;

import Resuable_Classes.Abstract_Class;
import Resuable_Classes.Reusable_Library;
import Resuable_Classes.Reusable_Library_Loggers;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.model.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class CodeChallenge_ClickCheckboxes extends Abstract_Class {

    @Test(priority = 1)
    public void Click_On_Checkboxes() throws InterruptedException {

        /*Using your preferred resource, write a quick script that
          goes to https://faculty.washington.edu/chudler/java/boxes.html
          and clicks every checkbox.
         */

        driver.navigate().to("https://faculty.washington.edu/chudler/java/boxes.html ");
        Thread.sleep(2500);
        WebDriverWait wait = new WebDriverWait(driver,15);
        logger.log(LogStatus.INFO,"Verifying checkboxes by clicking on each from the List");
        List<WebElement> elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//input[@onclick='display(this)']")));
        logger.log(LogStatus.INFO, "Checkbox count is " + elements.size());

        for(int i = 0; i < elements.size(); i++){

            try {
                logger.log(LogStatus.INFO, "Clicking on checkbox " + (i+1));
                elements.get(i).click();
            } catch (Exception e) {
                logger.log(LogStatus.FAIL,"Unable to click on checkbox " + (i+1) + " error is " + e);
            }//end of exception

        }//end of loop

        //get value from text box
        String val = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@name='num']"))).getAttribute("value");
        logger.log(LogStatus.INFO,"Textbox attribute is " + val);
        if(val.equals(Integer.toString(elements.size()))){
            logger.log(LogStatus.PASS,"Textbox attribute value matches with checkbox count as " + val);
        } else {
            logger.log(LogStatus.FAIL,"Textbox attribute value doesn't match with checkbox count.. Actual value is " + val);
        }//end of if else


    }//end of test method


    @Test(priority = 2)
    public void Yahoo_Wiki_Page_Verification() throws InterruptedException {
        driver.navigate().to("https://www.yahoo.com");
        Thread.sleep(2500);
        Reusable_Library_Loggers.userTypeAndHitEnter(driver,"//*[@id='header-search-input']","QA","Search Field Submit",logger);
        Reusable_Library_Loggers.click(driver,"//*[text()='Quality assurance - Wikipedia']","Wiki Link",logger);
        Thread.sleep(2500);
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        try {
            if (driver.findElement(By.xpath("//*[@id='bodyContent']")).getText().contains("Middle Ages")) {
                logger.log(LogStatus.PASS, "Keyword Middle Ages exist on the Wiki page");
            } else {
                logger.log(LogStatus.FAIL, "Unable to verify Middle Ages text on Wiki page");
            }//end of
        } catch (Exception e) {
            logger.log(LogStatus.PASS, "Unable to verify Middle Ages text on Wiki page " + e);
        }//end of exception

    }//end of test 2 method



}//end of java class
