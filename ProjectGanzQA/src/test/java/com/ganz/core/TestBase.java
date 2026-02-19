package com.ganz.core;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    protected final ApplicationManager app = new ApplicationManager();

    @BeforeMethod
    public void setUp() {
        // Запуск инициализации браузера перед каждым тестом
        app.init();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        // Закрытие браузера после теста
        app.stop();
    }
}