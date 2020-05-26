package com.geekbrains.selenium.start;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.Map;

public class RegisterPage {
    private WebDriver driver;

    @FindBy(css = "#email_create")
    private WebElement emailInput;

    @FindBy(css = "#SubmitCreate")
    private WebElement createAccountButton;

    @FindBy(css = "#customer_firstname")
    private WebElement customerFirstname;

    @FindBy(css = "#customer_lastname")
    private WebElement customerLastname;

    @FindBy(css = "#passwd")
    private WebElement password;

    @FindBy(css = "#firstname")
    private WebElement addressFirstname;

    @FindBy(css = "#lastname")
    private WebElement addressLastname;

    @FindBy(css = "#address1")
    private WebElement addressName;

    @FindBy(css = "#city")
    private WebElement addressCity;

    @FindBy(css = "#id_state")
    private WebElement addressState;

    @FindBy(css = "#postcode")
    private WebElement addressPostcode;

    @FindBy(css = "#phone_mobile")
    private WebElement addressPhone;

    @FindBy(css = "#submitAccount")
    private WebElement submitAccount;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public AccountPage register(Map<String, String> data) {
        emailInput.sendKeys(data.get("email"));
        createAccountButton.click();

        customerFirstname.sendKeys(data.get("customerFirstname"));
        customerLastname.sendKeys(data.get("customerLastname"));
        password.sendKeys(data.get("password"));
        addressFirstname.sendKeys(data.get("addressFirstname"));
        addressLastname.sendKeys(data.get("addressLastname"));
        addressName.sendKeys(data.get("addressName"));
        addressCity.sendKeys(data.get("addressCity"));
        addressPostcode.sendKeys(data.get("addressPostcode"));
        addressPhone.sendKeys(data.get("addressPhone"));
        new Select(addressState).selectByVisibleText(data.get("addressState"));
        submitAccount.click();
        return PageFactory.initElements(driver, AccountPage.class);
    }
}
