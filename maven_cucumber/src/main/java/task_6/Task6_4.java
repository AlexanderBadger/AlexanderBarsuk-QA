package task_6;

import static task_6.Constants.RUS_VOWELS;
import static task_6.Constants.STRING_FOR_TASK;

public class Task6_4 {
    public static void main(String[] args) {
        System.out.println("4. Вывод информации о строке");

        for (String line : STRING_FOR_TASK) {
            if (line.isEmpty()) {
                System.out.println("\nИсходная строка пустая");
                continue;
            }
            printAllParams(line);
            System.out.println("Строка в верхнем регистре: \"" + line.toUpperCase() + "\"");
            System.out.println("Строка в нижнем регистре: \"" + line.toLowerCase() + "\"");
        }
    }

    public static int getStringParams(String s, TypeParamEnum param) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        if (param.equals(TypeParamEnum.LENGTH)) {
            return s.length();
        }

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char targetChar = s.charAt(i);
            if (param.equals(TypeParamEnum.DIGIT) && Character.isDigit(targetChar)) {
                count++;
            } else if (param.equals(TypeParamEnum.LETTER) && Character.isAlphabetic(targetChar)) {
                count++;
            } else if (param.equals(TypeParamEnum.SPACE) && targetChar == ' ') {
                count++;
            } else if (param.equals(TypeParamEnum.VOWEL) && RUS_VOWELS.contains(String.valueOf(targetChar))) {
                count++;
            }
        }
        return count;
    }

    public static void printAllParams(String string) {
        String[] messages = {"Длина строки: ",
                "Количество цифр в строке: ",
                "Количество букв в строке: ",
                "Количество пробелов в строке: ",
                "Количество гласных букв в строке: "};
        TypeParamEnum[] params = {TypeParamEnum.LENGTH,
                TypeParamEnum.DIGIT,
                TypeParamEnum.LETTER,
                TypeParamEnum.SPACE,
                TypeParamEnum.VOWEL};

        StringBuilder result = new StringBuilder(String.format("%nИсходная строка: \"%s\"%n", string));

        for (int i = 0; i < messages.length; i++) {
            result.append(messages[i]).append(getStringParams(string, params[i])).append("\n");
        }
        System.out.println(result);
    }

    public static boolean isVowel(char c) {
        return RUS_VOWELS.contains(String.valueOf(c).toLowerCase());
    }
}