import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
public class UpdateUserTest {
    static User testUser = new User();

    @BeforeEach
    void userSignUp() {
        testUser = RequestSteps.createRandomUser();
    }

    @AfterEach
    void deleteUser() {
        if (testUser.isSavedInDB()) {
            RequestSteps.userDelete(testUser);
        } else {
            RequestSteps.logUserNotExists(testUser);
        }
    }

    @Test
    @DisplayName("Изменение пароля")
    public void updatePasswordTest() {
        log.info("Задача 4: Проверить, что в ответе на запрос PUT значение определенного поля было изменено");
        String newPassword = User.randomPassword();
        RequestSteps.passUpdate(testUser, newPassword);
        log.info("Пароль был изменен на '" + newPassword + "'");
        log.info("Задача 5: Проверить, что в ответе на запрос GET значение определенного поля "
                + "равно ожидаемому значению");
        log.info("Получение информации о пользователе '" + testUser.getUsername() + "'");
        RequestSteps.verifyPasswordUpdate(testUser, newPassword);
    }

    @Test
    @DisplayName("Удаление пользователя")
    public void deleteUserTest() {
        log.info("Задача 6: Проверить, что в ответе на запрос DELETE статус код равен ожидаемому значению");
        RequestSteps.userDelete(testUser);
    }
}