package main.pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static main.constants.PathConstants.ENROLL_BUTTON_XPATH;
import static main.constants.StringConstants.TEXT_FREE;

public class CoursePage {

    /**
     * Проверяет наличие кнопки "Поступить на курс".
     */
    public void verifyEnrollButton() {
        $x(ENROLL_BUTTON_XPATH).shouldBe(exist);
    }

    /**
     * Проверяет, что элемент с уведомлением о бесплатном курсе видим.
     */
    public void shouldHaveFreeNotice() {
        $(byText(TEXT_FREE)).shouldBe(Condition.visible);
    }
}