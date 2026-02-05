package com.ganz.core;
import com.ganz.fw.ItemHelper;
import com.ganz.fw.UserHelper;
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
    UserHelper userHelper;
    ItemHelper itemHelper;

    public void init(String browser, Object options) {
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver((ChromeOptions) options);
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver((FirefoxOptions) options);
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver((EdgeOptions) options);
        }

        if (driver != null) {
            driver.get("https://demowebshop.tricentis.com/");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

            userHelper = new UserHelper(driver);
            itemHelper = new ItemHelper(driver);
        }
    }

    public void stop() {
        if (driver != null) {
            driver.quit();
        }
    }

    public UserHelper getUser() {
        return userHelper;
    }

    public ItemHelper getItem() {
        return itemHelper;
    }
}