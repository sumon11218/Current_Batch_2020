package Day7_05022020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Google_Test_TryCatch {


    public static void main(String[] args) throws InterruptedException {

        //set the system chrome driver path atleast once in one of your main method
        //webdriver.chrome.driver needs to be in lower case string followed by your driver path
        System.setProperty("webdriver.chrome.driver","src//Resource//chromedriver80.exe");

        //you declare and define the web driver
        WebDriver driver = new ChromeDriver();

        //set the ArrayList for the cars
        //don't need to define the size/length and also don't need to define the index numbers
        //it's a resizable array
        ArrayList<String> cars = new ArrayList<>();
        cars.add("Lexus");
        cars.add("Toyota");
        cars.add("BMW");

        for(int i = 0; i < cars.size(); i++) {
            //opening the browser automatically to go to google home page
            driver.navigate().to("https://google.com");

            //maximizing the driver
            driver.manage().window().maximize();


            //wait few seconds after navigating to a page so browser can load properly
            //sleep statement handles in miliseconds so example 1 sec = 1000 milisec.
            Thread.sleep(2000);

            //using try catch  exception to handle any error
            try {
                //locate the search field by inspecting it first and then enter a keyword let say cars
                WebElement search = driver.findElement(By.xpath("//*[@name='q']"));
                search.sendKeys(cars.get(i));
            } catch (Exception e) {
                System.out.println("Unable to enter data on Search Field " + e);
            }//end of search field exception

            try {
                driver.findElement(By.xpath("//*[@name='btnK']")).submit();
            } catch (Exception e) {
                System.out.println("Unable to submit on Search Icon " + e);
            }//end of search icon exception

            //wait few seconds
            Thread.sleep(2000);

            try {
                //to capture a text from web site you need to
                String message = driver.findElement(By.xpath("//*[contains,(@id,'result-')]")).getText();
                //using array variable to split above message
                String[] arrayResult = message.split(" ");
                System.out.println("My search number is " + arrayResult[1]);
            } catch (Exception e) {
                System.out.println("Unable to capture on Search Result " + e);
                //screenshot
            }//end of search result exception

            // when you inspect an element and most of the time it takes you to the lowest tag and property within it
            //but i can still use the tags before and the properties of it as long as it highlights the same element in the page

        }//end of for loop

        //i prefer to use quit
        driver.quit();//your last statement


    }//end of main method



}//end of java class
