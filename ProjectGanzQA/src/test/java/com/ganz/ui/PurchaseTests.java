package com.ganz.ui;

import com.ganz.core.TestBase;
import com.ganz.fw.User;
import org.testng.annotations.Test;

public class PurchaseTests extends TestBase {

    
    User user = new User();

    @Test(priority = 1)
    public void registrationTest() {
        logger.info("--- Шаг 1: Регистрация ---");
        app.getUser().clickOnRegistrationLink();
        app.getUser().fillRegistrationForm(user);
        app.getUser().clickOnRegistrationButton();
    }

    @Test(priority = 2, dependsOnMethods = "registrationTest")
    public void loginTest() {
        logger.info("--- Шаг 2: Авторизация ---");
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginForm(user);
        app.getUser().clickOnLoginButton();
    }

    @Test(priority = 3, dependsOnMethods = "loginTest")
    public void addItemsTest() {
        logger.info("--- Шаг 3 и 4: Покупки ---");
        app.getItem().openItemByUrl("https://demowebshop.tricentis.com/141-inch-laptop");
        app.getItem().addToCart();

        app.getItem().openItemByUrl("https://demowebshop.tricentis.com/blue-jeans");
        app.getItem().setQuantity("2");
        app.getItem().addToCart();
    }

    @Test(priority = 4, dependsOnMethods = "addItemsTest")
    public void cartVerificationTest() {
        logger.info("--- Шаг 5: Переход в корзину ---");
        app.getItem().openShoppingCart();
        app.getUser().takeScreenshot();
    }
}
