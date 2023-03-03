package pages;

import org.testng.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.BrowserUtils;
import utilities.Constants;

public class LoginPage extends BasePage{
    @FindBy(xpath = "//h2[normalize-space()='Login to your account']")
    private WebElement verifyingObject;
    @FindBy(xpath = "//*[@data-qa='signup-name']")
    private WebElement signupNewUserNameBox;

    @FindBy(xpath = "//*[@data-qa='signup-email']")
    private WebElement signupEmailAddressBox;
    @FindBy(xpath = "//*[@data-qa='signup-button']")
    private WebElement signUpButton;

    @FindBy(xpath = "//*[@data-qa='login-email']")
    private WebElement loginEmailAddressBox;
    @FindBy(xpath = "//*[@data-qa='login-password']")
    private WebElement loginEmailPasswordBox;
    @FindBy(xpath = "//*[@data-qa='login-button']")
    private WebElement loginButton;

    @FindBy(xpath = "//*[@id='form']/div/div/div[3]/div")
    private WebElement newUserSignupMessageWebElement;


    public LoginPage() {

    }
    public void verifyingLoginPage(){
        Assert.assertTrue(verifyingObject.isDisplayed());
    }
    public void setSignupNewUserName() {
        BrowserUtils.verifyElementDisplayed(signupNewUserNameBox);
        signupNewUserNameBox.sendKeys(Constants.NAME);
    }

    public void setSignupEmailAddressBox() {
        BrowserUtils.verifyElementDisplayed(signupEmailAddressBox);

        signupEmailAddressBox.sendKeys(Constants.SIGN_UP_EMAIL);
    }


    public void clickSignupButton() {
        BrowserUtils.verifyElementDisplayed(signUpButton);
        signUpButton.click();
    }


    public void setLoginEmailAddress() {
        BrowserUtils.verifyElementDisplayed(loginEmailAddressBox);
        loginEmailAddressBox.sendKeys(Constants.LOGIN_EMAIL);
    }

    public void setLoginPassword() {
        BrowserUtils.verifyElementDisplayed(loginEmailPasswordBox);
        loginEmailPasswordBox.sendKeys(Constants.LOGIN_PASSWORD);
    }

    public void clickLoginButton() {
        BrowserUtils.verifyElementDisplayed(loginButton);
        loginButton.click();
    }

    public String getNewUserSignupMessage() {
        BrowserUtils.verifyElementDisplayed(newUserSignupMessageWebElement);
        return newUserSignupMessageWebElement.getText();
    }

}
