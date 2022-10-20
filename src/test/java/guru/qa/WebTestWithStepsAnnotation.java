package guru.qa;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class WebTestWithStepsAnnotation {

    private static final String REPOSITORY = "qa_guru_15_10_allure_lesson";
    StepsAnnotation steps = new StepsAnnotation();

    @Test
    @Feature("Issue в репозитории")
    @Story("Проверка Issue")
    @Owner("zhukovdk")
    @Severity(SeverityLevel.NORMAL)
    @Link(value = "Testing", url = "https://testing.github.com")
    @DisplayName("Проверка навзания кнопки Issue в репозитории")
    public void checkNameIssues() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        steps.openMainPage();
        steps.inputNameRepo();
        steps.clickOnResult();
        steps.checkResult();
    }
}
