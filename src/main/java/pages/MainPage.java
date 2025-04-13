package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    // Методы для взаимодействия с элементами

    public void clickOrderButtonTop() {
        driver.findElement(By.xpath("//button[contains(@class, 'Header_Button') and text()='Заказать']")).click();
    }

    public void clickOrderButtonBottom() {
        WebElement button = driver.findElement(By.xpath("//button[contains(@class, 'Button_Button') and text()='Заказать']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", button);
        button.click();
    }

    public void clickFaqQuestion(int index) {
        WebElement question = driver.findElement(By.id("accordion__heading-" + index));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", question);
        question.click();
    }

    public String getFaqAnswer(int index) {
        return driver.findElement(By.id("accordion__panel-" + index)).getText();
    }

    public void clickScooterLogo() {
        driver.findElement(By.className("Header_Logo__23yGT")).click();
    }

    public void clickYandexLogo() {
        driver.findElement(By.className("Header_LogoYandex__3TSOI")).click();
    }
}