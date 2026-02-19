package com.ganz.core;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    protected final ApplicationManager app = new ApplicationManager();

    @BeforeMethod
    public void setUp() {

        app.init();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        app.stop();
    }
}