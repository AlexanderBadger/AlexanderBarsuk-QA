package main;

import lombok.extern.log4j.Log4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static main.IntegerConstants.INT_1;
import static main.IntegerConstants.INT_ZERO;
import static main.LogMessages.FREQUENCY_ELEMENTS_LOG;

/**
 * Класс для нахождения наиболее часто повторяющегося элемента в списке.
 */
@Log4j
public class MostFrequentElementUtils {
    /**
     * Метод для нахождения наиболее часто повторяющегося элемента в списке.
     *
     * @param list список строк, в котором нужно найти наиболее частый элемент
     * @return наиболее часто повторяющийся элемент или null, если список пуст
     */
    public static String findMostFrequentElement(ArrayList<String> list) {
        // Создаем HashMap для подсчета элементов
        HashMap<String, Integer> frequencyMap = new HashMap<>();
        // Подсчитываем количество каждого элемента
        for (String item : list) {
            frequencyMap.put(item, frequencyMap.getOrDefault(item, INT_ZERO) + INT_1);
        }
        // Находим наиболее часто повторяющийся элемент
        String mostFrequentElement = null;
        int maxCount = INT_ZERO;
        for (String item : list) {
            int count = frequencyMap.get(item);
            if (count > maxCount) {
                maxCount = count;
                mostFrequentElement = item;
            }
        }
        return mostFrequentElement;
    }

    /**
     * Метод для подсчета частоты элементов в списке.
     *
     * @param list список строк для подсчета частоты
     * @return карта, где ключи - элементы, а значения - их частота
     */
    public static Map<String, Integer> calculateFrequency(List<String> list) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String element : list) {
            frequencyMap.put(element, frequencyMap.getOrDefault(element, INT_ZERO) + INT_1);
        }
        return frequencyMap;
    }

    /**
     * Метод для логирования частоты элементов.
     *
     * @param frequencyMap карта с элементами и их частотой
     */
    public static void logFrequency(Map<String, Integer> frequencyMap) {
        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            log.info(String.format(FREQUENCY_ELEMENTS_LOG, entry.getKey(), entry.getValue()));
        }
    }
}