import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class SelectCalendar {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        driver.findElement(By.xpath("//select[@id='ctl00_mainContent_ddl_originStation1']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='Amritsar (ATQ)']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//a[@value='GOP'][normalize-space()='Gorakhpur (GOP)'])[2]")).click();
        driver.findElement(By.xpath("//a[normalize-space()='16']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='Div1']")).isEnabled());
    }
}

