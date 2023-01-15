package AutomationExerciseWebpage_Exercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Test_14 {
    WebDriver driver=new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
    int productNumber=3;

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
    public void productsToCart(){
        //        4. Add products to cart
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,800)");
        List<WebElement> products=driver.findElements(By.xpath("//div[@class='features_items']//div[@class='col-sm-4']"));
        System.out.println(products.size() );
        for(int i=0;i<productNumber;i++){
           driver.findElement(By.xpath("(//a[@class='btn btn-default add-to-cart'])["+(2*i+1)+"]")).click();
           driver.findElement(By.xpath("//button[normalize-space()='Continue Shopping']")).click();
        }

    }
    @Test(priority = 3)
    public void clickCartButton(){
        //        5. Click 'Cart' button
        driver.findElement(By.xpath("//li/a[@href='/view_cart']")).click();
    }
    @Test(priority = 4)
    public void verifyCartPageIsVisible(){
        //        6. Verify that cart page is displayed
        WebElement shoppingCart= driver.findElement(By.xpath("//li[@class='active']"));
        Assert.assertTrue(shoppingCart.isDisplayed());

    }
    @Test(priority = 5)
    public void clickProceedToCheckOut(){
        //        7. Click Proceed To Checkout

        driver.findElement(By.xpath("//a[normalize-space()='Proceed To Checkout']")).click();
    }
    @Test(priority = 6)
    public void clickRegisterLoginButton(){
        //        8. Click 'Register / Login' button
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//u[normalize-space()='Register / Login']")));

        driver.findElement(By.xpath("//u[normalize-space()='Register / Login']")).click();

    }
    @Test(priority = 7)
    public void findAllDetailsInSıgnUpAndCreateAccount(){
        //        9. Fill all details in Signup and create account
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("İsmail Aslan");
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("ismail204@gmail.com");
        driver.findElement(By.xpath("//button[normalize-space()='Signup']")).click();
        driver.findElement(By.xpath("//input[@id='id_gender1']")).click();
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("12345");
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,800)");
        Select day=new Select(driver.findElement(By.xpath("//select[@id='days']")));
        day.selectByIndex(15);
        Select month=new Select(driver.findElement(By.xpath("//select[@id='months']")));
        month.selectByIndex(8);
        Select year=new Select(driver.findElement(By.xpath("//select[@id='years']")));
        year.selectByIndex(20);
        // driver.findElement(By.xpath("//input[@name='newsletter']")).click();
        // driver.findElement(By.xpath("//input[@name='optin']")).click();
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
    @Test(priority = 8)
    public void verifyAccountCreatedAndClickContinueButton() {
//        10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        String expected = "ACCOUNT CREATED!";
        String actual = driver.findElement(By.xpath("//h2[@data-qa='account-created']")).getText();
        Assert.assertEquals(expected, actual);
        driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();
    }
    @Test(priority = 9)
    public void verifyLoggedInAsUsername(){
//        11. Verify ' Logged in as username' at top
        WebElement loggedinText=driver.findElement(By.xpath("//li[10]//a[1]"));
        Assert.assertTrue(loggedinText.isDisplayed());
    }
    @Test(priority = 10)
    public void clickCartButtonAgain(){
//        12.Click 'Cart' button
        driver.findElement(By.xpath("//li/a[@href='/view_cart']")).click();
    }
    @Test(priority = 11)
    public void clickProceedToCheckOutAgain(){
//        13. Click 'Proceed To Checkout' button
        driver.findElement(By.xpath("//a[normalize-space()='Proceed To Checkout']")).click();

    }
    @Test(priority = 12)
    public void verifyAddressDetailsAndReviewYourOrder(){
        //        14. Verify Address Details and Review Your Order

        String expected="YOUR DELIVERY ADDRESS\n" +
                "Mr. İsmail Aslan\n" +
                "Inar Academy\n" +
                "Ayvali distinct\n" +
                "Dallas Teksas 0ER100\n" +
                "Canada\n" +
                "04428535225";
        String actual=driver.findElement(By.xpath("//ul[@id='address_delivery']")).getText();
        Assert.assertEquals(actual,expected);
        List<WebElement> products=driver.findElements(By.xpath("//td[@class='cart_product']"));
        Assert.assertEquals(products.size(),productNumber);
    }
    @Test(priority = 13)
    public void enterDescriptionAndClickPlaceOrder(){
        //        15. Enter description in comment text area and click 'Place Order'
        WebElement textArea= driver.findElement(By.xpath("//textarea[@name='message']"));
        textArea.sendKeys("dfgkhjhyteyutıkyljthr");
        driver.findElement(By.xpath("//a[normalize-space()='Place Order']")).click();
    }
    @Test(priority = 14)
    public void EnterPaymentDetails(){
        //        16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        driver.findElement(By.xpath("//input[@name='name_on_card']")).sendKeys("İsmail ASLAN");
        driver.findElement(By.xpath("//input[@name='card_number']")).sendKeys("159763294916");
        driver.findElement(By.xpath("//input[@placeholder='ex. 311']")).sendKeys("215");
        driver.findElement(By.xpath("//input[@placeholder='MM']")).sendKeys("11");
        driver.findElement(By.xpath("//input[@placeholder='YYYY']")).sendKeys("2024");

    }
    @Test(priority = 15)
    public void clickPayAndConfirmButton(){
        //        17. Click 'Pay and Confirm Order' button
        driver.findElement(By.xpath("//button[@id='submit']")).click();
    }
    @Test(priority = 16)
    public void verifySuccessMessage(){
        //        18. Verify success message 'Your order has been placed successfully!'
      //  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Your order has been placed successfully!')]")));
        WebElement message= driver.findElement(By.xpath("//b[normalize-space()='Order Placed!']"));
        Assert.assertTrue(message.isDisplayed());

    }
    @Test(priority = 17)
    public void clickDeleteAccount(){
        //        19. Click 'Delete Account' button
        driver.findElement(By.xpath("//a[normalize-space()='Delete Account']")).click();
    }
    @Test(priority = 17)
    public void verifyAccountDeletedAndClickContinueButton(){
        //        20. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        WebElement element= driver.findElement(By.xpath("//b[normalize-space()='Account Deleted!']"));
        Assert.assertTrue(element.isDisplayed());
        driver.findElement(By.xpath("//a[normalize-space()='Continue']")).click();
    }

    @AfterTest
    public void teardown(){
        driver.close();
    }
}



