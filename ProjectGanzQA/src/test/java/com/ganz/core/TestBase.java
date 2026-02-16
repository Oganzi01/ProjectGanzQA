package com.ganz.core;

import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    protected static ApplicationManager app = new ApplicationManager();
    protected static Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeMethod
    public void setUp() {
        logger.info("Настройка ChromeOptions для запуска...");
        ChromeOptions options = new ChromeOptions();


        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");


        System.out.println("Аргументы Chrome: " + options.asMap().get("goog:chromeOptions"));

        app.init("chrome", options);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        app.stop();
    }
}
