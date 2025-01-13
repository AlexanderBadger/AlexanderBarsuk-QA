import main.steps.AuthSteps;
import main.steps.CatalogSteps;
import main.steps.CheckSteps;
import main.steps.EditProfileSteps;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StepikTest extends BaseTest {

    CatalogSteps catalogSteps = new CatalogSteps();
    CheckSteps checkSteps = new CheckSteps();
    AuthSteps authSteps = new AuthSteps();
    EditProfileSteps editProfileSteps = new EditProfileSteps();

    @Test
    @Order(1)
    @DisplayName("Тест 1. Открывает браузер, загружает 'https://stepik.org/catalog' "
            + "и проверяет наличие кнопки 'Войти' на странице.")
    public void loginButtonTest() {
        checkSteps.checkButton();
    }

    @Test
    @Order(2)
    @DisplayName("Тест 2. Проверяет, что текст 'Бесплатно' и кнопка 'Поступить на курс'"
            + " присутствует на странице после выполнения некоторых действий: "
            + "на странице 'https:stepik.org/catalog' кликнуть чек-бокс 'Бесплатные', кликнуть на ссылку с текстом: "
            + "'питон в простых и очень простых задачах'")
    public void testFreeCourseAvailability() {
        catalogSteps.clickOnCheckbox();
        catalogSteps.findFreeCoursePython();
        checkSteps.checkFreeText();
        checkSteps.checkEnrollButton();
    }

    @Test
    @Order(3)
    @DisplayName("Тест 3. Вводит текст 'Java' в поле поиска на веб-странице, нажимает кнопку 'Искать' "
            + "и проверяет, что результат соответствует ожидаемому.")
    public void searchTest() {
        catalogSteps.searchJava();
    }

    @Test
    @Order(4)
    @DisplayName("Тест 4. Выполняет клик по кнопке 'Войти' на странице проверяет, "
            + "что пользователь перенаправлен на страницу авторизации." +
            "Водит в соответствующие поля логи и пароль, нажимает кнопку 'Войти' и происходит авторизация")
    public void clickAndAuthTest() {
        authSteps.login();
    }

    @Test
    @Order(5)
    @DisplayName("Тест 5. Проверяет, что все ссылки на веб-странице 'https://stepik.org/catalog' "
            + "являются действительными (не ведут на ошибку 404)")
    public void validLinksTest() {
        checkSteps.checkAllLinks();
    }

    @Test
    @Order(6)
    @DisplayName("Тест 6. Заполняет форму на веб-странице с авторизацией "
            + "с использованием случайно сгенерированных данных и при нажатии на кнопку 'Войти' "
            + "появляется сообщение об  ошибке: 'E-mail адрес и/или пароль не верны'.")
    public void errorMessageTest() {
        authSteps.loginWithRandomData();
        checkSteps.checkAlertElement();
    }

    @Test
    @Order(7)
    @DisplayName("Тест 7. Проверяет, что кнопка 'Искать' на веб-странице 'https://stepik.org/catalog' "
            + "отображается с определенными стилями (цвет, размер шрифта и т. д.).")
    public void buttonStyleTest() {
        checkSteps.checkStyleButton();
    }

    @Test
    @Order(8)
    @DisplayName("Тест 8. Проверяет, что определенный элемент на странице становится видимым "
            + "после прокрутки страницы.")
    public void visibleElementTest() {
        checkSteps.checkElementAfterScroll();
    }

    @Test
    @Order(9)
    @DisplayName("Тест 9. Проверяет, что  при изменении профиля на степике, "
            + "появляется всплывающее окно с сообщением об успешном изменении профиля")
    public void profileChangeTest() {
        authSteps.login();
        catalogSteps.stepsFromSettings();
        editProfileSteps.changeDataAndSave();
        checkSteps.checkPopUp();
    }
}