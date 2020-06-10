package com.geekbrains.selenium.start;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

import static org.testng.Assert.assertEquals;

public class RegisterTest extends BaseTest {
    private static int ACCOUNTS_NUM = 2;

    @Test(dataProvider = "authDataProvider")
    public void testAuth(UserAccount acc, UserAddress addr) {
        driver.get("http://automationpractice.com/index.php?controller=authentication");

        AccountPage accountPage = PageFactory.initElements(driver, RegisterPage.class).register(acc, addr);
        assertEquals(acc.getFullName(), accountPage.getAccountName());
    }

    @DataProvider(name = "authDataProvider")
    public Object[][] authDataProvider() {
        Object[][] result = new Object[ACCOUNTS_NUM][2];
        String fullName;
        Set<String> fullNamesSet = new HashSet<>();

        int i = 0;
        do {
            fullName = getRandomFirstName() + " " + getRandomLastName();
            if (!fullNamesSet.add(fullName)) {
                continue;
            }

            result[i] = new Object[2];
            result[i][0] = new UserAccount(
                fullName,
                getRandomLetters(10) + "@" + getRandomLetters(10) + ".com",
                getRandomLettersDigits(12)
            );
            result[i][1] = new UserAddress(
                "st. " + getRandomLetters(10) + " - " + getRandomDigits(3),
                getRandomCity(),
                getRandomState(),
                getRandomDigits(5),
                "+1" + getRandomDigits(10)
            );
            i++;
        } while (fullNamesSet.size() < ACCOUNTS_NUM);

        return result;
    }
}
