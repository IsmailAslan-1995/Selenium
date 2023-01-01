package Saucedemo_TestExercise.performance_glitch_user;

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
        //total amount control
        WebDriverManager.chromedriver().setup();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        LoginWebpage();
        addItems();
        clickCheckout();
        clickContinue();
        checkTotalAmount();
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

    private static void clickCheckout() {
        driver.navigate().to("https://www.saucedemo.com/cart.html");
        driver.findElement(By.xpath("//button[@id='checkout']")).click();

    }
    private static void clickContinue() {
        String name="ismail";
        String lastName="Aslan";
        String zipCode="34000";
        driver.findElement(By.xpath("//input[@id='first-name']")).sendKeys(name);
        driver.findElement(By.xpath("//input[@id='last-name']")).sendKeys(lastName);
        driver.findElement(By.xpath("//input[@id='postal-code']")).sendKeys(zipCode);
        driver.findElement(By.xpath("//input[@id='continue']")).click();
    }
    private static void checkTotalAmount() {
        driver.navigate().to("https://www.saucedemo.com/checkout-step-two.html");
        String amount=driver.findElement(By.xpath("//div[@class='summary_total_label']")).getText();
        Assert.assertEquals(amount,"Total: $140.34");
    }
}

