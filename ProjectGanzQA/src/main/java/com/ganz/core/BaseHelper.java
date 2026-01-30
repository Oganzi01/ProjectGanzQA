package com.ganz.core;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BaseHelper {
    protected WebDriver driver;
    protected Logger logger = LoggerFactory.getLogger(BaseHelper.class);

    public BaseHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void click(By locator) {
        logger.info("Клик по элементу: " + locator);
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }

    public void type(By locator, String text) {
        if (text != null) {
            click(locator);
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);
        }
    }

    public void takeScreenshot() {
        // Делаем скриншот во временный файл
        File tmp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        // Создаем путь для сохранения
        File screenshot = new File("screenshots/screen-" + System.currentTimeMillis() + ".png");
        try {
            // Создаем папку, если её нет
            File screenshotDir = new File("screenshots");
            if (!screenshotDir.exists()) screenshotDir.mkdirs();

            // Копируем файл
            com.google.common.io.Files.copy(tmp, screenshot);
            logger.info("Скриншот сделан и сохранен: " + screenshot.getPath());
        } catch (IOException e) {
            logger.error("Ошибка при сохранении скриншота: " + e.getMessage());
        }
    }
}