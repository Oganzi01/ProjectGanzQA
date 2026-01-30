package com.ganz.ui;

import com.ganz.core.TestBase;
import com.ganz.fw.User;
import org.testng.annotations.Test;

public class PurchaseTests extends TestBase {

    @Test
    public void fullPurchaseFlowTest() {
        User user = new User();

        logger.info("--- Шаг 1: Регистрация ---");
        app.getUser().clickOnRegistrationLink();
        app.getUser().fillRegistrationForm(user);
        app.getUser().clickOnRegistrationButton();

        logger.info("--- Шаг 2: Авторизация ---");
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginForm(user);
        app.getUser().clickOnLoginButton();

        logger.info("--- Шаг 3: Добавление ноутбука ---");
        // Прямой переход, чтобы кнопка Add to cart точно была на экране
        app.getItem().openItemByUrl("https://demowebshop.tricentis.com/141-inch-laptop");
        app.getItem().addToCart();

        logger.info("--- Шаг 4: Добавление джинсов ---");
        app.getItem().openItemByUrl("https://demowebshop.tricentis.com/blue-jeans");
        app.getItem().setQuantity("2");
        app.getItem().addToCart();

        logger.info("--- Шаг 5: Переход в корзину ---");
        app.getItem().openShoppingCart();

        app.getUser().takeScreenshot();
    }
}