import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    public WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demowebshop.tricentis.com/");
    }

    // Метод для клика
    public void click(By locator) {
        driver.findElement(locator).click();
    }

    // Метод для ввода текста (type)
    public void type(By locator, String text) {
        if (text != null) {
            WebElement element = driver.findElement(locator);
            element.clear();
            element.sendKeys(text);
        }
    }

    // Проверка наличия элемента (isElementPresent)
    public boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @AfterMethod(enabled = true) // можно поставить false, если хочешь, чтобы браузер не закрывался
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}