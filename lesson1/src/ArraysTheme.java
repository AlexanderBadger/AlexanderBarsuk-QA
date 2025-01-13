import java.util.Arrays;
import java.util.Random;

public class ArraysTheme {
    public static void main(String[] args) {
        //Задание 1. Сумма чисел в массиве
        System.out.println("Задание 1. Сумма чисел в массиве");
        final int[] MY_ARRAY = {1, 3, 5, 7, 9, 11};
        int sumNumber = 0;
        for (var arrayElement : MY_ARRAY) {
            sumNumber += arrayElement;
        }
        System.out.println("Сумма чисел в массиве " + Arrays.toString(MY_ARRAY) + " = " + sumNumber);

        //Задание 2. Вывод строк, у которых длина больше 5 символов
        System.out.println("\nЗадание 2. Вывод строк, у которых длина больше 5 символов");
        final String[] STRING_ARRAY = {"Саша", "Маша", "Паша", "Наташа", "Аркаша", "Зульфия"};
        final int STRING_LENGTH = 5;
        boolean longerThanFive = false;
        for (var stringArray : STRING_ARRAY) {
            if (stringArray.length() > STRING_LENGTH) {
                System.out.println(stringArray);
                longerThanFive = true;
            }
        }
        if (!longerThanFive) {
            System.out.println("Все строки в массиве " + Arrays.toString(STRING_ARRAY) + " короче " + STRING_LENGTH
                    + " символов.");
        }

        //Задание 3. Минимальное и максимальное число в массиве
        System.out.println("\nЗадание 3. Минимальное и максимальное число в массиве");
        final int[] MIN_MAX_ARRAY = {10, 3, 20, 7, 9, 11};
        int max = MIN_MAX_ARRAY[0];
        int min = MIN_MAX_ARRAY[0];
        for (int i = 1; i < MIN_MAX_ARRAY.length; i++) {
            max = Math.max(MIN_MAX_ARRAY[i], max);
            min = Math.min(MIN_MAX_ARRAY[i], min);
        }
        System.out.printf("%s %s %s %s %d %s %d\n", "В массиве", Arrays.toString(MIN_MAX_ARRAY), ":",
                "\nмаксимальное число = ", max, "\nминимальное число = ", min);

        //Задание 4. Сортировка массива по возрастанию
        System.out.println("\nЗадание 4. Сортировка массива по возрастанию");
        final int[] SORT_ARRAY = {-6, 3, 20, 0, 9, 11};
        System.out.println("Первоначальный массив - " + Arrays.toString(SORT_ARRAY));
        Arrays.sort(SORT_ARRAY);
        System.out.print("Отсортированный по возрастанию массив - " + Arrays.toString(SORT_ARRAY));

        //Задание 5. Сумма строк двумерного массива
        System.out.println("\n\nЗадание 5. Сумма строк двумерного массива");
        final int[][] TWO_DIM_ARRAY = {{15, -10, 31}, {30, 25, 2}, {9, 10, -11}, {6, 6, 6}};
        System.out.print("В двумерном массиве " + Arrays.deepToString(TWO_DIM_ARRAY) + " :\n");
        for (int i = 0; i < TWO_DIM_ARRAY.length; i++) {
            int lineSum = 0;
            for (int j = 0; j < TWO_DIM_ARRAY[i].length; j++) {
                lineSum += TWO_DIM_ARRAY[i][j];
            }
            System.out.printf("%s%d%s%d\n", "Сумма ", i + 1, " строки = ", lineSum);
        }

        //Задание 6. Наименьший элемент в каждом столбце двумерного массива
        System.out.println("\nЗадание 6. Наименьший элемент в каждом столбце двумерного массива");
        final int[][] MIN_TWO_DIM_ARRAY = {
                {150, -10, 31},
                {30, 25, 20},
                {9, 10, 11},
                {6, 66, 666}
        };
        System.out.println("В двумерном массиве " + Arrays.deepToString(MIN_TWO_DIM_ARRAY) + " :");
        for (int j = 0; j < MIN_TWO_DIM_ARRAY[j].length; j++) {
            min = MIN_TWO_DIM_ARRAY[0][j];
            for (int i = 1; i < MIN_TWO_DIM_ARRAY.length; i++) {
                min = Math.min(MIN_TWO_DIM_ARRAY[i][j], min);
            }
            System.out.printf("%s%d%s%d\n", "Минимальное число ", j + 1, " столбца = ", min);
        }

        //Задание 7. Массив - палиндром
        System.out.println("\nЗадание 7. Массив - палиндром");
        final int[] PALINDROME_ARRAY = {11, 9, 20, 20, 9, 11};
        boolean palindrome = true;
        int len = PALINDROME_ARRAY.length;
        for (int i = 0; i < (len / 2); i++) {
            if (PALINDROME_ARRAY[i] != PALINDROME_ARRAY[len - i - 1]) {
                palindrome = false;
                break;
            }
        }
        if (palindrome) {
            System.out.printf("%s %s %s", "Массив", Arrays.toString(PALINDROME_ARRAY), "является палиндромом");
        } else {
            System.out.printf("%s %s %s", "Массив", Arrays.toString(PALINDROME_ARRAY), "не является палиндромом");
        }

        //Задание 8. Вычисление среднего значения всех элементов в неравномерном массиве
        System.out.println("\n\nЗадание 8. Вычисление среднего значения всех элементов в неравномерном массиве");
        final int[][] UNEVEN_ARRAY = {{1, 2, 3}, {4, 5}, {6, 7, 8, 9}};
        System.out.println("Первоначальный массив - " + Arrays.deepToString(UNEVEN_ARRAY));
        double[] arrayNew = new double[UNEVEN_ARRAY.length];
        for (int i = 0; i < UNEVEN_ARRAY.length; i++) {
            double sum = 0;
            for (int j = 0; j < UNEVEN_ARRAY[i].length; j++) {
                sum += UNEVEN_ARRAY[i][j];
            }
            arrayNew[i] = sum / UNEVEN_ARRAY[i].length;
            System.out.printf("%s%d%s%s" + "\n", "Среднее значение ", i + 1, " строки = ", arrayNew[i]);
        }
        System.out.printf("%s %s\n", "Новый массив -", Arrays.toString(arrayNew));

        //Задание 9. Поиск максимальной суммы подмассива в неравномерном массиве
        System.out.println("\nЗадание 9. Поиск максимальной суммы подмассива в неравномерном массиве");
        final int[][] RANDOM_ARRAY = new int[7][7];
        Random rand = new Random();
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                RANDOM_ARRAY[i][j] = rand.nextInt(200) - 100;
            }
        }
        System.out.println("Случайный массив - " + Arrays.deepToString(RANDOM_ARRAY));
        //Новый массив
        int[] newRandomArray = new int[RANDOM_ARRAY.length];
        for (int i = 0; i < RANDOM_ARRAY.length; i++) {
            int sumArray = 0;
            for (int j = 0; j < RANDOM_ARRAY[i].length; j++) {
                sumArray += RANDOM_ARRAY[i][j];
            }
            newRandomArray[i] += sumArray;
        }
        System.out.printf("%s %s", "Новый массив -", Arrays.toString(newRandomArray));
        //Вычисление максимальной и минимальной суммы
        max = newRandomArray[0];
        min = newRandomArray[0];
        for (int i = 1; i < newRandomArray.length; i++) {
            max = Math.max(newRandomArray[i], max);
            min = Math.min(newRandomArray[i], min);
        }
        System.out.println("\nМаксимальное число = " + max + "\nМинимальное число = "
                + min);
        //Вычисление среднего значения
        double sumNumberArray = 0;
        for (int element : newRandomArray) {
            sumNumberArray += element;
        }
        double averageNewRandomArray = sumNumberArray / newRandomArray.length;
        System.out.printf("%s%.2f", "Среднее значение нового массива = ", averageNewRandomArray);
    }
}