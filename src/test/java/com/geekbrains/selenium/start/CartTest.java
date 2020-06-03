package com.geekbrains.selenium.start;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CartTest extends BaseTest {
    @Test
    public void testCart() {
        UserAccount acc = new UserAccount(
            getRandomFirstName() + " " + getRandomLastName(),
            getRandomLetters(10) + "@" + getRandomLetters(10) + ".com",
            getRandomLettersDigits(12)
        );
        UserAddress addr = new UserAddress(
            "st. " + getRandomLetters(10) + " - " + getRandomDigits(3),
            getRandomCity(),
            getRandomState(),
            getRandomDigits(5),
            "+1" + getRandomDigits(10)
        );

        chromeDriver.get("http://automationpractice.com/index.php?controller=authentication");

        AccountPage accountPage = PageFactory.initElements(chromeDriver, RegisterPage.class).register(acc, addr);
        CatalogPage catalogPage = accountPage.getCatalogMenuBlock().clickRandomCatalog();
        ProductInfo productInfoInCatalog = catalogPage.addRandomProductToCart();
        ProductInfo productInfoInCart = catalogPage.getCartBlock().getProductFromCart();

        assertEquals(productInfoInCatalog.getName(), productInfoInCart.getName());
        assertEquals(productInfoInCatalog.getPrice(), productInfoInCart.getPrice());
    }
}
