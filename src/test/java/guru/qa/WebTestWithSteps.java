package guru.qa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class WebTestWithSteps {
    private static final String REPOSITORY = "qa_guru_15_10_allure_lesson";

    @Test
    public void checkNameIssues() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Открываем главную страницу", () -> {
            open("https://github.com");
        });
        step("Вводим имя репозитория в поиск", () -> {
            $("[name = 'q']").setValue(REPOSITORY).pressEnter();

        });
        step("Кликаем по найденному результату", () -> {
            $(byText(REPOSITORY)).click();
        });
        step("Проверяем название кнопки Issue", () -> {
            $("#issues-tab").shouldHave(Condition.text("Issues"));
        });
    }
}
