package Practice_Tests;

import Resuable_Classes.Reusable_Library;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Express_AI {

    public static void main(String[] args) throws InterruptedException, IOException, BiffException, WriteException {

        Workbook readableFile = Workbook.getWorkbook(new File("src/Resource/Express_Search.xls"));
        //locate the readable worksheet by index
        Sheet readableSheet = readableFile.getSheet(0);

        //open readable file through Deskptop command automatically
        Desktop.getDesktop().open(new File("src\\Resource\\Express_Search.xls"));

        //we need create a writeable workbook to mimic readable file because we shouldn't be writing on readable file
        WritableWorkbook writableFile= Workbook.createWorkbook(new File("src/Resource/Express_Search_Result.xls"),readableFile);
        //create writable sheet
        WritableSheet writableSheet= writableFile.getSheet(0);
        //get the row cow count which are not empty
        int row = writableSheet.getRows();

        WebDriver driver = Reusable_Library.setDriver();

        for( int i =1; i<2;i++) {
            //all the variables
            String size = writableSheet.getCell(0,i).getContents();
            String quantity= writableSheet.getCell(1,i).getContents();
            String firstName=writableSheet.getCell(2,i).getContents();
            String lastName= writableSheet.getCell(3,i).getContents();
            String email = writableSheet.getCell(4,i).getContents();
            String phoneNumber = writableSheet.getCell(5,i).getContents();
            String streetAdd = writableSheet.getCell(6,i).getContents();
            String postalCode = writableSheet.getCell(7,i).getContents();
            String city = writableSheet.getCell(8,i).getContents();
            String State = writableSheet.getCell(9,i).getContents();
            String creditCardNumber=writableSheet.getCell(10,i).getContents();
            String expMonth = writableSheet.getCell(11,i).getContents();
            String expYear= writableSheet.getCell(12,i).getContents();
            String cvcCode = writableSheet.getCell(13,i).getContents();

            //navigate to express
            driver.navigate().to("https://www.express.com/");
            //wait for 2 seconds
            Thread.sleep(2000);
            //hover over the women with mouse action
            Reusable_Library.Hover(driver,"//a[text()='Women']","women");
            Thread.sleep(2000);
            // mouse click on dress
            Reusable_Library.MouseClick(driver,"//a[text()='Dresses']","dress");
            Thread.sleep(2000);
            //select the first dress
            Reusable_Library.click(driver,"//a[text()='off the shoulder ruffle maxi dress']","firstDress");
            Thread.sleep(2000);
            //select the size
            Reusable_Library.click(driver,"//span[text()='"+ size +"']","size");
            //this will add the bag
            Reusable_Library.click(driver,"//button[text()='Add to Bag']","add to bag");
            //this will hover over shopping sign
            Reusable_Library.Hover(driver,"//div[@class='DesktopHeader_icons__25y0X ravenDesktopIcons']/div[3]","hover shopping bag");
            Thread.sleep(2000);
            // this will click on view bag and checkout
            Reusable_Library.click(driver,"//a[text()='View Bag & Check Out']","view bag");
            Thread.sleep(2000);
            //dropdown quantity
            Reusable_Library.dropdownByText(driver,"//*[@id='qdd-0-quantity']",quantity,"quantity");
            //this will click on checkout
            Reusable_Library.click(driver,"//button[@id='continue-to-checkout']","checkout");
            Thread.sleep(2000);
            //click on checkout with guest
            Reusable_Library.click(driver,"//*[text()='Continue as Guest']","Guest");
            // this will put first name
            Reusable_Library.userKeys(driver,"//input[@id='contact-information-firstname']",firstName,"firstName");
            //this will enter last name
            Reusable_Library.userKeys(driver,"//*[@name='lastname']",lastName,"lastName");
            //this will enter email
            Reusable_Library.userKeys(driver,"//input[@name='email']",email,"email");
            //this will re enter email
            Reusable_Library.userKeys(driver,"//input[@name='confirmEmail']",email,"confirm email");
            //this will enter phone Number
            Reusable_Library.userKeys(driver,"//input[@name='phone']",phoneNumber,"Phone Number");
            //this will click continue
            Reusable_Library.click(driver,"//*[@class='btn _9yfmt _194FD _2tFXQ _2SogC']","continue");
            Thread.sleep(2000);
            // this will enter the address
            Reusable_Library.userKeys(driver,"//input[@name='shipping.line1']",streetAdd,"streetAdd");
            //this will enter zipcode
            Reusable_Library.userKeys(driver,"//input[@name='shipping.postalCode']",postalCode,"zipcode");
            //this will enter the city
            Reusable_Library.userKeys(driver,"//input[@name='shipping.city']",city,"city");
            //this will select the text
            Reusable_Library.dropdownByText(driver,"//*[@name='shipping.state']",State,"state");
            //this will go to continue
            Reusable_Library.click(driver,"//*[@class='btn _9yfmt _194FD _2tFXQ _2SogC']","continue");
            Thread.sleep(2000);
            Reusable_Library.click(driver,"//*[@class='btn _9yfmt _194FD _2tFXQ _2SogC']","continue");
            Thread.sleep(2000);
            //enter the card Number
            Reusable_Library.userKeys(driver,"//*[@name='creditCardNumber']",creditCardNumber,"creditCardNumber");
            //enter the exp Month
            Reusable_Library.dropdownByText(driver,"//*[@name='expMonth']",expMonth,"expMonth");
            //enter the exp Year
            Reusable_Library.dropdownByText(driver,"//*[@name='expYear']",expYear,"expYear");
            //enter cvv code
            Reusable_Library.userKeys(driver,"//*[@name='cvv']",cvcCode,"cvv");
            // click on place order
            Reusable_Library.click(driver,"//*[text()='Place Order']","Place order");
            Thread.sleep(3000);
            //capture text
            String errormsg = Reusable_Library.captureText(driver,"//*[@id='rvn-note-NaN']","Error Result");
            //print the statement
            System.out.println("My search number is "+ errormsg);

            Label label= new Label(14,i,errormsg);
            writableSheet.addCell(label);

            //delete all the cookies
            driver.manage().deleteAllCookies();

        }//end of for loop

        writableFile.write();
        writableFile.close();
        readableFile.close();

        Thread.sleep(2000);
        //open the writable excel to view test results automatically
        //use Desktop.getDesktop().open command to open desktop applications
        Desktop.getDesktop().open(new File("src\\Resource\\Express_Search_Result.xls"));

    }//end of main


}//end of java class
