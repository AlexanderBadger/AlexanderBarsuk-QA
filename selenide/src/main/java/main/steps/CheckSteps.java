package main.steps;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j;
import main.AllPages;
import main.pages.CatalogPage;
import main.pages.CoursePage;
import main.pages.EditProfilePage;

import static com.codeborne.selenide.Selenide.$x;
import static main.constants.LogMessages.BUTTON_SEARCH_LOG;
import static main.constants.LogMessages.CHECKING_PRESENCE_LOGIN_BUTTON_LOG;
import static main.constants.LogMessages.CHECK_ALL_LINKS_LOG;
import static main.constants.LogMessages.CHECK_ELEMENT_AFTER_SCROLLING_LOG;
import static main.constants.LogMessages.CHECK_NOTIFICATION_LOG;
import static main.constants.LogMessages.CHECK_POPUP_LOG;
import static main.constants.LogMessages.CHECK_VISIBILITY_AND_STYLES_OF_THE_BUTTON_LOG;
import static main.constants.LogMessages.TEXT_SEARCH_LOG;
import static main.constants.PathConstants.ENROLL_BUTTON_XPATH;
import static main.constants.PathConstants.VACANCY_XPATH;
import static main.constants.StringConstants.ALERT_TEXT;
import static main.constants.StringConstants.ELEMENT_IS_INVISIBLE;

@Log4j
public class CheckSteps {

    private final CatalogPage catalogPage = new CatalogPage();

    private final CoursePage coursePage = new CoursePage();

    private final EditProfilePage editProfilePage = new EditProfilePage();

    private final AllPages allPages = new AllPages();

    @Step("Проверяет наличие всплывающего окна")
    public void checkPopUp() {
        log.info(CHECK_POPUP_LOG);
        editProfilePage.shouldHavePopUp();
    }

    @Step("Прокручивает страницу к указанному элементу и проверяет его видимость")
    public void checkElementAfterScroll() {
        log.info(CHECK_ELEMENT_AFTER_SCROLLING_LOG);
        SelenideElement elementToCheck = $x(VACANCY_XPATH);
        catalogPage.scrollToElement(elementToCheck);
        if (!elementToCheck.isDisplayed()) {
            throw new AssertionError(ELEMENT_IS_INVISIBLE);
        }
    }

    @Step("Проверяет видимость кнопки поиска и её стили")
    public void checkStyleButton() {
        log.info(CHECK_VISIBILITY_AND_STYLES_OF_THE_BUTTON_LOG);
        catalogPage.verifySearchButtonVisible();
        catalogPage.verifyButtonStyles();
    }

    @Step("Проверяет наличие элемента с уведомлением")
    public void checkAlertElement() {
        log.info(CHECK_NOTIFICATION_LOG);
        catalogPage.shouldBeByText(ALERT_TEXT);
    }

    @Step("Проверяет все ссылки на странице")
    public void checkAllLinks() {
        log.info(CHECK_ALL_LINKS_LOG);
        catalogPage.checkAllLinks();
    }

    @Step("Проверяет видимость кнопки 'Записаться на курс'")
    public void checkEnrollButton() {
        log.info(BUTTON_SEARCH_LOG);
        allPages.waitForElement(ENROLL_BUTTON_XPATH);
        coursePage.verifyEnrollButton();
    }

    @Step("Проверяет наличие текста о бесплатном курсе")
    public void checkFreeText() {
        log.info(TEXT_SEARCH_LOG);
        coursePage.shouldHaveFreeNotice();
    }

    @Step("Проверяет наличие кнопки входа")
    public void checkButton() {
        log.info(CHECKING_PRESENCE_LOGIN_BUTTON_LOG);
        catalogPage.displayButton();
    }
}