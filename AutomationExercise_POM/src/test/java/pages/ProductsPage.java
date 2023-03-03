package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.BrowserUtils;
import utilities.Constants;

import java.time.Duration;
import java.util.List;

public class ProductsPage extends BasePage{
    JavascriptExecutor js=(JavascriptExecutor)driver;

    @FindBy(xpath = "//h2[normalize-space()='All Products']")
    private WebElement verifyingObject;
    @FindBy(xpath = "(//h2[normalize-space()='All Products'])[1]")
    private WebElement allProductsText;
    @FindBy(xpath = "//h2[normalize-space()='Searched Products']")
    private WebElement searchedProductText;

    @FindBy(id = "search_product")
    private WebElement searchProductBox;
    @FindBy(xpath = "//i[@class='fa fa-search']")
    private WebElement searchButton;
    @FindBy(xpath = "//div[@class='product-overlay']")
    private List<WebElement> relatedProducts;
    @FindBy(xpath = "//div[@id='Women']")
    private WebElement womenButton;
    @FindBy(xpath = "//a[normalize-space()='Men']")
    private WebElement menButton;
    @FindBy(xpath = "//a[normalize-space()='Kids']")
    private WebElement kidsButton;
    @FindBy(xpath = "//a[contains(@href,'brand')]")
    private List<WebElement> brandNames;
    @FindBy(xpath = "//a[contains(@href,'/brand_products')]")
    private List<WebElement> mainCategory;
    @FindBy(xpath = "//a[contains(@href,'category_products')]")
    private List<WebElement> subCategory;
    @FindBy(xpath = "//h2[@class='title text-center']")
    private WebElement productTitle;
    @FindBy(xpath = "//div[@class='overlay-content']/p")
    private WebElement searchedProductName;



    public void verifyProductPage(){
        BrowserUtils.verifyElementDisplayed(verifyingObject);
        Assert.assertTrue(verifyingObject.isDisplayed());
    }
    public void verifyAllProductsText(){
        BrowserUtils.verifyElementDisplayed(allProductsText);
        Assert.assertTrue(allProductsText.isDisplayed());
    }


    public void searchProduct(){
        BrowserUtils.verifyElementDisplayed(searchProductBox);
        searchProductBox.sendKeys(Constants.SEARCHED_PRODUCT_NAME);
    }
    public void clickSearchButton(){
        BrowserUtils.verifyElementDisplayed(searchButton);
        searchButton.click();
    }
    public void verifySearchedProductText() {
        BrowserUtils.verifyElementDisplayed(searchedProductText);
        Assert.assertTrue(searchedProductText.isDisplayed());
    }
    public void verifyAllRelatedProductsVisible(){
        js.executeScript("window.scrollBy(0,500)");
        Assert.assertEquals(relatedProducts.size(),Constants.SEARCHED_PRODUCT_NUMBER);

    }
    public void addAllSearchedProducts() {
        for (int i = 0; i < relatedProducts.size(); i++) {
            relatedProducts.get(i).findElement(By.xpath("//a[@class='btn btn-default add-to-cart']")).click();
            driver.findElement(By.xpath("//button[normalize-space()='Continue Shopping']")).click();
        }
    }
    public void clickBrand(String brandName){
        for (int i=0;i<brandNames.size();i++){
            if(brandNames.get(i).getText().equalsIgnoreCase(brandName)){
                brandNames.get(i).click();
            }
        }
    }
    public void clickCategoryButton(String mainCategoryName,String subCategoryName){
        for(int i=0;i<mainCategory.size();i++){
            if(mainCategory.get(i).getText().equalsIgnoreCase(mainCategoryName)){
               for(int j=0;j<subCategory.size();j++){
                   if(subCategory.get(j).getText().equalsIgnoreCase(subCategoryName)){
                       subCategory.get(j).click();
                   }
               }
            }
        }
    }
    public void verifyCategoryProducts(String mainCategoryName,String subCategoryName){
        Assert.assertTrue(verifyCategoryProductsTitle(mainCategoryName,subCategoryName));
    }
    private boolean verifyCategoryProductsTitle(String mainCategoryName,String subCategoryName){
        String searchedCategoryName=mainCategoryName+" - "+subCategoryName+"PRODUCTS";
        if(productTitle.getText().equalsIgnoreCase(searchedCategoryName)){
            return true;
        }
        return false;
    }
    public void verifySearchedProduct() {
        BrowserUtils.waitForVisibility(searchedProductName, Duration.ofSeconds(10));
        Assert.assertEquals(searchedProductName.getText(),Constants.SEARCHED_PRODUCT_NAME);
    }



}
