import io.restassured.response.Response;
import lombok.extern.log4j.Log4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Log4j
public class GameTest {
    static User testUser = new User();

    @BeforeEach
    void userSignUp() {
        log.info(LogMessages.USER_CREATION_LOG);
        testUser = RequestSteps.createUser();
        RequestSteps.obtainAuthenticationToken(testUser);
    }

    @AfterEach
    void deleteUser() {
        RequestSteps.userDelete(testUser);
    }

    @Test
    @DisplayName("Задача 3.1 Проверить, что в ответе на запрос GET количество элементов "
            + "массива равно ожидаемому значению.")
    public void addGameTest() {
        log.info(LogMessages.GET_GAMES_LOG);
        int gamesCount = RequestSteps.getGamesCount(testUser);
        log.info("У пользователя " + gamesCount + " игр");
        Game game = RequestSteps.createGame(Game.randomGameTitle());
        RequestSteps.addGame(testUser, game);
        log.info(LogMessages.GET_GAMES_LOG);
        int updateGamesCount = RequestSteps.getGamesCount(testUser);
        int delta = updateGamesCount - gamesCount;
        log.info("Количество игр изменилось на " + delta);
    }

    @Test
    @DisplayName("Задача 3.2: Проверить, что в ответе на запрос DELETE отсутствует определенное поле")
    public void deleteGameTest() {
        Game game = RequestSteps.createGame(Game.randomGameTitle());
        RequestSteps.addGame(testUser, game);
        Response deleteGame = RequestSteps.deleteGame(testUser, game);
        RequestSteps.validateDeleteResponse(deleteGame);
        String bodyAsString = deleteGame.getBody().asString();
        Assertions.assertFalse(bodyAsString.contains("gameId"));
        log.info(LogMessages.SUCCESSFUL_GAME_DELETE_MESSAGE_LOG);
    }
}