package pages;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.BrowserUtils;
import utilities.Constants;

import java.util.*;

public class CartPage extends BasePage {
    @FindBy(xpath = "//li[@class='active']")
    private WebElement verifyingObject;
    @FindBy(xpath = "//b[normalize-space()='Cart is empty!']")
    private  WebElement emptyCartText;
    @FindBy(xpath = "//a[normalize-space()='Proceed To Checkout']")
    private WebElement proceedToCheckoutButton;
    @FindBy(xpath = "//tr[contains(@id,'product')]")
    private List<WebElement> products;
    @FindBy(xpath = "//a[contains(@href,'product')]")
    private List<WebElement> productsNames;
    @FindBy(xpath = "//td[@class='cart_price']")
    private List<WebElement> productsPrices;
    @FindBy(xpath = "//td[@class='cart_quantity']")
    private List<WebElement> productsQuantity;
    @FindBy(xpath = "//td[@class='cart_total']")
    private List<WebElement> totalProductPrice;
    @FindBy(xpath = "//td[@class='cart_delete']")
    private List<WebElement> cartDeleteButtons;
    @FindBy(xpath = "//u[normalize-space()='Register / Login']")
    private WebElement registerLoginButton;
    @FindBy(xpath = "//button[normalize-space()='Continue On Cart']")
    private WebElement continueOnCartButton;

    public void verifyingCartPage(){
        BrowserUtils.verifyElementDisplayed(verifyingObject);
        Assert.assertTrue(verifyingObject.isDisplayed());
    }
    public void verifyingEmptyCart(){
        BrowserUtils.verifyElementDisplayed(emptyCartText);
        Assert.assertTrue(emptyCartText.isDisplayed());
    }
    public void clickProceedToCheckoutButton(){
        BrowserUtils.verifyElementDisplayed(proceedToCheckoutButton);
        proceedToCheckoutButton.click();
    }
    public void deleteProduct(String productName){
        for(int i=0;i<productsNames.size();i++){
            if(productsNames.get(i).getText().equalsIgnoreCase(productName)){
                products.get(i).findElement(By.xpath("//td[@class='cart_delete']")).click();
            }
        }
    }
    public void clickRegisterLoginButton(){
        BrowserUtils.verifyElementDisplayed(registerLoginButton);
        registerLoginButton.click();
    }
    public void clickContinueOnCartButton(){
        BrowserUtils.verifyElementDisplayed(continueOnCartButton);
        continueOnCartButton.click();
    }
    public void verifyProductInCartPage(String productName){
        Assert.assertTrue(verifyProductInCart(productName));
    }
    public void verifyProductPriceInCartPage(String productName,int price){
        Assert.assertTrue(verifyProductPriceInCart(productName,price));
    }
    public void verifyProductQuantityInCartPage(String productName,int quantity){
        Assert.assertTrue(verifyProductQuantityInCart(productName,quantity));
    }
    public void verifyProductTotalInCartPage(String productName,int productNumber){
        Assert.assertTrue(verifyProductTotalInCart(productName,productNumber));
    }
    public void verifyAllProductsInCartPage(){
        Assert.assertTrue(verifyAllProductsInCart(Constants.SEARCHED_PRODUCT_NAME_ARRAY));
    }
    public void verifyAllProductPriceInCartPage(Map<String,Integer> allProductsNameAndPrice ){
        Assert.assertTrue(verifyAllProductPriceInCart(allProductsNameAndPrice));
    }
    public void verifyAllProductQuantityInCartPage(Map<String,Integer> allProductsNameAndQuantity ){
        Assert.assertTrue(verifyAllProductQuantityInCart(allProductsNameAndQuantity));
    }
    public void verifyAllProductTotalInCartPage(HashMap<String,Integer> allProductsNameAndAmount ){
        Assert.assertTrue(verifyAllProductTotalInCart(allProductsNameAndAmount));

    }
    private boolean verifyProductInCart(String productName){
        for(int i=0;i<products.size();i++){
            if(products.get(i).findElement(By.xpath("//a[contains(@href,'details')]")).getText().equalsIgnoreCase(productName)){
                return true;
            }
        }
        return false;
    }
    private boolean verifyProductPriceInCart(String productName,int price){
        String sPrice="Rs. "+price;
        for(int i=0;i<products.size();i++){
            if(products.get(i).findElement(By.xpath("//a[contains(@href,'details')]")).getText().equalsIgnoreCase(productName)){
               if(products.get(i).findElement(By.xpath("//td[@class='cart_price']")).getText().equalsIgnoreCase(sPrice)){
                   return true;
                }
            }
        }
        return false;
    }
    private boolean verifyProductQuantityInCart(String productName,int quantity){
        String sQuantity=quantity+"";
        for(int i=0;i<products.size();i++){
            if(products.get(i).findElement(By.xpath("//a[contains(@href,'details')]")).getText().equalsIgnoreCase(productName)){
                if(products.get(i).findElement(By.xpath("//td[@class='cart_quantity']")).getText().equalsIgnoreCase(sQuantity)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean verifyProductTotalInCart(String productName,int productNumber){

        for(int i=0;i<products.size();i++){
            if(products.get(i).findElement(By.xpath("//a[contains(@href,'details')]")).getText().equalsIgnoreCase(productName)){
               // int total=Integer.parseInt(products.get(i).findElement(By.xpath("//td[@class='cart_total']")).getText());

                if(products.get(i).findElement(By.xpath("//td[@class='cart_total']")).getText().equalsIgnoreCase(String.valueOf(productNumber))){
                    return true;
                }
            }
        }
        return false;
    }


    private boolean verifyAllProductsInCart(String [] productNames){
       List<String> productsName= Arrays.stream(productNames).toList();
        int productsNumber=0;
        for(int i=0;i<products.size();i++){
            if(productsName.contains(products.get(i).findElement(By.xpath("//a[contains(@href,'details')]")).getText())){
                productsNumber++;
            }
        }

        return  productsNumber==products.size() ? true:false;
    }
    private boolean verifyAllProductPriceInCart(Map<String,Integer> allProductsNameAndPrice ){
        int productsNumber=0;
        Set productsName=allProductsNameAndPrice.keySet();
        Set productsPrice=allProductsNameAndPrice.entrySet();
        List<String> productsPriceList=productsPrice.stream().toList();
        for(int i=0;i<products.size();i++){
            if(productsName.contains(products.get(i).findElement(By.xpath("//a[contains(@href,'details')]")).getText())){
                String sPrice=products.get(i).findElement(By.xpath("//td[@class='cart_price']")).getText();
                String[] price =sPrice.split(" ");
                if(productsPriceList.get(i).equalsIgnoreCase(price[1])){
                   productsNumber++;
                }
            }
        }
        return productsNumber==allProductsNameAndPrice.size() ? true : false;
    }
    private boolean verifyAllProductQuantityInCart(Map<String,Integer> allProductsNameAndQuantity ){
        int productsNumber=0;
        Set productsNameSet=allProductsNameAndQuantity.keySet();
        List<String>productsName=productsNameSet.stream().toList();
        Set productsQuantity=allProductsNameAndQuantity.entrySet();
        List<String> productsPriceList=productsQuantity.stream().toList();
        for(int i=0;i<products.size();i++){
            if(productsName.contains(products.get(i).findElement(By.xpath("//a[contains(@href,'details')]")).getText())){
                String sQuantity=products.get(i).findElement(By.xpath("//td[@class='cart_quantity']")).getText();
                if(productsPriceList.get(i).equalsIgnoreCase(sQuantity)){
                    productsNumber++;
                }
            }
        }
        return productsNumber==allProductsNameAndQuantity.size() ? true : false;
    }
    private boolean verifyAllProductTotalInCart(HashMap<String,Integer> allProductsNameAndAmount ){
        int total=0;
        int productsNumber=0;
        Set productsNameSet=allProductsNameAndAmount.keySet();
        List<String>productsName=productsNameSet.stream().toList();
        Set productsTotal=allProductsNameAndAmount.entrySet();
        List<String> productsTotalList=productsTotal.stream().toList();
        for(int i=0;i<products.size();i++){
            if(productsName.contains(products.get(i).findElement(By.xpath("//a[contains(@href,'details')]")).getText())){
                String stringTotal=products.get(i).findElement(By.xpath("//td[@class='cart_total']")).getText();
                String [] sTotal=stringTotal.split(" ");
                String sPrice=products.get(i).findElement(By.xpath("//td[@class='cart_price']")).getText();
                String[] price =sPrice.split(" ");
                total=Integer.parseInt(productsTotalList.get(i))*Integer.parseInt(price[1]);
                if(String.valueOf(total).equalsIgnoreCase(sTotal[1])){
                   productsNumber++;
                }
            }
        }
        return productsNumber==allProductsNameAndAmount.size() ? true : false;
    }

}
