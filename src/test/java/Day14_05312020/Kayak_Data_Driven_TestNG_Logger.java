package Day14_05312020;

import Resuable_Classes.Reusable_Library;
import Resuable_Classes.Reusable_Library_Loggers;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Kayak_Data_Driven_TestNG_Logger {

    //when using annotation method your local driver
    //must be declared outside so i can call it
    //on all my annotation method
    WebDriver driver;
    //readable workbook
    Workbook readableFile;
    //readable sheet
    Sheet readableSheet;
    //writable workbook
    WritableWorkbook writableFile;
    //writable sheet
    WritableSheet wSheet;
    //initiate row count
    int row;

    //declare the report
    ExtentReports reports;
    //declare the test/logger
    ExtentTest logger;

    @BeforeSuite
    public void callDriver() throws IOException, InterruptedException, BiffException {
        //define the path of readable file
        readableFile = Workbook.getWorkbook(new File("src//main//java//Excels//Kayak_Search.xls"));
        //define readable sheet
        readableSheet = readableFile.getSheet(0);
        //define the path to create writable file
        writableFile = Workbook.createWorkbook(new File("src//main//java//Excels//Kayak_Search_Results.xls"),readableFile);
        //define the writable sheet
        wSheet = writableFile.getSheet(0);
        //get all visible row count
        row = wSheet.getRows();
        //defined the driver
        driver = Reusable_Library_Loggers.setDriver();
        //define the report path
        Thread.sleep(1500);
        reports = new ExtentReports("src//main//java//HTML_Report//Kayak_Report.html",true);
    }//end of BeforeSuite

    @Test
    public void kayakSearch() throws InterruptedException, WriteException {
        //define your logger to start your test
        logger = reports.startTest("Kayak Search Result");
        logger.log(LogStatus.INFO,"Navigating to Kayak page");
        for(int i = 1; i < 2; i++) {
            driver.navigate().to("https://www.kayak.com");
            Thread.sleep(2000);
            //click on Search field
            Reusable_Library_Loggers.click(driver,"//*[contains(@id,'pickup-field')]","Search Filed",logger);
            //enter keyword on search field
            String airports = wSheet.getCell(0,i).getContents();
            Reusable_Library_Loggers.userKeys(driver,"//*[@name='pickup']",airports,"Search Field",logger);

            //click on car result item as first one
            Reusable_Library_Loggers.click(driver,"//*[@class='item-info']","Car Result",logger);

            //click on drop off
            Reusable_Library_Loggers.click(driver,"//*[@data-placeholder='Drop-off']","Drop-off Date",logger);
            Thread.sleep(2000);
            //enter pick up date
            String dropOffDate = wSheet.getCell(3,i).getContents();
            Reusable_Library_Loggers.userTypeAndHitEnter(driver,"//*[contains(@id,'dropoff-date-input')]",dropOffDate,"Drop-off Date",logger);
            Thread.sleep(2000);
            //click somewhere outside
            Reusable_Library_Loggers.click(driver,"//*[@class='title dark']","Text Content",logger);

            //click on drop off time
            Thread.sleep(1000);
            Reusable_Library_Loggers.click(driver,"//*[contains(@id,'end-time-select')]","Drop off Time",logger);
            //choose drop off up time
            Thread.sleep(2000);
            String dropOffTime = wSheet.getCell(4,i).getContents();
            Reusable_Library_Loggers.mouseClick(driver,"//*[contains(@id,'end-time-select-option') and @data-title='"+dropOffTime+"']","Choose Drop-off Time",logger);

            //click on pick up date
            Reusable_Library_Loggers.click(driver,"//*[@data-placeholder='Pick-up']","Pick-up Date",logger);
            Thread.sleep(2000);
            //enter pick up date
            String pickupDate = wSheet.getCell(1,i).getContents();
            Reusable_Library_Loggers.userTypeAndHitEnter(driver,"//*[contains(@id,'pickup-date-input')]",pickupDate,"Pick-up Date",logger);
            //click somewhere outside
            Reusable_Library_Loggers.click(driver,"//*[@class='title dark']","Text Content",logger);

            //choose pick up time
            Thread.sleep(2000);
            String pickupTime = wSheet.getCell(2,i).getContents();
            Reusable_Library_Loggers.mouseClick(driver,"//*[contains(@id,'start-time-select-option') and @data-title='"+pickupTime+"']","Choose Drop-off Time",logger);

            //click on search icon
            Reusable_Library_Loggers.click(driver,"//*[@title='Search cars']","Search Icon",logger);
            Thread.sleep(4000);
            //click on vehicle size checkbox
            String vehicleSize = wSheet.getCell(5,i).getContents();
            Reusable_Library_Loggers.click(driver,"//div[text()='"+vehicleSize+"']","Vehicle Size Checkbox",logger);

            //click on second View Deal button
            Thread.sleep(5000);
            Reusable_Library_Loggers.clickByIndex(driver,"//*[text()='View Deal']",1,"View Deal",logger);

            ArrayList<String> list = new ArrayList(driver.getWindowHandles());
            driver.switchTo().window(list.get(1));
            Thread.sleep(2000);
            String result = Reusable_Library_Loggers.captureText(driver,"//*[contains(@class,'bui-panel') or @class='search' or @class='booking-section' or @class='addressGrid']","Car Info",logger);
            Label label = new Label(6,i,result);
            wSheet.addCell(label);
            driver.close();
            driver.switchTo().window(list.get(0));
            driver.manage().deleteAllCookies();
        }//end of for loop

        //end the test
        reports.endTest(logger);
    }//end of Kayak test

    @AfterSuite
    public void quitDriver() throws IOException, WriteException {
        writableFile.write();
        writableFile.close();
        readableFile.close();
        //driver.quit();
        reports.flush();
    }//end of AfterSuite





}//end of java class
