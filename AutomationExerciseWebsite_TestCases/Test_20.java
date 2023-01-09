package AutomationExerciseWebpage_Exercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class Test_20 {
    WebDriver driver=new ChromeDriver();
    String productName="t-shirt";
    int searchedProductNumber=3;
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
    public void clickProductsButton(){
        //        3. Click on 'Products' button
        driver.findElement(By.xpath("//a[@href='/products']")).click();

    }
    @Test(priority = 2)
    public void verifyAllProductsPage(){
        //        4. Verify user is navigated to ALL PRODUCTS page successfully
        WebElement title= driver.findElement(By.xpath("(//h2[normalize-space()='All Products'])[1]"));
        Assert.assertTrue(title.isDisplayed());

    }
    @Test(priority = 3)
    public void searchProduct(){
        //        5. Enter product name in search input and click search button
        WebElement searchButton= driver.findElement(By.xpath("//input[@id='search_product']"));
        searchButton.click();
        searchButton.sendKeys(productName);
        driver.findElement(By.xpath("//button[@id='submit_search']")).click();
    }
    @Test(priority = 4)
    public void verifySearchedProducts(){
        //        6. Verify 'SEARCHED PRODUCTS' is visible

        WebElement searchedProducts= driver.findElement(By.xpath("(//h2[normalize-space()='Searched Products'])[1]"));
        Assert.assertTrue(searchedProducts.isDisplayed());
    }
    @Test(priority = 5)

    public void verifyAllSearchedProductsAreVisible() throws InterruptedException {
        //        7. Verify all the products related to search are visible
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,500)");
        List<WebElement> products=driver.findElements(By.xpath("//div[@class='product-overlay']"));
        Assert.assertEquals(searchedProductNumber,products.size());
    }

    @Test(priority = 6)
    public void addToCart() throws InterruptedException {
        //        8. Add those products to cart
        List<WebElement> products=driver.findElements(By.xpath("//div[@class='product-overlay']"));
        for(int i=0; i< products.size();i++){
            products.get(i).findElement(By.xpath("//a[@class='btn btn-default add-to-cart']")).click();
            driver.findElement(By.xpath("//button[normalize-space()='Continue Shopping']")).click();


        }

    }
    @Test(priority = 7)

    public void clickCartButtonAndVerifyProductsVisibility(){
        //        9. Click 'Cart' button and verify that products are visible in cart
        driver.findElement(By.xpath("//li/a[@href='/view_cart']")).click();
        List<WebElement>products=driver.findElements(By.xpath("//td[@class='cart_product']"));
        Assert.assertEquals(products.size(),searchedProductNumber);

    }
    @Test(priority = 8)
    public void clickSigUpButton(){
        //        10. Click 'Signup / Login' button and submit login details
        driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']")).click();
        driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.DELETE)
                .sendKeys("ismail@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.DELETE)
                .sendKeys("12345")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER);
    }
    @Test(priority = 9)
    public void againGoToCartPage(){
        //        11. Again, go to Cart page

        driver.findElement(By.xpath("//li/a[@href='/view_cart']")).click();
    }
    @Test(priority = 10)
    public void verifyProductsVisibility(){
        //        12. Verify that those products are visible in cart after login as well
        List<WebElement>products=driver.findElements(By.xpath("//td[@class='cart_product']"));
        Assert.assertEquals(products.size(),searchedProductNumber);

    }

    @AfterTest
    public void tearDown(){
        driver.close();
    }

}

