import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
public class CreateUserTest {

    @Test
    @DisplayName("Задача 2.1 Создаем пользователя, получаем токен, удаляем пользователя")
    public void addUserTest() {
        User testUser = RequestSteps.createUser();
        RequestSteps.obtainAuthenticationToken(testUser);
        RequestSteps.userDelete(testUser);
    }
}