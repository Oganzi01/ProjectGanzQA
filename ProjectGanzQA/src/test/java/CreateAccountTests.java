import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends BaseTest {

    @Test
    public void createAccountPositiveTest() {
        // Создаем объект-параметр (Parameter Object)
        User user = new User()
                .setFirstName("Oleg")
                .setLastName("Ganz")
                .setEmail("ganz" + System.currentTimeMillis() + "@gmail.com")
                .setPassword("Oleg1243");

        click(By.cssSelector(".ico-register"));
        click(By.cssSelector("#gender-male"));

        // Заполняем форму, извлекая данные из объекта
        type(By.cssSelector("#FirstName"), user.getFirstName());
        type(By.cssSelector("#LastName"), user.getLastName());
        type(By.cssSelector("#Email"), user.getEmail());
        type(By.cssSelector("#Password"), user.getPassword());
        type(By.cssSelector("#ConfirmPassword"), user.getPassword());

        click(By.cssSelector("#register-button"));

        // Проверка по тексту (Assertion)
        Assert.assertTrue(isElementPresent(By.xpath("//div[contains(text(),'Your registration completed')]")));
    }
}