package AutomationExerciseWebpage_Exercises;
//  Verify Test Cases Page
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Test_07 {
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
    public void  clickTestCaseButton(){
        //      4. Click on 'Test Cases' button
        driver.findElement(By.xpath("//a[contains(text(),'Test Cases')]")).click();
    }
    @Test(priority = 3)
    public void verifyNavigatedToTestCasePage(){
        //      5. Verify user is navigated to test cases page successfully
        WebElement text= driver.findElement(By.xpath("//div[@class='panel-group']//h5"));
        Assert.assertTrue(text.isDisplayed());
    }
    @AfterTest
    public void tearDown(){
        driver.close();
    }

}

