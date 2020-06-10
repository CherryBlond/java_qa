package com.geekbrains.selenium.start;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {
    protected WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters("browser")
    public void beforeMethod(@Optional(value = "chrome") String browser) {
        if ("firefox".equals(browser)) {
            driver = new FirefoxDriver();
        } else if ("chrome".equals(browser)) {
            driver = new ChromeDriver();
        } else {
            driver = null;
            throw new RuntimeException("unknown browser");
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void afterMethod() {
        if (driver != null) {
            driver.quit();
        }
    }

    protected static String getRandomFirstName() {
        return FIRST_NAMES[(int) (Math.random() * FIRST_NAMES.length)];
    }

    protected static String getRandomLastName() {
        return LAST_NAMES[(int) (Math.random() * LAST_NAMES.length)];
    }

    protected static String getRandomCity() {
        return CITIES[(int) (Math.random() * CITIES.length)];
    }

    protected static String getRandomState() {
        return STATES[(int) (Math.random() * STATES.length)];
    }

    protected static String getRandomDigits(int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            int index = (int) (Math.random() * DIGITS.length());
            sb.append(DIGITS.charAt(index));
        }
        return sb.toString();
    }

    protected static String getRandomLetters(int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            int index = (int) (Math.random() * LETTERS.length());
            sb.append(LETTERS.charAt(index));
        }
        return sb.toString();
    }

    protected static String getRandomLettersDigits(int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            int index = (int) (Math.random() * LETTERS_DIGITS.length());
            sb.append(LETTERS_DIGITS.charAt(index));
        }
        return sb.toString();
    }

    protected static String[] FIRST_NAMES = new String[] {
        "Max", "Mary", "Ivan", "Lola", "Santa", "Roma", "Elena", "Black", "Brown", "Zola", "Pete", "John"
    };

    protected static String[] LAST_NAMES = new String[] {
        "Turner", "Byrd", "Knight", "Patel", "Bolton", "Ward", "Ryan", "Guerrero", "Vaughan", "Rodgers", "Kaprio"
    };

    protected static String[] CITIES = new String[] {
        "New York", "Los Angeles", "Chicago", "Houston", "Phoenix", "Philadelphia", "San Antonio", "San Diego", "Dallas", "San Jose", "Austin", "Jacksonville", "Fort Worth", "Columbus", "Charlotte", "San Francisco", "Indianapolis"
    };

    protected static String[] STATES = new String[] {
        "Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut", "Delaware", "District of Columbia", "Florida", "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Puerto Rico", "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "US Virgin Islands", "Utah", "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming"
    };

    protected static String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    protected static String DIGITS = "0123456789";
    protected static String LETTERS_DIGITS = LETTERS + DIGITS;
}
