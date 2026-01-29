import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends BaseTest {

    @Test
    public void createAccountPositiveTest() {
        // 1. Нажимаем на Register
        click(By.cssSelector(".ico-register"));

        // 2. Выбираем пол (Gender)
        click(By.cssSelector("#gender-male"));

        // 3. Заполняем данные (используем наш метод type)
        type(By.cssSelector("#FirstName"), "Oleg");
        type(By.cssSelector("#LastName"), "Ganz");

        // ВАЖНО: Email должен быть уникальным.
        // Добавим число к твоему email, чтобы тест можно было запускать много раз
        String email = "ganz" + System.currentTimeMillis() + "@gmail.com";
        type(By.cssSelector("#Email"), email);

        type(By.cssSelector("#Password"), "Oleg1243");
        type(By.cssSelector("#ConfirmPassword"), "Oleg1243");

        // 4. Жмем кнопку регистрации
        click(By.cssSelector("#register-button"));

        // 5. Assert (Проверка TestNG)
        // Проверяем, что на странице есть текст о завершении регистрации
        Assert.assertTrue(isElementPresent(By.xpath("//div[contains(text(),'Your registration completed')]")));

        System.out.println("Аккаунт создан: " + email);
    }
}
