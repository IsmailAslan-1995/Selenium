package AutomationExerciseWebpage_Exercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Test_21 {
    WebDriver driver=new ChromeDriver();

    @BeforeTest()
    public void launchBrowserAndNavigateWebsite(){
        //        1. Launch browser
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //        2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
    }
    @Test(priority = 1)
    public void clickProductsButton(){
        //        3. Click on 'Products' button
        driver.findElement(By.xpath("//a[@href='/products']")).click();

    }
    @Test(priority = 2)
    public void verifyAllProductsPage(){
        //        4. Verify user is navigated to ALL PRODUCTS page successfully
        WebElement title= driver.findElement(By.xpath("(//h2[normalize-space()='All Products'])[1]"));
        Assert.assertTrue(title.isDisplayed());
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,500)");


    }
    @Test(priority = 3)
    public void clickOnViewProductButton() throws InterruptedException {
        //        5. Click on 'View Product' button

       WebElement element= driver.findElement(By.cssSelector("a[href='/product_details/1']"));
       Thread.sleep(3000);
       element.click();

    }
    @Test(priority = 4)
    public void verifyWriteYourReviewIsVisible() {
        //        6. Verify 'Write Your Review' is visible
        WebElement review= driver.findElement(By.xpath("//a[normalize-space()='Write Your Review']"));
        Assert.assertTrue(review.isDisplayed());

    }
    @Test(priority = 5)
    public void enterNameEmailReviewAndSubmitButton() {
        //        7. Enter name, email and review
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("İsmail ASLAN");
        driver.findElement(By.xpath("//input[@id='email']")) .sendKeys("ismail@gmail.com");
        driver.findElement(By.xpath("//textarea[@id='review']")) .sendKeys("Message!!!");
        driver.findElement(By.xpath("//button[@id='button-review']")).click();
 }
    @Test(priority = 6)
    public void VerifySuccessMessage() throws InterruptedException {

        //        9. Verify success message 'Thank you for your review.'
        WebElement message= driver.findElement(By.xpath("(//div[@class='alert-success alert'])[1]"));
        Assert.assertTrue(message.isDisplayed());
    }
    @AfterTest
    public void tearDown(){
        driver.close();
    }
}
