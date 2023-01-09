package AutomationExerciseWebpage_Exercises;

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

public class Test_26 {
    WebDriver driver=new ChromeDriver();
    @BeforeTest
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
    public void scrollDownToBottom() throws InterruptedException {
        //      4. Scroll down page to bottom
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
    public void scrollUpPageToTop(){
        //  6. Scroll up page to top
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");

    }
    @Test(priority = 5)
    public void verifyPageIsScrolledUpAndText(){
        //        7. Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen
        WebElement upperText= driver.findElement(By.xpath("//div[@class='item active']//h2[contains(text(),'Full-Fledged practice website for Automation Engin')]"));
        Assert.assertTrue(upperText.isDisplayed());
    }
    @AfterTest
    public void tearDown(){
        driver.close();
    }
}

