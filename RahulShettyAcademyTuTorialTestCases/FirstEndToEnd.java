
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;

import java.time.Duration;


public class FirstEndToEnd {
    final static int adultNumber=4;
    final static int childNumber=2;
    final static int infantNumber=1;
    final static String passengerText=adultNumber+" Adults, "+childNumber+" Children, "+infantNumber+" Infant";
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/"); //URL in the browser
       // driver.findElement(By.id("//input[@id='ctl00_mainContent_rbtnl_Trip_0']")).click();

        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();

        driver.findElement(By.xpath("//a[@value='DEL']")).click();

        Thread.sleep(2000);

        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='MAA']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@class='ui-state-default ui-state-highlight ui-state-active']")).click();

        if (driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")) {

            System.out.println("its disabled");

            Assert.assertTrue(true);

        } else {

            Assert.assertTrue(false);

        }
        for(int i=1;i<adultNumber;i++){
            driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-k8qxaj r-d9fdf6']//div[1]//div[2]//div[3]//*[name()='svg']//*[name()='path' and contains(@fill-rule,'nonzero')]")).click();
        }
        for(int i=0;i<childNumber;i++){
            driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-150rngu r-eqz5dr r-16y2uox r-1wbh5a2 r-11yh6sk r-1rnoaur r-1sncvnh']//div[2]//div[2]//div[3]")).click();
        }
        for(int i=0;i<infantNumber;i++){
            driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-14lw9ot r-z2wwpe r-vgw6uq r-156q2ks r-urutk0 r-8uuktl r-136ojw6']//div[3]//div[2]//div[3]//*[name()='svg']")).click();
        }
        String actual=driver.findElement(By.xpath("//div[@class='css-1dbjc4n']//div//div[@class='css-1dbjc4n r-14lw9ot r-11u4nky r-z2wwpe r-1phboty r-rs99b7 r-1loqt21 r-13awgt0 r-ymttw5 r-5njf8e r-1otgn73']//div[@class='css-1dbjc4n r-1awozwy r-18u37iz r-1wtj0ep']")).getText();
        Assert.assertEquals(actual,passengerText);

        driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();

        driver.findElement(By.cssSelector("input[value='Search']")).click();

        // driver.findElement(By.xpath("//input[@value='Search']")).click();

        // driver.findElement(By.name("ctl00$mainContent$btn_FindFlights")).click();
        // driver.findElement(By.cssSelector("#ctl00_mainContent_btn_FindFlights")).click();
        driver.close();

    }

}

