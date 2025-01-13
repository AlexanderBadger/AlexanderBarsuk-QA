package main;

import lombok.Getter;
import lombok.extern.log4j.Log4j;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

import static main.IntegerConstants.INT_FOR_RANDOMIZER_101;
import static main.IntegerConstants.INT_FOR_RANDOMIZER_50;
import static main.IntegerConstants.INT_ZERO;
import static main.IntegerConstants.QUEUE_ELEMENT_10;
import static main.LogMessages.LIST_CONTAIN_NUMBER_LOG;
import static main.LogMessages.LIST_NOT_CONTAIN_NUMBER_LOG;
import static main.StringConstants.APPLE;
import static main.StringConstants.BANANA;
import static main.StringConstants.MELON;
import static main.StringConstants.WATERMELON;

@Log4j
@Getter
public class ArrayListUtils {
    private final ArrayList<Integer> numbers;

    /**
     * Конструктор класса ArrayListUtils.
     * Инициализирует список чисел и генерирует случайные числа.
     */
    public ArrayListUtils() {
        this.numbers = new ArrayList<>();
        generateRandomNumbers();
    }

    /**
     * Создает тестовые данные в виде списка строк, представляющих фрукты.
     *
     * @return Список строк, содержащий тестовые данные фруктов.
     */
    public static ArrayList<String> createTestData() {
        ArrayList<String> testList = new ArrayList<>();
        testList.add(APPLE);
        testList.add(BANANA);
        testList.add(APPLE);
        testList.add(BANANA);
        testList.add(BANANA);
        testList.add(WATERMELON);
        testList.add(MELON);
        return testList;
    }

    /**
     * Генерирует случайные числа и добавляет их в список.
     * Случайные числа находятся в диапазоне от -50 до 50.
     */
    private void generateRandomNumbers() {
        Random random = new Random();
        for (int i = INT_ZERO; i < QUEUE_ELEMENT_10; i++) {
            // Случайные числа от -50 до 50
            numbers.add(random.nextInt(INT_FOR_RANDOMIZER_101) - INT_FOR_RANDOMIZER_50);
        }
    }

    /**
     * Удаляет все отрицательные числа из списка.
     */
    public void removeNegativeNumbers() {
        numbers.removeIf(number -> number < INT_ZERO);
    }

    /**
     * Проверяет, содержится ли указанное число в списке.
     *
     * @param checkNumber Число для проверки.
     * @return true, если число содержится в списке; false в противном случае.
     */
    public boolean containsNumber(int checkNumber) {
        return numbers.contains(checkNumber);
    }

    /**
     * Удаляет дубликаты из списка чисел.
     *
     * @return Обновленный список чисел без дубликатов.
     */
    public ArrayList<Integer> removeDuplicates() {
        HashSet<Integer> uniqueNumbers = new HashSet<>(numbers);
        numbers.clear();
        numbers.addAll(uniqueNumbers);
        return numbers;
    }

    /**
     * Логирует наличие числа в списке.
     *
     * @param number Число для проверки.
     */
    public void logNumberPresence(int number) {
        if (containsNumber(number)) {
            log.info(LIST_CONTAIN_NUMBER_LOG + number);
        } else {
            log.info(LIST_NOT_CONTAIN_NUMBER_LOG + number);
        }
    }

    /**
     * Проверяет, являются ли все числа в коллекции неотрицательными.
     *
     * @return {@code true}, если все числа неотрицательные; {@code false} в противном случае.
     */
    public boolean areAllNumbersNonNegative() {
        return numbers.stream().allMatch(number -> number >= INT_ZERO);
    }
}