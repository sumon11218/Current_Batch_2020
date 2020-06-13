package Yahoo_Page_Object;

import Resuable_Classes.Abstract_Class;
import Resuable_Classes.Reusable_Library_Loggers;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Yahoo_Search_Result_Page extends Abstract_Class {

    /** declaring local logger to this page class */
    ExtentTest logger;

    /** constructor method to handle local driver and logger equal to driver and
        logger from abstract class
     */
    public Yahoo_Search_Result_Page(WebDriver driver){
        super();
        PageFactory.initElements(driver,this);
        //local page logger gets set to abstract class logger when you use it in
        //page object concept
        this.logger = super.logger;
    }//end of constructor


    /** method to scroll all the way to the bottom on yahoo result page */
    public Yahoo_Search_Result_Page scrollToBottom(){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        logger.log(LogStatus.INFO,"Scrolling to the bottom of Yahoo Search Result page");
        jse.executeScript("scroll(0,10000);");
        return new Yahoo_Search_Result_Page(driver);
    }//end of scrolling method

    /** method to capture the search number */
    public Yahoo_Search_Result_Page searchNumber() throws InterruptedException {
        String searchResult = Reusable_Library_Loggers.captureText(driver,"//*[@class='compPagination']","Search Result",logger);
        String[] searchNumber = searchResult.split("Next");
        logger.log(LogStatus.INFO,"My Search number is " + searchNumber[1]);
        return new Yahoo_Search_Result_Page(driver);
    }//end of searchnumber method



}//end of java class
