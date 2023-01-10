package AutomationExerciseWebpage_Exercises;
// Search Product

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

public class Test_09 {
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
    public void clickProductsButton(){
        //       4. Click on 'Products' button
        driver.findElement(By.xpath("//a[@href='/products']")).click();

    }
    @Test(priority = 3)
    public void verifyNavigateToAllProductsPage(){
        //       5. Verify user is navigated to ALL PRODUCTS page successfully
        WebElement image= driver.findElement(By.xpath("//img[@id='sale_image']"));
        Assert.assertTrue(image.isDisplayed());
    }
    @Test(priority = 4)
    public void searchProductAndClickSearchButton(){

        //    6. Enter product name in search input and click search button
        WebElement searchButton= driver.findElement(By.xpath("//input[@id='search_product']"));
        searchButton.click();
        searchButton.sendKeys("Stylish Dress");
        driver.findElement(By.xpath("//button[@id='submit_search']")).click();
    }
    @Test(priority = 5)
    public void verifySearchedProductTextVisibility(){
        //    7. Verify 'SEARCHED PRODUCTS' is visible
        WebElement text= driver.findElement(By.xpath("//h2[@class='title text-center']"));
        Assert.assertTrue(text.isDisplayed());
    }
    @Test(priority = 6)
    public void verifyAllProductsRelatedToSearchIsVisible(){
        //    8. Verify all the products related to search are visible
        List<WebElement>products=driver.findElements(By.xpath("//div[@class='productinfo text-center']//p"));

        for(int i=0;i< products.size();i++){
            String productName=driver.findElements(By.xpath("//div[@class='productinfo text-center']//p")).get(i).getText();
            driver.findElement(By.xpath("//input[@id='search_product']"));
            Actions actions=new Actions(driver);
            actions.click()
                    .sendKeys(Keys.DELETE)
                    .sendKeys(productName);
            driver.findElement(By.xpath("//button[@id='submit_search']")).click();
            WebElement text= driver.findElement(By.xpath("//h2[@class='title text-center']"));
            Assert.assertTrue(text.isDisplayed());
        }

    }
    @AfterTest
    public void tearDown(){
        driver.close();
    }
}

