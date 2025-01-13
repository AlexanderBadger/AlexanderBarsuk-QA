package Task_6;

import static Task_6.Constants.STRING_FOR_TASK;

public class Task6_1 {
    public static void main(String[] args) {
        System.out.println("Задание 1. Вывод строки и ее длины");
        for (String lineString : STRING_FOR_TASK) {
            int lineLength = lineString.length();
            System.out.printf("%s. Символов в строке - %d.%n", lineString, lineLength);
        }
        int max = STRING_FOR_TASK[0].length();
        String strMax = STRING_FOR_TASK[0];
        for (int i = 1; i < STRING_FOR_TASK.length; i++) {
            if (STRING_FOR_TASK[i].length() > max) {
                max = STRING_FOR_TASK[i].length();
                strMax = STRING_FOR_TASK[i];
            }
        }
        System.out.printf("%nСамая длинная строка это - %s. Её длина - %d символов.%n", strMax, max);
        int min = STRING_FOR_TASK[0].length();
        String strMin = STRING_FOR_TASK[0];
        for (int i = 1; i < STRING_FOR_TASK.length; i++) {
            if (STRING_FOR_TASK[i].length() <= min) {
                min = STRING_FOR_TASK[i].length();
                strMin = STRING_FOR_TASK[i];
            }
        }
        System.out.printf("Самая короткая строка это - %s. Её длина - %d символов.%n", strMin, min);
    }
}