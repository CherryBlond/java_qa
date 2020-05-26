package com.geekbrains.selenium.start;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegisterTest extends BaseTest {
    @Test
    public void testAuth() {
        chromeDriver.get("http://automationpractice.com/index.php?controller=authentication");

        Map<String, String> data = new HashMap<>();
        data.put("email", "test2@local.site");
        data.put("customerFirstname", "John");
        data.put("customerLastname", "Doe");
        data.put("password", "qweRTY12#$");
        data.put("addressFirstname", "John");
        data.put("addressLastname", "Doe");
        data.put("addressName", "Long st. 123");
        data.put("addressCity", "Jersey");
        data.put("addressState", "Ohio");
        data.put("addressPostcode", "77231");
        data.put("addressPhone", "+1982037284");
        AccountPage accountPage = PageFactory.initElements(chromeDriver, RegisterPage.class).register(data);
        assertEquals("John Doe", accountPage.getAccountName());
    }
}
