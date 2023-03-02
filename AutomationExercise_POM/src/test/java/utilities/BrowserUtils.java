package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;

import static org.testng.AssertJUnit.assertTrue;

public class BrowserUtils {

    /**
     * Verifies whether the element is displayed on page
     * fails if the element is not found or not displayed
     *
     * @param element
     */
    public static void verifyElementDisplayed(WebElement element) {
        try {
            assertTrue("Element not visible: " + element, element.isDisplayed());
        } catch (NoSuchElementException e) {
            Assert.fail("Element not found: " + element);

        }
    }

    /**
     * Performs double click action on an element
     * @param element
     */
    public void doubleClick(WebElement element) {
        new Actions(Driver.getDriver()).doubleClick(element).build().perform();
    }


    /**
     * Performs thread sleep for the desired seconds
     */
    public static void wait(int secs) {
        try {
            Thread.sleep(1000 * secs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     *  Navigates to the target window
     * @param targetTitle
     */
    public static void switchToWindow(String targetTitle) {
        String origin = Driver.getDriver().getWindowHandle();
        for (String handle : Driver.getDriver().getWindowHandles()) {
            Driver.getDriver().switchTo().window(handle);
            if (Driver.getDriver().getTitle().equals(targetTitle)) {
                return;
            }
        }
        Driver.getDriver().switchTo().window(origin);
    }

    /**
     * Waits for visibility of an element
     * @param element
     * @return WebElement
     *
     */
    public static WebElement waitForVisibility(WebElement element, Duration timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeToWaitInSec);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }


    /**
     * Waits for visibility of an element
     * @param locator
     * @return WebElement
     *
     */
    public static WebElement waitForVisibility(By locator, Duration timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Waits for clickablility of an element
     * @param element
     * @return WebElement
     *
     */
    public static WebElement waitForClickablility(WebElement element, Duration timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Waits for clickablility of an element
     * @param locator
     * @return WebElement
     *
     */
    public static WebElement waitForClickablility(By locator, Duration timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public String getScreenshot(String testCaseName, WebDriver driver){
        TakesScreenshot screenshot=(TakesScreenshot) Driver.getDriver();
        File source=screenshot.getScreenshotAs(OutputType.FILE);
        File file=new File(System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png");
        try {
            FileUtils.copyFile(source,file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
    }
}
