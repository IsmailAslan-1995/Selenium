package AutomationExerciseWebpage_Exercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Test_17 {
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
    public void addProductsToCart(){
        //        4. Add products to cart
        List<WebElement> products=driver.findElements(By.xpath("//div[@class='product-overlay']"));

        for(int i=0; i< products.size();i++){
            Actions actions=new Actions(driver);
            actions.moveToElement(driver.findElement(By.xpath("//div[@class='product-overlay']")));
            actions.click(driver.findElements(By.xpath("//a[@class='btn btn-default add-to-cart']")).get(i));
        }
    }
    @Test(priority = 3)
    public void clickToCart(){
        //        5. Click 'Cart' button
        driver.findElement(By.xpath("//li/a[@href='/view_cart']")).click();
    }
    @Test(priority = 4)
    public void VerifyCartPage(){
        //        6. Verify that cart page is displayed
        WebElement shoppingCart=driver.findElement(By.xpath("//li[@class='active']"));
        Assert.assertTrue(shoppingCart.isDisplayed());

    }
    @Test(priority = 5)
    public List<WebElement> clickXButton(){
        //        7. Click 'X' button corresponding to particular product
        List<WebElement> removeButton=driver.findElements(By.xpath("//i[@class='fa fa-times']"));
        for (int i=0;i<5;i++){
            List<WebElement>removedElement=driver.findElements(By.xpath("//td[@class='cart_description']"));
            removeButton.get(i).click();
        }
    return removeButton;
    }
    @Test(priority = 6)
    public void verifyRemovedProducts(){
        //        8. Verify that product is removed from the cart

        List<WebElement> products=driver.findElements(By.xpath("//td[@class='cart_description']"));
        for (int i=0;i< products.size();i++){
            if(clickXButton().contains(driver.findElements(By.xpath("//td[@class='cart_description']")).get(i))){
                Assert.assertTrue(false);
            }
        }

    }
    @AfterTest
    public void tearDown(){
        driver.close();
    }

}



