import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import java.util.List;


public class FirstTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.google.by/");
        driver.findElement(By.name("q")).sendKeys("iTechArt" + Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement firstResult = wait.until(presenceOfElementLocated(By.cssSelector("h3")));
        var resultText = firstResult.getAttribute("textContent");
        var pageTitle = driver.getTitle();

        if (pageTitle.contains("iTechArt") && resultText.contains("iTechArt"))
        {
            System.out.println("Заголовок вкладки: " + pageTitle);
            System.out.println("Первый результат: " + resultText);
            driver.quit();
        }
        else
        {
            System.out.println("Error");
            driver.quit();
            System.exit(-1);
        }


    }
}

