package guru.qa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebTestSelenide {
    private static final String REPOSITORY = "qa_guru_15_10_allure_lesson";

    @Test
    public void checkNameIssues() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");
        $("[name = 'q']").setValue(REPOSITORY).pressEnter();
        $(byText(REPOSITORY)).click();
        $("#issues-tab").shouldHave(Condition.text("Issues"));
    }
}
