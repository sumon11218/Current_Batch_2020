package Yahoo_Page_Object;

import Resuable_Classes.Abstract_Class;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Yahoo_Base_Class extends Abstract_Class {
    /** constructor class is defined to call local driver and set it to
        the driver from abstract class
     */
    public Yahoo_Base_Class(WebDriver driver){
        super();
        PageFactory.initElements(driver,this);
    }//end of constructor

    /** method/object is created to make the page classes static
        by referencing as a new name similar to the actual page class name
     */

    /** object/method for yahoo home page */
    public static Yahoo_Homepage yahoo_homepage(){
        Yahoo_Homepage yahoo_homepage = new Yahoo_Homepage(driver);
        return yahoo_homepage;
    }//end of object reference for yahoo homepage

    /** object/method for yahoo search result page */
    public static Yahoo_Search_Result_Page yahoo_search_result_page(){
        Yahoo_Search_Result_Page yahoo_search_result_page = new Yahoo_Search_Result_Page(driver);
        return yahoo_search_result_page;
    }//end of object reference for yahoo search result page










}//end of java class
