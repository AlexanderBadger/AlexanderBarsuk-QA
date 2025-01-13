import lombok.extern.log4j.Log4j;
import main.NameNumberMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static main.IntegerConstants.DOUBLE_2;
import static main.IntegerConstants.DOUBLE_5;
import static main.IntegerConstants.INT_1;
import static main.IntegerConstants.INT_2;
import static main.IntegerConstants.INT_3;
import static main.IntegerConstants.INT_4;
import static main.IntegerConstants.INT_5;
import static main.IntegerConstants.INT_6;
import static main.LogMessages.ADD_EMPTY_LIST_LOG;
import static main.LogMessages.ADD_NUMBERS_LOG;
import static main.LogMessages.AVERAGE_LOG;
import static main.LogMessages.CALCULATE_AVERAGES_LOG;
import static main.LogMessages.CALCULATION_ATTEMPT_CAUSED_EXCEPTION_LOG;
import static main.LogMessages.CHECK_NUMBERS_SUCCESS_LOG;
import static main.LogMessages.ERROR_MESSAGE_LOG;
import static main.LogMessages.SUCCESS_CALCULATE_AVERAGES_LOG;
import static main.LogMessages.TEST_ENVIRONMENT_SET_UP_LOG;
import static main.StringConstants.NAME_FOR_TEST_NAME_NUMBER_MAP_1;
import static main.StringConstants.NAME_FOR_TEST_NAME_NUMBER_MAP_2;
import static main.StringConstants.NAME_NUMBER_MAP_EXCEPTION;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Log4j
class NameNumberTest {
    private NameNumberMap nameNumberMap;

    @BeforeEach
    void setUp() {
        nameNumberMap = new NameNumberMap();
        log.info(TEST_ENVIRONMENT_SET_UP_LOG);
    }

    @Test
    @DisplayName("Проверка добавления чисел к имени")
    void testAddNumbers() {
        List<Integer> numbers = Arrays.asList(INT_1, INT_2, INT_3);
        nameNumberMap.addNumbers(NAME_FOR_TEST_NAME_NUMBER_MAP_1, numbers);
        log.info(String.format(ADD_NUMBERS_LOG, NAME_FOR_TEST_NAME_NUMBER_MAP_1, numbers));
        assertEquals(numbers, nameNumberMap.nameNumberMap.get(NAME_FOR_TEST_NAME_NUMBER_MAP_1));
        log.info(CHECK_NUMBERS_SUCCESS_LOG);
    }

    @Test
    @DisplayName("Проверка вычисления среднего значения для имени")
    void testCalculateAverage() {
        List<Integer> numbers = Arrays.asList(INT_1, INT_2, INT_3);
        nameNumberMap.addNumbers(NAME_FOR_TEST_NAME_NUMBER_MAP_1, numbers);
        log.info(String.format(ADD_NUMBERS_LOG, NAME_FOR_TEST_NAME_NUMBER_MAP_1, numbers));
        double average = nameNumberMap.calculateAverage(NAME_FOR_TEST_NAME_NUMBER_MAP_1);
        log.info(String.format(AVERAGE_LOG, NAME_FOR_TEST_NAME_NUMBER_MAP_1, average));
        assertEquals(DOUBLE_2, average, String.format(ERROR_MESSAGE_LOG, DOUBLE_2, average));
    }

    @Test
    @DisplayName("Проверка вычисления среднего значения вызывает исключение для пустого списка")
    void testCalculateAverageThrowsExceptionForEmptyList() {
        nameNumberMap.addNumbers(NAME_FOR_TEST_NAME_NUMBER_MAP_2, Arrays.asList());
        log.info(ADD_EMPTY_LIST_LOG);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            nameNumberMap.calculateAverage(NAME_FOR_TEST_NAME_NUMBER_MAP_2);
        });
        String expectedMessage = String.format(NAME_NUMBER_MAP_EXCEPTION, NAME_FOR_TEST_NAME_NUMBER_MAP_2);
        assertEquals(expectedMessage, exception.getMessage());
        log.info(CALCULATION_ATTEMPT_CAUSED_EXCEPTION_LOG + expectedMessage);
    }

    @Test
    @DisplayName("Проверка вычисления всех средних значений")
    void testCalculateAllAverages() {
        List<Integer> numbers1 = Arrays.asList(INT_1, INT_2, INT_3);
        List<Integer> numbers2 = Arrays.asList(INT_4, INT_5, INT_6);
        nameNumberMap.addNumbers(NAME_FOR_TEST_NAME_NUMBER_MAP_1, numbers1);
        nameNumberMap.addNumbers(NAME_FOR_TEST_NAME_NUMBER_MAP_2, numbers2);
        log.info(String.format(ADD_NUMBERS_LOG, NAME_FOR_TEST_NAME_NUMBER_MAP_1, numbers1));
        log.info(String.format(ADD_NUMBERS_LOG, NAME_FOR_TEST_NAME_NUMBER_MAP_2, numbers2));
        Map<String, Double> expectedAverages = new HashMap<>();
        expectedAverages.put(NAME_FOR_TEST_NAME_NUMBER_MAP_1, DOUBLE_2);
        expectedAverages.put(NAME_FOR_TEST_NAME_NUMBER_MAP_2, DOUBLE_5);
        Map<String, Double> actualAverages = nameNumberMap.calculateAllAverages();
        log.info(CALCULATE_AVERAGES_LOG + actualAverages);
        assertEquals(expectedAverages, actualAverages);
        log.info(SUCCESS_CALCULATE_AVERAGES_LOG);
    }
}