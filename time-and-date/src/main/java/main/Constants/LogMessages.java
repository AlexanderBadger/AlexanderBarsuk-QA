package main.Constants;

import lombok.NoArgsConstructor;

@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public final class LogMessages {
    public static final String CURRENT_DATE_AND_TIME_LOG = "Текущая дата и время: ";
    public static final String CURRENT_DATE_CUSTOM_FORMAT_LOG = "Текущая дата в формате 'dd.MM.yyyy': ";
    public static final String CURRENT_TIME_LOG = "Текущее время в формате 'HH:mm:ss': ";
    public static final String CURRENT_DATE_AND_TIME_IN_CITY_LOG = "Текущая дата и время г.%s: %s";
    public static final String DAY_LOG = "Какой день: ";
    public static final String MONTH_LOG = "Какого месяца: ";
    public static final String YEAR_LOG = "Какого года: ";
    public static final String DAYS_DIFFERENCE_LOG = "Разница в днях между '%s' и '%s' составляет дней: %s";
    public static final String WEEKEND_LOG = "Дата %s - это выходной: %s";
    public static final String SET_DATE_LOG = "Заданная дата: %s";
    public static final String UPDATE_DATE_LOG = "Измененная дата: %s %n";
    public static final String ADD_DAYS_LOG = "Изменить дату на количество дней: ";
    public static final String READ_FILE_ERROR_LOG = "Ошибка при чтении файла: ";
    public static final String ERROR_DELETING_FILE_LOG = "Ошибка при удалении файла: ";
    public static final String SUCCESS_RENAME_FILE_LOG = "Файл успешно переименован: ";
    public static final String RENAME_FILE_ERROR_LOG = "Ошибка при переименовании файла: ";
    public static final String CREATE_DIRECTORY_LOG = "Директория успешно создана: ";
    public static final String FILE_CREATED_LOG = "Файл создан: ";
    public static final String FILE_FILLED_LOG = "Файл заполнен данными: ";
    public static final String SUCCESS_FILE_DELETE_LOG = "Файл удален: ";
    public static final String FILE_NOT_FOUND_LOG = "Файл для удаления не найден: ";
    public static final String ERROR_LOG = "Ошибка: ";
    public static final String RECORDING_COMPLETED_LOG = "Запись дней с даты %d-%d-%d выполнена";
    public static final String RECORDING_ERROR_LOG = "Ошибка при записи в файл: ";
    public static final String FILE_ALREADY_EXIST_LOG = "Файл уже существует: ";
    public static final String SUCCESS_DIRECTORY_DELETE_LOG = "Директория удалена: ";
    public static final String ERROR_CREATING_FILE_LOG = "Ошибка при создании файла: ";
    public static final String FAILED_TO_CREATE_FILE_LOG = "Не удалось создать файл: ";
}