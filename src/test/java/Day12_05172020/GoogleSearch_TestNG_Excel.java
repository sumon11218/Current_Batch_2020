package Day12_05172020;

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

public class GoogleSearch_TestNG_Excel {
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

    @BeforeSuite
    public void callDriver() throws IOException, InterruptedException, BiffException {
        //define the path of readable file
        readableFile = Workbook.getWorkbook(new File("src//main//resources//Google_Search.xls"));
        //define readable sheet
        readableSheet = readableFile.getSheet(0);
        //define the path to create writable file
        writableFile = Workbook.createWorkbook(new File("src//main//resources//Google_Search_Results.xls"),readableFile);
        //define the writable sheet
        wSheet = writableFile.getSheet(0);
        //defined the driver
        driver = Reusable_Library.setDriver();
    }//end of BeforeMethod

    @Test
    public void googleSearch() throws InterruptedException, WriteException {
        int row = wSheet.getRows();
        for(int i = 1; i < row; i++) {
            String cars = wSheet.getCell(0,i).getContents();
            driver.navigate().to("https://www.google.com");
            Thread.sleep(2000);
            //enter keyword car on my search field
            Reusable_Library.userKeys(driver, "//*[@name='q']", cars, "Search Field");
            //click on submit
            Reusable_Library.submit(driver, "//*[@name='btnK']", "Google Search Button");
            Thread.sleep(2000);
            //capture text and print out the search number
            String searchResult = Reusable_Library.captureText(driver, "//*[@id='result-stats']", "Search Results");
            //split the text and print the number
            String[] arraySearch = searchResult.split(" ");
            //Reporter.log("My search number for car is " + arraySearch[1]);
            System.out.println("My search number for car is " + arraySearch[1]);
            //add the label
            Label label = new Label(1,i,arraySearch[1]);
            wSheet.addCell(label);
        }//end of for loop
    }//end of google test

    @AfterSuite
    public void quitDriver() throws IOException, WriteException {
        writableFile.write();
        writableFile.close();
        readableFile.close();
        driver.quit();
    }//end of Aftermethod



}//end of java class
