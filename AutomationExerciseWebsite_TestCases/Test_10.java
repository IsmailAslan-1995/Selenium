package AutomationExerciseWebpage_Exercises;
// Verify Subscription in home page

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
public class Test_10 {
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
    public void verifyHomepage(){
        //        3. Verify that home page is visible successfully
        WebElement logo=driver.findElement(By.xpath("//img[@alt='Website for automation practice']"));
        Assert.assertTrue(logo.isDisplayed());
    }
    @Test(priority = 2)
    public void scrollDownToFooter(){
        //      4. Scroll down to footer
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }
    @Test(priority = 3)
    public void verifyText(){
        //    5. Verify text 'SUBSCRIPTION'
        WebElement text= driver.findElement(By.xpath("//h2[normalize-space()='Subscription']"));
        Assert.assertTrue(text.isDisplayed());
    }
    @Test(priority = 4)
    public void enterEmailAndClickArrowButton(){
        //     6. Enter email address in input and click arrow button
        driver.findElement(By.xpath("//input[@id='susbscribe_email']")).sendKeys("ismail@gmail.com");
        driver.findElement(By.xpath("//i[@class='fa fa-arrow-circle-o-right']")).click();
    }
    @Test(priority = 5)
    public void verifyMessageVisibility(){
        //     7. Verify success message 'You have been successfully subscribed!' is visible
        WebElement message= driver.findElement(By.xpath("//div[@class='alert-success alert']"));
        Assert.assertTrue(message.isDisplayed());
    }
    @AfterTest
    public void teardown(){
        driver.close();
    }
}

