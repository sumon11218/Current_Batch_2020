package Day5_04252020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class test_WW {

    public static void main(String[] args) throws InterruptedException {

        //define your property
        System.setProperty("webdriver.chrome.driver","src//Resource//chromedriver80.exe");
        //define the driver
        WebDriver driver = new ChromeDriver();
        //navigate to amazon home page
        driver.navigate().to("https://www.weightwatchers.com");
        Thread.sleep(2500);

        driver.findElement(By.xpath("//*[@ class='find-a-meeting']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@name='meetingSearch']")).sendKeys("11219");
        driver.findElement(By.xpath("//*[@spice='SEARCH_BUTTON']")).click();
        Thread.sleep(2000);
        driver.findElements(By.xpath("//*[@class='location__name']")).get(1).click();
        Thread.sleep(3000);
        String scheduleDetail = driver.findElement(By.xpath("//*[@class='meeting-schedule__schedule']")).getText();

        System.out.println("Schedule detail: " + scheduleDetail);

    }//end of main


}//end of java class
