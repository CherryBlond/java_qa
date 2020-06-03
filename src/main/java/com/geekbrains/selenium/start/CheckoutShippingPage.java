package com.geekbrains.selenium.start;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutShippingPage {
    private WebDriver driver;

    @FindBy(css = "#cgv")
    private WebElement agreement;

    @FindBy(css = ".cart_navigation button.btn-default")
    private WebElement nextStepButton;

    public CheckoutShippingPage(WebDriver driver) {
        this.driver = driver;
    }

    public void agreeWithDeliveryTerms() {
        agreement.click();
    }

    public CheckoutPaymentPage nextStep() {
        nextStepButton.click();
        return PageFactory.initElements(driver, CheckoutPaymentPage.class);
    }
}
