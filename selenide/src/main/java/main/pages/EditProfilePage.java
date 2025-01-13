package main.pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$x;
import static main.constants.PathConstants.ABOUT_FIELD_XPATH;
import static main.constants.PathConstants.POPUP_XPATH;

public class EditProfilePage {

    /**
     * Заполняеm string текст для поля "О себе".
     */
    public void fillAboutField(String string) {
        $x(ABOUT_FIELD_XPATH).setValue(string);
    }

    /**
     * Проверяет, что всплывающее окно видимо.
     */
    public void shouldHavePopUp() {
        $x(POPUP_XPATH).shouldBe(Condition.visible);
    }
}