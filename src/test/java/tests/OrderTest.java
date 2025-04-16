package tests;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.OrderPage;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class OrderTest extends BaseTest {
    private OrderPage orderPage;

    private final String name;
    private final String lastName;
    private final String address;
    private final String metro;
    private final String phone;
    private final String date;
    private final String period;
    private final String comment;
    private final String buttonType;

    public OrderTest(String name, String lastName, String address, String metro,
                     String phone, String date, String period, String comment, String buttonType) {
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.metro = metro;
        this.phone = phone;
        this.date = date;
        this.period = period;
        this.comment = comment;
        this.buttonType = buttonType;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {"Иван", "Иванов", "ул. Ленина, 1", "Черкизовская", "89991112233", "01.01.2023", "сутки", "Позвонить за час", "top"},
                {"Анна", "Петрова", "пр. Мира, 10", "Сокольники", "89994445566", "15.12.2022", "двое суток", "Не звонить", "bottom"}
        });
    }

    @Before
    public void initOrderPage() {
        orderPage = new OrderPage(driver);
    }

    @Test
    public void testOrderFlow() {
        if ("top".equals(buttonType)) {
            mainPage.clickOrderButtonTop();
        } else {
            mainPage.clickOrderButtonBottom();
        }

        orderPage.fillFirstStep(name, lastName, address, metro, phone);
        orderPage.fillSecondStep(date, period, comment);
        orderPage.confirmOrder();

        assertTrue("Не удалось оформить заказ (обнаружен баг)",
                orderPage.isSuccessModalDisplayed());
    }
}