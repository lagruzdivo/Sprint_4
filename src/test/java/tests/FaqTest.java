package tests;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class FaqTest extends BaseTest {
    @Test
    public void testFaqSection() {
        for (int i = 0; i < 8; i++) {
            mainPage.clickFaqQuestion(i);
            String answer = mainPage.getFaqAnswer(i);
            assertNotNull("Ответ на вопрос " + i + " не должен быть null", answer);
            assertFalse("Ответ на вопрос " + i + " не должен быть пустым", answer.isEmpty());
        }
    }
}