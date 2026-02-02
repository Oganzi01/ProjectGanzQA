package com.ganz.core;

import com.ganz.fw.UserHelper;
import com.ganz.fw.ItemHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import java.time.Duration;

public class ApplicationManager {
    public WebDriver driver;
    protected String browser;
    protected UserHelper userHelper;
    protected ItemHelper itemHelper;

    public ApplicationManager(String browser) {
        this.browser = (browser != null) ? browser : "chrome";
    }

    public void init() {
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless"); // Запуск без графического окна
            options.addArguments("--no-sandbox"); // Нужно для работы в Docker/Linux
            options.addArguments("--disable-dev-shm-usage"); // Решает проблему нехватки памяти в контейнере
            options.addArguments("--window-size=1920,1080"); // Задаем размер окна, так как GUI нет
            driver = new ChromeDriver(options);

        } else if (browser.equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--headless");
            driver = new FirefoxDriver(options);

        } else if (browser.equalsIgnoreCase("edge")) {
            EdgeOptions options = new EdgeOptions();
            options.addArguments("--headless");
            driver = new EdgeDriver(options);
        }

        // В headless-режиме лучше не использовать maximize(),
        // размер окна мы уже задали выше в настройках ChromeOptions
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demowebshop.tricentis.com/");

        userHelper = new UserHelper(driver);
        itemHelper = new ItemHelper(driver);
    }

    public void stop() {
        if (driver != null) {
            driver.quit();
        }
    }

    public UserHelper getUser() { return userHelper; }
    public ItemHelper getItem() { return itemHelper; }
}