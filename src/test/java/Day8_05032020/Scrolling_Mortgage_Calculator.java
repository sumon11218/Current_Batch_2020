package Day8_05032020;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Scrolling_Mortgage_Calculator {


    public static void main(String[] args) throws InterruptedException {

        //set the chrome path
        System.setProperty("webdriver.chrome.driver","src//Resource//chromedriver80.exe");
        //set some pre conditions using ChromeOptions
        ChromeOptions options = new ChromeOptions();
        //set the arguments you want for the driver
        options.addArguments("start-maximized","incognito");
        //now simply define your chrome driver
        WebDriver driver = new ChromeDriver(options);

        //navigate to mortgage calculator home page
        driver.navigate().to("https://www.mortgagecalculator.org");

        Thread.sleep(2500);

        //declare and define javascript
        JavascriptExecutor jse = (JavascriptExecutor)driver;

        //scroll all the way to the bottom of the page
        //jse.executeScript("scroll(0,5000)");
        //Thread.sleep(1000);
        //scroll all the way to the top of the page again
        //jse.executeScript("scroll(0,-5000)");

        //scrolling to an element view for Home Value
        try{
            WebElement homeValue = driver.findElement(By.xpath("//*[@id='homeval']"));
            jse.executeScript("arguments[0].scrollIntoView(true);",homeValue);
        } catch (Exception e) {
            System.out.println("Unable to locate Home Value " + e);
        }//end of home value

    }//end of main


}//end of class
