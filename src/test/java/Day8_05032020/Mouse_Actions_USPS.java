package Day8_05032020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;

public class Mouse_Actions_USPS {

    public static void main(String[] args) throws InterruptedException {

        //set the chrome path
        System.setProperty("webdriver.chrome.driver","src//Resource//chromedriver80.exe");
        //set some pre conditions using ChromeOptions
        ChromeOptions options = new ChromeOptions();
        //set the arguments you want for the driver
        options.addArguments("start-maximized","incognito");
        //now simply define your chrome driver
        WebDriver driver = new ChromeDriver(options);

        //navigate to USPS
        driver.navigate().to("https://www.usps.com");

        Thread.sleep(2500);

        //call your Mouse Actions
        Actions mouse = new Actions(driver);

        //hover to Mail & Ship tab
        try{
            WebElement mailAndShip = driver.findElement(By.xpath("//*[text()='Mail & Ship']"));
            //call your Actions command to move to the element
            mouse.moveToElement(mailAndShip).perform();
        }catch (Exception e){
                System.out.println("Unable to locate Mail & Ship " + e);
        }//end of Mail & Ship Exception
         Thread.sleep(1500);
        //click on Click-N-Ship using Actions
        try{
            WebElement clickAndShip = driver.findElement(By.xpath("//a[text()='Click-N-Ship']"));
            //call your Actions command to move to the element and then click
            mouse.moveToElement(clickAndShip).click().perform();
            //this is to submit using mouse actions
            //clickAndShip.submit();
            //mouse.moveToElement(clickAndShip).sendKeys(Keys.ENTER).perform();
        }catch (Exception e){
            System.out.println("Unable to locate Click-N-Ship " + e);
        }//end of Click-N-Ship Exception

        ArrayList<String> dentalProgam = new ArrayList<>();
        dentalProgam.add("PPO-LOW");
        dentalProgam.add("PPO-MEDIUM");
        dentalProgam.add("PPO-HIGH");

    }//end of main


}//end of java class
