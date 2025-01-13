package main.steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j;
import main.AllPages;
import main.pages.CatalogPage;

import static main.constants.LogMessages.CHECK_TRANSITION_TO_SETTINGS_LOG;
import static main.constants.LogMessages.CLICK_ON_CHECKBOX_LOG;
import static main.constants.LogMessages.JAVA_COURSE_SEARCH_LOG;
import static main.constants.LogMessages.PYTHON_FREE_COURSE_SEARCH_LOG;
import static main.constants.PathConstants.NAVBAR_PROFILE_XPATH;
import static main.constants.PathConstants.PYTHON_XPATH;
import static main.constants.PathConstants.SETTINGS_XPATH;
import static main.constants.StringConstants.JAVA_TEXT;
import static main.constants.StringConstants.MODAL_FIELD_TEXT_FREE;
import static main.constants.StringConstants.PYTHON_TEXT;
import static main.pages.CatalogPage.goToSecondTab;

/**
 * Класс для представления шагов взаимодействия с каталогом.
 */
@Log4j
public class CatalogSteps {

    private final CatalogPage catalogPage = new CatalogPage();

    private final AllPages allPages = new AllPages();

    @Step("Ищет курс по программированию на Java")
    public void searchJava() {
        log.info(JAVA_COURSE_SEARCH_LOG);
        catalogPage.searchAndEnter(JAVA_TEXT);
        catalogPage.nonEmptySearchResult();
    }

    @Step("Находит бесплатный курс по Python, устанавливает соответствующий чекбокс")
    public void clickOnCheckbox() {
        log.info(CLICK_ON_CHECKBOX_LOG);
        catalogPage.clickCheckBoxFree();
    }

    @Step("Ищет бесплатный курс по Python на странице каталога")
    public void findFreeCoursePython() {
        log.info(PYTHON_FREE_COURSE_SEARCH_LOG);
        catalogPage.search(PYTHON_TEXT);
        allPages.waitForElement(PYTHON_XPATH);
        catalogPage.clickOn(PYTHON_XPATH);
        goToSecondTab();
    }

    @Step("Переходит в настройки профиля")
    public void stepsFromSettings() {
        log.info(CHECK_TRANSITION_TO_SETTINGS_LOG);
        catalogPage.clickOnModal(MODAL_FIELD_TEXT_FREE);
        catalogPage.clickOn(NAVBAR_PROFILE_XPATH);
        catalogPage.clickOn(SETTINGS_XPATH);
    }
}