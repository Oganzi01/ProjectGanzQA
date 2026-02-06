package com.ganz.fw;

import com.ganz.core.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ItemHelper extends BaseHelper {
    public ItemHelper(WebDriver driver) {
        super(driver);
    }

    public void openItemByUrl(String itemUrl) {
        driver.get(itemUrl);
       
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void addToCart() {
        click(By.cssSelector(".add-to-cart-button"));
    }

    public void setQuantity(String qty) {
        type(By.className("qty-input"), qty);
    }

    public void openShoppingCart() {
        click(By.className("ico-cart"));
    }
}
