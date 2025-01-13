import lombok.extern.log4j.Log4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static main.IntegerConstants.INT_1;
import static main.IntegerConstants.INT_2;
import static main.IntegerConstants.INT_3;
import static main.IntegerConstants.INT_4;
import static main.LogMessages.HASH_MAP_DELETE_KEY_LOG;
import static main.LogMessages.HASH_MAP_DELETE_NON_EXIST_KEY_LOG;
import static main.LogMessages.HASH_MAP_INITIALIZED_LOG;
import static main.LogMessages.HASH_MAP_SUCCESS_DELETE_KEY_LOG;
import static main.LogMessages.KEY_MUST_EXIST_BEFORE_DELETION_LOG;
import static main.LogMessages.KEY_MUST_NO_EXIST_AFTER_DELETION_LOG;
import static main.LogMessages.KEY_MUST_NO_EXIST_BEFORE_DELETION_LOG;
import static main.LogMessages.SIZE_OF_MAP_AFTER_DELETE_NON_EXISTENT_KEY_LOG;
import static main.LogMessages.SIZE_OF_MAP_MUST_REMAIN_THE_SAME_LOG;
import static main.StringConstants.APPLE;
import static main.StringConstants.BANANA;
import static main.StringConstants.KEY_TO_REMOVE;
import static main.StringConstants.MELON;
import static main.StringConstants.WATERMELON;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Log4j
public class RemoveElementFromHashMapTest {
    private HashMap<String, Integer> map;

    @BeforeEach
    public void setUp() {
        map = new HashMap<>();
        map.put(APPLE, INT_1);
        map.put(BANANA, INT_2);
        map.put(MELON, INT_3);
        map.put(WATERMELON, INT_4);
        log.info(HASH_MAP_INITIALIZED_LOG + map);
    }

    @Test
    @DisplayName("Тест на успешное удаление элемента из HashMap")
    public void removeElementTest() {
        String keyToRemove = BANANA;
        log.info(HASH_MAP_DELETE_KEY_LOG + keyToRemove);
        assertTrue(map.containsKey(keyToRemove), KEY_MUST_EXIST_BEFORE_DELETION_LOG);
        map.remove(keyToRemove);
        log.info(String.format(HASH_MAP_SUCCESS_DELETE_KEY_LOG, keyToRemove, map));
        assertFalse(map.containsKey(keyToRemove), KEY_MUST_NO_EXIST_AFTER_DELETION_LOG);
    }

    @Test
    @DisplayName("Тест на удаление несуществующего элемента из HashMap")
    public void removeNonExistentElementTest() {
        String keyToRemove = KEY_TO_REMOVE;
        log.info(HASH_MAP_DELETE_NON_EXIST_KEY_LOG + keyToRemove);
        assertFalse(map.containsKey(keyToRemove), KEY_MUST_NO_EXIST_BEFORE_DELETION_LOG);
        // Удаление несуществующего ключа не должно вызывать ошибок
        map.remove(keyToRemove);
        // Проверяем, что другие элементы остались нетронутыми
        assertEquals(INT_4, map.size(), SIZE_OF_MAP_MUST_REMAIN_THE_SAME_LOG);
        log.info(SIZE_OF_MAP_AFTER_DELETE_NON_EXISTENT_KEY_LOG + map.size());
    }
}