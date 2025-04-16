package tests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MainPage;
import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected MainPage mainPage;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().window().maximize();
        mainPage = new MainPage(driver);
        mainPage.open();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}