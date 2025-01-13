import lombok.extern.log4j.Log4j;
import main.ArrayListUtils;
import main.MostFrequentElementUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

import static main.IntegerConstants.INT_ZERO;
import static main.LogMessages.FIRST_MOST_FREQUENT_ELEMENT_LOG;
import static main.LogMessages.LIST_OF_ELEMENTS_LOG;
import static main.LogMessages.MOST_FREQUENT_ELEMENT_TEST_LOG;
import static main.LogMessages.ONE_ELEMENT_LOG;
import static main.LogMessages.RESULT_LOG;
import static main.LogMessages.TEST_PASSED_LOG;
import static main.StringConstants.APPLE;
import static main.StringConstants.BANANA;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Log4j
public class MostFrequentElementTest {

    @Test
    @DisplayName("Проверка того, что метод правильно определяет наиболее часто встречающийся элемент")
    public void mostFrequentElementTest() {
        ArrayList<String> list = ArrayListUtils.createTestData();
        log.info(LIST_OF_ELEMENTS_LOG + list);
        log.info(MOST_FREQUENT_ELEMENT_TEST_LOG);
        Map<String, Integer> frequencyMap = MostFrequentElementUtils.calculateFrequency(list);
        MostFrequentElementUtils.logFrequency(frequencyMap);
        String result = MostFrequentElementUtils.findMostFrequentElement(list);
        log.info(RESULT_LOG + result);
        assertEquals(BANANA, result);
    }

    @Test
    @DisplayName("Проверка случая, когда в списке только один элемент.")
    public void singleElementTest() {
        ArrayList<String> list = new ArrayList<>();
        list.add(APPLE);
        log.info(LIST_OF_ELEMENTS_LOG + list);
        log.info(ONE_ELEMENT_LOG);
        String result = MostFrequentElementUtils.findMostFrequentElement(list);
        log.info(RESULT_LOG + result);
        assertEquals(APPLE, result);
    }

    @Test
    @DisplayName("Проверка первого встреченного элемента с максимальной частотой.")
    public void firstMaxFrequencyTest() {
        ArrayList<String> list = new ArrayList<>();
        list.add(BANANA);
        list.add(BANANA);
        list.add(APPLE);
        list.add(APPLE);
        // Перемешиваем список
        Collections.shuffle(list);
        log.info(LIST_OF_ELEMENTS_LOG + list);
        // Находим элемент с максимальной частотой
        String result = MostFrequentElementUtils.findMostFrequentElement(list);
        log.info(FIRST_MOST_FREQUENT_ELEMENT_LOG + result);
        // Создаем частотную карту для проверки
        Map<String, Integer> frequencyMap = MostFrequentElementUtils.calculateFrequency(list);
        // Находим максимальную частоту
        int maxFrequency = frequencyMap.values().stream().max(Integer::compare).orElse(INT_ZERO);
        // Проверяем, что возвращаемый элемент имеет максимальную частоту
        assertEquals((int) frequencyMap.get(result), maxFrequency);
        log.info(TEST_PASSED_LOG);
    }
}