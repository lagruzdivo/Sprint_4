package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public static final String URL = "https://qa-scooter.praktikum-services.ru/";

    private final By orderButtonTop = By.xpath("//button[contains(@class, 'Header_Button') and text()='Заказать']");
    private final By orderButtonBottom = By.xpath("//button[contains(@class, 'Button_Button') and text()='Заказать']");
    private final String faqQuestionLocator = "accordion__heading-";
    private final String faqAnswerLocator = "accordion__panel-";
    private final By yandexLogo = By.className("Header_LogoYandex__3TSOI");
    private final By scooterLogo = By.className("Header_Logo__23yGT");

    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void open() {
        driver.get(URL);
    }

    public void clickOrderButtonTop() {
        wait.until(ExpectedConditions.elementToBeClickable(orderButtonTop)).click();
    }

    public void clickOrderButtonBottom() {
        WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(orderButtonBottom));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", button);
        button.click();
    }

    public void clickFaqQuestion(int index) {
        WebElement question = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(faqQuestionLocator + index)));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", question);
        question.click();
    }

    public String getFaqAnswer(int index) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(faqAnswerLocator + index))).getText();
    }

    public void clickScooterLogo() {
        wait.until(ExpectedConditions.elementToBeClickable(scooterLogo)).click();
    }

    public void clickYandexLogo() {
        wait.until(ExpectedConditions.elementToBeClickable(yandexLogo)).click();
    }
}