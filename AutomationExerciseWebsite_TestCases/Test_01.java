package AutomationExerciseWebpage_Exercises;
// Register User
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;
public class Test_01 {
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
//        5. Verify 'New User Signup!' is visible
        WebElement newUserSignupButton= driver.findElement(By.xpath("//h2[normalize-space()='New User Signup!']"));
        Assert.assertTrue(newUserSignupButton.isDisplayed());
//        6. Enter name and email address
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("İsmail Aslan");
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("ismail@gmail.com");
//        7. Click 'Signup' button
        driver.findElement(By.xpath("//button[normalize-space()='Signup']")).click();
//        8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement enterAccountInformationButton= driver.findElement(By.xpath("//b[normalize-space()='Enter Account Information']"));
        Assert.assertTrue(enterAccountInformationButton.isDisplayed());
//        9. Fill details: Title, Name, Email, Password, Date of birth
        driver.findElement(By.xpath("//input[@id='id_gender1']")).click();
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("12345");
        Select day=new Select(driver.findElement(By.xpath("//select[@id='days']")));
        day.selectByIndex(15);
        Select month=new Select(driver.findElement(By.xpath("//select[@id='months']")));
        month.selectByIndex(8);
        Select year=new Select(driver.findElement(By.xpath("//select[@id='years']")));
        year.selectByIndex(20);

//        10. Select checkbox 'Sign up for our newsletter!'
        driver.findElement(By.xpath("//input[@name='newsletter']")).click();
//        11. Select checkbox 'Receive special offers from our partners!'
        driver.findElement(By.xpath("//input[@name='optin']")).click();

//        12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys("İsmail");
        driver.findElement(By.xpath("//input[@id='last_name']")).sendKeys("Aslan");
        driver.findElement(By.xpath("//input[@id='company']")) .sendKeys("Inar Academy");
        driver.findElement(By.xpath("//input[@id='address1']")).sendKeys("Ayvali distinct");
        Select countryButton=new Select(driver.findElement(By.xpath("//select[@id='country']")));
        countryButton.selectByIndex(2);
        driver.findElement(By.xpath("//input[@id='state']")).sendKeys("Teksas");
        driver.findElement(By.xpath("//input[@id='city']")) .sendKeys("Dallas");
        driver.findElement(By.xpath("//input[@id='zipcode']")).sendKeys("0ER100");
        driver.findElement(By.xpath("//input[@id='mobile_number']")) .sendKeys("04428535225");

 //       13. Click 'Create Account button'
        driver.findElement(By.xpath("//button[@data-qa='create-account']")).click();
//        14. Verify that 'ACCOUNT CREATED!' is visible
        String expected="ACCOUNT CREATED!";
        String actual=driver.findElement(By.xpath("//h2[@data-qa='account-created']")).getText();
        Assert.assertEquals(expected,actual);
//        15. Click 'Continue' button
        driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();
//        16. Verify that 'Logged in as username' is visible
        WebElement loggedinText=driver.findElement(By.xpath("//li[10]//a[1]"));
        Assert.assertTrue(loggedinText.isDisplayed());
//        17. Click 'Delete Account' button
        driver.findElement(By.xpath("//a[normalize-space()='Delete Account']")).click();
//        18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        WebElement accountDeleted=driver.findElement(By.xpath("//b[normalize-space()='Account Deleted!']"));
        driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();
        driver.close();

    }
}

