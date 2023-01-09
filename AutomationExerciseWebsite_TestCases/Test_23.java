package AutomationExerciseWebpage_Exercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Test_23 {

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
    public void clickSignUpButton() {
        //       4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']")).click();
    }  @Test(priority = 3)
public void fillDetailsAndCreateAccount(){
//        5. Fill all details in Signup and create account
    driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("İsmail Aslan");
    driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("ismail60@gmail.com");
    driver.findElement(By.xpath("//button[normalize-space()='Signup']")).click();
    driver.findElement(By.xpath("//input[@id='id_gender1']")).click();
    driver.findElement(By.xpath("//input[@id='password']")).sendKeys("12345");
    Select day=new Select(driver.findElement(By.xpath("//select[@id='days']")));
    day.selectByIndex(15);
    Select month=new Select(driver.findElement(By.xpath("//select[@id='months']")));
    month.selectByIndex(8);
    Select year=new Select(driver.findElement(By.xpath("//select[@id='years']")));
    year.selectByIndex(20);
      JavascriptExecutor js=(JavascriptExecutor)driver;
      js.executeScript("window.scrollBy(0,300)");
    driver.findElement(By.xpath("//input[@name='newsletter']")).click();
    driver.findElement(By.xpath("//input[@name='optin']")).click();
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
    driver.findElement(By.xpath("//button[normalize-space()='Create Account']")).click();
}
    @Test(priority = 4)
    public void verifyAccountCreatedAndClickContinueButton(){
        //        6. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        WebElement element= driver.findElement(By.xpath("//b[normalize-space()='Account Created!']"));
       Assert.assertTrue(element.isDisplayed());
       driver.findElement(By.xpath("//a[normalize-space()='Continue']")).click();
    }
    @Test(priority = 5)
    public void verifyLoggedInAsUsername(){
        //        7. Verify ' Logged in as username' at top
        WebElement loggedinText=driver.findElement(By.xpath("//li[10]//a[1]"));
        Assert.assertTrue(loggedinText.isDisplayed());
    }
    @Test(priority = 6)
    public void addProducts(){
        //        8. Add products to cart
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,400)");

        List<WebElement> products = driver.findElements(By.xpath("//div[@class='product-overlay']"));
            products.get(0).findElement(By.xpath("(//div//a[@class='btn btn-default add-to-cart'])[1]")).click();
            driver.findElement(By.xpath("//button[normalize-space()='Continue Shopping']")).click();
            products.get(1).findElement(By.xpath("(//div//a[@class='btn btn-default add-to-cart'])[3]")).click();
            driver.findElement(By.xpath("//button[normalize-space()='Continue Shopping']")).click();

    }
    @Test(priority = 7)
    public void clickCartButton(){
        //        9. Click 'Cart' button
        driver.findElement(By.xpath("//li/a[@href='/view_cart']")).click();

    }
    @Test(priority = 8)
    public void verifyCartPage(){
        //        10. Verify that cart page is displayed
        WebElement text=driver.findElement(By.xpath("//li[@class='active']"));
        Assert.assertTrue(text.isDisplayed());
    }
    @Test(priority = 9)
    public void  clickProceedToCheckout(){
        //        11. Click Proceed To Checkout
        driver.findElement(By.xpath("//a[normalize-space()='Proceed To Checkout']")).click();
    }
    @Test(priority = 10)
    public void verifyDeliveryAddress(){
        //        12. Verify that the delivery address is same address filled at the time registration of account
        String actual="YOUR DELIVERY ADDRESS\n" +
                "Mr. İsmail Aslan\n" +
                "Inar Academy\n" +
                "Ayvali distinct\n" +
                "Dallas Teksas 0ER100\n" +
                "Canada\n" +
                "04428535225";
        String expected=driver.findElement(By.xpath("//ul[@id='address_delivery']")).getText();
        Assert.assertEquals(actual,expected);
    }
     @AfterTest
    public void tearDown(){
        driver.close();
    }


