package AutomationExerciseWebpage_Exercises;
// Verify All Products and product detail page

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;


public class Test_08 {
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
    public void checkProductsListVisibility(){
        //       6. The products list is visible
        List<WebElement> products=driver.findElements(By.className("col-sm-4"));
        for(int i=0;i< products.size();i++){
            WebElement product=driver.findElements(By.className("col-sm-4")).get(i);
            Assert.assertTrue(product.isDisplayed());
        }
    }
    @Test(priority = 5)
    public void clickViewProductOfFirstProduct(){
        //      7. Click on 'View Product' of first product
        driver.findElement(By.xpath("//div[@class='col-sm-9 padding-right']//div[2]//div[1]//div[2]//ul[1]//li[1]//a[1]")).click();
    }
    @Test(priority = 6)
    public void checkLandProductDetailPage(){
        //      8. User is landed to product detail page
        WebElement productInformation= driver.findElement(By.xpath("//div[@class='product-information']"));
        Assert.assertTrue(productInformation.isDisplayed());
    }
    @Test(priority = 7)
    public void verifyDetailVisibility(){
        //9. Verify that  detail is visible: product name, category, price, availability, condition, brand
        WebElement productName= driver.findElement(By.xpath("//div[@class='product-information']"));
        Assert.assertTrue(productName.isDisplayed());
      List<WebElement> details=driver.findElements(By.xpath("//div[@class='product-information']/p"));
      for(int i=0;i<details.size();i++){
          WebElement detail=driver.findElements(By.xpath("//div[@class='product-information']/p")).get(i);
          Assert.assertTrue(detail.isDisplayed());
      }
    }
    @AfterTest
    public void tearDown(){
        driver.close();
    }

}


