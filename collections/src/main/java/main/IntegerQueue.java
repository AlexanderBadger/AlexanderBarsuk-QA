package main;

import lombok.extern.log4j.Log4j;

import java.util.LinkedList;
import java.util.Queue;

import static main.LogMessages.ADD_ELEMENT_LOG;
import static main.LogMessages.QUEUE_DELETE_ELEMENT_LOG;
import static main.LogMessages.QUEUE_IS_EMPTY_LOG;

/**
 * Класс {@code IntegerQueue} представляет собой очередь целых чисел.
 * Он использует {@link LinkedList} для хранения элементов очереди.
 * <p>
 * Очередь реализует стандартные операции добавления, удаления и просмотра элементов.
 * </p>
 */
@Log4j
public class IntegerQueue {
    private final Queue<Integer> queue;

    /**
     * Конструктор, инициализирующий пустую очередь.
     */
    public IntegerQueue() {
        this.queue = new LinkedList<>();
    }

    /**
     * Добавляет элемент в конец очереди.
     *
     * @param element элемент, который нужно добавить в очередь
     */
    public void enqueue(int element) {
        queue.add(element);
        log.info(ADD_ELEMENT_LOG + element);
    }

    /**
     * Удаляет и возвращает элемент из начала очереди.
     * <p>
     * Возвращает {@code null}, если очередь пуста.
     * </p>
     *
     * @return удаленный элемент или {@code null}, если очередь пуста
     */
    public Integer dequeue() {
        Integer removedElement = queue.poll();
        if (removedElement != null) {
            log.info(QUEUE_DELETE_ELEMENT_LOG + removedElement);
        } else {
            log.info(QUEUE_IS_EMPTY_LOG);
        }
        return removedElement;
    }

    /**
     * Проверяет, пуста ли очередь.
     *
     * @return {@code true}, если очередь пуста, {@code false} в противном случае
     */
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    /**
     * Возвращает количество элементов в очереди.
     *
     * @return количество элементов в очереди
     */
    public int size() {
        return queue.size();
    }

    /**
     * Возвращает элемент из начала очереди, не удаляя его.
     * <p>
     * Возвращает {@code null}, если очередь пуста.
     * </p>
     *
     * @return элемент из начала очереди или {@code null}, если очередь пуста
     */
    public Integer peek() {
        return queue.peek();
    }
}