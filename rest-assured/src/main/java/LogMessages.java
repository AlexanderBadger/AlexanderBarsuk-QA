import lombok.NoArgsConstructor;

@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public final class LogMessages {
    public static final String GET_GAMES_LOG = "Получение списка игр";
    public static final String USER_CREATION_LOG = "Создание пользователя";
    public static final String SUCCESS_USER_CREATION_LOG = "Пользователь успешно создан";
    public static final String USER_CHANGE_PASSWORD_LOG = "Изменение пароля пользователя";
    public static final String USER_DELETE_LOG = "Удаление пользователя";
    public static final String SUCCESS_USER_DELETION_LOG = "Пользователь успешно удален";
    public static final String SUCCESSFUL_GAME_DELETE_MESSAGE_LOG = "Игра успешно удалена";
    public static final String SEND_REGISTRATION_REQUEST_LOG = "Отправка запроса на регистрацию нового пользователя";
    public static final String CREATING_GAME_AND_ADD_LOG = "Создание новой игры и добавление ее в список пользователя";
    public static final String ADD_GAME_IN_DATABASE_LOG = "Добавление новой игры в БД";
    public static final String ADD_GAME_DETAILS_LOG = "Добавление в модель игры сведений об ID";
    public static final String GAME_DELETE_LOG = "Удаление добавленной игры";
    public static final String DOWNLOAD_REQUEST_LOG = "Отправка запроса на скачивание изображения";
    public static final String SAVING_IMAGE_LOG = "Сохранение изображения";
    public static final String SPECIFYING_PATH_TO_FILE_LOG = "Указание пути к файлу картинки";
    public static final String FILE_UPLOAD_REQUEST_LOG = "Выполнение POST-запроса на загрузку картинки";
    public static final String CHECK_STATUS_CODE_LOG = "Проверка успешного статус-кода ответа";
    public static final String UPLOAD_SERVER_LOG = "Файл загружен на сервер";
}