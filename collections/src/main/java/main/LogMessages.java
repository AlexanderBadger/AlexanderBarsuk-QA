package main;

import lombok.NoArgsConstructor;

@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public final class LogMessages {
    public static final String LAUNCH_TEST_LOG = "Запуск теста на поиск студента с максимальным средним баллом.";
    public static final String TEST_PASSED_LOG = "Тест пройден.\n";
    public static final String START_SORT_STUDENTS_LOG = "Сортировка студентов по дате рождения начата.";
    public static final String SORT_FINISH_LOG = "Сортировка студентов по дате рождения завершена.\n";
    public static final String SEARCH_MAX_AVERAGE_SCORE_LOG = "Поиск студента с максимальным средним баллом начат.";
    public static final String STUDENT_WITH_MAX_AVERAGE_SCORE_LOG = "Студент с максимальным средним баллом: %s%n";
    public static final String EMPTY_LIST_LOG = "Список студентов пуст";
    public static final String SEARCH_YOUNGEST_STUDENT_LOG = "Поиск самого молодого студента начат.";
    public static final String SUCCESS_SEARCH_YOUNGEST_STUDENT_LOG = "Самый молодой студент найден: %s%n";
    public static final String WITHDRAWAL_OF_UNIQUE_NAME_LOG = "Вывод студентов с уникальными именами";
    public static final String STUDENTS_COUNT_LOG = "Количество студентов с именем '%s': %d";
    public static final String LAUNCH_STUDENTS_COUNT_LOG = "Подсчет студентов с именем '%s' начат.";
    public static final String LIST_OF_ELEMENTS_LOG = "Список элементов: ";
    public static final String RESULT_LOG = "Результат: ";
    public static final String SEVERAL_ELEMENTS_WITH_SAME_FREQUENCY_LOG = "Проверка списка с несколькими элементами, "
            + "встречающимися одинаковое количество раз";
    public static final String ONE_ELEMENT_LOG = "Проверка списка с одним элементом";
    public static final String MOST_FREQUENT_ELEMENT_TEST_LOG = "Проверка наиболее часто встречающегося элемента";
    public static final String ALL_VALUES_TREEMAP_LOG = "Все значения в TreeMap: ";
    public static final String TREEMAP_CONTAINS_KEY_LOG = "TreeMap содержит ключ: ";
    public static final String TREEMAP_VALUE_FOR_KEY_LOG = "Полученное значение для ключа ";
    public static final String TREEMAP_FIRST_KEY_LOG = "Первый ключ в TreeMap: ";
    public static final String TREEMAP_LAST_KEY_LOG = "Последний ключ в TreeMap: ";
    public static final String TREEMAP_KEY_VALUE_LOG = "После удаления ключа '%s': %s";
    public static final String TREEMAP_DELETE_ALL_LOG = "TreeMap после удаления всех элементов: ";
    public static final String TREEMAP_CLEANING_LOG = "Очистка treeMap";
    public static final String TREEMAP_AFTER_ADD_NEW_ELEMENTS_LOG = "Состояние TreeMap после добавления "
            + "новых элементов: ";
    public static final String TREEMAP_NUMBER_OF_ELEMENTS_LOG = "Количество элементов в TreeMap: ";
    public static final String TREEMAP_INITIALIZE_LOG = "Инициализированный TreeMap: ";
    public static final String SET_COMBINED_LOG = "Объединенное множество: ";
    public static final String QUEUE_DELETE_ELEMENT_LOG = "Удаленный элемент: ";
    public static final String QUEUE_IS_EMPTY_LOG = "Очередь пуста, ничего не удалено.";
    public static final String QUEUE_INITIALIZED_LOG = "Очередь инициализирована.";
    public static final String ARRAY_LIST_INITIALIZED_LOG = "ArrayList инициализирован.";
    public static final String TEST_LAUNCH_LOG = "Запуск теста: ";
    public static final String ADD_ELEMENT_LOG = "Добавлен элемент: ";
    public static final String QUEUE_NEXT_ELEMENT_LOG = "Следующий элемент в очереди: ";
    public static final String TRY_DELETE_FROM_EMPTY_QUEUE_LOG = "Попытка удалить элемент из пустой очереди.";
    public static final String HASH_MAP_INITIALIZED_LOG = "HashMap инициализирован с элементами: ";
    public static final String HASH_MAP_DELETE_KEY_LOG = "Проверяем удаление ключа: ";
    public static final String HASH_MAP_SUCCESS_DELETE_KEY_LOG = "Ключ '%s' удален. Текущие элементы: %s";
    public static final String HASH_MAP_DELETE_NON_EXIST_KEY_LOG = "Проверяем удаление несуществующего ключа: ";
    public static final String KEY_MUST_NO_EXIST_BEFORE_DELETION_LOG = "Ключ не должен существовать перед удалением";
    public static final String KEY_MUST_EXIST_BEFORE_DELETION_LOG = "Ключ должен существовать перед удалением";
    public static final String KEY_MUST_NO_EXIST_AFTER_DELETION_LOG = "Ключ не должен существовать после удаления";
    public static final String SIZE_OF_MAP_MUST_REMAIN_THE_SAME_LOG = "Размер карты должен оставаться прежним";
    public static final String SIZE_OF_MAP_AFTER_DELETE_NON_EXISTENT_KEY_LOG = "Размер карты после попытки удаления "
            + "несуществующего ключа: ";
    public static final String VALUE_COMBINED_SET_LOG = "Размер объединенного множества должен быть равен %s";
    public static final String COMBINED_SET_MUST_CONTAIN_LOG = "Объединенное множество должно содержать %s";
    public static final String CHECK_UNION_OF_TWO_SETS_LOG = "Проверка объединения двух множеств.";
    public static final String INITIALIZATION_OF_TWO_SETS_LOG = "Инициализированы множества: set1 = '%s', set2 = '%s'";
    public static final String CHECK_IMMUTABILITY_ORIGINAL_SETS_AFTER_UNION_LOG = "Проверка неизменности оригинальных "
            + "множеств после объединения.";
    public static final String SIZE_OF_THE_SET1_LOG = "Размер первого множества: ";
    public static final String SIZE_OF_THE_SET2_LOG = "Размер второго множества: ";
    public static final String SIZE_OF_THE_SET1_SHOULD_REMAIN_LOG = "Размер первого множества должен оставаться %d.";
    public static final String SIZE_OF_THE_SET2_SHOULD_REMAIN_LOG = "Размер второго множества должен оставаться %d.";
    public static final String UNION_WITH_EMPTY_SET_LOG = "Объединенное множество при объединении с пустым: ";
    public static final String SIZE_OF_SET_AFTER_UNION_WITH_EMPTY_SET_LOG = "Размер объединенного множества "
            + "при объединении с пустым множеством должен быть равен: ";
    public static final String SUM_OF_NUMBERS_LOG = "Сумма всех чисел: ";
    public static final String LIST_AFTER_DELETE_NEGATIVE_NUMBERS_LOG = "Список после удаления отрицательных чисел: ";
    public static final String LIST_CONTAIN_NUMBER_LOG = "Список содержит число: ";
    public static final String LIST_NOT_CONTAIN_NUMBER_LOG = "Список не содержит число: ";
    public static final String SUM_INTERVAL_LOG = "Сумма должна находиться в диапазоне от %d до %d";
    public static final String INT_ORIGINS_LOG = "Исходные числа: ";
    public static final String NON_NEGATIVE_INT_LOG = "Число не должно быть отрицательным";
    public static final String CHECK_PRESENCE_INT_LOG = "Проверяем наличие числа: ";
    public static final String INT_MUST_BE_CONTAINED_IN_LIST_LOG = "Число должно содержаться в списке";
    public static final String INT_BEFORE_DELETE_LOG = "Список перед удалением дубликатов: ";
    public static final String INT_AFTER_DELETE_LOG = "Список после удаления дубликатов: ";
    public static final String DUPLICATE_MUST_BE_DELETED_LOG = "Дубликаты должны быть удалены";
    public static final String TEST_ENVIRONMENT_SET_UP_LOG = "Тестовая среда настроена с именами и числами.";
    public static final String AVERAGE_LOG = "Среднее значение для %s: %s";
    public static final String CALCULATION_ATTEMPT_CAUSED_EXCEPTION_LOG = "Попытка вычислить среднее значение "
            + "для несуществующего имени вызвала исключение.";
    public static final String CHECK_ADD_ELEMENT_IN_TREE_MAP_LOG = "Проверка добавления элементов в TreeMap.";
    public static final String SIZE_OF_TREE_MAP_SHOULD_BE_LOG = "Размер TreeMap должен быть равен ";
    public static final String TREE_MAP_MUST_CONTAIN_KEY_LOG = "TreeMap должен содержать ключ: ";
    public static final String CHECK_CONTAIN_KEY_LOG = "Проверка наличия ключа '%s' в TreeMap.";
    public static final String RECEIVING_VALUE_ON_KEY_LOG = "Получение значения по ключу '%s' из TreeMap.";
    public static final String VALUE_ON_KEY_SHOULD_BE_LOG = "Значение по ключу '%s' должно быть %d.";
    public static final String FIRST_KEY_MUST_BE_LOG = "Первый ключ должен быть- ";
    public static final String LAST_KEY_MUST_BE_LOG = "Последний ключ должен быть- ";
    public static final String DELETE_ELEMENT_FROM_TREE_MAP_LOG = "Удаление элемента с ключом '%s' из TreeMap.";
    public static final String TREE_MAP_NOT_CONTAIN_KEY_LOG = "TreeMap не должен содержать ключ: ";
    public static final String CLEAN_ALL_LOG = "Очистка всех элементов из TreeMap.";
    public static final String TREE_MAP_MUST_BE_CLEAN_LOG = "TreeMap должен быть пустым после очистки.";
    public static final String CHECK_FIRST_AND_LAST_KEYS_LOG = "Проверка первого и последнего ключей в TreeMap.";
    public static final String CHECK_SIZE_OF_TREE_MAP_LOG = "Проверка размера TreeMap после добавления элементов.";
    public static final String SIZE_OF_TREE_MAP_AFTER_ADDING_LOG = "Размер TreeMap после добавления новых "
            + "элементов должен быть равен - ";
    public static final String ADD_NUMBERS_LOG = "Добавлены числа для '%s': %s";
    public static final String ADD_EMPTY_LIST_LOG = "Добавлен пустой список";
    public static final String CALCULATE_AVERAGES_LOG = "Вычислены все средние значения: ";
    public static final String SUCCESS_CALCULATE_AVERAGES_LOG = "Успешно проверены все средние значения.";
    public static final String CHECK_NUMBERS_SUCCESS_LOG = "Успешно проверены числа";
    public static final String FREQUENCY_ELEMENTS_LOG = "Элемент: %s , Частота: %s";
    public static final String EMPTY_SET_LOG = "Пустое множество: ";
    public static final String FILLED_SET_LOG = "Заполненное множество: ";
    public static final String ERROR_MESSAGE_LOG = "Ожидаемое значение: %s, Фактическое значение: %s";
    public static final String FIRST_MOST_FREQUENT_ELEMENT_LOG = "Первый встреченный наиболее часто "
            + "встречающийся элемент: ";
}