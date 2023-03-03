package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import utilities.BrowserUtils;
import utilities.Constants;

public class SignupPage extends BasePage {
    JavascriptExecutor js = (JavascriptExecutor) driver;
    @FindBy(xpath = "//*[@id='form']/div/div/div/div[1]/h2")
    private WebElement enterAccountInformationTitle;

    @FindBy(xpath = "//*[@id='id_gender1']")
    private WebElement id_genderMR;

    @FindBy(xpath = "//*[@id='id_gender2']")
    private WebElement id_genderMRS;

    @FindBy(xpath = "//*[@type='password']")
    private WebElement passwordBox;

    @FindBy(xpath = "//*[@data-qa='days']")
    private WebElement dateOfBirth_DAYs;
    @FindBy(xpath = "//*[@data-qa='months']")
    private WebElement dateOfBirth_MONTHs;
    @FindBy(xpath = "//*[@data-qa='years']")
    private WebElement dateOfBirth_YEARs;
    @FindBy(xpath = "//input[@id='newsletter']")
    private WebElement signupForOurNewsletterButton;
    @FindBy(xpath = "//input[@id='optin']")
    private WebElement receiveSpecialOffersFromOurPartnersButton;
    @FindBy(xpath = "//input[@id='first_name']")
    private WebElement firstNameButton;
    @FindBy(xpath = "//input[@id='last_name']")
    private WebElement lastNameButton;
    @FindBy(xpath = "//input[@id='company']")
    private WebElement companyButton;
    @FindBy(xpath = "//input[@id='address1']")
    private WebElement address1Button;
    @FindBy(xpath = "//input[@id='address2']")
    private WebElement address2Button;
    @FindBy(xpath = "//select[@id='country']")
    private WebElement countryButton;
    @FindBy(xpath = "//input[@id='state']")
    private WebElement stateButton;
    @FindBy(xpath = "//input[@id='city']")
    private WebElement cityButton;
    @FindBy(xpath = "//input[@id='zipcode']")
    private WebElement zipcodeButton;
    @FindBy(xpath = "//input[@id='mobile_number']")
    private WebElement mobileNumberButton;
    @FindBy(xpath = "//button[normalize-space()='Create Account']")
    private WebElement createAccountButton;
    @FindBy(xpath = "//b[normalize-space()='Account Created!']")
    private WebElement accountCreatedText;
    @FindBy(xpath = "//a[normalize-space()='Continue']")
    private WebElement continueButton;
    @FindBy(xpath = "//a[text()=' Logged in as ' ]")
    private WebElement verifyingLoginText;
    @FindBy(xpath = "//*[@id='header']/div/div/div/div[2]/div/ul/li[2]/a")
    private WebElement productsPageButton;
    @FindBy(xpath = "//b[normalize-space()='Account Deleted!']")
    private WebElement verifyDeleteAccount;
    @FindBy(xpath = "//a[normalize-space()='Continue']")
    private WebElement deleteAccountContinue;

    public SignupPage() {

    }

    public void verifyingSignupPage() {
        Assert.assertTrue(enterAccountInformationTitle.isDisplayed());
    }

    public String getEnterAccountInformationTitle() {
        BrowserUtils.verifyElementDisplayed(enterAccountInformationTitle);
        return enterAccountInformationTitle.getText();
    }

    public void selectTitleMen() {
        BrowserUtils.verifyElementDisplayed(id_genderMR);
        id_genderMR.click();
    }

    public void selectTitleWomen() {
        BrowserUtils.verifyElementDisplayed(id_genderMRS);
        id_genderMRS.click();
    }

    public void setPassword() {
        BrowserUtils.verifyElementDisplayed(passwordBox);
        passwordBox.sendKeys(Constants.SIGN_UP_PASSWORD);
    }

    public void setDateOfBirth() {
        String []birthdate=Constants.BIRTHDATE.split("-");

        setDay(birthdate[0]);
        setMonth(birthdate[1]);
        setYear(birthdate[2]);
    }

    private void setDay(String day) {
        BrowserUtils.verifyElementDisplayed(dateOfBirth_DAYs);
        Select select = new Select(dateOfBirth_DAYs);
        select.selectByVisibleText(day);
    }

    private void setMonth(String month) {
        Select select = new Select(dateOfBirth_MONTHs);
        select.selectByVisibleText(month);
    }

    private void setYear(String year) {
        Select select = new Select(dateOfBirth_YEARs);
        select.selectByVisibleText(year);
    }

    public void clickSignupForOurNewsletterButton() {
        js.executeScript("window.scrollBy(0,500)");
        BrowserUtils.verifyElementDisplayed(signupForOurNewsletterButton);
        signupForOurNewsletterButton.click();

    }

    public void clickReceiveSpecialOffersFromOurPartnersButton() {
        BrowserUtils.verifyElementDisplayed(receiveSpecialOffersFromOurPartnersButton);
        receiveSpecialOffersFromOurPartnersButton.click();

    }
    public void setFirstNameButton() {
        BrowserUtils.verifyElementDisplayed(firstNameButton);

        firstNameButton.sendKeys(Constants.NAME);
    }

    public void setLastNameButton() {
        BrowserUtils.verifyElementDisplayed(lastNameButton);
        lastNameButton.sendKeys(Constants.LASTNAME);
    }

    public void setCompanyButton() {
        BrowserUtils.verifyElementDisplayed(companyButton);
        companyButton.sendKeys(Constants.COMPANY_NAME);
    }

    public void setAddress1Button() {
        BrowserUtils.verifyElementDisplayed(address1Button);
        address1Button.sendKeys(Constants.ADDRESS);
    }

    public void setAddress2Button() {
        BrowserUtils.verifyElementDisplayed(address2Button);
        address2Button.sendKeys(Constants.ADDRESS_SECOND);
    }

    public void setCountryButton() {
        js.executeScript("window.scrollBy(0,1000)");
        BrowserUtils.verifyElementDisplayed(countryButton);
        Select select = new Select(countryButton);
        select.selectByVisibleText(Constants.COUNTRY);
    }

    public void setStateButton() {
        BrowserUtils.verifyElementDisplayed(stateButton);
        stateButton.sendKeys(Constants.STATE);
    }

    public void setCityButton() {
        BrowserUtils.verifyElementDisplayed(cityButton);
        cityButton.sendKeys(Constants.CITY);
    }

    public void setZipcodeButton() {
        BrowserUtils.verifyElementDisplayed(zipcodeButton);
        zipcodeButton.sendKeys(Constants.ZIPCODE);
    }

    public void setMobileNumberButton() {
        BrowserUtils.verifyElementDisplayed(mobileNumberButton);
        mobileNumberButton.sendKeys(Constants.MOBILE_NUMBER);
    }

    public void clickCreateAccountButton() {
        BrowserUtils.verifyElementDisplayed(createAccountButton);
        createAccountButton.click();
    }

    public void verifyAccountCreatedText() {
        org.testng.Assert.assertTrue(accountCreatedText.isDisplayed());
    }

    public void clickContinueButton() {
        BrowserUtils.verifyElementDisplayed(continueButton);
        continueButton.click();
    }
    public void selectProductsPageButton() {
        productsPageButton.click();
    }
    public void getVerifyingLoginText(){
        String expected="Logged in as "+Constants.NAME;
        BrowserUtils.verifyElementDisplayed(verifyingLoginText);
        String actual=driver.findElement(By.xpath("//a[text()=' Logged in as ' ]")).getText();
        Assert.assertEquals(expected,actual);
    }
    public void getVerifyDeleteAccount(){
        BrowserUtils.verifyElementDisplayed(verifyDeleteAccount);
        Assert.assertTrue(verifyDeleteAccount.isDisplayed());

    }
    public void clickDeleteAccountContinue(){
        BrowserUtils.verifyElementDisplayed(deleteAccountContinue);
        Assert.assertTrue(deleteAccountContinue.isDisplayed());
    }
}




