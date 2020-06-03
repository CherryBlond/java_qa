package com.geekbrains.selenium.start;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderTest extends BaseTest {
    @Test
    public void testOrder() {
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

        CheckoutSummaryPage checkoutSummaryPage = catalogPage.getCartBlock().proceedToCheckout();
        assertEquals(productInfoInCatalog.getPrice(), checkoutSummaryPage.getTotalAmount());

        CheckoutAddressPage checkoutAddressPage = checkoutSummaryPage.nextStep();
        UserAddress addrFromCheckout = checkoutAddressPage.getAddress();
        assertEquals(addr.getAddress(), addrFromCheckout.getAddress());
        assertEquals(addr.getCity(), addrFromCheckout.getCity());
        assertEquals(addr.getState(), addrFromCheckout.getState());
        assertEquals(addr.getPostcode(), addrFromCheckout.getPostcode());
        assertEquals(addr.getPhone(), addrFromCheckout.getPhone());

        CheckoutShippingPage checkoutShippingPage = checkoutAddressPage.nextStep();
        checkoutShippingPage.agreeWithDeliveryTerms();

        CheckoutPaymentPage checkoutPaymentPage = checkoutShippingPage.nextStep();
        assertEquals(productInfoInCatalog.getPrice(), checkoutPaymentPage.getTotalAmount());

        checkoutPaymentPage.chooseCardPayment();
        String confirmation = checkoutPaymentPage.confirm();
        assertEquals("Your order on My Store is complete.", confirmation);
    }
}
