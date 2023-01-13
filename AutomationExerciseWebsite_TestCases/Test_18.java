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
import java.util.List;

public class Test_18 {
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
    public void verifyCategories(){
        //        3. Verify that categories are visible on left side bar
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,400)");
        List<WebElement> categories=driver.findElements(By.xpath("//h4[@class='panel-title']"));
        for (int i=0;i<categories.size();i++){
            WebElement category=driver.findElements(By.xpath("//h4[@class='panel-title']")).get(i);
            Assert.assertTrue(category.isDisplayed());
        }
    }
    @Test(priority = 2)
    public void clickWomenCategory(){
        //        4. Click on 'Women' category
        WebElement womenCategory=driver.findElement(By.xpath("//a[normalize-space()='Women']"));
        womenCategory.click();
    }
    @Test(priority = 3)
    public void clickOnAnyCategoryLinkUnderWomenCategory(){
        //        5. Click on any category link under 'Women' category, for example: Dress
        WebElement dressButton= driver.findElement(By.xpath("//div[@id='Women']//a[contains(text(),'Dress')]"));
        dressButton.click();


    }
    @Test(priority = 4)
    public void verifyWomenCategoryPage(){
        //        6. Verify that category page is displayed and confirm text 'WOMEN - TOPS PRODUCTS'
        WebElement text= driver.findElement(By.xpath("//a[normalize-space()='Tops']"));
        Assert.assertTrue(text.isDisplayed());
    }
    @Test(priority = 5)
    public void clickAnySubcategoryLinkOfMenCategory() throws InterruptedException {
        //        7. On left side bar, click on any sub-category link of 'Men' category

        Thread.sleep(2000);
       WebElement menCategory= driver.findElement(By.xpath("//a[normalize-space()='Men']"));
       menCategory.click();
        Thread.sleep(2000);
       WebElement subCategory=driver.findElement(By.xpath("//div[@id='Men']//li[1]"));
       subCategory.click();
    }
    @Test(priority = 6)
    public void verifyMenCategoryPage(){
        //        8. Verify that user is navigated to that category page
        WebElement text= driver.findElement(By.xpath("//h2[@class='title text-center']"));
        Assert.assertTrue(text.isDisplayed());

    }
    @AfterTest
    public void tearDown(){
        driver.close();
    }

}


