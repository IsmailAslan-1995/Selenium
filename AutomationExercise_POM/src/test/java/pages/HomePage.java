package pages;

import org.testng.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.BrowserUtils;
import utilities.Constants;

import java.util.List;

public class HomePage extends BasePage {
    @FindBy(xpath = "//div[@class='item active']//h2[contains(text(),'Full-Fledged practice website for Automation Engin')]")
    private WebElement verifyingObject;

    public void verifyingHomePage(){
        BrowserUtils.verifyElementDisplayed(verifyingObject);
        Assert.assertTrue(verifyingObject.isDisplayed());
    }



}


