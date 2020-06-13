package ActionItems;

import Resuable_Classes.Reusable_Library;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Kayak_Mahmoud_Firoz {


    WebDriver driver;
    Workbook readableFile;
    Sheet readableSheet;
    WritableWorkbook writableFile;
    WritableSheet writableSheet;
    String title;
    String bookingInfo1;
    String estimatedPrice1;
    String bookingInfo2;
    String estimatedPrice2;
    String bookingInfo3;
    String estimatedPrice3;
    String locatorInfo2;


    @BeforeSuite
    public void defineDriver() throws IOException, BiffException, IOException, BiffException, InterruptedException {
        //Define the path of readable file
        readableFile = Workbook.getWorkbook(new File("src/main/java/Excel/Kayak.xls"));
        //Define the readable sheet
        readableSheet = readableFile.getSheet(0);
        //Define the path to create writable file
        writableFile = Workbook.createWorkbook(new File("src/main/java/Excel/KayakResults.xls"), readableFile);
        //define the writable sheet
        writableSheet = writableFile.getSheet(0);
        //Define the driver
        driver = Reusable_Library.setDriver();
    }//end of the Before method

    @Test
    public void operation() throws InterruptedException, WriteException {
        //Define a variable for row
        int row = writableSheet.getRows();
        //for loop starts
        for (int i = 1; i < row; i++) {
            //Define the string variable for airportName
            String airportName = writableSheet.getCell(0, i).getContents();
            //Define the string variable for startDate
            String startDate = writableSheet.getCell(1, i).getContents();
            //Define the string variable for startTime
            String startTime = writableSheet.getCell(2, i).getContents();
            //Define the string variable for endDate
            String endDate = writableSheet.getCell(3, i).getContents();
            //Define the string variable for endTime
            String endTime = writableSheet.getCell(4, i).getContents();
            //Define the string variable for vehicleSize
            String vehicleSize = writableSheet.getCell(5, i).getContents();
            //opening the browser
            driver.navigate().to("https://www.kayak.com");
            //Delaying for 2.5 sec
            Thread.sleep(2500);
            //Click the search box
            Reusable_Library.click(driver, "//div[@data-placeholder='Enter an airport or city']", "Click search box");
            //Enter the airport in the search box
            Reusable_Library.userKeys(driver, "//*[@name='pickup']", airportName, "input");
            //Delaying for 1.5 sec
            Thread.sleep(1500);
            //Using keyboard command: Enter
            Reusable_Library.keyEnter(driver, "//*[@name='pickup']", "Enter");
            //Delaying for 2sec
            Thread.sleep(2000);
            //Selecting the end date
            Reusable_Library.click(driver, "(//div[@class='_iQh']) [2]", "Clicking drop off date date");
            //Delay for 3 sec
            Thread.sleep(3000);
            // Selecting the time from excel file
            Reusable_Library.userKeys(driver, "(//div[@aria-label='Drop-off date']) [2]", endDate, "selecting Drop off date");
            //Delay for 1.5 sec
            Thread.sleep(1500);
            //Using keyboard command: Enter
            Reusable_Library.keyEnter(driver, "(//div[@aria-label='Drop-off date']) [2]", "hit Enter");
            //Clicking outside to cancel the calender table
            // Reusable_Library.click(driver, "//*[@class='_iaU _h-2 _iEi _iuv _idj']", "click outside");
            Reusable_Library.click(driver, "//*[@class='_iaU _h-2 _iEi _iuv _idj']", "click outside");
            //Delay for 2sec
            Thread.sleep(2000);
            //Clicking the end time box
            // Reusable_Library.click(driver, "(//div[@aria-haspopup='listbox']) [3]", "End time");
            Reusable_Library.click(driver, "//*[@class='_id7 _irc _ii0 _iir']) [2]","Enter");
            //Delay for 3 sec
            Thread.sleep(3000);
            //Scrolling down
            //Reusable_Library.scrollDown(driver, "//*[@class='handle']", 0, 10, "Scroll down");
            //Delaying for 2 sec
            Thread.sleep(2000);
            //
            if (i == 1) {
                Reusable_Library.click(driver, "(//*[@data-title='" + endTime + "']) [2]", "end time");
            }//end of the if condition
            if (i == 2 || i == 3) {
                Reusable_Library.click(driver, "(//*[@data-title='" + endTime + "']) [4]", "end time");
            }//end of the if condition
            // Clicking the start time
            Reusable_Library.click(driver, "(//*[@class='_iQh']) [1]", "click");
            //Delaying for 3 sec
            Thread.sleep(3000);
            //Enter the start date
            Reusable_Library.userKeys(driver, "(//div[@aria-label='Pick-up date']) [2]", startDate, "Pickup date");
            //Hitting Enter
            Reusable_Library.keyEnter(driver, "(//div[@aria-label='Pick-up date']) [2]", "Hitting Enter");
            //Delaying for 3 sec
            Thread.sleep(3000);
            //clicking outside to close the calender table
            Reusable_Library.click(driver, "//*[@class='_iaU _h-2 _iEi _iuv _idj']", "click outside");
            Reusable_Library.click(driver, "//*[@class='_iaU _h-2 _iEi _iuv _idj']", "click outside");

            //Delaying for 2.5 sec
            Thread.sleep(2500);
            //Clicking the start time
            Reusable_Library.click(driver, "(//div[@aria-haspopup='listbox']) [2]", "Click pickup time hour");

            //Delay for 5 sec
            Thread.sleep(5000);
            //using scrolling down
           // Reusable_Library.scrollDown(driver, "//*[@class='handle']", 0, 10, "Scroll down");
            //Clicking the start date time
            Reusable_Library.click(driver, "(//li[contains(text(),'" + startTime + "')]) [1]", "Select pickup time hour");
            //Clicking the search button
            Reusable_Library.click(driver, "//*[@class='_h-2 _ivP _iv1']", "search");
            //Delaying for 3sec
            Thread.sleep(3000);
            //Clicking the checkbox for car size
            Reusable_Library.click(driver, "//div[@id='cars-topFilter-" + vehicleSize + "-checkbox_icon']", "checkbox");
            //Delay for 5 sec
            Thread.sleep(5000);
            //Delay for 5 sec
            Reusable_Library.click(driver, "(//*[contains(text(),'View Deal')]) [2]", "view deal");
            Thread.sleep(5000);
            //Create the array for the tabs
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            //Switching to new tab
            driver.switchTo().window(tabs.get(1));
            //Delaying for 4 sec
            Thread.sleep(4000);
            //Printing the title of the new page
            System.out.println(driver.getTitle());
            //Creating the variable for title
            title = driver.getTitle();
            //if condition for the correct title
            if (i == 1 && title.equals("Rental Center")) {
                //Capturing the booking info in a string variable
                bookingInfo1 = Reusable_Library.captureText(driver, "(//*[@class='col-md-12']) [1]", "Booking info");
                //Capturing the estimated price in a string variable
                estimatedPrice1 = driver.findElement(By.xpath("//td[@class='bold_bs_value']")).getText();
            }//end of the if condition
            //if condition for the correct title
            if (i == 2 && title.equals("Inglewood Car Booking - KAYAK")) {
                locatorInfo2="(//*[@class='Checkout-Common-Uicore-NormalText resetColor']) [1]";
                //Capturing the booking info in a string variable
                bookingInfo2 = Reusable_Library.captureText(driver,locatorInfo2, "Booking info");
                //Capturing the estimated price in a string variable
                estimatedPrice2 = driver.findElement(By.xpath("(//*[@class='fpiCell']) [22]")).getText();
            }//end of the if condition
            //if condition for the correct title
            if (i == 3 && title.equals("Rental Center")) {
                //Capturing the booking info in a string variable
                bookingInfo3 = Reusable_Library.captureText(driver, "(//*[@class='col-md-12']) [1]", "Booking info");
                //Capturing the estimated price in a string variable
                estimatedPrice3 = driver.findElement(By.xpath("//td[@class='bold_bs_value']")).getText();
            }//end of the if condition
            //creating label for booking info 1
            Label label61 = new Label(6, 1, bookingInfo1);
            writableSheet.addCell(label61);
            //creating label for booking info
            Label label62 = new Label(6, 2, bookingInfo2);
            //Adding the value into a cell
            writableSheet.addCell(label62);
            //creating label for booking info
            Label label63 = new Label(6, 3, bookingInfo3);
            //Adding the value into a cell
            writableSheet.addCell(label63);
            //creating label for booking info
            Label label71 = new Label(7, 1, estimatedPrice1);
            //Adding the value into a cell
            writableSheet.addCell(label71);
            //creating label for booking info
            Label label72 = new Label(7, 2, estimatedPrice2);
            //Adding the value into a cell
            writableSheet.addCell(label72);
            //creating label for booking info
            Label label73 = new Label(7, 3, estimatedPrice3);
            //Adding the value into a cell
            writableSheet.addCell(label73);
            //closing the current window
            driver.close();
            //switching back to the previous window
            driver.switchTo().window(tabs.get(0));
            //Removing all the cookies
            driver.manage().deleteAllCookies();

        }//end of for loop
    }//end of the Test method

    @AfterSuite
    public void quitDriver() throws InterruptedException, IOException, WriteException {
        writableFile.write();
        writableFile.close();
        readableFile.close();
        driver.quit();
    }//end of the quit method



}//end of java class
