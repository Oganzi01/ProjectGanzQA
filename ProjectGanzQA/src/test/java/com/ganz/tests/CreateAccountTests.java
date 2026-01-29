package com.ganz.tests;

import com.ganz.core.TestBase;
import com.ganz.fw.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    @Test
    public void createAccountPositiveTest() {
        User user = new User()
                .setFirstName("Oleg")
                .setLastName("Ganz")
                .setEmail("ganz" + System.currentTimeMillis() + "@gmail.com")
                .setPassword("Oleg1243");

        app.getUserHelper().click(By.cssSelector(".ico-register"));
        app.getUserHelper().click(By.cssSelector("#gender-male"));
        app.getUserHelper().fillRegistrationForm(user);
        app.getUserHelper().click(By.cssSelector("#register-button"));

        Assert.assertTrue(app.getUserHelper().isElementPresent(By.xpath("//div[@class='result' and contains(text(), 'Your registration completed')]")));
    }
}