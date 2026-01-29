package com.ganz.fw;

import com.ganz.core.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends BaseHelper {
    public UserHelper(WebDriver driver) {
        super(driver);
    }

    public void fillRegistrationForm(User user) {
        type(By.id("FirstName"), user.getFirstName());
        type(By.id("LastName"), user.getLastName());
        type(By.id("Email"), user.getEmail());
        type(By.id("Password"), user.getPassword());
        type(By.id("ConfirmPassword"), user.getPassword());
    }

    public void login(String email, String password) {
        click(By.cssSelector(".ico-login"));
        type(By.id("Email"), email);
        type(By.id("Password"), password);
        click(By.cssSelector(".login-button"));
    }
}