package Saucedemo_TestExercise.standard_user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class TestCase_4 {
    public static void main(String[] args) {
        /**
         * Test -Product sort button-
         */

        WebDriver driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ASUS\\Desktop\\chromedriver.exe");

        driver.get("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        userLogin(driver);


        WebElement sortContainer = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
        Select dropdown = new Select(sortContainer);
        dropdown.selectByIndex(1);

        Assert.assertEquals(driver.findElement(By.xpath("//div[normalize-space()='Test.allTheThings() T-Shirt (Red)']")).getText(),
                "Test.allTheThings() T-Shirt (Red)");
        checkSort(driver);


        WebElement sortContainer2 = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
        Select dropdown2 = new Select(sortContainer2);
        dropdown2.selectByIndex(2);

        String price = driver.findElement(By.xpath("//div[@class='inventory_list']//div[1]//div[2]//div[2]//div[1]")).getText();
        Assert.assertEquals(price, "$7.99");
        driver.close();

    }

    public static void userLogin(WebDriver driver) {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("#login-button")).click();
    }

    private static void checkSort(WebDriver driver) {
        List<WebElement> productsName = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        for(int i=0;i< productsName.size()-1;i++){
            String s1 = driver.findElements(By.xpath("//div[@class='inventory_item_name']")).get(i).getText();
            String s2 = driver.findElements(By.xpath("//div[@class='inventory_item_name']")).get(i+1).getText();
            int sort=s1.compareTo(s2);
            if(sort>=0) {
                Assert.assertTrue(true);
            }else{
                Assert.assertTrue(false);
            }
        }
    }
}

