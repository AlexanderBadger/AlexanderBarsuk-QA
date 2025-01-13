package src.Task_6;

import static Task_6.Constants.ALLOWED_SYMBOLS;
import static Task_6.Constants.PALINDROME;

public class Task6_3 {
    public static void main(String[] args) {
        System.out.println("Задание 3. Проверка строки на палиндромность");
        for (String linePalindrome : PALINDROME) {
            System.out.print(linePalindrome + " - ");
            if (isPalindromeUsingStringBuilder(linePalindrome)) {
                System.out.println(": строка является палиндромом.");
            } else {
                System.out.println(": строка не является палиндромом.");
            }
        }
    }

    public static boolean isPalindromeUsingStringBuilder(String text) {
        String clean = text.replaceAll(ALLOWED_SYMBOLS, "").toLowerCase();
        StringBuilder plain = new StringBuilder(clean);
        StringBuilder reverse = plain.reverse();
        System.out.print(reverse);
        return (reverse.toString()).equals(clean);
    }
}