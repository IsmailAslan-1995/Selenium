package AutomationExerciseWebpage_Exercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Test_16 {
    WebDriver driver = new ChromeDriver();
    int productNumber = 3;

    @BeforeTest()
    public void launchBrowserAndNavigateWebsite() {
        //        1. Launch browser
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //        2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
    }

    @Test(priority = 1)
    public void verifyHomepage() {
        //        3. Verify that home page is visible successfully
        WebElement logo = driver.findElement(By.xpath("//img[@alt='Website for automation practice']"));
        Assert.assertTrue(logo.isDisplayed());
    }

    @Test(priority = 2)
    public void clickSignupLoginButton() {
        //        4. Click 'Signup / Login' button
        driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']")).click();
    }

    @Test(priority = 3)
    public void fillDetailsAndCreateAccount() {
        //        5. Fill all details in Signup and create account
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("İsmail Aslan");
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("ismail2@gmail.com");
        driver.findElement(By.xpath("//button[normalize-space()='Signup']")).click();
        driver.findElement(By.xpath("//input[@id='id_gender1']")).click();
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("12345");
        Select day = new Select(driver.findElement(By.xpath("//select[@id='days']")));
        day.selectByIndex(15);
        Select month = new Select(driver.findElement(By.xpath("//select[@id='months']")));
        month.selectByIndex(8);
        Select year = new Select(driver.findElement(By.xpath("//select[@id='years']")));
        year.selectByIndex(20);
        // driver.findElement(By.xpath("//input[@name='newsletter']")).click();
        // driver.findElement(By.xpath("//input[@name='optin']")).click();
        driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys("İsmail");
        driver.findElement(By.xpath("//input[@id='last_name']")).sendKeys("Aslan");
        driver.findElement(By.xpath("//input[@id='company']")).sendKeys("Inar Academy");
        driver.findElement(By.xpath("//input[@id='address1']")).sendKeys("Ayvali distinct");
        Select countryButton = new Select(driver.findElement(By.xpath("//select[@id='country']")));
        countryButton.selectByIndex(2);
        driver.findElement(By.xpath("//input[@id='state']")).sendKeys("Teksas");
        driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Dallas");
        driver.findElement(By.xpath("//input[@id='zipcode']")).sendKeys("0ER100");
        driver.findElement(By.xpath("//input[@id='mobile_number']")).sendKeys("04428535225");
        driver.findElement(By.xpath("//button[@data-qa='create-account']")).click();
    }

    @Test(priority = 4)
    public void verifyLoggedInAsUsername() {
        //          6. Verify 'Logged in as username' at top
        WebElement loggedinText = driver.findElement(By.xpath("//li[10]//a[1]"));
        Assert.assertTrue(loggedinText.isDisplayed());
    }

    @Test(priority = 5)
    public void addProductsToCart() {
        //        7. Add products to cart
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,800)");
        for (int i = 0; i < productNumber; i++) {
            driver.findElement(By.xpath("(//a[@class='btn btn-default add-to-cart'])[" + (2 * i + 1) + "]")).click();
            driver.findElement(By.xpath("//button[normalize-space()='Continue Shopping']")).click();
        }

    }


    @Test(priority = 6)
    public void clickCartButton() {
//        8.Click 'Cart' button
        driver.findElement(By.xpath("//li/a[@href='/view_cart']")).click();
    }

    @Test(priority = 7)
    public void verifyCartPageIsVisible() {
        //        9. Verify that cart page is displayed
        WebElement shoppingCart = driver.findElement(By.xpath("//li[@class='active']"));
        Assert.assertTrue(shoppingCart.isDisplayed());

    }


    @Test(priority = 8)
    public void clickProceedToCheckOut() {
//        10. Click 'Proceed To Checkout' button
        driver.findElement(By.xpath("//a[normalize-space()='Proceed To Checkout']")).click();

    }

    @Test(priority = 9)
    public void verifyAddressDetailsAndReviewYourOrder() {
        //  11. Verify Address Details and Review Your Order

        String expected = "YOUR DELIVERY ADDRESS\n" +
                "Mr. İsmail Aslan\n" +
                "Inar Academy\n" +
                "Ayvali distinct\n" +
                "Dallas Teksas 0ER100\n" +
                "Canada\n" +
                "04428535225";
        String actual = driver.findElement(By.xpath("//ul[@id='address_delivery']")).getText();
        Assert.assertEquals(actual, expected);
        List<WebElement> products = driver.findElements(By.xpath("//td[@class='cart_product']"));
        Assert.assertEquals(products.size(), productNumber);
    }

    @Test(priority = 10)
    public void enterDescriptionAndClickPlaceOrder() {
        //        12. Enter description in comment text area and click 'Place Order'
        WebElement textArea = driver.findElement(By.xpath("//textarea[@name='message']"));
        textArea.sendKeys("dfgkhjhyteyutıkyljthr");
        driver.findElement(By.xpath("//a[normalize-space()='Place Order']")).click();
    }

    @Test(priority = 11)
    public void EnterPaymentDetails() {
        //        13. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        driver.findElement(By.xpath("//input[@name='name_on_card']")).sendKeys("İsmail ASLAN");
        driver.findElement(By.xpath("//input[@name='card_number']")).sendKeys("159763294916");
        driver.findElement(By.xpath("//input[@placeholder='ex. 311']")).sendKeys("215");
        driver.findElement(By.xpath("//input[@placeholder='MM']")).sendKeys("11");
        driver.findElement(By.xpath("//input[@placeholder='YYYY']")).sendKeys("2024");

    }

    @Test(priority = 12)
    public void clickPayAndConfirmButton() {
        //        14. Click 'Pay and Confirm Order' button
        driver.findElement(By.xpath("//button[@id='submit']")).click();
    }

    @Test(priority = 13)
    public void verifySuccessMessage() {
        //        15. Verify success message 'Your order has been placed successfully!'
        WebElement message = driver.findElement(By.xpath("//b[normalize-space()='Order Placed!']"));
        Assert.assertTrue(message.isDisplayed());

    }

    @Test(priority = 14)
    public void clickDeleteAccount() {
        //        16. Click 'Delete Account' button
        driver.findElement(By.xpath("//a[normalize-space()='Delete Account']")).click();
    }

    @Test(priority = 15)
    public void verifyAccountDeletedAndClickContinueButton() {
        //        17. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        WebElement element = driver.findElement(By.xpath("//b[normalize-space()='Account Deleted!']"));
        Assert.assertTrue(element.isDisplayed());
        driver.findElement(By.xpath("//a[normalize-space()='Continue']")).click();
    }

    @AfterTest
    public void teardown() {
        driver.close();
    }

}


