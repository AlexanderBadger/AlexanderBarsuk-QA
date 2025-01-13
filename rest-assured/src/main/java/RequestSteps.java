import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

@Slf4j
public class RequestSteps {
    public static Response signUp(User user) {
        Object requestBody = new CreateUserBody(user);
        Response singUpResponse = BasicRequests.postResponse(Constants.USER_REGISTRATION, requestBody);
        if (singUpResponse.getStatusCode() == SC_CREATED) {
            user.setSavedInDB(true);
        }
        return singUpResponse;
    }

    public static User createUser() {
        String username = User.randomUsername();
        String password = User.randomPassword();
        User testUser = new User(username, password);
        log.info(LogMessages.SEND_REGISTRATION_REQUEST_LOG);
        Response userCreateResponse = RequestSteps.signUp(testUser);
        validateUserCreationResponse(userCreateResponse, testUser);
        return testUser;
    }

    public static void validateUserCreationResponse(Response response, User user) {
        response.then()
                .log()
                .all()
                .statusCode(SC_CREATED)
                .body(Constants.INFO_MESSAGE, equalTo("User created"))
                .body(Constants.REGISTER_DATA_LOGIN, equalTo(user.getUsername()))
                .body(Constants.REGISTER_DATA_PASS, equalTo(user.getPassword()))
                .body(Constants.REGISTER_DATA_ID, notNullValue());
        log.info("Пользователь '" + user.getUsername() + "' успешно создан");
    }

    public static void obtainAuthenticationToken(User user) {
        log.info("Получение токена для пользователя '" + user.getUsername() + "'");
        Object requestBody = new TokenBody(user);
        Response loginResponse = BasicRequests.postResponse(Constants.CREATE_TOKEN, requestBody);
        user.setToken("Bearer " + loginResponse.then().extract().response().path("token"));
        log.info("Для пользователя установлен токен - " + user.getToken());
    }

    public static Response userDelete(User user) {
        log.info(LogMessages.USER_DELETE_LOG);
        Response userDeleteResponse = BasicRequests.deleteResponse(Constants.USER, user.getToken());
        userDeleteResponse.then()
                .log()
                .all()
                .statusCode(SC_OK)
                .body("info.message", equalTo("User successfully deleted"));
        log.info(LogMessages.SUCCESS_USER_DELETION_LOG);
        if (userDeleteResponse.getStatusCode() == SC_OK) {
            user.setSavedInDB(false);
        }
        return userDeleteResponse;
    }

    public static void logUserNotExists(User user) {
        log.info("Пользователь '" + user.getUsername() + "' не существует. Удаление не требуется");
    }

    public static User createRandomUser() {
        String username = User.randomUsername();
        String password = User.randomPassword();
        log.info(String.format("Создание пользователя с логином '%s', паролем '%s'", username, password));
        User userWithoutGame = new User(username, password);
        log.info(LogMessages.SEND_REGISTRATION_REQUEST_LOG);
        Response userCreateResponse = signUp(userWithoutGame);
        userCreateResponse.then().statusCode(SC_CREATED);
        log.info(LogMessages.SUCCESS_USER_CREATION_LOG);
        obtainAuthenticationToken(userWithoutGame);
        return userWithoutGame;
    }

    public static int getGamesCount(User user) {
        log.info("Запрос списка игр пользователя '" + user.getUsername() + "'");
        Response getGamesResponse = BasicRequests.getResponse(Constants.ADD_GAME, user.getToken());
        getGamesResponse.then().statusCode(SC_OK);
        return Json.arrayLength(getGamesResponse.then().extract().response());
    }

    public static Game createGame(String gameTitle) {
        Game game = new Game(gameTitle, Constants.GAME_COMPANY, Constants.GAME_DESCRIPTION);
        return game;
    }

    public static void addGame(User user, Game game) {
        log.info(LogMessages.CREATING_GAME_AND_ADD_LOG);
        if (user.getToken() == null) {
            obtainAuthenticationToken(user);
        }
        log.info(LogMessages.ADD_GAME_IN_DATABASE_LOG);
        GameBody gameBody = new GameBody(game);
        Response addGameResponse = BasicRequests.postResponse(Constants.ADD_GAME, user.getToken(), gameBody);
        addGameResponse.then().statusCode(SC_CREATED).log().status().and().log().body();
        log.info(LogMessages.ADD_GAME_DETAILS_LOG);
        log.info("id = " + addGameResponse.then().extract().response().path(Constants.REGISTER_DATA_GAME_ID));
        game.setGameId(addGameResponse.then().extract().response().path(Constants.REGISTER_DATA_GAME_ID));
    }

    public static Response deleteGame(User user, Game game) {
        log.info(LogMessages.GAME_DELETE_LOG);
        return BasicRequests.deleteResponse(Constants.ADD_GAME, user.getToken(), game.getGameId());
    }

    public static Response passUpdate(User user, String newPass) {
        log.info(LogMessages.USER_CHANGE_PASSWORD_LOG);
        PasswordUpdateBody newPassBody = new PasswordUpdateBody(newPass);
        Response passUpdateResponse = BasicRequests.putResponse(Constants.USER, user.getToken(), newPassBody);
        if (passUpdateResponse.getStatusCode() == SC_OK) {
            user.setPassword(newPass);
        }
        return passUpdateResponse;
    }

    public static Response getUserInfo(User user) {
        return BasicRequests.getResponse(Constants.USER, user.getToken());
    }

    public static void verifyPasswordUpdate(User user, String expectedPassword) {
        Response userInfoResponse = RequestSteps.getUserInfo(user);
        userInfoResponse.then().log().all().statusCode(SC_OK).body("pass", equalTo(expectedPassword));
        log.info("Значение 'pass' равно новому паролю - '" + expectedPassword + "'");
    }

    public static Response postUploadFile(File image) {
        return given().multiPart(image).when().post(Constants.URL + Constants.UPLOAD_FILE);
    }

    public static void exportFile(Response response) {
        try (FileOutputStream image = new FileOutputStream(Constants.DOWNLOAD_LINK)) {
            image.write(response.asByteArray());
        } catch (IOException e) {
            System.out.println("Не удалось сохранить изображение: " + e.getMessage());
        }
    }

    public static Response downloadImage() {
        log.info(LogMessages.DOWNLOAD_REQUEST_LOG);
        Response response = BasicRequests.getResponse(Constants.DOWNLOAD_FILE);
        verifyStatusCode(response, SC_OK);
        return response;
    }

    public static void saveImage(Response response) {
        log.info(LogMessages.SAVING_IMAGE_LOG);
        RequestSteps.exportFile(response);
    }

    public static File getImageFile() {
        log.info(LogMessages.SPECIFYING_PATH_TO_FILE_LOG);
        return new File(Constants.UPLOAD_LINK);
    }

    public static void uploadImage(File imageFile) {
        log.info(LogMessages.FILE_UPLOAD_REQUEST_LOG);
        Response response = RequestSteps.postUploadFile(imageFile);
        response.then().log().all().statusCode(SC_OK);
        log.info(LogMessages.UPLOAD_SERVER_LOG);
    }

    public static void verifyStatusCode(Response response, int expectedStatusCode) {
        log.info(LogMessages.CHECK_STATUS_CODE_LOG);
        response.then().statusCode(expectedStatusCode);
    }

    public static void validateDeleteResponse(Response deleteGameResponse) {
        deleteGameResponse.then()
                .log()
                .all()
                .statusCode(SC_OK)
                .body(Constants.INFO_MESSAGE, equalTo(Constants.SUCCESSFUL_GAME_DELETE_MESSAGE));
    }

    public static boolean isFileDownloaded(String filePath) {
        File file = new File(filePath);
        return file.exists();
    }
}