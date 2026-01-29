package com.ganz.core;

import org.openqa.selenium.remote.Browser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    // Читаем браузер из консоли, если не указан — берем Chrome по умолчанию
    protected final ApplicationManager app = new ApplicationManager(
            System.getProperty("browser", Browser.CHROME.browserName())
    );

    @BeforeMethod
    public void setUp() {
        app.init();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        app.stop();
    }
}