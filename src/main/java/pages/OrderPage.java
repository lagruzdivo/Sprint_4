package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage {
    private final WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    // Методы для заполнения формы

    public void fillFirstStep(String name, String lastName, String address, String metro, String phone) {
        driver.findElement(By.xpath("//input[@placeholder='* Имя']")).sendKeys(name);
        driver.findElement(By.xpath("//input[@placeholder='* Фамилия']")).sendKeys(lastName);
        driver.findElement(By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']")).sendKeys(address);
        driver.findElement(By.xpath("//input[@placeholder='* Станция метро']")).sendKeys(metro);
        driver.findElement(By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']")).sendKeys(phone);
        driver.findElement(By.xpath("//button[text()='Далее']")).click();
    }

    public void fillSecondStep(String date, String period, String comment) {
        driver.findElement(By.xpath("//input[@placeholder='* Когда привезти самокат']")).sendKeys(date);
        driver.findElement(By.className("Dropdown-placeholder")).click();
        driver.findElement(By.xpath("//div[text()='" + period + "']")).click();
        driver.findElement(By.xpath("//input[@placeholder='Комментарий для курьера']")).sendKeys(comment);
        driver.findElement(By.xpath("//button[text()='Заказать']")).click();
    }

    public void confirmOrder() {
        driver.findElement(By.xpath("//button[text()='Да']")).click();
    }

    public boolean isSuccessModalDisplayed() {
        return driver.findElement(By.className("Order_ModalHeader__3FDaJ")).isDisplayed();
    }
}