package com.ganz.fw;

import com.ganz.core.BaseHelper; // ЭТА СТРОКА УБЕРЕТ КРАСНЫЙ ЦВЕТ
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartTests extends BaseHelper {

    public CartTests(WebDriver driver) {
        super(driver);
    }

    public void openItemByUrl(String itemUrl) {
        driver.get(itemUrl);
    }

    public void addToCart() {
        click(By.cssSelector(".add-to-cart-button"));
    }

    public void addToCartGeneral() {
        addToCart();
    }

    public void setQuantity(String qty) {
        type(By.className("qty-input"), qty);
    }

    public void openCart() {
        click(By.className("ico-cart"));
    }

    public void openShoppingCart() {
        openCart();
    }
}