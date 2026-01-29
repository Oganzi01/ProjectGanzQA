package com.ganz.tests;

import com.ganz.core.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;

public class LoginTests extends TestBase {

    @Test
    public void loginPositiveTest() {
        // Мы используем данные, которые точно есть в базе или были созданы
        app.getUserHelper().login("ganz@gmail.com", "Oleg1243");

        // Проверяем, что появилась кнопка Logout (значит, мы вошли)
        Assert.assertTrue(app.getUserHelper().isElementPresent(By.cssSelector(".ico-logout")));
    }
}