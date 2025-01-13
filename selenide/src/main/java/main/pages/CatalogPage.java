package main.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.extern.log4j.Log4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import java.io.IOException;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static main.constants.IntegerConstants.STATUS_CODE;
import static main.constants.PathConstants.ALERT_XPATH;
import static main.constants.PathConstants.CHECKBOX_FREE_XPATH;
import static main.constants.PathConstants.COURSE_CARD_SELECTOR;
import static main.constants.PathConstants.FIND_BUTTON_XPATH;
import static main.constants.PathConstants.LOGIN_BUTTON_XPATH;
import static main.constants.PathConstants.SEARCH_FIELD_XPATH;
import static main.constants.StringConstants.ALL_LINKS_SELECTOR;
import static main.constants.StringConstants.BACKGROUND_COLOR;
import static main.constants.StringConstants.COLOR;
import static main.constants.StringConstants.EXPECTED_BACKGROUND_COLOR;
import static main.constants.StringConstants.EXPECTED_COLOR;
import static main.constants.StringConstants.LINK_ATTRIBUTE;
import static main.constants.StringConstants.LINK_CHECK_ERROR;
import static main.constants.StringConstants.LINK_NOT_VALID;
import static main.constants.StringConstants.LINK_VALID_AND_STATUS_CODE;

/**
 * Страница Catalog сайта 'https://stepik.org/catalog'
 */
@Log4j
public class CatalogPage {

    /**
     * Проверяет, что кнопка входа видима на странице.
     */
    public void displayButton() {
        $x(LOGIN_BUTTON_XPATH).shouldBe(Condition.visible);
    }

    /**
     * Кликает на кнопку входа.
     */
    public void clickLoginButton() {
        $x(LOGIN_BUTTON_XPATH).click();
    }

    /**
     * Вводит строку поиска и отправляет её.
     *
     * @param searchString строка для поиска.
     */
    public void searchAndEnter(String searchString) {
        $x(SEARCH_FIELD_XPATH).setValue(searchString);
        $x(SEARCH_FIELD_XPATH).sendKeys(Keys.ENTER);
    }

    /**
     * Проверяет, что результат поиска не пустой
     */
    public void nonEmptySearchResult() {
        $(COURSE_CARD_SELECTOR).shouldNotBe(Condition.empty);
    }

    /**
     * Вводит строку поиска в текстовое поле.
     *
     * @param searchString строка для поиска.
     */
    public void search(String searchString) {
        $x(SEARCH_FIELD_XPATH).setValue(searchString);
        $x(SEARCH_FIELD_XPATH).sendKeys(Keys.ENTER);
    }

    /**
     * Кликает на чекбокс "Бесплатно".
     */
    public void clickCheckBoxFree() {
        $(byText(CHECKBOX_FREE_XPATH)).click();
    }

    /**
     * Проверяет наличие элемента с заданным текстом.
     *
     * @param string текст, который должен быть у элемента.
     */
    public void shouldBeByText(String string) {
        $x(ALERT_XPATH).shouldBe(text(string));
    }

    /**
     * Кликает на элемент по заданному XPath.
     *
     * @param path XPath к элементу.
     */
    public void clickOn(String path) {
        $x(path).click();
    }

    /**
     * Кликает на модальное окно по заданному тексту.
     *
     * @param path текст элемента для клика.
     */
    public void clickOnModal(String path) {
        $(byText(path)).click();
    }

    /**
     * Проверяет, что кнопка поиска видима.
     */
    public void verifySearchButtonVisible() {
        $(FIND_BUTTON_XPATH).shouldBe(Condition.visible);
    }

    /**
     * Проверяет стили кнопки поиска.
     */
    public void verifyButtonStyles() {
        // Проверка цвета фона кнопки
        $(FIND_BUTTON_XPATH).shouldHave(Condition.cssValue(BACKGROUND_COLOR, EXPECTED_BACKGROUND_COLOR));
        // Проверка цвета текста кнопки
        $(FIND_BUTTON_XPATH).shouldHave(Condition.cssValue(COLOR, EXPECTED_COLOR));
    }

    /**
     * Проверяет все ссылки на странице и выводит их статус.
     */
    public void checkAllLinks() {
        // Получаем все ссылки на странице
        ElementsCollection links = $$(ALL_LINKS_SELECTOR);
        for (int i = 0; i < links.size(); i++) {
            // Получаем элемент заново в каждой итерации
            SelenideElement link = links.get(i);
            String url = link.getAttribute(LINK_ATTRIBUTE);
            assert url != null;
            if (!url.isEmpty()) {
                try {
                    // Проверяем статус код ссылки
                    int statusCode = getStatusCode(url);
                    if (statusCode == STATUS_CODE) {
                        log.info(LINK_NOT_VALID + url);
                    } else {
                        log.info(String.format(LINK_VALID_AND_STATUS_CODE, url, statusCode));
                    }
                } catch (IOException e) {
                    log.error(LINK_CHECK_ERROR + url);
                }
            }
        }
    }

    /**
     * Получает статус код HTTP для заданного URL.
     *
     * @param url URL для проверки статуса.
     * @return статус код ответа HTTP.
     * @throws IOException если произошла ошибка при подключении к URL.
     */
    private int getStatusCode(String url) throws IOException {
        Document doc = Jsoup.connect(url).execute().parse();
        return doc.connection().response().statusCode();
    }

    /**
     * Прокручивает страницу до указанного элемента.
     *
     * @param element элемент, до которого нужно прокрутить.
     */
    public void scrollToElement(SelenideElement element) {
        element.scrollIntoView(true);
    }

    /**
     * Переключает фокус WebDriver на вторую вкладку в браузере.
     * <p>
     * Этот метод получает текущий экземпляр WebDriver и переключается на
     * второе окно/вкладку, которое открыто. Предполагается, что открыто
     * как минимум две вкладки; в противном случае может быть выброшено
     * исключение.
     * </p>
     *
     * @throws NoSuchWindowException если открыто менее двух окон.
     * @throws WebDriverException    если не удается переключиться на окно.
     */
    public static void goToSecondTab() {
        WebDriver driver = getWebDriver();
        String handle = driver.getWindowHandles().toArray()[1]
                .toString();
        driver.switchTo().window(handle);
    }
}