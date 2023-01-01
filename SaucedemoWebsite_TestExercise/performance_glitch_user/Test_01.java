package Saucedemo_TestExercise.performance_glitch_user;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class Test_01 {
    public static void main(String[] args) {
        // Test Case:Login Lag Problem
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        // 3 seconds is determined to performance criteria for every process for this project
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));


        String userName="performance_glitch_user";
        String password="secret_sauce";
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(userName);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@id='login-button']")).click();



        // Check any web elements for determine login or not
        String webelement=driver.findElement(By.xpath("//span[@class='title']")).getText();

        Assert.assertEquals(webelement,"PRODUCTS");
        driver.close();


    }
}

