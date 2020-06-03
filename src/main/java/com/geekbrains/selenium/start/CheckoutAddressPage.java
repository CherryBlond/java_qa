package com.geekbrains.selenium.start;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckoutAddressPage {
    private WebDriver driver;

    @FindBy(css = "#address_delivery .address_phone_mobile")
    private WebElement phone;

    @FindBy(css = "#address_delivery .address_address1")
    private WebElement address;

    @FindBy(css = "#address_delivery .address_state_name")
    private WebElement location;

    @FindBy(css = ".cart_navigation  button.btn-default")
    private WebElement nextStepButton;

    public CheckoutAddressPage(WebDriver driver) {
        this.driver = driver;
    }

    public UserAddress getAddress() {
        String locationInfo = location.getText().trim();
        Matcher matcher = Pattern.compile("^(.+), (.+) (\\d{5})$").matcher(locationInfo);
        matcher.find();
        return new UserAddress(
            address.getText().trim(),
            matcher.group(1),
            matcher.group(2),
            matcher.group(3),
            phone.getText().trim()
        );
    }

    public CheckoutShippingPage nextStep() {
        nextStepButton.click();
        return PageFactory.initElements(driver, CheckoutShippingPage.class);
    }
}
