package AutomationExerciseWebpage_Exercises;
//Login User with correct email and password
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class Test_02 {
    public static void main(String[] args) {
//        1. Launch browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//        2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
//        3. Verify that home page is visible successfully
        WebElement logo=driver.findElement(By.xpath("//img[@alt='Website for automation practice']"));
        Assert.assertTrue(logo.isDisplayed());
//        4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']")).click();
//        5. Verify 'Login to your account' is visible
        WebElement loginToYourAccountButton= driver.findElement(By.xpath("//h2[normalize-space()='Login to your account']"));
        Assert.assertTrue(loginToYourAccountButton.isDisplayed());
//        6. Enter correct email address and password
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("ismail@gmail.com");
        driver.findElement(By.xpath("//input[@data-qa='login-password']")).sendKeys("12345");
//        7. Click 'login' button
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
//        8. Verify that 'Logged in as username' is visible
        String expected="Logged in as İsmail Aslan";
        String actual=driver.findElement(By.xpath("//a[text()=' Logged in as ' ]")).getText();
        Assert.assertEquals(expected,actual);
//        9. Click 'Delete Account' button
        driver.findElement(By.xpath("//a[normalize-space()='Delete Account']")).click();

//        10. Verify that 'ACCOUNT DELETED!' is visible
        String expected1="ACCOUNT DELETED!";
        String actual1=driver.findElement(By.xpath("//b[normalize-space()='Account Deleted!']")).getText();
        driver.close();
    }
}

