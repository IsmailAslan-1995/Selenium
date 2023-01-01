package Saucedemo_TestExercise.problem_user;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class Test_04 {

    private static WebDriver driver = new ChromeDriver();

    public static void main(String[] args) {
        // Test Case: Checkout Button Control
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        List<WebElement> ProblemUserImageList = ProblemUserImageList();
        List<WebElement> StandardUserImageList = StandardUserImageList();
        Comparison(ProblemUserImageList,StandardUserImageList);

    }
    private static void LoginWebpageWithStandardUser() {
        String userName = "problem_user";
        String password = "secret_sauce";
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(userName);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
    }
    private static void loginWebpageWithProblemUser() {

        String userName = "problem_user";
        String password = "secret_sauce";
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(userName);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
    }
    private static List<WebElement> ProblemUserImageList() {
        loginWebpageWithProblemUser();

        List<WebElement> imagesList = driver.findElements(By.xpath("//div[@class='inventory_item']/div[@class='inventory_item_img']"));
        return imagesList;
    }
    private static List<WebElement> StandardUserImageList() {
        LoginWebpageWithStandardUser();
        List<WebElement> imagesList = driver.findElements(By.xpath("//div[@class='inventory_item']/div[@class='inventory_item_img']"));
        return imagesList;

    }
    private static void Comparison(List<WebElement> problemUserImageList, List<WebElement> standardUserImageList) {
        if(problemUserImageList.size()!=standardUserImageList.size()){
            Assert.assertTrue(false);
        }
        for(int i=0;i<problemUserImageList.size();i++){


        }
    }
}


