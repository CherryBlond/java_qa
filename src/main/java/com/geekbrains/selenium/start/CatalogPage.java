package com.geekbrains.selenium.start;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CatalogPage {
    private WebDriver driver;
    private WebDriverWait waiter;

    @FindBy(css = ".product-container")
    private List<WebElement> productsCards;

    public CatalogPage(WebDriver driver) {
        this.driver = driver;
        this.waiter = new WebDriverWait(driver, 10);
    }

    public ProductInfo addRandomProductToCart() {
        WebElement productCard = productsCards.get((int) (Math.random() * productsCards.size()));
        String productName = productCard.findElement(By.cssSelector(".product-name")).getText().trim();
        String productPrice = productCard.findElement(By.cssSelector(".right-block .product-price")).getText().trim();

        new Actions(driver).moveToElement(productCard).build().perform();
        // ждем появления плашки с товаром
        try { Thread.sleep(1000); } catch (InterruptedException e) {}

        WebElement addToCartButton = productCard.findElement(By.cssSelector(".ajax_add_to_cart_button"));
        addToCartButton.click();
        // ждем появления корзины
        waiter.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#layer_cart")));

        return new ProductInfo(productName, productPrice);
    }

    public CartBlock getCartBlock() {
        return PageFactory.initElements(driver, CartBlock.class);
    }
}
