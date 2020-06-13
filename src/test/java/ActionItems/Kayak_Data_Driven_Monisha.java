package ActionItems;

import Resuable_Classes.Reusable_Library;
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

public class Kayak_Data_Driven_Monisha {

    //when using annotation method you local driver
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

    @BeforeSuite
    public void callDriver() throws IOException, InterruptedException, BiffException {
        //define the path of readable file
        readableFile = Workbook.getWorkbook(new File("src//main//java//Excels//Kayak_Search_Monisha.xls"));
        //define readable sheet
        readableSheet = readableFile.getSheet(0);
        //define the path to create writable file
        writableFile = Workbook.createWorkbook(new File("src//main//java//Excels//Kayak_Search_Monisha_Results.xls"),readableFile);
        //define the writable sheet
        wSheet = writableFile.getSheet(0);
        //defined the driver
        driver = Reusable_Library.setDriver();
    }//end of BeforeMethod

    @Test
    public void Kayak_search() throws InterruptedException, WriteException {
        int row = wSheet.getRows();
        for(int i = 1; i < row; i++) {
            String airportName = wSheet.getCell(0,i).getContents();
            String startDate = wSheet.getCell(1,i).getContents();
            String startTime = wSheet.getCell(2,i).getContents();
            String endDate = wSheet.getCell(3,i).getContents();
            String endTime = wSheet.getCell(4,i).getContents();
            String vehicleSize = wSheet.getCell(5,i).getContents();


            driver.navigate().to("https://www.kayak.com/");
            Thread.sleep(2500);

            Reusable_Library.mouseClick(driver,"//*[@data-placeholder='Enter an airport or city']","Search Field");
            Reusable_Library.userKeys(driver,"//*[@name='pickup']", airportName,"Airport name");
            Thread.sleep(1500);
            Reusable_Library.mouseClick(driver,"//*[@data-placeholder='Drop-off']","End Date Calendar");
            Thread.sleep(1500);
            Reusable_Library.userTypeAndHitEnter(driver,"//*[contains(@id,'-dropoff-date-input')]", endDate,"End Date Input");
            Reusable_Library.click(driver,"//*[@class='title dark']","click outside the box");
            Reusable_Library.click(driver,"//*[contains(@id,'-end-time-select-display-status')]","End Time");
            Thread.sleep(1500);
            Reusable_Library.mouseClick(driver,"//*[contains(@id,'-end-time-select-option') and @data-title='" + endTime + "']","End Time Value");
            Thread.sleep(1500);
            Reusable_Library.mouseClick(driver,"//*[@data-placeholder='Pick-up']","Start Date Calendar");
            Thread.sleep(1500);
            Reusable_Library.userTypeAndHitEnter(driver,"//*[contains(@id,'pickup-date-input')]", startDate,"Start Date Input");
            Reusable_Library.click(driver,"//*[@class='title dark']","click outside the box");
            //Reusable_Library.click(driver,"//*[contains(@id,'-start-time-select-display-')]","Start Time");
            Thread.sleep(1500);
            Reusable_Library.mouseClick(driver,"//*[contains(@id,'-start-time-select-option-') and @data-title='" + startTime + "']","Start Time Value");
            Reusable_Library.click(driver,"//*[contains(@id,'-submit')]","Search Icon");
            Thread.sleep(2000);
            Reusable_Library.click(driver,"//*[text()='" + vehicleSize + "']","Size Box");
            Thread.sleep(4500);
            Reusable_Library.clickByIndex(driver,"//*[text()='View Deal']",1,"view deal");
            //Define the ArrayList for new tab and to
            ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
            //switch back to the new tab
            driver.switchTo().window(tabs.get(1));
            Thread.sleep(2500);
            String vehicleInfo = Reusable_Library.captureText(driver,"//*[@class='Checkout-Common-Uicore-NormalText resetColor' or contains(@class,'bui-panel') or @class='card-body p-2' or @class='mb-3 d-none d-lg-block  w-100' or @class='card no-shadow w-100']","vehicleInfo");
            Label label = new Label(6, i, vehicleInfo);
            wSheet.addCell(label);
            Thread.sleep(1000);
            driver.close();
            //Switch back to the first tab
            driver.switchTo().window(tabs.get(0));
            driver.manage().deleteAllCookies();
        }//end of for loop
    }//end of google test


    @AfterSuite
    public void quitDriver() throws IOException, WriteException {
        writableFile.write();
        writableFile.close();
        readableFile.close();
        driver.quit();
    }//end of AfterMethod





}//end of java class
