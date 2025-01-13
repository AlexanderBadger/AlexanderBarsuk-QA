package src.Task_6;

import java.util.Arrays;

import static Task_6.Constants.EMPTY_LINES;

public class Task6_7 {
    public static void main(String[] args) {
        System.out.println("Задание 7. Поиск пустой строки");
        System.out.println(Arrays.deepToString(EMPTY_LINES));
        for (int i = 0; i < EMPTY_LINES.length; i++) {
            if (EMPTY_LINES[i].trim().isEmpty()) {
                System.out.println("Индекс пустой строки = " + i);
            }
        }
    }
}