package main.steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j;
import main.RandomDataGenerator;
import main.pages.AuthPage;
import main.pages.CatalogPage;

import static main.constants.LogMessages.LOGIN_LOG;
import static main.constants.LogMessages.LOGIN_WITH_RANDOM_DATA_LOG;
import static main.constants.StringConstants.LOGIN;
import static main.constants.StringConstants.PASSWORD;

@Log4j
public class AuthSteps {

    private final CatalogPage catalogPage = new CatalogPage();
    private final AuthPage authPage = new AuthPage();

    @Step("Выполняет вход в систему с заданными данными")
    public void login() {
        log.info(LOGIN_LOG);
        catalogPage.clickLoginButton();
        authPage.fillLoginField(LOGIN);
        authPage.fillPasswordField(PASSWORD);
        authPage.clickLoginFormButton();
    }

    @Step("Выполняет вход в систему со случайными данными")
    public void loginWithRandomData() {
        log.info(LOGIN_WITH_RANDOM_DATA_LOG);
        catalogPage.clickLoginButton();
        authPage.fillLoginField(RandomDataGenerator.generateRandomEmail());
        authPage.fillPasswordField(RandomDataGenerator.generateRandomPassword());
        authPage.clickLoginFormButton();
    }
}