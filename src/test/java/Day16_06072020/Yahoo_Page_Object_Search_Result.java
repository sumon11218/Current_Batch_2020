package Day16_06072020;

import Resuable_Classes.Abstract_Class;
import Yahoo_Page_Object.Yahoo_Base_Class;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class Yahoo_Page_Object_Search_Result extends Abstract_Class {

    @Test
    public void Yahoo_Search_Result() throws InterruptedException {

        //using arraylist to define array test data
        ArrayList<String> cars = new ArrayList<>();
        cars.add("Lexus");
        cars.add("BMW");
        cars.add("Mercedes");

        /** we are using reference name for page classes which is defined
            on Yahoo base class
         */
        for(int i = 0; i < cars.size(); i++) {
            logger.log(LogStatus.INFO, "navigating to Yahoo Home page");
            driver.navigate().to("https://www.yahoo.com");
            Thread.sleep(2500);
            /** calling searchField method from Yahoo home page */
            Yahoo_Base_Class.yahoo_homepage().searchField(cars.get(i));
            /** calling searchIcon method from yahoo search result page */
            Yahoo_Base_Class.yahoo_homepage().searchIcon();
            Thread.sleep(2500);
            /** calling scrollToBottom method from yahoo search result page */
            Yahoo_Base_Class.yahoo_search_result_page().scrollToBottom();
            /** calling searchNumber method from yahoo search result page */
            Yahoo_Base_Class.yahoo_search_result_page().searchNumber();
        }//end of for loop

    }//end of test method



}//end of java class




