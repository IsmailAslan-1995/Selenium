package testCases;

import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.LoginPage;
import pages.SignupPage;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;
import utilities.Driver;

public class Test_01 {
    SoftAssert softAssert = new SoftAssert();
    @BeforeSuite
    public void setUpSuite() {
        // code that is executed before the entire test suite
        String URL = ConfigurationReader.getProperty("url");
        String browser = ConfigurationReader.getProperty("browser");
        String environment = ConfigurationReader.getProperty("environment");
        Driver.getDriver().get(URL);
        System.out.println("::::::Test Information ::::::\n\tURL :" + URL + "\n\tBrowser :" + browser + "\n\tEnvironment :" + environment);
        BrowserUtils.wait(1);
    }
    @BeforeTest
    public void setupTest(){
        String URL = ConfigurationReader.getProperty("url");
        Driver.getDriver().get(URL);
    }
    @Test
    public void test_01(){

        HomePage homePage=new HomePage();
        homePage.verifyingHomePage();
        homePage.clickSignupLoginButton();
        LoginPage loginPage=new LoginPage();
        loginPage.verifyingLoginPage();
        String newUserSignupMessage = loginPage.getNewUserSignupMessage();

        softAssert.assertEquals(newUserSignupMessage, "New User Signup!", "Test Case 1 - Verify 'New User Signup!' is visible");

        loginPage.setSignupNewUserName();
        loginPage.setSignupEmailAddressBox();

        loginPage.clickSignupButton();
        SignupPage signupPage=new SignupPage();
        signupPage.verifyingSignupPage();
        String actualEnterAccountInformationTitle = signupPage.getEnterAccountInformationTitle();
        softAssert.assertEquals(actualEnterAccountInformationTitle, "ENTER ACCOUNT INFORMATION", "ERROR : Test Case 1 - Verify that 'ENTER ACCOUNT INFORMATION' is visible\n");

        signupPage.selectTitleMen();
        signupPage.setPassword();
        signupPage.setDateOfBirth();
        signupPage.clickSignupForOurNewsletterButton();
        signupPage.clickReceiveSpecialOffersFromOurPartnersButton();
        signupPage.setFirstNameButton();
        signupPage.setLastNameButton();
        signupPage.setCompanyButton();
        signupPage.setAddress1Button();
        signupPage.setAddress2Button();
        signupPage.setCountryButton();
        signupPage.setStateButton();
        signupPage.setCityButton();
        signupPage.setZipcodeButton();
        signupPage.setMobileNumberButton();
        signupPage.clickCreateAccountButton();
        signupPage.clickContinueButton();
        signupPage.getVerifyingLoginText();
        signupPage.clickDeleteAccountButton();
        signupPage.getVerifyDeleteAccount();
        signupPage.clickDeleteAccountContinue();

    }
    @AfterTest
    public void afterTest() {
        // Perform cleanup tasks or generate test reports here
        Driver.getDriver().quit();
    }
}
