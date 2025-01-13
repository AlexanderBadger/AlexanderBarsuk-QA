import lombok.extern.log4j.Log4j;
import main.ArrayListUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;

import static main.IntegerConstants.INT_FOR_INTERVAL_MAX;
import static main.IntegerConstants.INT_FOR_INTERVAL_MIN;
import static main.IntegerConstants.QUEUE_ELEMENT_10;
import static main.LogMessages.ARRAY_LIST_INITIALIZED_LOG;
import static main.LogMessages.CHECK_PRESENCE_INT_LOG;
import static main.LogMessages.DUPLICATE_MUST_BE_DELETED_LOG;
import static main.LogMessages.INT_AFTER_DELETE_LOG;
import static main.LogMessages.INT_BEFORE_DELETE_LOG;
import static main.LogMessages.INT_MUST_BE_CONTAINED_IN_LIST_LOG;
import static main.LogMessages.INT_ORIGINS_LOG;
import static main.LogMessages.LIST_AFTER_DELETE_NEGATIVE_NUMBERS_LOG;
import static main.LogMessages.NON_NEGATIVE_INT_LOG;
import static main.LogMessages.SUM_INTERVAL_LOG;
import static main.LogMessages.SUM_OF_NUMBERS_LOG;
import static main.LogMessages.TEST_PASSED_LOG;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Log4j
public class ArrayListTests {
    private static ArrayListUtils arrayListUtils;

    @BeforeAll
    public static void setUp() {
        arrayListUtils = new ArrayListUtils();
        log.info(ARRAY_LIST_INITIALIZED_LOG);
    }

    @Test
    @DisplayName("проверка вычисления суммы чисел")
    public void getSumTest() {
        log.info(INT_ORIGINS_LOG + arrayListUtils.getNumbers());
        int sum = arrayListUtils.getNumbers().stream().mapToInt(Integer::intValue).sum();
        log.info(SUM_OF_NUMBERS_LOG + sum);
        assertTrue(sum >= INT_FOR_INTERVAL_MIN && sum <= INT_FOR_INTERVAL_MAX,
                String.format(SUM_INTERVAL_LOG, INT_FOR_INTERVAL_MIN, INT_FOR_INTERVAL_MAX));
    }

    @Test
    @DisplayName("Проверка удаления отрицательных чисел")
    public void removeNegativeNumbersTest() {
        // Получаем оригинальный список чисел для логирования
        ArrayList<Integer> originalNumbers = new ArrayList<>(arrayListUtils.getNumbers());
        log.info(INT_ORIGINS_LOG + originalNumbers);
        // Удаляем отрицательные числа
        arrayListUtils.removeNegativeNumbers();
        // Логируем список после удаления отрицательных чисел
        ArrayList<Integer> updatedNumbers = arrayListUtils.getNumbers();
        log.info(LIST_AFTER_DELETE_NEGATIVE_NUMBERS_LOG + updatedNumbers);
        assertTrue(arrayListUtils.areAllNumbersNonNegative(), NON_NEGATIVE_INT_LOG);
        log.info(TEST_PASSED_LOG);
    }

    @Test
    @DisplayName("Проверка наличия числа в списке")
    public void containsNumberTest() {
        log.info(INT_ORIGINS_LOG + arrayListUtils.getNumbers());
        int numberToCheck = arrayListUtils.getNumbers().getFirst();
        log.info(CHECK_PRESENCE_INT_LOG + numberToCheck);
        arrayListUtils.logNumberPresence(numberToCheck);
        assertTrue(arrayListUtils.containsNumber(numberToCheck), INT_MUST_BE_CONTAINED_IN_LIST_LOG);
    }

    @Test
    @DisplayName("Проверка удаления дубликатов")
    public void removeDuplicatesTest() {
        arrayListUtils.getNumbers().add(QUEUE_ELEMENT_10);
        arrayListUtils.getNumbers().add(QUEUE_ELEMENT_10);
        log.info(INT_BEFORE_DELETE_LOG + arrayListUtils.getNumbers());
        ArrayList<Integer> uniqueNumbers = arrayListUtils.removeDuplicates();
        log.info(INT_AFTER_DELETE_LOG + uniqueNumbers);
        assertEquals(uniqueNumbers.size(), new HashSet<>(uniqueNumbers).size(), DUPLICATE_MUST_BE_DELETED_LOG);
    }
}