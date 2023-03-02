package testCases;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductsPage;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;
import utilities.Driver;

public class Test_20 {
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
    public void test_20() {
        HomePage homePage=new HomePage();
        homePage.verifyingHomePage();
        homePage.clickProductsButton();

        ProductsPage productsPage=new ProductsPage();
        productsPage.verifyProductPage();
        productsPage.verifyAllProductsText();
        productsPage.searchProduct();
        productsPage.clickSearchButton();
        productsPage.verifySearchedProductText();
        productsPage.verifyAllRelatedProductsVisible();
        productsPage.addAllSearchedProducts();
        productsPage.clickCartButton();

        CartPage cartPage=new CartPage();
        cartPage.verifyingCartPage();
        cartPage.verifyAllProductsInCartPage();
        cartPage.clickSignupLoginButton();
        LoginPage loginPage=new LoginPage();
        loginPage.setLoginEmailAddress();
        loginPage.setLoginPassword();
        loginPage.clickCartButton();
        cartPage.verifyAllProductsInCartPage();

    }
    @AfterSuite
    public void afterTest() {
        // Perform cleanup tasks or generate test reports here
        Driver.getDriver().quit();
    }
}
