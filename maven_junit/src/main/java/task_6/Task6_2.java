package task_6;

import static task_6.Constants.STRING_FOR_TASK;

public class Task6_2 {
    public static void main(String[] args) {
        System.out.println("Задание 2. Перепись строки в обратном порядке");
        for (String lineString : STRING_FOR_TASK) {
            System.out.print(lineString + " - ");
            System.out.println(reverseString(lineString));
        }
    }

    public static String reverseString(String string) {
        StringBuilder sb = new StringBuilder(string);
        return sb.reverse().toString();
    }
}