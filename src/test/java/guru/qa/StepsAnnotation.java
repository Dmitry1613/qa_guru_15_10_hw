package guru.qa;

import com.codeborne.selenide.Condition;
import io.qameta.allure.*;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class StepsAnnotation {
    private static final String REPOSITORY = "qa_guru_15_10_allure_lesson";

    @Step("Открываем главную страницу")
    public void openMainPage() {
        open("https://github.com");
    }

    @Step("Вводим в поиск имя репозитория {REPOSITORY}")
    public void inputNameRepo() {
        $("[name = 'q']").setValue(REPOSITORY).pressEnter();
    }

    @Step("Кликаем по найденному результату")
    public void clickOnResult() {
        $(byText(REPOSITORY)).click();

    }

    @Step("Проверяем название кнопки Issue")
    public void checkResult() {
        $("#issues-tab").shouldHave(Condition.text("Issues"));
    }
}
