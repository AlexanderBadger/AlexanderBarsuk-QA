package src;

public class CyclesTheme {
    public static void main(String[] args) {
        //Задание 1. Подсчет суммы четных и нечетных чисел
        System.out.println("Задание 1. Подсчет суммы четных и нечетных чисел");
        final int FIRST_NUMBER = -10;
        final int LAST_NUMBER = 21;
        int currentNumber = FIRST_NUMBER;
        int sumEven = 0;
        int sumUneven = 0;
        do {
            if (currentNumber % 2 == 0) {
                sumEven += currentNumber;
            } else {
                sumUneven += currentNumber;
            }
            currentNumber++;
        } while (currentNumber <= LAST_NUMBER);
        System.out.println("В отрезке [" + FIRST_NUMBER + "," + LAST_NUMBER + "] сумма четных чисел = "
                + sumEven + ", а нечетных = " + sumUneven);

        //Задание 2. Вывод чисел в порядке убывания
        System.out.println("\nЗадание 2. Вывод чисел в порядке убывания");
        int num1 = 10;
        int num2 = 10;
        int num3 = 5;
        int maxim = 0;
        int minim = 0;
        if (num1 >= num2 && num1 >= num3) {
            maxim = num1;
            if (num2 >= num3) {
                minim = num3;
            } else {
                minim = num2;
            }
        } else if (num2 >= num1 && num2 >= num3) {
            maxim = num2;
            if (num1 >= num3) {
                minim = num3;
            } else {
                minim = num1;
            }
        } else if (num3 >= num1 && num3 >= num2) {
            maxim = num3;
            if (num1 >= num2) {
                minim = num2;
            } else {
                minim = num1;
            }
        }
        System.out.println("Максимальное число = " + maxim + "\nМинимальное число = " + minim);
        for (int i = (maxim - 1); i > minim; i--) {
            System.out.printf("%d ", i);
        }

        //Задание 3. Вывод реверсивного числа и суммы его цифр
        System.out.println("\n\nЗадание 3. Вывод реверсивного числа и суммы его цифр");
        int normalNumber = 1234;
        int reverseNumber;
        int sumOfNumbers = 0;
        while (normalNumber != 0) {
            if (normalNumber > 0) {
                reverseNumber = normalNumber % 10;
                normalNumber = normalNumber / 10;
                sumOfNumbers += reverseNumber;
                System.out.print(reverseNumber);
            } else if (normalNumber < 0) {
                normalNumber = -normalNumber;
                reverseNumber = (normalNumber % 10);
                normalNumber = normalNumber / 10;
                sumOfNumbers += reverseNumber;
                System.out.printf("%c%d", '-', reverseNumber);
            }
        }
        System.out.println("\nСумма цифр полученного числа = " + sumOfNumbers);

        //Задание 4. Вывод чисел в несколько строк
        System.out.println("\nЗадание 4. Вывод чисел в несколько строк");
        int fromPoint = 1;
        int toPoint = 24;
        int count = 0;
        final int STRING_LENGTH = 5;
        for (int i = fromPoint; i < toPoint; i++) {
            if (i % 2 != 0) {
                System.out.printf("%3d ", i);
                count++;
                if (count % STRING_LENGTH == 0) {
                    System.out.println();
                }
            }
        }
        int remaining = count % STRING_LENGTH;
        if (remaining != 0) {
            for (int i = remaining; i < STRING_LENGTH; i++) {
                System.out.printf("%3d ", 0);
            }
            System.out.println();
        }

        //Задание 5. Проверка количества двоек числа на четность/нечетность
        System.out.println("\nЗадание 5. Проверка количества двоек числа на четность/нечетность");
        final int ORIGIN_NUMBER = 3242592;
        int numberWithTwos = ORIGIN_NUMBER;
        int countTwos = 0;
        while (numberWithTwos != 0) {
            if (numberWithTwos % 10 == 2 || numberWithTwos % 10 == -2) {
                countTwos++;
            }
            numberWithTwos = numberWithTwos / 10;
        }
        if (countTwos % 2 != 0) {
            System.out.println("В " + ORIGIN_NUMBER + " нечетное количество двоек — " + countTwos);
        } else if (countTwos % 2 == 0 && countTwos != 0) {
            System.out.println("В " + ORIGIN_NUMBER + " четное количество двоек — " + countTwos);
        } else {
            System.out.println("В " + ORIGIN_NUMBER + " нет двоек");
        }

        //Задание 6. Отображение геометрических фигур
        System.out.println("\nЗадание 6. Отображение геометрических фигур");
        //Прямоугольник
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print("*");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
        //Прямоугольный треугольник
        int cellQuantity = 5;
        var cell = "#";
        while (cellQuantity > 0) {
            var repeat = cell.repeat(cellQuantity);
            cellQuantity--;
            System.out.println(repeat);
        }
        System.out.print("\n");
        //Равнобедренный треугольник
        var dollar = "$";
        int dollarQuantity = 1;
        do {
            var repeat = dollar.repeat(dollarQuantity);
            System.out.println(repeat);
            dollarQuantity++;
        }
        while (dollarQuantity < 3);
        do {
            var repeat = dollar.repeat(dollarQuantity);
            System.out.println(repeat);
            dollarQuantity--;
        }
        while (dollarQuantity >= 1);

        //Задание 7. Отображение ASCII-символов
        System.out.println("\nЗадание 7. Отображение ASCII-символов");
        System.out.printf("%-9s %-9s %-20s\n", "DECIMAL", "CHARACTER", "DESCRIPTION");
        for (int i = 15; i <= 'z'; i++) {
            char character = (char) i;
            if (i % 2 != 0 && i < '0') {
                System.out.printf("   %-9d  %-9c  %-20s\n", i, character, Character.getName(i));
            }
            if (Character.isLowerCase(character) && i % 2 == 0) {
                System.out.printf("   %-9d  %-9c  %-20s\n", i, character, Character.getName(i));
            }
        }

        //Задание 8. Проверка, является ли число палиндромом
        System.out.println("\nЗадание 8. Проверка, является ли число палиндромом");
        int number = 1234321;
        int originalNumber = number;
        int reversedNumber = 0;
        while (number != 0) {
            int remainder = number % 10;
            reversedNumber = reversedNumber * 10 + remainder;
            number = number / 10;
        }
        if (originalNumber == reversedNumber) {
            System.out.println("Число " + originalNumber + " является палиндромом.");
        } else {
            System.out.println("Число " + originalNumber + " не является палиндромом.");
        }

        //Задание 9. Проверка, является ли число счастливым
        System.out.println("\nЗадание 9. Проверка, является ли число счастливым");
        final int HAPPY_NUMBER = 123456;
        int leftNumber = HAPPY_NUMBER / 1000;
        int rightNumber = HAPPY_NUMBER - (leftNumber * 1000);
        int sumOfLeftNumbers = 0;
        int sumOfRightNumbers = 0;
        int leftNumber1, rightNumber1;
        int leftNumber2 = leftNumber;
        int rightNumber2 = rightNumber;
        while (leftNumber > 0) {
            leftNumber1 = leftNumber % 10;
            leftNumber = leftNumber / 10;
            sumOfLeftNumbers += leftNumber1;
        }
        while (rightNumber > 0) {
            rightNumber1 = rightNumber % 10;
            rightNumber = rightNumber / 10;
            sumOfRightNumbers += rightNumber1;
        }
        if (sumOfLeftNumbers == sumOfRightNumbers) {
            System.out.printf("Число " + HAPPY_NUMBER + " является счастливым\n");
        } else {
            System.out.printf("Число " + HAPPY_NUMBER + " не является счастливым\n");
        }
        System.out.println("Сумма цифр " + leftNumber2 + " = " + sumOfLeftNumbers
                + ", а сумма " + rightNumber2 + " = " + sumOfRightNumbers);

        //Задание 10. Отображение таблицы умножения Пифагора
        System.out.println("\nЗадание 10. Отображение таблицы умножения Пифагора");
        int i, j;
        System.out.printf("   |");
        for (i = 2; i < 10; i++)
            System.out.printf("%2d ", i);
        System.out.print("\n---|------------");
        System.out.print("-----------\n");
        for (i = 2; i < 10; i++) {
            System.out.printf("%2d |", i);
            for (j = 2; j < 10; j++)
                System.out.printf("%2d ", i * j);
            System.out.println();
        }
    }
}