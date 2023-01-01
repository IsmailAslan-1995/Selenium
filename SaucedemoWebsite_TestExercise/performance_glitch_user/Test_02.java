package Saucedemo_TestExercise.performance_glitch_user;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;


public class Test_02 {
    private static  WebDriver driver=new ChromeDriver();
    public static void main(String[] args) {
        // Test Case: Checkout Control
        WebDriverManager.chromedriver().setup();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        LoginWebpage();
        addItems();
        int productNumber=productNumbers();
        checkoutProductsNumbersControl(productNumber);
        controlCheckout();
        driver.close();
    }
    private static void LoginWebpage() {
        String userName="performance_glitch_user";
        String password="secret_sauce";
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(userName);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
    }
    private static void addItems() {
       List<WebElement> addButton=driver.findElements(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory']"));
       for( int i=0;i<addButton.size();i++){
           driver.findElement(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory']")).click();
       }

    }
    private static int productNumbers() {
        List<WebElement> addButton=driver.findElements(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory']"));
        return addButton.size();
    }
    private static void checkoutProductsNumbersControl(int productNumbers){
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
        driver.navigate().to("https://www.saucedemo.com/cart.html");
        List<WebElement>products=driver.findElements(By.xpath("//button[class='btn btn_secondary btn_small cart_button']"));
        Assert.assertEquals(productNumbers,products.size());

          }
    private static void controlCheckout() {
        driver.navigate().to("https://www.saucedemo.com/cart.html");
        driver.findElement(By.xpath("//button[@id='checkout']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//span[@class='title']")).getText(),"CHECKOUT: YOUR INFORMATION");
    }
}

