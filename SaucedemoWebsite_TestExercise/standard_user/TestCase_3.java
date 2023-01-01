package Saucedemo_TestExercise.standard_user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class TestCase_3 {
    public static void main(String[] args) throws InterruptedException {
        //CHECKOUT CONTROL
        System.setProperty("web-driver.chrome.driver", "\\Selenium and driver\\chromedriver_win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://www.saucedemo.com/");

        String username = "standard_user";

        String password = "secret_sauce";

        String firstName = "Guven";
        String lastName = "Dolas";
        String zipCode = "34600";

        driver.findElement(By.id("user-name")).sendKeys(username);

        driver.findElement(By.id("password")).sendKeys(password);

        driver.findElement(By.id("login-button")).click();

        Thread.sleep(3000);

        List<WebElement> addToCartButton = driver.findElements(By.xpath("//button[text()='Add to cart']"));

        for (int i = 0; i < addToCartButton.size(); i++) {
            addToCartButton.get(i).click();

        }

        //click shop icon
        driver.findElement(By.xpath("//*[@id='shopping_cart_container']/a")).click();
        //click
        driver.findElement(By.id("checkout")).click();
        driver.findElement(By.id("first-name")).sendKeys(firstName);
        driver.findElement(By.id("last-name")).sendKeys(lastName);
        driver.findElement(By.id("postal-code")).sendKeys(zipCode);
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("finish")).click();
        String actual = driver.findElement(By.xpath("//h2[contains(text(),'THANK YOU FOR YOUR ORDER')]")).getText();
        String expected = "THANK YOU FOR YOUR ORDER";

            Assert.assertEquals(actual,expected);

        driver.quit();
    }
}

