package main.steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j;
import main.AllPages;
import main.pages.CatalogPage;
import main.pages.EditProfilePage;

import static main.constants.LogMessages.CHANGE_DATA_AND_SAVING_LOG;
import static main.constants.PathConstants.SAVE_XPATH;
import static main.constants.StringConstants.ABOUT_MYSELF_TEXT_FREE;

@Log4j
public class EditProfileSteps {

    private final CatalogPage catalogPage = new CatalogPage();

    private final EditProfilePage editProfilePage = new EditProfilePage();

    private final AllPages allPages = new AllPages();

    @Step("Изменяет данные о себе и сохраняет изменения")
    public void changeDataAndSave() {
        log.info(CHANGE_DATA_AND_SAVING_LOG);
        editProfilePage.fillAboutField(ABOUT_MYSELF_TEXT_FREE);
        allPages.waitForElement(SAVE_XPATH);
        catalogPage.clickOn(SAVE_XPATH);
    }
}