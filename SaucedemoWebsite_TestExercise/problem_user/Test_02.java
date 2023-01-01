package Saucedemo_TestExercise.problem_user;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class Test_02 {
    private static WebDriver driver=new ChromeDriver();

    public static void main(String[] args) {
        //Test Case: Check Sort Bar
        WebDriverManager.chromedriver().setup();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        LoginWebpage();
        clickSortButton();
        checkSort();
        driver.close();
    }
    private static void LoginWebpage() {
        String userName="problem_user";
        String password="secret_sauce";
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(userName);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
    }
    private static void clickSortButton() {
        WebElement sortButton=driver.findElement(By.xpath("//select[@class='product_sort_container']"));
        Select button=new Select(sortButton);
        button.selectByIndex(1);
    }
    private static void checkSort() {
        List<WebElement> productsName=driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        for(int i=0;i< productsName.size()-1;i++){
            String s1=driver.findElements(By.xpath("//div[@class='inventory_item_name']")).get(i).getText();
            String s2=driver.findElements(By.xpath("//div[@class='inventory_item_name']")).get(i+1).getText();
            int sort=s1.compareTo(s2);
            if(sort>=0) {
                Assert.assertTrue(true);
            }else{
                Assert.assertTrue(false);
            }
        }
    }
}

