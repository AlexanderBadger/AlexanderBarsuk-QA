import lombok.NoArgsConstructor;

@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public final class Constants {
    public static final String URL = "http://85.192.34.140:8080";
    public static final String GET_INVALID_URL = "/api/invalid-url";
    public static final String GET_CARS_BRANDS = "/api/easy/carBrands";
    public static final String USER_REGISTRATION = "/api/signup";
    public static final String USER_NAME = "admin";
    public static final String USER = "/api/user";
    public static final String CREATE_TOKEN = "/api/login";
    public static final String ADD_GAME = "/api/user/games";
    public static final String DOWNLOAD_FILE = "/api/files/download";
    public static final String UPLOAD_FILE = "/api/files/upload";
    public static final String AUTH_TEXT = "Authorization";
    public static final String UPLOAD_LINK = "src/test/resources/Rick.jpg";
    public static final String DOWNLOAD_LINK = "target/downloaded_image.jpg";
    public static final String INFO_MESSAGE = "info.message";
    public static final String REGISTER_DATA_LOGIN = "register_data.login";
    public static final String REGISTER_DATA_PASS = "register_data.pass";
    public static final String REGISTER_DATA_ID = "register_data.id";
    public static final String REGISTER_DATA_GAME_ID = "register_data.gameId";
    public static final String SUCCESSFUL_GAME_DELETE_MESSAGE = "Game successfully deleted";
    public static final String GAME_COMPANY = "Ubisoft";
    public static final String GAME_TITLE = "Assassin Creed ";
    public static final String GAME_DESCRIPTION = "A game with an endless number of parts";
    public static final Integer NUMBER_1 = 1;
    public static final Integer NUMBER_2 = 100;
    public static final Integer NUMBER_3 = 1000;
}