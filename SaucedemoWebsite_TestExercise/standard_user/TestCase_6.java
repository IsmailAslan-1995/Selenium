package Selenium_2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class TestCase_6 {

    public static void main(String[] args) {
        /**
         * Image control
         */

        WebDriver driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ASUS\\Desktop\\chromedriver.exe");

        driver.get("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("#login-button")).click();

        Assert.assertEquals(driver.findElement(By.xpath("//img[@alt='Sauce Labs Backpack']")).getAttribute("src"),"https://www.saucedemo.com/static/media/sauce-backpack-1200x1500.34e7aa42.jpg");
        driver.close();
    }
}

