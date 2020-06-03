package com.geekbrains.selenium.start;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutSummaryPage {
    private WebDriver driver;

    @FindBy(css = "#total_product")
    private WebElement totalAmount;

    @FindBy(css = "a.standard-checkout")
    private WebElement nextStepButton;

    public CheckoutSummaryPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTotalAmount() {
        return totalAmount.getText().trim();
    }

    public CheckoutAddressPage nextStep() {
        nextStepButton.click();
        return PageFactory.initElements(driver, CheckoutAddressPage.class);
    }
}
