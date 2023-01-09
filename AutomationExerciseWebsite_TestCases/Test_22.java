package AutomationExerciseWebpage_Exercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Test_22 {
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
    public void scrollBottomOfWebPage(){
        //        3. Scroll to bottom of page
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }
    @Test(priority = 2)
    public void verifyRecommendedItemsAreVisible(){
        //        4. Verify 'RECOMMENDED ITEMS' are visible
        WebElement element= driver.findElement(By.xpath("//h2[normalize-space()='recommended items']"));
        Assert.assertTrue(element.isDisplayed());
    }
    @Test(priority = 3)
    public void clickOnAddToCartOnRecommendedProduct(){
        //        5. Click on 'Add To Cart' on Recommended product
        driver.findElement(By.xpath("//div[@class='item active']//div[1]//div[1]//div[1]//div[1]//a[1]")).click();
    }
    @Test(priority = 4)
    public void clickOnViewCartButton(){
        //        6. Click on 'View Cart' button
        WebElement cartButton= driver.findElement(By.xpath("//u[normalize-space()='View Cart']"));
        cartButton.click();

    }
    @Test(priority = 5)
    public void  verifyProductInCartPage(){
        //        7. Verify that product is displayed in cart page
        WebElement product= driver.findElement(By.xpath("//img[@alt='Product Image']"));
        Assert.assertTrue(product.isDisplayed());
    }
    @AfterTest
    public void tearDown(){
        driver.close();
    }
}

