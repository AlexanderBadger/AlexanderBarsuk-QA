import lombok.extern.log4j.Log4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static main.IntegerConstants.INT_3;
import static main.IntegerConstants.INT_5;
import static main.LogMessages.CHECK_IMMUTABILITY_ORIGINAL_SETS_AFTER_UNION_LOG;
import static main.LogMessages.CHECK_UNION_OF_TWO_SETS_LOG;
import static main.LogMessages.COMBINED_SET_MUST_CONTAIN_LOG;
import static main.LogMessages.EMPTY_SET_LOG;
import static main.LogMessages.FILLED_SET_LOG;
import static main.LogMessages.INITIALIZATION_OF_TWO_SETS_LOG;
import static main.LogMessages.SET_COMBINED_LOG;
import static main.LogMessages.SIZE_OF_SET_AFTER_UNION_WITH_EMPTY_SET_LOG;
import static main.LogMessages.SIZE_OF_THE_SET1_LOG;
import static main.LogMessages.SIZE_OF_THE_SET1_SHOULD_REMAIN_LOG;
import static main.LogMessages.SIZE_OF_THE_SET2_LOG;
import static main.LogMessages.SIZE_OF_THE_SET2_SHOULD_REMAIN_LOG;
import static main.LogMessages.UNION_WITH_EMPTY_SET_LOG;
import static main.LogMessages.VALUE_COMBINED_SET_LOG;
import static main.StringConstants.APPLE;
import static main.StringConstants.BANANA;
import static main.StringConstants.MELON;
import static main.StringConstants.PEACH;
import static main.StringConstants.WATERMELON;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Log4j
public class SetExampleTest {
    private Set<String> set1;
    private Set<String> set2;

    @BeforeEach
    public void setUp() {
        // Инициализация множеств перед каждым тестом
        set1 = new HashSet<>();
        set1.add(APPLE);
        set1.add(BANANA);
        set1.add(MELON);
        set2 = new HashSet<>();
        set2.add(BANANA);
        set2.add(WATERMELON);
        set2.add(PEACH);
    }

    /**
     * Тест проверки объединения двух множеств.
     */
    @Test
    @DisplayName("Проверка объединения двух множеств")
    public void unionOfSetsTest() {
        log.info(String.format(INITIALIZATION_OF_TWO_SETS_LOG, set1, set2));
        log.info(CHECK_UNION_OF_TWO_SETS_LOG);
        // Копируем первое множество
        Set<String> unionSet = new HashSet<>(set1);
        // Объединяем с вторым множеством
        unionSet.addAll(set2);
        log.info(SET_COMBINED_LOG + unionSet);
        assertEquals(INT_5, unionSet.size(), (String.format(VALUE_COMBINED_SET_LOG, INT_5)));
        assertTrue(unionSet.contains(APPLE), (String.format(COMBINED_SET_MUST_CONTAIN_LOG, APPLE)));
        assertTrue(unionSet.contains(BANANA), (String.format(COMBINED_SET_MUST_CONTAIN_LOG, BANANA)));
        assertTrue(unionSet.contains(MELON), (String.format(COMBINED_SET_MUST_CONTAIN_LOG, MELON)));
        assertTrue(unionSet.contains(WATERMELON), (String.format(COMBINED_SET_MUST_CONTAIN_LOG, WATERMELON)));
        assertTrue(unionSet.contains(PEACH), (String.format(COMBINED_SET_MUST_CONTAIN_LOG, PEACH)));
    }

    /**
     * Тест проверки, что оригинальные множества не изменяются после объединения.
     */
    @Test
    @DisplayName("Проверка на неизменность оригинальных множеств после объединения")
    public void originalSetsUnchangedTest() {
        log.info(String.format(INITIALIZATION_OF_TWO_SETS_LOG, set1, set2));
        log.info(CHECK_IMMUTABILITY_ORIGINAL_SETS_AFTER_UNION_LOG);
        Set<String> unionSet = new HashSet<>(set1);
        unionSet.addAll(set2);
        log.info(SIZE_OF_THE_SET1_LOG + set1.size());
        log.info(SIZE_OF_THE_SET2_LOG + set2.size());
        assertEquals(INT_3, set1.size(), SIZE_OF_THE_SET1_SHOULD_REMAIN_LOG + INT_3);
        assertEquals(INT_3, set2.size(), SIZE_OF_THE_SET2_SHOULD_REMAIN_LOG + INT_3);
    }

    /**
     * Тест проверки объединения пустого множества.
     */
    @Test
    @DisplayName("Проверка на объединение с пустым множеством")
    public void unionWithEmptySetTest() {
        Set<String> emptySet = new HashSet<>();
        Set<String> unionSet = new HashSet<>(set1);
        unionSet.addAll(emptySet);
        log.info(EMPTY_SET_LOG + emptySet);
        log.info(FILLED_SET_LOG + set1);
        log.info(UNION_WITH_EMPTY_SET_LOG + unionSet);
        assertEquals(INT_3, unionSet.size(), SIZE_OF_SET_AFTER_UNION_WITH_EMPTY_SET_LOG + INT_3);
    }
}