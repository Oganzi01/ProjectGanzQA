package com.ganz.core;

import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    protected static ApplicationManager app = new ApplicationManager();
    // Объявляем логгер здесь, чтобы он был доступен во всех тестах
    protected static Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();

        // Настройки для стабильной работы в Docker (Jenkins)
        options.addArguments("--headless");                // Без окна
        options.addArguments("--no-sandbox");               // Пропуск ограничений Linux
        options.addArguments("--disable-dev-shm-usage");    // Использование системной памяти
        options.addArguments("--window-size=1920,1080");    // Фиксированный размер экрана

        app.init("chrome", options);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        app.stop();
    }
}