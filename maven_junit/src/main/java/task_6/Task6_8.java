package task_6;

import static task_6.Constants.PALINDROME;
import static task_6.Constants.SPACE;

public class Task6_8 {
    public static void main(String[] args) {
        System.out.println("Задание 8. Замена вхождений");
        for (String lineString : PALINDROME) {
            System.out.print(lineString + " - ");
            System.out.println(customReplaceAll(lineString, SPACE, "ПРОБЕЛ"));
            System.out.print(lineString + " - ");
            System.out.println(customReplaceAll(lineString, "о", "ООО"));
        }
    }

    public static String customReplaceAll(String str, String oldStr, String newStr) {
        if ("".equals(str) || "".equals(oldStr) || oldStr.equals(newStr)) {
            return str;
        }
        if (newStr == null) {
            newStr = "";
        }
        final int strLength = str.length();
        final int oldStrLength = oldStr.length();
        StringBuilder builder = new StringBuilder(str);
        for (int i = 0; i < strLength; i++) {
            int index = builder.indexOf(oldStr, i);
            if (index == -1) {
                if (i == 0) {
                    return str;
                }
                return builder.toString();
            }
            builder = builder.replace(index, index + oldStrLength, newStr);
        }
        return builder.toString();
    }
}