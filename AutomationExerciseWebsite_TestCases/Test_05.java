package AutomationExerciseWebpage_Exercises;
//Register User with existing email

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

public class Test_05 {
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
    public void clickLoginSignupButton(){
        //        4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']")).click();
        //        5. Verify 'New User Signup!' is visible
        WebElement newUserSignupButton= driver.findElement(By.xpath("//h2[normalize-space()='New User Signup!']"));
        Assert.assertTrue(newUserSignupButton.isDisplayed());
    }
    @Test(priority = 3)
    public void tryCreateNewAccountWithAlreadyAccount(){

        //        6. Enter name and already registered email address
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("İsmail Aslan");
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("ismail@gmail.com");

    }
    @Test(priority = 4)
    public void clickSignUpButton(){
        //        7. Click 'Signup' button
        driver.findElement(By.xpath("//button[normalize-space()='Signup']")).click();
    }
    @Test(priority = 4)
    public void verifyErrorMessage(){
        //       8. Verify error 'Email Address already exist!' is visible
        WebElement errorMessage= driver.findElement(By.xpath("//p[normalize-space()='Email Address already exist!']"));
        Assert.assertTrue(errorMessage.isDisplayed());
    }
    @AfterTest
    public void tearDown(){
        driver.close();
    }

}

