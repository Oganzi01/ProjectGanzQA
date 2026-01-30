package com.ganz.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    protected final ApplicationManager app = new ApplicationManager(System.getProperty("browser", "chrome"));
    protected Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeMethod
    public void setUp() {
        app.init();
        // Теперь переходим на главную через app
        app.driver.get("https://demowebshop.tricentis.com/");
    }

    @AfterMethod(enabled = true)
    public void tearDown() {
        app.stop();
    }
}