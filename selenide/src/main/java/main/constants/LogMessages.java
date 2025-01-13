package main.constants;

import lombok.NoArgsConstructor;

@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public final class LogMessages {
    public static final String OPEN_CATALOG_PAGE_LOG = "Открываем страницу каталога";
    public static final String CHECKING_PRESENCE_LOGIN_BUTTON_LOG = "Проверяем наличие кнопки входа";
    public static final String JAVA_COURSE_SEARCH_LOG = "Ищем курс по Java";
    public static final String PYTHON_FREE_COURSE_SEARCH_LOG = "Ищем бесплатный курс по Python";
    public static final String TEXT_SEARCH_LOG = "Проверяем наличие текста о бесплатном курсе ";
    public static final String BUTTON_SEARCH_LOG = "Проверяем наличие кнопки 'Записаться на курс'";
    public static final String LOGIN_LOG = "Выполняем вход в систему";
    public static final String CLICK_ON_CHECKBOX_LOG = "Кликаем на чекбокс 'Бесплатные'";
    public static final String CHECK_ALL_LINKS_LOG = "Проверяем все ссылки на странице";
    public static final String LOGIN_WITH_RANDOM_DATA_LOG = "Выполняем вход с случайными данными";
    public static final String CHECK_NOTIFICATION_LOG = "Проверяем наличие уведомления";
    public static final String CHECK_VISIBILITY_AND_STYLES_OF_THE_BUTTON_LOG = "Проверяем видимость кнопки поиска"
            + " и её стили";
    public static final String CHECK_ELEMENT_AFTER_SCROLLING_LOG = "Проверяем элемент после прокрутки";
    public static final String CHECK_TRANSITION_TO_SETTINGS_LOG = "Переходим в настройки профиля";
    public static final String CHANGE_DATA_AND_SAVING_LOG = "Изменяем данные и сохраняем изменения";
    public static final String CHECK_POPUP_LOG = "Проверяем наличие всплывающего окна";
    public static final String CANT_FIND_ELEMENT_LOG = "Элемент с XPath %s не найден после %d попыток";
}