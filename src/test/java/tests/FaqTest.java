package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MainPage;

import java.time.Duration;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class FaqTest {
    private WebDriver driver;
    private MainPage mainPage;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        mainPage = new MainPage(driver);
    }

    @Test
    public void testFaqSection() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        // Проверяем все 8 вопросов
        for (int i = 0; i < 8; i++) {
            mainPage.clickFaqQuestion(i);
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.id("accordion__panel-" + i)));

            String answer = mainPage.getFaqAnswer(i);
            assertNotNull("Ответ на вопрос " + i + " не должен быть null", answer);
            assertFalse("Ответ на вопрос " + i + " не должен быть пустым", answer.isEmpty());
        }
    }

    @After
    public void teardown() {
        driver.quit();
    }
}