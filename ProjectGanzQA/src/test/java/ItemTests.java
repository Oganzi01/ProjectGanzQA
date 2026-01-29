import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ItemTests extends BaseTest {

    @BeforeMethod
    public void ensurePrecondition() {
        // Шаг авторизации (предусловие)
        click(By.cssSelector(".ico-login"));
        type(By.cssSelector("#Email"), "ganz@gmail.com");
        type(By.cssSelector("#Password"), "Oleg1243");
        click(By.cssSelector(".login-button"));
    }

    @Test
    public void addItemToCartTest() {
        // 1. Кликаем на "Add to cart" у второго товара
        click(By.xpath("(//input[@value='Add to cart'])[2]"));

        // 2. ВАЖНО: Ждем, пока исчезнет уведомление, которое перекрывает экран
        try { Thread.sleep(4000); } catch (InterruptedException e) {}

        // 3. Кликаем на корзину
        click(By.cssSelector(".ico-cart"));

        // 4. Проверка добавления по названию товара (Assert по тексту)
        String productName = driver.findElement(By.cssSelector(".product-name")).getText();
        Assert.assertFalse(productName.isEmpty(), "Корзина пуста, товар не добавился!");

        System.out.println("Успешно добавлен товар: " + productName);
    }
}