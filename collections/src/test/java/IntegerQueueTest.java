import lombok.extern.log4j.Log4j;
import main.IntegerQueue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static main.IntegerConstants.INT_2;
import static main.IntegerConstants.INT_3;
import static main.IntegerConstants.QUEUE_ELEMENT_10;
import static main.IntegerConstants.QUEUE_ELEMENT_20;
import static main.IntegerConstants.QUEUE_ELEMENT_30;
import static main.LogMessages.QUEUE_INITIALIZED_LOG;
import static main.LogMessages.QUEUE_NEXT_ELEMENT_LOG;
import static main.LogMessages.TEST_LAUNCH_LOG;
import static main.LogMessages.TRY_DELETE_FROM_EMPTY_QUEUE_LOG;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Log4j
public class IntegerQueueTest {
    private IntegerQueue queue;

    @BeforeEach
    public void setUp() {
        queue = new IntegerQueue();
        log.info(QUEUE_INITIALIZED_LOG);
    }

    @Test
    @DisplayName("Проверка добавления и удаления элементов из очереди")
    public void enqueueAndDequeueTest() {
        log.info(TEST_LAUNCH_LOG);
        queue.enqueue(QUEUE_ELEMENT_10);
        queue.enqueue(QUEUE_ELEMENT_20);
        queue.enqueue(QUEUE_ELEMENT_30);
        assertEquals(INT_3, queue.size());
        assertFalse(queue.isEmpty());
        assertEquals(QUEUE_ELEMENT_10, queue.dequeue());
        assertEquals(INT_2, queue.size());
        assertEquals(QUEUE_ELEMENT_20, queue.peek());
        log.info(QUEUE_NEXT_ELEMENT_LOG + queue.peek());
    }

    @Test
    @DisplayName("Проверка удаления элемента из пустой очереди")
    public void dequeueFromEmptyQueueTest() {
        log.info(TEST_LAUNCH_LOG);
        assertNull(queue.dequeue());
        log.info(TRY_DELETE_FROM_EMPTY_QUEUE_LOG);
        assertTrue(queue.isEmpty());
    }
}