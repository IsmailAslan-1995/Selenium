package AutomationExerciseWebpage_Exercises;
// Verify Subscription in Cart page

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Test_11 {
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
    public void clickCartButton(){
        //    4. Click 'Cart' button
        driver.findElement(By.xpath("//body[1]/header[1]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[3]/a[1]")).click();
    }
    @Test(priority = 3)
    public void scrollDownToFooter(){
        //    5. Scroll down to footer
            JavascriptExecutor js=(JavascriptExecutor)driver;
            js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        }
    @Test(priority = 4)
    public void verifySubscriptionTextVisibility(){
        //    6. Verify text 'SUBSCRIPTION'
        WebElement text= driver.findElement(By.xpath("//h2[normalize-space()='Subscription']"));
        Assert.assertTrue(text.isDisplayed());
    }
    @Test(priority = 5)
    public void enterEmailAndClickArrowButton(){
        //    7. Enter email address in input and click arrow button
        driver.findElement(By.xpath("//input[@id='susbscribe_email']")).sendKeys("ismail@gmail.com");
        driver.findElement(By.xpath("//i[@class='fa fa-arrow-circle-o-right']")).click();
    }
    @Test(priority = 6)
    public void verifyMessageVisibility(){
//    8. Verify success message 'You have been successfully subscribed!' is visible
        WebElement message= driver.findElement(By.xpath("//div[@class='alert-success alert']"));
        Assert.assertTrue(message.isDisplayed());
    }
    @AfterTest
    public void teardown(){
        driver.close();
    }


}

