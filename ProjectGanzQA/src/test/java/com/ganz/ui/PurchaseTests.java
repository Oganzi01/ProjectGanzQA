package com.ganz.ui;

import com.ganz.core.TestBase;
import com.ganz.fw.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class PurchaseTests extends TestBase {

    Logger logger = LoggerFactory.getLogger(PurchaseTests.class);

    @Test
    public void registrationTest() {

        User user = new User("Ganz", "test" + System.currentTimeMillis() + "@test.com", "Password123!");

        logger.info("--- Шаг 1: Регистрация ---");
        app.getUser().clickOnRegistrationLink();


        app.getUser().fillRegistrationForm(user);
        app.getUser().clickOnRegistrationButton();
    }

    @Test(dependsOnMethods = "registrationTest")
    public void loginTest() {
        User user = new User("Ganz", "test@test.com", "Password123!");

        logger.info("--- Шаг 2: Авторизация ---");
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginForm(user);
        app.getUser().clickOnLoginButton();
    }

    @Test(dependsOnMethods = "loginTest")
    public void addItemsTest() {
        logger.info("--- Шаг 3 и 4: Покупки ---");
        app.getItem().openItemByUrl("https://demowebshop.tricentis.com/141-inch-laptop");
        app.getItem().addToCart();

        app.getItem().openItemByUrl("https://demowebshop.tricentis.com/blue-jeans");
        app.getItem().setQuantity("2");
        app.getItem().addToCart();
    }

    @Test(dependsOnMethods = "addItemsTest")
    public void cartVerificationTest() {
        logger.info("--- Шаг 5: Переход в корзину ---");
        app.getItem().openShoppingCart();
        app.getUser().takeScreenshot();
    }
}