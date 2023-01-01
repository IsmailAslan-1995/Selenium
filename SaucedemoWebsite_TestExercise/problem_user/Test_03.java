package Saucedemo_TestExercise.problem_user;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class Test_03 {
    private static WebDriver driver=new ChromeDriver();

    public static void main(String[] args) {
        // Test Case: Checkout Button Control
        WebDriverManager.chromedriver().setup();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        LoginWebpage();
        addItems();
        final int PRODUCT_NUMBERS=6;
        //checkAddButton(PRODUCT_NUMBERS);
        checkCheckOutButton();
        driver.close();
    }


    private static void LoginWebpage() {
        String userName="standard_user";
        String password="secret_sauce";
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(userName);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
    }
    private static void addItems()  {
        List<WebElement> addButton=driver.findElements(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory']"));
        for( int i=0;i<addButton.size();i++){
            driver.findElement(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory']")).click();
        }


    }
    private static void checkAddButton(int productsNumber) {
        Assert.assertEquals(driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")).getText(),productsNumber);

    }

    private static void checkCheckOutButton() {
        driver.navigate().to("https://www.saucedemo.com/cart.html");
        WebElement checkoutButton=driver.findElement(By.xpath("//button[@id='checkout']"));
        checkoutButton.click();
        driver.navigate().to("https://www.saucedemo.com/checkout-step-one.html");
        Assert.assertEquals(driver.findElement(By.xpath("//span[@class='title']")).getText(),"CHECKOUT: YOUR INFORMATION");
    }
}

