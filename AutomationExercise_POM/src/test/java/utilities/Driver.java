package utilities;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    private static final int IMPLICIT_WAIT_TIME_IN_SECONDS = 20;
    private static final int IMPLICIT_PAGE_LAOD_TIMEOUT = 20;

    private Driver(){

    }

    private static WebDriver driver;

    public static WebDriver getDriverReference(){
        return driver;
    }

    public static WebDriver getDriver(){
        if(driver == null){
            switch (ConfigurationReader.getProperty("browser")){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "chromeheadless":
                    //to run chrome without interface (headless mode)
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.setHeadless(true);
                    driver=new ChromeDriver();
            }
        }
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIME_IN_SECONDS, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(IMPLICIT_PAGE_LAOD_TIMEOUT, TimeUnit.SECONDS);
        return driver;
    }
    public static void closeDriver(){
        if(driver != null){
            driver.quit();
            driver = null;
        }
    }
}



