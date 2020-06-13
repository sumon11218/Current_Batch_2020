package Day5_04252020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locate_By_Xpath {

    public static void main(String[] args) throws InterruptedException {

        //line below store your search field xpath as a string variable
        String searchPath = "//*[@name='field-keywords']";
        //line below store your Search Icon xpath as a string variable
        String searchIconPath = "//*[@value='Go']";
        //line below store your Image Icon xpath as a string variable
        String imagePath = "//img[contains(@class,'s-image')]";

        //define your property
        System.setProperty("webdriver.chrome.driver","src//Resource//chromedriver80.exe");
        //define the driver
        WebDriver driver = new ChromeDriver();
        //navigate to amazon home page
        driver.navigate().to("https://www.amazon.com");
        //maximize your driver window
        driver.manage().window().maximize();
        //wait few seconds
        Thread.sleep(2000);
        //enter a keyword laptop on amazon search field by using xpath
        driver.findElement(By.xpath(searchPath)).sendKeys("laptop");
        //driver.findElement(By.xpath("//*[@name='field-keywords']")).submit();
        //click on search icon
        driver.findElement(By.xpath(searchIconPath)).click();
        Thread.sleep(2500);
        //click on second image item of the same elements within that page using index number
        driver.findElements(By.xpath(imagePath)).get(4).click();
        //renavigate back to home page
       // driver.navigate().to("https://www.amazon.com");

    }//end of main


}//end of java class
