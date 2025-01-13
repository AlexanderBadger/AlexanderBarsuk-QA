package src.Task_6;

import static Task_6.Constants.RUS_VOWELS;
import static Task_6.Constants.STRING_FOR_TASK;

public class Task6_4 {
    public static void main(String[] args) {
        System.out.println("Задание 4. Вывод информации о строке");
        for (String lines : STRING_FOR_TASK) {
            int digitCount = 0;
            int letterCount = 0;
            int spaceCount = 0;
            int vowelCount = 0;
            for (char c : lines.toCharArray()) {
                if (Character.isDigit(c)) {
                    digitCount++;
                } else if (Character.isLetter(c)) {
                    letterCount++;
                    if (isVowel(c)) {
                        vowelCount++;
                    }
                } else if (Character.isWhitespace(c)) {
                    spaceCount++;
                }
            }
            System.out.printf("Строка: %s%nСтрока в верхнем регистре: %s%nСтрока в нижнем регистре: %s%n" +
                            "Чисел: %d%nБукв: %d%nПробелов: %d%nГласных букв: %d%n%n", lines, lines.toUpperCase(),
                    lines.toLowerCase(), digitCount, letterCount, spaceCount, vowelCount);
        }
    }

    public static boolean isVowel(char c) {
        return RUS_VOWELS.contains(String.valueOf(c).toLowerCase());
    }
}