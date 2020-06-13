package Practice_Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Aetna_Test {

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
        driver.navigate().to("https://www.aetna.com");

        WebDriverWait wait = new WebDriverWait(driver,15);
        Actions actions = new Actions(driver);
        try{
            Thread.sleep(2500);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Shop for a plan']"))).click();
        }catch (Exception e) {
            System.out.println("Unable to locate Shop for a plan " + e);
        }

        try{
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Medicare']")));
            element.click();
        }catch (Exception e) {
            System.out.println("Unable to locate Medicare " + e);
        }
        try{
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Find a doctor')]")));
            actions.moveToElement(element).click().perform();
        }catch (Exception e) {
            System.out.println("Unable to locate Find a doctor " + e);
        }

        try{
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'2020 Medicare plans you purchase yourself')]")));
            actions.moveToElement(element).click().perform();
        }catch (Exception e) {
            System.out.println("Unable to locate 2020 Medicare plans you purchase yourself " + e);
        }

        Thread.sleep(3000);

        try{
            int x=99; //this integer coming from array list
            //locate the pointer first on the property
            WebElement pointer = driver.findElement(By.xpath("//*[@class='rz-pointer rz-pointer-min']"));
            //move the mouse to the slider pointer then hit tab to switch to the pointer
            actions.moveToElement(pointer).sendKeys(Keys.TAB).perform();
            //since default is 25 we are pressing arrow left -25 times through looping
            //to set the value to 0
            for (int i = 0; i < 25; i++) {
                //arrow left to loop through to reset the mile to 0
                actions.sendKeys(Keys.ARROW_LEFT).perform();
            }//end of loop resume the value to 0
            Thread.sleep(1000);
            for (int i = 0; i < x; i++) {
                //arrow right to loop through number of desired range
                actions.sendKeys(Keys.ARROW_RIGHT).perform();
                //Thread.sleep(200);
            }//end of loop resume the value to desired range you want
        } catch (Exception e) {
            System.out.println("Unable to move slider to specific range " + e);
        }








    }//end of main




}//end of class
