package com.ganz.core;

import com.ganz.fw.UserHelper;
import com.ganz.fw.ItemHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
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
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        }

        driver.manage().window().maximize();
        // Глобальное ожидание элементов
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