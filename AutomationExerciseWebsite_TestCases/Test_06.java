package AutomationExerciseWebpage_Exercises;
// Contact Us Form
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Test_06 {
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
    public void clickContactUsButton(){
        //        4. Click on 'Contact Us' button
        driver.findElement(By.xpath("//a[normalize-space()='Contact us']")).click();

    }
    @Test(priority = 3)
    public void verifyGetInTouchText(){
        //        5. Verify 'GET IN TOUCH' is visible
        WebElement text= driver.findElement(By.xpath("//h2[normalize-space()='Get In Touch']"));
        Assert.assertTrue(text.isDisplayed());
    }
    @Test(priority = 4)
    public void fillInformation(){
        //        6. Enter name, email, subject and message
        driver.findElement(By.xpath("//input[@data-qa='name']")).sendKeys("İsmail Aslan");
        driver.findElement(By.xpath("//input[@data-qa='email']")).sendKeys("ismail@gmail.com");
        driver.findElement(By.xpath("//input[@data-qa='subject']")).sendKeys("Login Problem");
        driver.findElement(By.xpath("//textarea[@id='message']")).sendKeys("I have login problem");

    }
    @Test(priority = 5)
    public void uploadFile(){
        //        7. Upload file
       WebElement uploadFileButton=driver.findElement(By.xpath("//input[@name='upload_file']"));
       uploadFileButton.sendKeys("C:\\Users\\Sys\\Desktop\\HW4 ANSYS Application V2.pdf");
    }
    @Test(priority = 6)
    public void clickSubmitButton() throws InterruptedException {
        //        8. Click 'Submit' button
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@data-qa='submit-button']")).click();
    }
    @Test(priority = 7)
    public void clickOkButton(){
        //        9. Click OK button
        Alert alert=driver.switchTo().alert();
        alert.accept();
    }
    @AfterTest
    public void tearDown(){
        driver.close();
    }

}

