package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.BrowserUtils;
import utilities.Driver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BasePage {
    @FindBy(xpath = "//a[normalize-space()='Home']")
    private WebElement homePageButton;
    @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a")
    private WebElement signupLoginButton;
    @FindBy(xpath = "//a[normalize-space()='Cart']")
    private WebElement cartButton;
    @FindBy(xpath = "//a[@href='/products']")
    private WebElement productsButton;
    @FindBy(xpath = "//a[contains(text(),'Test Cases')]")
    private WebElement testCasesButton;
    @FindBy(xpath = "//a[normalize-space()='API Testing']")
    private WebElement apiTestingButton;
    @FindBy(xpath = "//a[normalize-space()='Video Tutorials']")
    private WebElement videoTutorialsButton;
    @FindBy(xpath = "//a[normalize-space()='Contact us']")
    private WebElement contactUsButton;
    @FindBy(xpath = "//a[normalize-space()='Logout']")
    private WebElement logoutButton;
    @FindBy(xpath = "//a[normalize-space()='Delete Account']")
    private WebElement deleteAccountButton;

    @FindBy(xpath = "//input[@id='susbscribe_email']")
    private WebElement subscribeEmail;
    @FindBy(xpath = "//i[@class='fa fa-arrow-circle-o-right']")
    private WebElement arrowCircleButton;
    @FindBy(xpath ="//input[@id='susbscribe_email']" )
    private WebElement subscribeEmailBox;
    @FindBy(xpath = "//button[@id='subscribe']")
    private WebElement subscribeButton;
    @FindBy(xpath = "//a[@id='scrollUp']")
    private WebElement scrollUpArrow;

    protected  static WebDriver driver= Driver.getDriver();


    protected WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    public  BasePage(){

        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);

    }
    public void navigateTo(String component) {
        String locator = "//a[text() = '" + component + "']";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator))).click();
    }
    public void clickHomePageButton(){
        BrowserUtils.verifyElementDisplayed(homePageButton);
        homePageButton.click();

    }
    public void clickSignupLoginButton() {
        BrowserUtils.verifyElementDisplayed(signupLoginButton);
        signupLoginButton.click();
    }

    public void clickCartButton() {
        BrowserUtils.verifyElementDisplayed(cartButton);
        cartButton.click();
    }
    public void clickProductsButton() {
        BrowserUtils.verifyElementDisplayed(productsButton);
        productsButton.click();
    }

    public void clickTestCasesButton() {
        BrowserUtils.verifyElementDisplayed(testCasesButton);
        testCasesButton.click();
    }

    public void clickApiTestingButton() {
        BrowserUtils.verifyElementDisplayed(apiTestingButton);
        apiTestingButton.click();
    }

    public void clickVideoTutorialsButton() {
        BrowserUtils.verifyElementDisplayed(videoTutorialsButton);
        videoTutorialsButton.click();
    }

    public void clickLogoutButton() {
        BrowserUtils.verifyElementDisplayed(logoutButton);
        logoutButton.click();
    }
    public void clickDeleteAccountButton() {
        BrowserUtils.verifyElementDisplayed(deleteAccountButton);
        deleteAccountButton.click();
    }
    public void clickContactUsButton() {
        BrowserUtils.verifyElementDisplayed(contactUsButton);
        contactUsButton.click();
    }
    public void setSubscribeEmail(String email){
        BrowserUtils.verifyElementDisplayed(subscribeEmail);
        subscribeEmail.sendKeys(email);
    }
    public void clickArrowCircleButton(){
        BrowserUtils.verifyElementDisplayed(arrowCircleButton);
        arrowCircleButton.click();
    }
    public void setSubscribeEmailBox(String email){
        BrowserUtils.verifyElementDisplayed(subscribeEmailBox);
        subscribeEmailBox.sendKeys(email);
    }
    public void clickSubscribeButton(){
        BrowserUtils.verifyElementDisplayed(subscribeButton);
        subscribeButton.click();
    }
    public void clickScrollUpArrow(){
        BrowserUtils.verifyElementDisplayed(scrollUpArrow);
        scrollUpArrow.click();
    }

}
