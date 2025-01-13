package task_6;

import java.util.Arrays;

import static task_6.Constants.SEPARATION;
import static task_6.Constants.SPACE;
import static task_6.Constants.SPACES;
import static task_6.Constants.STRING_FOR_TASK;

public class Task6_6 {
    public static void main(String[] args) {
        System.out.println("Задание 6. Строки в массив");
        for (String line : STRING_FOR_TASK) {
            line = line.replaceAll(SPACES, SPACE);
            print(line.split(SPACE));
            System.out.printf(" - Количество слов в строке = %d%n", wordCount(line));
        }
    }

    static void print(String[] arr) {
        System.out.print(Arrays.toString(arr));
    }

    public static int wordCount(String inputString) {
        String[] lines = inputString.trim().split(SEPARATION);
        return lines.length;
    }
}