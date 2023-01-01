package Saucedemo_TestExercise.standard_user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class TestCase_2 {
    public static void main(String[] args) throws InterruptedException {
        //standard user login
        //RESET APP STATE CONTROL


        System.setProperty("web-driver.chrome.driver", "\\Selenium and driver\\chromedriver_win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://www.saucedemo.com/");

        String username = "standard_user";

        String password = "secret_sauce";

        driver.findElement(By.id("user-name")).sendKeys(username);

        driver.findElement(By.id("password")).sendKeys(password);

        driver.findElement(By.id("login-button")).click();

        Thread.sleep(3000);

        List<WebElement> addToCartButton = driver.findElements(By.xpath("//button[text()='Add to cart']"));

        for (int i = 0; i < addToCartButton.size(); i++) {
            addToCartButton.get(i).click();

        }
        //Shop product size
        System.out.println("After Product size --> " + driver.findElement(By.xpath("//*[@id='shopping_cart_container']/a/span")).getText());

        driver.findElement(By.xpath("//button[text()='Open Menu']")).click();
        driver.findElement(By.id("reset_sidebar_link")).click();

        String productSize = driver.findElement(By.xpath("//*[@id='shopping_cart_container']/a")).getText();
        System.out.println(driver.findElement(By.xpath("//*[@id='shopping_cart_container']/a")).getText());

        if (productSize.isEmpty()) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test Failed");
        }
        driver.quit();
    }
}

