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

    public AccountPage register(UserAccount acc, UserAddress addr) {
        emailInput.sendKeys(acc.getEmail());
        createAccountButton.click();

        customerFirstname.sendKeys(acc.getFirstName());
        customerLastname.sendKeys(acc.getLastName());
        password.sendKeys(acc.getPassword());

        addressName.sendKeys(addr.getAddress());
        addressCity.sendKeys(addr.getCity());
        addressPostcode.sendKeys(addr.getPostcode());
        addressPhone.sendKeys(addr.getPhone());
        new Select(addressState).selectByVisibleText(addr.getState());
        submitAccount.click();
        return PageFactory.initElements(driver, AccountPage.class);
    }
}
