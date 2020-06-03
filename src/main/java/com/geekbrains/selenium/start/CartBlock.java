package com.geekbrains.selenium.start;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartBlock {
    private WebDriver driver;

    @FindBy(css = "#layer_cart .product-name")
    private WebElement productName;

    @FindBy(css = "#layer_cart #layer_cart_product_price")
    private WebElement productPrice;

    @FindBy(css = "#layer_cart a.btn-default")
    private WebElement proceedToCheckoutButton;

    public CartBlock(WebDriver driver) {
        this.driver = driver;
    }

    public ProductInfo getProductFromCart() {
        return new ProductInfo(productName.getText().trim(), productPrice.getText().trim());
    }

    public CheckoutSummaryPage proceedToCheckout() {
        proceedToCheckoutButton.click();
        return PageFactory.initElements(driver, CheckoutSummaryPage.class);
    }
}
