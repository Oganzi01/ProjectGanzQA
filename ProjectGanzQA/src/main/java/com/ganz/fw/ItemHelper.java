package com.ganz.fw;

import com.ganz.core.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ItemHelper extends BaseHelper {
    public ItemHelper(WebDriver driver) {
        super(driver);
    }

    public void addItemToCart() {
        click(By.xpath("(//input[@value='Add to cart'])[2]"));
    }
}