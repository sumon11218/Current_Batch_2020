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

public class Kayak_Deta_Driven_Shafat {

    WebDriver driver;
    //readable workbook
    Workbook readableFile;
    //readable sheet
    Sheet readableSheet;
    //writable workbook
    WritableWorkbook writableFile;
    //writable sheet
    WritableSheet excelSheet;



    @BeforeSuite
    public void defineDriver() throws IOException, BiffException, InterruptedException {
        //define the driver
        driver = Reusable_Library.setDriver();
        //defining the read able workbook path

        readableFile= Workbook.getWorkbook(new File("src//main//java//Excels//Kayak_Search_Shafat.xls"));
        //define the sheet

        readableSheet= readableFile.getSheet(0);
        //define the writable work book path
        WritableWorkbook writableFile;
        writableFile= Workbook.createWorkbook(new File("src//main//java//Excels//Kayak_Search_Shafat_Results.xls"),readableFile);
        //defining writable sheet

        excelSheet= writableFile.getSheet(0);



    }//end of before method



    @Test
    public void KayakTestCase() throws InterruptedException, WriteException {
        int rows=excelSheet.getRows();
        for(int i=1; i<rows;i++) {

            String airportName =excelSheet.getCell(0,i).getContents();
            String startDate = excelSheet.getCell(1,i).getContents();
            String startTime = excelSheet.getCell(2,i).getContents();
            String endDate = excelSheet.getCell(3,i).getContents();
            String endTime = excelSheet.getCell(4,i).getContents();
            String vehicleSize = excelSheet.getCell(5,i).getContents();
            String vehicleInfo = excelSheet.getCell(6,i).getContents();



            //navigate to web page
            driver.navigate().to("https://www.kayak.com");
            Thread.sleep(3000);
            //clicking on search box for airport
            Reusable_Library.click(driver, "//*[@data-placeholder='Enter an airport or city']", "airport");
            //put 2 seconds before entering airport name
            Thread.sleep(2000);
            //typing and entering Airportname
            Reusable_Library.userTypeAndHitEnter(driver, "//*[@name='pickup']", airportName, "airportName");

            //clicking on end date
            Reusable_Library.click(driver, "//*[@data-placeholder='Drop-off']", "end date");
            Thread.sleep(2000);
            //entering the end date
            Reusable_Library.userTypeAndHitEnter(driver, "(//*[@aria-label='Drop-off date']) [2]", endDate, "startingdate");
            //end time clicking
            Reusable_Library.click(driver, "(//*[@class='_id7 _irc _ii0 _iir']) [2]", "timeclick");
            Thread.sleep(2000);
            //choosing the end time
            Reusable_Library.clickByIndex(driver, "//li[@aria-label='" + endTime + "']", 1,"endTime");

            //clicking on start date
            Reusable_Library.click(driver, "//*[@data-placeholder='Pick-up']", "START DATE");
            Thread.sleep(2000);
            //ENTERING START DATE
            Reusable_Library.userTypeAndHitEnter(driver, "(//*[@aria-label='Pick-up date'])[2]", startDate, "startDate");
            Thread.sleep(3000);
            //clicking anywhere
            Reusable_Library.click(driver, "//*[@class='title dark']", "click anywhere");
            Thread.sleep(2000);
            //click on start noon button
            Reusable_Library.click(driver, "(//*[@class='_id7 _irc _ii0 _iir']) [1]", "click on start noon");
            Thread.sleep(3000);
            //choosing the starting time
            Reusable_Library.clickByIndex(driver, "//li[@aria-label='" + startTime + "']", 0,"startTime");
            Thread.sleep(3000);

            //clicking on search icon box
            Reusable_Library.click(driver, "//*[@viewBox='0 0 54 54']", "search icon");
            //clicking on checkbox
            Reusable_Library.click(driver, "(//*[contains(@class,'_idf _jAd _iji _ibc _jY2')])[2]",  "VehicleSize");
            Thread.sleep(3000);
            //clicking view deals by using index method
            Reusable_Library.clickByIndex(driver, "//*[text()='View Deal']", 2, "car deals");

            //define arraylist for a new tab
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

            driver.switchTo().window(tabs.get(1));
            Thread.sleep(3000);
            //close the driver


            //capture text for the car
            String message = Reusable_Library.captureText(driver, "(//*[contains(@class,'Checkout-Common-Baselayout-R')or contains(@class,'bui-panel') ])[5]", "vehicleInfo");
            System.out.println("My car is " + message);
            //sending the message to excel
            Label Capturedmessage= new Label(6, i, message);
            excelSheet.addCell(Capturedmessage);
            driver.manage().deleteAllCookies();

            driver.close();
            driver.switchTo().window(tabs.get(0));

            //delete all cookies
            driver.manage().deleteAllCookies();


        }//end of loop
    }//end of test method

    @AfterSuite
    public void quitdriver() throws IOException, WriteException {
        writableFile.write();
        writableFile.close();
        readableFile.close();
        driver.quit();
    }//end of after suite





}//end of java class
