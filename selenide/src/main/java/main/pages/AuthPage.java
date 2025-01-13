package main.pages;

import static com.codeborne.selenide.Selenide.$x;
import static main.constants.PathConstants.LOGIN_FIELD_XPATH;
import static main.constants.PathConstants.LOGIN_FORM_BUTTON_XPATH;
import static main.constants.PathConstants.PASSWORD_FIELD_XPATH;

public class AuthPage {

    /**
     * Кликает на кнопку формы входа.
     */
    public void clickLoginFormButton() {
        $x(LOGIN_FORM_BUTTON_XPATH).click();
    }

    /**
     * Заполняет поле логина.
     *
     * @param login логин для ввода.
     */
    public void fillLoginField(String login) {
        $x(LOGIN_FIELD_XPATH).setValue(login);
    }

    /**
     * Заполняет поле пароля.
     *
     * @param password пароль для ввода.
     */
    public void fillPasswordField(String password) {
        $x(PASSWORD_FIELD_XPATH).setValue(password);
    }
}