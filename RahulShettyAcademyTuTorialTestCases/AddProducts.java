import java.time.Duration;
import java.util.Arrays;

import java.util.List;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

public class addProducts {


    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        String[] itemsNeeded = {"Cucumber", "Brocolli", "Beetroot"};


        driver.get("https://rahulshettyacademy.com/seleniumPractise/");

        Thread.sleep(3000);

        addItems(driver, itemsNeeded);

    }
    public static void addItems(WebDriver driver, String[] itemsNeeded) {
        int addedItemNumber = 0;
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

        for (int i = 0; i < products.size(); i++) {
            //Brocolli - 1 Kg
            //Brocolli,    1 kg

            String[] name = products.get(i).getText().split("-");
            String formattedName = name[0].trim();

            //format it to get actual vegetable name
            //convert array into array list for easy search
            //  check whether name you extracted is present in arrayList or not-

            List itemsNeededList = Arrays.asList(itemsNeeded);

            if (itemsNeededList.contains(formattedName)) {
                addedItemNumber++;
                //click on Add to cart

                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

                if (addedItemNumber == itemsNeeded.length) {
                    break;
                }
            }
        }
    }
}
