package com.geekbrains.selenium.start;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {
    protected ChromeDriver chromeDriver;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();

        chromeDriver = new ChromeDriver();
        chromeDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterEach
    public void tearDown() {
        chromeDriver.quit();
    }
}
