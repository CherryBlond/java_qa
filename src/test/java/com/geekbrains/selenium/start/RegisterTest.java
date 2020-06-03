package com.geekbrains.selenium.start;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.support.PageFactory;

import java.util.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegisterTest extends BaseTest {
    @ParameterizedTest
    @MethodSource("authDataProvider")
    public void testAuth(UserAccount acc, UserAddress addr) {
        chromeDriver.get("http://automationpractice.com/index.php?controller=authentication");

        AccountPage accountPage = PageFactory.initElements(chromeDriver, RegisterPage.class).register(acc, addr);
        assertEquals(acc.getFullName(), accountPage.getAccountName());
    }

    public static Stream<Arguments> authDataProvider() {
        List<Arguments> result = new ArrayList<>();
        String fullName;
        Set<String> fullNamesSet = new HashSet<>();

        do {
            fullName = getRandomFirstName() + " " + getRandomLastName();
            if (fullNamesSet.add(fullName)) {
                result.add(Arguments.arguments(
                    new UserAccount(
                        fullName,
                        getRandomLetters(10) + "@" + getRandomLetters(10) + ".com",
                        getRandomLettersDigits(12)
                    ),
                    new UserAddress(
                        "st. " + getRandomLetters(10) + " - " + getRandomDigits(3),
                        getRandomCity(),
                        getRandomState(),
                        getRandomDigits(5),
                        "+1" + getRandomDigits(10)
                    )
                ));
            }
        } while (fullNamesSet.size() <= 5);

        return result.stream();
    }
}
