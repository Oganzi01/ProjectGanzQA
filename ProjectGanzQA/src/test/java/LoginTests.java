import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test
    public void loginWithValidDataTest() {
        System.out.println("Запуск теста логина...");

        // Кликаем на Login в шапке
        driver.findElement(By.cssSelector(".ico-login")).click();

        // Заполняем Email
        WebElement emailField = driver.findElement(By.cssSelector("#Email"));
        emailField.sendKeys("ganz@gmail.com");

        // Заполняем Пароль
        WebElement passwordField = driver.findElement(By.cssSelector("#Password"));
        passwordField.sendKeys("Oleg1243");

        // Жмем кнопку Login
        driver.findElement(By.cssSelector(".button-1.login-button")).click();

        // Проверяем, что видим твой email в аккаунте
        WebElement accountEmail = driver.findElement(By.cssSelector(".header-links .account"));
        System.out.println("Успешный вход под: " + accountEmail.getText());
    }
}
