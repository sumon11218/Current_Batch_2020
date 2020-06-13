package Day15_06062020;

import Resuable_Classes.Abstract_Class;
import Yahoo_Page_Object.Yahoo_Base_Class;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class Yahoo_Page_Object_Search_Result extends Abstract_Class {

    @Test
    public void Yahoo_Search_Result() throws InterruptedException {



        /** we are using reference name for page classes which is defined
            on Yahoo base class
         */

        logger.log(LogStatus.INFO,"navigating to Yahoo Home page");
        driver.navigate().to("https://www.yahoo.com");
        Thread.sleep(2500);
        /** calling searchField method from Yahoo home page */
        Yahoo_Base_Class.yahoo_homepage().searchField("Cars");
        /** calling searchIcon method from yahoo search result page */
        Yahoo_Base_Class.yahoo_homepage().searchIcon();
        Thread.sleep(2500);
        /** calling scrollToBottom method from yahoo search result page */
        Yahoo_Base_Class.yahoo_search_result_page().scrollToBottom();
        /** calling searchNumber method from yahoo search result page */
        Yahoo_Base_Class.yahoo_search_result_page().searchNumber();

    }//end of test method



}//end of java class




