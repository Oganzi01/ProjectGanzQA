import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class HomePageTests extends BaseTest {

    @Test
    public void findElementsStandardTest() {
        System.out.println("Запуск: Стандартные локаторы (ID, Class)...");
        driver.findElement(By.id("small-searchterms"));
        driver.findElement(By.className("header-logo"));
        System.out.println("Стандартные локаторы — OK.");
    }

    @Test
    public void findElementsCssTest() {
        System.out.println("Запуск: CSS Selectors...");
        driver.findElement(By.cssSelector("#small-searchterms"));
        driver.findElement(By.cssSelector(".header-logo"));
        System.out.println("CSS — OK.");
    }

    @Test
    public void findElementsXpathTest() {
        System.out.println("Запуск: xPath...");

        // Поиск по ID через xPath
        driver.findElement(By.xpath("//*[@id='small-searchterms']"));

        // Поиск по Классу через xPath
        driver.findElement(By.xpath("//*[@class='header-logo']"));

        // Поиск по Тексту ссылки (очень полезно!)
        driver.findElement(By.xpath("//a[contains(text(),'Log in')]"));

        System.out.println("xPath — OK.");
    }
}
