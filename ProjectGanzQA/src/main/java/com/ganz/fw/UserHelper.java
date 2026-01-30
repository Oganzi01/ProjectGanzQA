package com.ganz.fw;

import com.ganz.core.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends BaseHelper {

    public UserHelper(WebDriver driver) {
        super(driver);
    }

    public void clickOnRegistrationLink() {
        click(By.className("ico-register"));
    }

    public void fillRegistrationForm(User user) {
        click(By.id("gender-male"));
        type(By.id("FirstName"), "Oleg");
        type(By.id("LastName"), "Ganz");
        type(By.id("Email"), user.getEmail());
        type(By.id("Password"), user.getPassword());
        type(By.id("ConfirmPassword"), user.getPassword());
    }

    public void clickOnRegistrationButton() {
        click(By.id("register-button"));
    }

    public void clickOnLoginLink() {
        click(By.className("ico-login"));
    }

    public void fillLoginForm(User user) {
        type(By.id("Email"), user.getEmail());
        type(By.id("Password"), user.getPassword());
    }

    public void clickOnLoginButton() {
        click(By.cssSelector(".login-button"));
    }
}
