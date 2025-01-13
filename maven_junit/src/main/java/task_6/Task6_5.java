package task_6;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static task_6.Constants.OUR_NAMES;
import static task_6.Constants.RUS_CONSONANTS;
import static task_6.Constants.SHORT_NAME;
import static task_6.Constants.SPACE;
import static task_6.Task6_4.isVowel;

public class Task6_5 {
    public static void main(String[] args) {
        System.out.println("Задание 5. Массив с нашими ФИО");
        //Сортировка массива по алфавиту
        List<String> abcSort = Arrays.asList(OUR_NAMES);
        Collections.sort(abcSort);
        System.out.println("Сортировка массива по алфавиту: " + abcSort + "\n");
        //Вывод ФИО, у которых фамилия начинается на гласную
        System.out.println("Фамилия начинается с гласной:");
        for (String lastnames : OUR_NAMES) {
            String[] parts = lastnames.split(SPACE);
            String lastname = parts[0];
            char lastChar = lastname.charAt(0);
            if (isVowel(lastChar)) {
                System.out.println(lastnames);
            }
        }
        //Вывод ФИО, у которых имя кончается на согласную
        System.out.println("\nИмя кончается согласной:");
        for (String names : OUR_NAMES) {
            String[] parts = names.split(SPACE);
            String name = parts[1];
            char lastChar = name.charAt(name.length() - 1);
            if (isConsonant(lastChar)) {
                System.out.println(names);
            }
        }
        //Вывод Фамилия И.О.
        System.out.println("\nВывод в формате Фамилия И.О.:");
        Pattern ptrn = Pattern.compile(SHORT_NAME);
        for (String string : OUR_NAMES) {
            string = string.trim();
            if (string.isEmpty()) {
                continue;
            }
            Matcher m = ptrn.matcher(string);
            if (m.find()) {
                System.out.println(m.group(1) + SPACE
                        + (m.group(3) == null ? "" : (m.group(3).toUpperCase() + "."))
                        + (m.group(5) == null ? "" : (m.group(5).toUpperCase() + ".")));
            }
        }
        //Вывод без повторяющихся символов
        System.out.println("\nВывод ФИО без повторящихся символов:");
        for (String line : OUR_NAMES) {
            StringBuilder uniqueLetters = new StringBuilder();
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < line.length(); i++) {
                String letter = String.valueOf(line.charAt(i));
                if (letter.equals(SPACE) || !uniqueLetters.toString().contains(letter.toLowerCase())) {
                    uniqueLetters.append(letter.toLowerCase());
                    result.append(letter);
                }
            }
            System.out.println(result);
        }
    }

    public static boolean isConsonant(char c) {
        return RUS_CONSONANTS.contains(String.valueOf(c).toLowerCase());
    }
}