package com.ganz.core;

import com.ganz.fw.ItemHelper;
import com.ganz.fw.UserHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;

public class ApplicationManager {
    public WebDriver driver;

    protected UserHelper userHelper;
    protected ItemHelper itemHelper;

    public void init() {
        ChromeOptions options = new ChromeOptions();

        // Настройки для Jenkins/Docker (Headless режим)
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--window-size=1920,1080");

        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demowebshop.tricentis.com/");


        userHelper = new UserHelper(driver);
        itemHelper = new ItemHelper(driver);
    }

    public UserHelper getUser() {
        return userHelper;
    }

    public ItemHelper getItem() {
        return itemHelper;
    }

    public void stop() {
        if (driver != null) {
            driver.quit();
        }
    }
}