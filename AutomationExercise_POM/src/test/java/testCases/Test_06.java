package testCases;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ContactUsPage;
import pages.HomePage;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;
import utilities.Driver;

public class Test_06 {
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
    @Test
    public void test_01() {
        HomePage homePage=new HomePage();
        homePage.verifyingHomePage();
        homePage.clickContactUsButton();
        ContactUsPage contactUsPage=new ContactUsPage();
        contactUsPage.getVerifyingContactUsPage();
        contactUsPage.setNameBox();
        contactUsPage.setEmailBox();
        contactUsPage.setSubjectBox();
        contactUsPage.setMessageBox();
        contactUsPage.setUploadFile();
        contactUsPage.clickSubmitButton();
        contactUsPage.clickOkButton();
        contactUsPage.verifySuccessMessage();
        contactUsPage.clickHomeButton();
        homePage.verifyingHomePage();
    }
    @AfterSuite
    public void afterTest() {
        // Perform cleanup tasks or generate test reports here
        Driver.getDriver().quit();
    }
}
