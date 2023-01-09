package AutomationExerciseWebpage_Exercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;


public class Test_24 {
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
//        4. Add products to cart
        public void addToCard() throws InterruptedException {
        Thread.sleep(2000);
        JavascriptExecutor js=(JavascriptExecutor)driver;
       js.executeScript("window.scrollBy(0,500)");

        driver.findElement((By.xpath("(//a[contains(text(),'Add to cart')])[1]"))).click();
        driver.findElement(By.xpath("//button[normalize-space()='Continue Shopping']")).click();
        driver.findElement(By.xpath("(//a[contains(text(),'Add to cart')])[3]")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Continue Shopping']")).click();
    }
    @Test(priority = 3)
    public void clickCartButton(){
//        5. Click 'Cart' button
        driver.findElement(By.xpath("//li/a[@href='/view_cart']")).click();

    }
    @Test(priority = 4)
    public void verifyCartPage(){
//        6. Verify that cart page is displayed
        WebElement text=driver.findElement(By.xpath("//li[@class='active']"));
        Assert.assertTrue(text.isDisplayed());
    }
    @Test(priority = 5)
    public void  clickProceedToCheckout(){
//        7. Click Proceed To Checkout
        driver.findElement(By.xpath("//a[normalize-space()='Proceed To Checkout']")).click();

    }
    @Test(priority = 6)
    public void clickRegisterLoginButton(){
        //        8. Click 'Register / Login' button
        driver.findElement(By.xpath("//u[normalize-space()='Register / Login']")).click();

    }
    @Test(priority = 7)
    public void CreateAccount(){
        //        9. Fill all details in Signup and create account
        driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']"));
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
        js.executeScript("window.scrollBy(0,500)");

        driver.findElement(By.xpath("//input[@name='newsletter']")).click();
        driver.findElement(By.xpath("//input[@name='optin']")).click();
        driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys("İsmail");
        driver.findElement(By.xpath("//input[@id='last_name']")).sendKeys("Aslan");
        driver.findElement(By.xpath("//input[@id='company']")) .sendKeys("Inar Academy");
        driver.findElement(By.xpath("//input[@id='address1']")).sendKeys("Ayvali distinct");
        Select countryButton=new Select(driver.findElement(By.xpath("//select[@id='country']")));
        countryButton.selectByIndex(2);

        js.executeScript("window.scrollBy(500,1100)");

        driver.findElement(By.xpath("//input[@id='state']")).sendKeys("Teksas");
        driver.findElement(By.xpath("//input[@id='city']")) .sendKeys("Dallas");
        driver.findElement(By.xpath("//input[@id='zipcode']")).sendKeys("0ER100");
        driver.findElement(By.xpath("//input[@id='mobile_number']")) .sendKeys("04428535225");
        driver.findElement(By.xpath("//button[@data-qa='create-account']")).click();
    }
    @Test(priority = 8)
    public void verifyAccountCreatedAndClickContinue(){
        //        10. Verify 'ACCOUNT CREATED!' and click 'Continue' button

        WebElement element= driver.findElement(By.xpath("//b[normalize-space()='Account Created!']"));
       Assert.assertTrue(element.isDisplayed());
       driver.findElement(By.xpath("//a[normalize-space()='Continue']")).click();
    }
    @Test(priority = 9)
    public void verifyLogin(){
        //        11. Verify ' Logged in as username' at top
        String actual="Logged in as İsmail Aslan";
        String expected=driver.findElement(By.xpath("//a[text()=' Logged in as ' ]")).getText();
        Assert.assertEquals(expected,actual);
    }
    @Test(priority = 10)
    public void clickCartButtonAgain(){
        driver.findElement(By.xpath("//li/a[@href='/view_cart']")).click();
    }
    @Test(priority = 11)
    public void  clickProceedToCheckoutAgain(){
//        13. Click 'Proceed To Checkout' button
        driver.findElement(By.xpath("//a[normalize-space()='Proceed To Checkout']")).click();

    }
    @Test(priority = 12)
    public void verifyAddressDetailAndReviewYourOrder(){
        //        14. Verify Address Details and Review Your Order
        WebElement addressDetails= driver.findElement(By.xpath("//h2[normalize-space()='Address Details']"));
        Assert.assertTrue(addressDetails.isDisplayed());
        WebElement order=driver.findElement(By.xpath("//h2[normalize-space()='Review Your Order']"));
        Assert.assertTrue(order.isDisplayed());
    }
    @Test(priority = 13)
    public void enterDescriptionAndClickOrder(){
        //        15. Enter description in comment text area and click 'Place Order'
       WebElement messageArea= driver.findElement(By.xpath("//textarea[@name='message']"));
       messageArea.sendKeys("Hi!!!");
       driver.findElement(By.xpath("//a[normalize-space()='Place Order']")).click();
    }
    @Test(priority = 14)
    public void  enterPaymentDetailsAndPayButton(){
        //        16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        //        17. Click 'Pay and Confirm Order' button
        driver.findElement(By.xpath("//input[@name='name_on_card']")).sendKeys("İsmail ASLAN");
        driver.findElement(By.xpath("//input[@name='card_number']")).sendKeys("123654");
        driver.findElement(By.xpath("//input[@placeholder='ex. 311']")).sendKeys("123");
        driver.findElement(By.xpath("//input[@placeholder='MM']")).sendKeys("12");
        driver.findElement(By.xpath("//input[@placeholder='YYYY']")).sendKeys("2012");
        driver.findElement(By.xpath("//button[@id='submit']")).click();

    }
    @Test(priority = 15)
    public void verifySuccessMessage(){
        //        18. Verify success message 'Your order has been placed successfully!'
        WebDriverWait w =new WebDriverWait(driver,Duration.ofSeconds(10));
        w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Your order has been placed successfully!')]")));
        WebElement message= driver.findElement(By.xpath("(//div[@class='alert-success alert'])[1]"));
        Assert.assertTrue(message.isDisplayed());
    }
    @Test(priority = 16)
    public void clickDownloadInvoiceButtonAndVerifyInvoiceIsDownloadedSuccessfully() throws InterruptedException {
        //        19. Click 'Download Invoice' button and verify invoice is downloaded successfully.
        driver.findElement(By.xpath("//a[normalize-space()='Download Invoice']")).click();
        Thread.sleep(10000);
        File file=new File("C:\\Users\\Sys\\Downloads\\invoice.txt");
        Assert.assertTrue(file.exists());
    }
    @Test(priority = 17)
    public void clickContinueButton(){
        //        20. Click 'Continue' button
        driver.findElement(By.xpath("//a[normalize-space()='Continue']")).click();
    }
    @Test(priority = 18)
    public void clickDeleteAccountButton(){
        //        21. Click 'Delete Account' button

        driver.findElement(By.xpath("//a[normalize-space()='Delete Account']")).click();
    }
    @Test(priority = 19)
    public void verifyAccountDeletedAndClickContinueButton(){
        //        22. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        WebElement text= driver.findElement(By.xpath("//b[normalize-space()='Account Deleted!']"));
        Assert.assertTrue(text.isDisplayed());
        driver.findElement(By.xpath("//a[normalize-space()='Continue']")).click();

    }
    @AfterTest
    public void tearDown(){
        driver.close();
    }

}


