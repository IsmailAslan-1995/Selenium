package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.BrowserUtils;
import utilities.Constants;

public class ContactUsPage extends BasePage {
    JavascriptExecutor js = (JavascriptExecutor) driver;
    @FindBy(xpath = "//div[@class='col-sm-12']")
    private WebElement verifyingObject;
    @FindBy(xpath = "//input[@placeholder='Name']")
    private WebElement nameBox;
    @FindBy(xpath = "//input[@placeholder='Email']")
    private WebElement emailBox;
    @FindBy(xpath = "//input[@placeholder='Subject']")
    private WebElement subjectBox;
    @FindBy(xpath = "//textarea[@id='message']")
    private WebElement messageBox;
    @FindBy(xpath = "//input[@name='upload_file']")
    private WebElement uploadFileButton;
    @FindBy(xpath = "//input[@name='submit']")
    private WebElement submitButton;
    @FindBy(xpath = "//div[@class='status alert alert-success']")
    private WebElement successMessage;
    @FindBy(xpath = "//span[normalize-space()='Home']")
    private WebElement homeButton;


    public void getVerifyingContactUsPage(){
        BrowserUtils.verifyElementDisplayed(verifyingObject);
        Assert.assertTrue(verifyingObject.isDisplayed());
    }
    public void setNameBox(){
        BrowserUtils.verifyElementDisplayed(nameBox);
        nameBox.sendKeys(Constants.NAME);
    }
    public void setEmailBox(){
        BrowserUtils.verifyElementDisplayed(emailBox);
        emailBox.sendKeys(Constants.SIGN_UP_EMAIL);
    }
    public void setSubjectBox(){
        BrowserUtils.verifyElementDisplayed(subjectBox);
        subjectBox.sendKeys(Constants.SUBJECT);
    }
    public void setMessageBox(){
        BrowserUtils.verifyElementDisplayed(messageBox);
        messageBox.sendKeys(Constants.MESSAGE);
    }
    public void setUploadFile(){
        BrowserUtils.verifyElementDisplayed(uploadFileButton);
        uploadFileButton.sendKeys(Constants.UPLOAD_FILEPATH);
    }
    public void clickSubmitButton(){
        js.executeScript("window.scrollBy(0,500)");
        BrowserUtils.verifyElementDisplayed(submitButton);
        submitButton.click();
    }
    public void clickOkButton(){
        Alert alert=driver.switchTo().alert();
        alert.accept();
    }
    public void verifySuccessMessage(){
        BrowserUtils.verifyElementDisplayed(successMessage);
        Assert.assertTrue(successMessage.isDisplayed());
    }
    public void clickHomeButton(){
        BrowserUtils.verifyElementDisplayed(homeButton);
        homeButton.click();
    }
}
