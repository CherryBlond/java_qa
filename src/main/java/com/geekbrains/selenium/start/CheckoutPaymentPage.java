package com.geekbrains.selenium.start;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPaymentPage {
    private WebDriver driver;
    private WebDriverWait waiter;

    @FindBy(css = "#total_product")
    private WebElement totalAmount;

    @FindBy(css = ".bankwire")
    private WebElement payByCardButton;

    @FindBy(css = "#cart_navigation button.btn-default")
    private WebElement confirmButton;

    @FindBy(css = "#center_column .cheque-indent strong")
    private WebElement orderCompleteText;

    public CheckoutPaymentPage(WebDriver driver) {
        this.driver = driver;
        this.waiter = new WebDriverWait(driver, 10);
    }

    public String getTotalAmount() {
        return totalAmount.getText().trim();
    }

    public void chooseCardPayment() {
        payByCardButton.click();
        // ждем загрузки страницы
        waiter.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#cart_navigation button.btn-default")));
    }

    public String confirm() {
        confirmButton.click();
        // ждем появления подтверждения заказа
        waiter.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#center_column .cheque-indent strong")));
        return orderCompleteText.getText().trim();
    }
}
