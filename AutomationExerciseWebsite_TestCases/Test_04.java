package AutomationExerciseWebpage_Exercises;

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

public class Test_04 {
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
    public void LoginAccount(){
 //       4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']")).click();
//        5. Verify 'Login to your account' is visible
        WebElement loginToYourAccountButton= driver.findElement(By.xpath("//h2[normalize-space()='Login to your account']"));
        Assert.assertTrue(loginToYourAccountButton.isDisplayed());
//        6. Enter correct email address and password
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("ismail@gmail.com");
        driver.findElement(By.xpath("//input[@data-qa='login-password']")).sendKeys("12345");
//        7. Click 'login' button
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

    }
    @Test(priority = 3)
    public void verifyLogin(){
//        8. Verify that 'Logged in as username' is visible
        String expected="Logged in as İsmail Aslan";
        String actual=driver.findElement(By.xpath("//a[text()=' Logged in as ' ]")).getText();
        Assert.assertEquals(expected,actual);    }
    @Test(priority = 4)
    public void clickLogoutButton(){
        //        9. Click 'Logout' button
        driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();

    }
    @Test(priority = 5)
    public void verifyLoginPage(){
        //        10. Verify that user is navigated to login page
        WebElement logo=driver.findElement(By.xpath("//img[@alt='Website for automation practice']"));
        Assert.assertTrue(logo.isDisplayed());
    }
    @AfterTest
    public void tearDown(){
        driver.close();
    }





}

