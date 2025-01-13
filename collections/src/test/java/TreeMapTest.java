import lombok.extern.log4j.Log4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.TreeMap;

import static main.IntegerConstants.INT_1;
import static main.IntegerConstants.INT_2;
import static main.IntegerConstants.INT_3;
import static main.IntegerConstants.INT_4;
import static main.IntegerConstants.INT_5;
import static main.IntegerConstants.INT_6;
import static main.IntegerConstants.INT_7;
import static main.LogMessages.ALL_VALUES_TREEMAP_LOG;
import static main.LogMessages.CHECK_ADD_ELEMENT_IN_TREE_MAP_LOG;
import static main.LogMessages.CHECK_CONTAIN_KEY_LOG;
import static main.LogMessages.CHECK_FIRST_AND_LAST_KEYS_LOG;
import static main.LogMessages.CHECK_SIZE_OF_TREE_MAP_LOG;
import static main.LogMessages.CLEAN_ALL_LOG;
import static main.LogMessages.DELETE_ELEMENT_FROM_TREE_MAP_LOG;
import static main.LogMessages.FIRST_KEY_MUST_BE_LOG;
import static main.LogMessages.LAST_KEY_MUST_BE_LOG;
import static main.LogMessages.RECEIVING_VALUE_ON_KEY_LOG;
import static main.LogMessages.SIZE_OF_TREE_MAP_AFTER_ADDING_LOG;
import static main.LogMessages.SIZE_OF_TREE_MAP_SHOULD_BE_LOG;
import static main.LogMessages.TEST_PASSED_LOG;
import static main.LogMessages.TREEMAP_AFTER_ADD_NEW_ELEMENTS_LOG;
import static main.LogMessages.TREEMAP_CLEANING_LOG;
import static main.LogMessages.TREEMAP_CONTAINS_KEY_LOG;
import static main.LogMessages.TREEMAP_DELETE_ALL_LOG;
import static main.LogMessages.TREEMAP_FIRST_KEY_LOG;
import static main.LogMessages.TREEMAP_INITIALIZE_LOG;
import static main.LogMessages.TREEMAP_KEY_VALUE_LOG;
import static main.LogMessages.TREEMAP_LAST_KEY_LOG;
import static main.LogMessages.TREEMAP_NUMBER_OF_ELEMENTS_LOG;
import static main.LogMessages.TREEMAP_VALUE_FOR_KEY_LOG;
import static main.LogMessages.TREE_MAP_MUST_BE_CLEAN_LOG;
import static main.LogMessages.TREE_MAP_MUST_CONTAIN_KEY_LOG;
import static main.LogMessages.TREE_MAP_NOT_CONTAIN_KEY_LOG;
import static main.LogMessages.VALUE_ON_KEY_SHOULD_BE_LOG;
import static main.StringConstants.APPLE;
import static main.StringConstants.BANANA;
import static main.StringConstants.COCONUT;
import static main.StringConstants.DASH;
import static main.StringConstants.GRAPE;
import static main.StringConstants.MELON;
import static main.StringConstants.PEACH;
import static main.StringConstants.WATERMELON;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Log4j
public class TreeMapTest {

    private TreeMap<String, Integer> treeMap;

    @BeforeEach
    public void setUp() {
        // Инициализация TreeMap перед каждым тестом
        treeMap = new TreeMap<>();
        treeMap.put(APPLE, INT_1);
        treeMap.put(BANANA, INT_2);
        treeMap.put(MELON, INT_3);
        treeMap.put(PEACH, INT_4);
        log.info(TREEMAP_INITIALIZE_LOG + treeMap);
    }

    @Test
    @DisplayName("Проверка добавления элементов в TreeMap")
    public void addElementsTest() {
        log.info(CHECK_ADD_ELEMENT_IN_TREE_MAP_LOG);
        log.info(TREEMAP_NUMBER_OF_ELEMENTS_LOG + treeMap.size());
        assertEquals(INT_4, treeMap.size(), SIZE_OF_TREE_MAP_SHOULD_BE_LOG + INT_4);
        log.info(TEST_PASSED_LOG);
    }

    @Test
    @DisplayName("Проверка наличия ключа в TreeMap")
    public void containsKeyTest() {
        String keyToCheck = BANANA;
        log.info(String.format(CHECK_CONTAIN_KEY_LOG, keyToCheck));
        boolean containsKey = treeMap.containsKey(keyToCheck);
        log.info(TREEMAP_CONTAINS_KEY_LOG + keyToCheck + DASH + containsKey);
        assertTrue(containsKey, TREE_MAP_MUST_CONTAIN_KEY_LOG + keyToCheck);
        log.info(TEST_PASSED_LOG);
    }

    @Test
    @DisplayName("Получение значения по ключу из TreeMap")
    public void getValueByKeyTest() {
        String keyToCheck = BANANA;
        log.info(String.format(RECEIVING_VALUE_ON_KEY_LOG, keyToCheck));
        Integer value = treeMap.get(keyToCheck);
        log.info(TREEMAP_VALUE_FOR_KEY_LOG + keyToCheck + DASH + value);
        assertEquals(INT_2, value, String.format(VALUE_ON_KEY_SHOULD_BE_LOG, keyToCheck, INT_2));
        log.info(TEST_PASSED_LOG);
    }

    @Test
    @DisplayName("Проверка первого и последнего ключей в TreeMap")
    public void firstAndLastKeyTest() {
        log.info(CHECK_FIRST_AND_LAST_KEYS_LOG);
        String firstKey = treeMap.firstKey();
        String lastKey = treeMap.lastKey();
        log.info(TREEMAP_FIRST_KEY_LOG + firstKey);
        log.info(TREEMAP_LAST_KEY_LOG + lastKey);
        assertEquals(BANANA, firstKey, FIRST_KEY_MUST_BE_LOG + BANANA);
        assertEquals(APPLE, lastKey, LAST_KEY_MUST_BE_LOG + APPLE);
        log.info(TEST_PASSED_LOG);
    }

    @Test
    @DisplayName("Удаление элемента из TreeMap")
    public void removeElementTest() {
        String keyToRemove = BANANA;
        log.info(String.format(DELETE_ELEMENT_FROM_TREE_MAP_LOG, keyToRemove));
        // Логируем текущее состояние TreeMap перед удалением
        log.info(ALL_VALUES_TREEMAP_LOG + treeMap);
        treeMap.remove(keyToRemove);
        // Логируем состояние TreeMap после удаления
        log.info(String.format(TREEMAP_KEY_VALUE_LOG, keyToRemove, treeMap));
        assertFalse(treeMap.containsKey(keyToRemove), TREE_MAP_NOT_CONTAIN_KEY_LOG + keyToRemove);
        log.info(TEST_PASSED_LOG);
    }

    @Test
    @DisplayName("Очистка всех элементов из TreeMap")
    public void clearTreeMapTest() {
        log.info(CLEAN_ALL_LOG);
        // Логируем состояние TreeMap перед очисткой
        log.info(ALL_VALUES_TREEMAP_LOG + treeMap);
        treeMap.clear();
        // Логируем состояние TreeMap после очистки
        log.info(TREEMAP_DELETE_ALL_LOG + treeMap);
        assertTrue(treeMap.isEmpty(), TREE_MAP_MUST_BE_CLEAN_LOG);
        log.info(TEST_PASSED_LOG);
    }

    @Test
    @DisplayName("Проверка размера TreeMap после добавления элементов")
    public void sizeAfterAddingElementsTest() {
        log.info(CHECK_SIZE_OF_TREE_MAP_LOG);
        // Сначала очищаем
        log.info(ALL_VALUES_TREEMAP_LOG + treeMap);
        treeMap.clear();
        log.info(TREEMAP_CLEANING_LOG);
        log.info(TREEMAP_DELETE_ALL_LOG + treeMap);
        treeMap.put(WATERMELON, INT_5);
        treeMap.put(GRAPE, INT_6);
        treeMap.put(COCONUT, INT_7);
        log.info(TREEMAP_AFTER_ADD_NEW_ELEMENTS_LOG + treeMap);
        assertEquals(INT_3, treeMap.size(), SIZE_OF_TREE_MAP_AFTER_ADDING_LOG);
        log.info(TEST_PASSED_LOG);
    }
}