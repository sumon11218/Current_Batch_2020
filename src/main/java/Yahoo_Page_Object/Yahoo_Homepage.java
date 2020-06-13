package Yahoo_Page_Object;

import Resuable_Classes.Abstract_Class;
import Resuable_Classes.Reusable_Library_Loggers;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Yahoo_Homepage extends Abstract_Class {

    /** declare ExtentTest so you can use it locally **/
    ExtentTest logger;

    /** we need to create a constructor method that defines
    driver and logger to be reuse locally to this page class
    ..constructor inherits same name as your java parent class
    */
    public Yahoo_Homepage(WebDriver driver){
        /** super() command define the driver and logger variable
            you need locally which is coming from abstract class
         */
        super();

        /** PageFactory.initElements allows you to set a local driver to
            equal to your driver coming from abstract class by using 'this'
            command to indicate you are using the driver in this page class
         */
        PageFactory.initElements(driver,this);

        /** local page logger gets set to abstract class 'logger' when you
           use it in page object concept
         */
        this.logger = super.logger;
    }//end of constructor

    /** method for searchfield */
    public Yahoo_Homepage searchField(String userValue){
        Reusable_Library_Loggers.userKeys(driver,"//*[@id='header-search-input']",userValue,"Search Field",logger);
        return new Yahoo_Homepage(driver);
        /** the driver that i used is returning you the same
            yahoo_homepage
         */
    }//end of search method

    /** method for search icon */
    public Yahoo_Homepage searchIcon(){
        Reusable_Library_Loggers.click(driver,"//*[@id='header-desktop-search-button']","Search Icon",logger);
        return new Yahoo_Homepage(driver);
    }//end of search icon method






}//end of java class
