package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailPage extends BasePage{

    By addToCartButtonLocator = By.id("add-to-cart-button");
    By popuoButton=By.id("attach-close_sideSheet-link");

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnProductDetailPage() {
        return isDisplayed(addToCartButtonLocator);
    }

    public void addToCart() throws InterruptedException {
        click(addToCartButtonLocator);
        Thread.sleep(2000);
        click(popuoButton);

    }
}
