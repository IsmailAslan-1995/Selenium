import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DropDownDynamic {
    static WebDriver driver = new ChromeDriver();
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.spicejet.com/");

        driver.findElement(By.xpath("//div[@data-testid='to-testID-origin']//input[@type='text']")).click();
        driver.findElement(By.xpath("//div[contains(text(),'ATQ')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[contains(text(),'IXG')]")).click();
        driver.close();
    }
}

