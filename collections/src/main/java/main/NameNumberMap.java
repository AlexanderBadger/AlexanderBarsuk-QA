package main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static main.StringConstants.NAME_NUMBER_MAP_EXCEPTION;

/**
 * Класс {@code NameNumberMap} представляет собой словарь, который хранит пары "имя - список чисел".
 * Этот класс предоставляет методы для добавления чисел к именам и вычисления средних значений списков чисел.
 */
public class NameNumberMap {
    // Словарь для хранения пар "имя - список чисел"
    public Map<String, List<Integer>> nameNumberMap;

    /**
     * Конструктор, инициализирующий пустой словарь.
     */
    public NameNumberMap() {
        this.nameNumberMap = new HashMap<>();
    }

    /**
     * Добавляет список чисел для указанного имени.
     *
     * @param name    имя, к которому будет привязан список чисел
     * @param numbers список чисел, который нужно добавить
     */
    public void addNumbers(String name, List<Integer> numbers) {
        nameNumberMap.put(name, numbers);
    }

    /**
     * Вычисляет среднее значение списка чисел для указанного имени.
     *
     * @param name имя, для которого нужно вычислить среднее значение
     * @return среднее значение списка чисел
     * @throws IllegalArgumentException если список чисел для указанного имени пуст или не существует
     */
    public double calculateAverage(String name) {
        List<Integer> numbers = nameNumberMap.get(name);
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException(String.format(NAME_NUMBER_MAP_EXCEPTION, name));
        }
        return numbers.stream().mapToInt(Integer::intValue).average().orElse(0.0);
    }

    /**
     * Вычисляет средние значения для всех имен в словаре.
     *
     * @return словарь, где ключи - имена, а значения - средние значения соответствующих списков чисел
     */
    public Map<String, Double> calculateAllAverages() {
        Map<String, Double> averages = new HashMap<>();
        for (Map.Entry<String, List<Integer>> entry : nameNumberMap.entrySet()) {
            averages.put(entry.getKey(), calculateAverage(entry.getKey()));
        }
        return averages;
    }
}