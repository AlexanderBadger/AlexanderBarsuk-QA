import java.math.BigDecimal;
import java.math.RoundingMode;

public class VariablesTheme {
    public static void main(String[] args) {
        //Задание 1. Вывод характеристик компьютера
        System.out.println("1. Вывод характеристик компьютера");
        byte core = 8;
        short ram = 16384;
        int ssd = 500000000;
        long gpu = 8000000000L;
        float powerUnit = 0.5F;
        double cpu = 2.60;
        boolean isPowerful = true;
        char ramUnit = '2';
        System.out.println(core + " - кол-во ядер\n" + ram + " мегабайт - объем оперативной памяти\n" + ssd
                + " килобайт - объем твердотельного накопителя\n" + gpu
                + " байт - объем памяти графического ускорителя\n" + powerUnit + " киловатт - мощность блока питания\n"
                + cpu + " гигагерц - тактовая частота процессора\n" + isPowerful + " - мощный ли он?\n" + ramUnit
                + " - кол-во плашек оперативной памяти\n");

        //Задание 2. Расчет стоимости товара со скидкой
        System.out.println("2. Расчет стоимости товара со скидкой");
        var pen = new BigDecimal("105.5");
        var book = new BigDecimal("235.83");
        var discount = new BigDecimal("0.11");
        BigDecimal sum = pen.add(book);
        BigDecimal multi = sum.multiply(discount).setScale(2, RoundingMode.HALF_UP);
        BigDecimal sub = sum.subtract(multi);
        System.out.println(sum + " - общая стоимость товаров без скидки\n" + multi + " - сумма скидки\n"
                + sub + " - общая стоимость товаров со скидкой\n");

        //Задание 3. Вывод слова JAVA
        System.out.println("3. Вывод слова JAVA");
        System.out.println("   J     a  v     v  a\n   J    a a  v   v  a a\nJ  J   aaaaa  V V  aaaaa\n "
                + "JJ   a     a  V  a     a\n");

        //Задание 4. Вывод min и max значений целых числовых типов
        System.out.println("4. Вывод min и max значений целых числовых типов");
        byte byteVariable = 127;
        short shortVariable = 32767;
        int intVariable = 2147483647;
        long longVariable = 9223372036854775807L;
        System.out.println("Первоначальное значение byteVariable = " + byteVariable + "\n"
                + "Первоначальное значение shortVariable = " + shortVariable + "\n"
                + "Первоначальное значение intVariable = " + intVariable + "\n"
                + "Первоначальное значение longVariable = " + longVariable + "\n"
                + "Инкремент byteVariable = " + ++byteVariable + "\n"
                + "Инкремент shortVariable = " + ++shortVariable + "\n"
                + "Инкремент intVariable = " + ++intVariable + "\n"
                + "Инкремент longVariable = " + ++longVariable + "\n"
                + "Декремент byteVariable = " + --byteVariable + "\n"
                + "Декремент shortVariable = " + --shortVariable + "\n"
                + "Декремент intVariable = " + --intVariable + "\n"
                + "Декремент longVariable = " + --longVariable + "\n");

        //Задание 5. Перестановка значений переменных
        System.out.println("5. Перестановка значений переменных");
        int variable1 = 2;
        int variable2 = 5;
        System.out.println("Первоначальные значения: variable1 = " + variable1 + ", variable2 = " + variable2);
        int temp = (byte) variable1;
        variable1 = variable2;
        variable2 = temp;
        System.out.println("Перестановка с помощью третьей переменной: variable1 = " + variable1 + ", variable2 = "
                + variable2);
        variable1 += variable2;
        variable2 = variable1 - variable2;
        variable1 -= variable2;
        System.out.println("Перестановка с помощью арифметической операции: variable1 = " + variable1 + ", variable2 = "
                + variable2);
        variable1 ^= variable2;
        variable2 ^= variable1;
        variable1 ^= variable2;
        System.out.println("Перестановка с помощью битовой операции: variable1 = " + variable1 + ", variable2 = "
                + variable2 + "\n");

        //Задание 6. Вывод символов и их кодов
        System.out.println("6. Вывод символов и их кодов");
        char dollar = '$';
        char asterisk = '*';
        char atSign = '@';
        char verticalBar = '|';
        char tilde = '~';
        System.out.println(dollar + " = " + (int) dollar + "\n" + asterisk + " = " + (int) asterisk + "\n" + atSign
                + " = " + (int) atSign + "\n" + verticalBar + " = " + (int) verticalBar + "\n" + tilde + " = "
                + (int) tilde + "\n");

        //Задание 7. Вывод в консоль ASCII-арт Дюка
        System.out.println("7. Вывод в консоль ASCII-арт Дюка");
        char slash = '/';
        char backSlash = '\\';
        char underscore = '_';
        char leftParenthesis = '(';
        char rightParenthesis = ')';
        System.out.printf("    %c%c\n", slash, backSlash);
        System.out.printf("   %c  %c\n", slash, backSlash);
        System.out.printf("  %c%c%c %c%c\n", slash, underscore, leftParenthesis, rightParenthesis, backSlash);
        System.out.printf(" %c      %c\n", slash, backSlash);
        System.out.printf("%c%c%c%c%c%c%c%c%c%c\n\n", slash, underscore, underscore, underscore, underscore, slash,
                backSlash, underscore, underscore, backSlash);

        //Задание 8. Вывод количества сотен, десятков и единиц числа
        System.out.println("8. Вывод количества сотен, десятков и единиц числа");
        int number = 123;
        int hundreds = number / 100;
        int tens = number / 10 % 10;
        int units = number % 10;
        int total = hundreds + tens + units;
        int multiply = hundreds * tens * units;
        System.out.println("Число " + number + " содержит:\n  сотен - " + hundreds + "\n  десятков - " + tens
                + "\n  единиц - " + units + "\nСумма его цифр = " + total + "\nПроизведение = " + multiply + "\n");

        //Задание 9. Вывод времени
        System.out.println("9. Вывод времени");
        int sec = 86399;
        int hh = sec / 3600;
        int mm = sec % 3600 / 60;
        int ss = sec % 60;
        System.out.println(hh + ":" + mm + ":" + ss);
    }
}