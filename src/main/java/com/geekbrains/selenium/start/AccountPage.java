package com.geekbrains.selenium.start;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage {
    private WebDriver driver;

    @FindBy(css = ".account span")
    private WebElement myAccountName;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getAccountName() {
        return myAccountName.getText();
    }
}
