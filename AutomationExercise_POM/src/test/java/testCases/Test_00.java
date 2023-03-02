package testCases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductsPage;
import pages.SignupPage;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;
import utilities.Driver;

public class Test_00 {

    SoftAssert softAssert = new SoftAssert(); // We should use soft assertion because in this test case we have multiple cases to test

    ExtentReports extentReports;
    @BeforeSuite
    public void setUpSuite() {
        // code that is executed before the entire test suite
        String path=System.getProperty("user.dir")+"\\reports\\index.html";
        ExtentSparkReporter  extentSparkReporter =new ExtentSparkReporter(path);
        extentSparkReporter.config().setReportName("Automation Exercise Test Cases");
        extentSparkReporter.config().setDocumentTitle("Test Results");
        extentReports=new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
        extentReports.setSystemInfo("Tester Name","İsmail ASLAN");

        String URL = ConfigurationReader.getProperty("url");
        String browser = ConfigurationReader.getProperty("browser");
        String environment = ConfigurationReader.getProperty("environment");
        Driver.getDriver().get(URL);
        System.out.println("::::::Test Information ::::::\n\tURL :" + URL + "\n\tBrowser :" + browser + "\n\tEnvironment :" + environment);
        BrowserUtils.wait(1);
    }

    @Test
    public void test_00() {
        extentReports.createTest("First Scenario");
        HomePage homePage=new HomePage();
        homePage.verifyingHomePage();
        homePage.clickSignupLoginButton();
        LoginPage loginPage=new LoginPage();
        loginPage.verifyingLoginPage();
        String newUserSignupMessage = loginPage.getNewUserSignupMessage();
        //Verify 'New User Signup!' is visible
        softAssert.assertEquals(newUserSignupMessage, "New User Signup!", "Test Case 1 - Verify 'New User Signup!' is visible");
        //Enter name and email address
        loginPage.setSignupNewUserName();
        loginPage.setSignupEmailAddressBox();
        // Click 'Signup' button
        loginPage.clickSignupButton();

        // Verify that 'ENTER ACCOUNT INFORMATION' is visible
        SignupPage signupPage=new SignupPage();
        String actualEnterAccountInformationTitle = signupPage.getEnterAccountInformationTitle();
        softAssert.assertEquals(actualEnterAccountInformationTitle, "ENTER ACCOUNT INFORMATION", "ERROR : Test Case 1 - Verify that 'ENTER ACCOUNT INFORMATION' is visible\n");

        // Fill details: Title, Name, Email, Password, Date of birth
        signupPage.selectTitleMen();
        signupPage.setPassword();
        signupPage.setDateOfBirth();

        signupPage.selectProductsPageButton();

        ProductsPage productsPage=new ProductsPage();
        productsPage.searchProduct();
        productsPage.clickSearchButton();
        productsPage.verifySearchedProduct();
        extentReports.flush();

    }
    @AfterTest
    public void afterTest() {
        // Perform cleanup tasks or generate test reports here
        Driver.getDriver().quit();
    }
}
