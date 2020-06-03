package com.geekbrains.selenium.start;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CatalogMenuBlock {
    private WebDriver driver;

    @FindBy(css = ".sf-menu > li > a")
    private List<WebElement> catalogLinks;

    public CatalogMenuBlock(WebDriver driver) {
        this.driver = driver;
    }

    public CatalogPage clickRandomCatalog() {
        catalogLinks.get((int) (Math.random() * catalogLinks.size())).click();
        return PageFactory.initElements(driver, CatalogPage.class);
    }
}
