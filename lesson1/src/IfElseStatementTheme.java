package src;

public class IfElseStatementTheme {
    public static void main(String[] args) {
        //Задание 1. Перевод псевдокода на язык Java
        System.out.println("1. Перевод псевдокода на язык Java");
        int age = 32;
        if (age > 20) {
            System.out.println("You're already " + age + "! Well you're an old man!");
        } else {
            System.out.println("You are only " + age + " years old! Whole life ahead!");
        }
        String checkGender = "male";
        String gender = "male";
        if (gender.equals(checkGender)) {
            System.out.println("You are not a woman!");
        } else {
            System.out.println("You're not a man!");
        }
        double height = 1.81;
        if (height < 1.80) {
            System.out.println("Your height is less than 1.80! Are you a dwarf?");
        } else {
            System.out.println("Your height is more than 1.80! Are you a elf?");
        }
        char firstLetterOfName = "Alex".charAt(0);
        if (firstLetterOfName == 'M') {
            System.out.println("Your name starts with the letter 'M'");
        } else if (firstLetterOfName == 'I') {
            System.out.println("Your name starts with the letter 'I'");
        } else {
            System.out.println("Your name starts with the letter '" + firstLetterOfName + "'");
        }

        //Задание 2. Поиск max и min числа
        System.out.println("\n2. Поиск max и min числа");
        int variable1 = 100;
        int variable2 = 120;
        if (variable1 > variable2) {
            System.out.println("Max число = " + variable1 + "\n" + "Min число = " + variable2);
        } else if (variable1 < variable2) {
            System.out.println("Max число = " + variable2 + "\n" + "Min число = " + variable1);
        } else {
            System.out.println("Число 1 = " + variable1 + "\n" + "Число 2 = " + variable2 + "\n" + "Они равны");
        }

        //Задание 3. Проверка числа
        System.out.println("\n3. Проверка числа");
        int variable = -10;
        if (variable == 0) {
            System.out.println("Число является нулём");
        } else {
            if ((variable % 2) == 0 && variable > 0) {
                System.out.println("Число " + variable + " четное и положительное");
            } else if ((variable % 2) != 0 && variable > 0) {
                System.out.println("Число " + variable + " нечетное и положительное");
            } else if ((variable % 2) == 0 && variable < 0) {
                System.out.println("Число " + variable + " четное и отрицательное");
            } else {
                System.out.println("Число " + variable + " нечетное и отрицательное");
                }
            }

        //Задание 4. Поиск одинаковых цифр в числах
        System.out.println("\n4. Поиск одинаковых цифр в числах");
        int num1 = 123;
        int num2 = 223;
        System.out.println("Исходные числа = " + num1 + " , " + num2);
        if (num1 % 10 != num2 % 10 && num1 / 10 % 10 != num2 / 10 % 10 && num1 / 100 != num2 / 100) {
            System.out.println("There are no equal numbers");
        } else {
            if (num1 % 10 == num2 % 10) {
                System.out.println("Одинаковые цифры в 1 разряде = " + num1 % 10);
            }
            if (num1 / 10 % 10 == num2 / 10 % 10) {
                System.out.println("Одинаковые цифры во 2 разряде = " + num1 / 10 % 10);
            }
            if (num1 / 100 == num2 / 100) {
                System.out.println("Одинаковые цифры в 3 разряде = " + num1 / 100);
            }
        }

        //Задание 5. Определение символа по его коду
        System.out.println("\n5. Определение символа по его коду");
        char symbol = '\u0057';
        if (Character.isLetter(symbol) == false & Character.isDigit(symbol) == false) {
            System.out.println("Символ " + "'" + symbol + "'" + " - не буква и не число");
        } else if (Character.isDigit(symbol) == true) {
            System.out.println("Символ " + "'" + symbol + "'" + " - число");
        } else if (Character.isLowerCase(symbol) == true) {
            System.out.println("Символ " + "'" + symbol + "'" + " - маленькая буква");
        } else if (Character.isUpperCase(symbol) == true) {
            System.out.println("Символ " + "'" + symbol + "'" + " - большая буква");
        }

        //Задание 6. Подсчет суммы вклада и начисленных банком %
        System.out.println("\n6. Подсчет суммы вклада и начисленных банком %");
        int depositAmount = 300000;
        float percent;
        if (depositAmount < 100000) {
            percent = 0.05f;
        } else if (depositAmount <= 300000) {
            percent = 0.07f;
        } else {
            percent = 0.1f;
        }
        System.out.println("Сумма вклада = " + depositAmount + "\n" + "Начисленный процент = " + depositAmount * percent
                + "\n" + "Итоговая сумма = " + (depositAmount + (depositAmount * percent)));

        //Задание 7. Определение оценки по предметам
        System.out.println("\n7. Определение оценки по предметам");
        int history = 59;
        int programming = 92;
        int pointHistory;
        int pointProgramming;
        final int FIVE = 91;
        final int FOUR = 73;
        final int THREE = 60;
        if (history > FIVE) {
            pointHistory = 5;
        } else if (history > FOUR & history <= FIVE) {
            pointHistory = 4;
        } else if (history > THREE & history <= FOUR) {
            pointHistory = 3;
        } else {
            pointHistory = 2;
        }
        if (programming > FIVE) {
            pointProgramming = 5;
        } else if (programming > FOUR & programming <= FIVE) {
            pointProgramming = 4;
        } else if (programming > THREE & programming <= FOUR) {
            pointProgramming = 3;
        } else {
            pointProgramming = 2;
        }
        float averagePoint = (float) (pointHistory + pointProgramming) / 2;
        float averagePercent = (float) (history + programming) / 2;
        System.out.println(pointHistory + " - history\n" + pointProgramming + " - programming\n"
                + averagePoint + " - average point\n" + averagePercent + " - average percent");

        //Задание 8. Расчет прибыли за год
        System.out.println("\n8. Расчет прибыли за год");
        int rentPerMonth = 5000;
        int sales = 13000;
        int costPrice = 9000;
        int profitPerYear = (sales - costPrice - rentPerMonth) * 12;
        if (profitPerYear > 0) {
            System.out.println("Прибыль за год - " + "+" + profitPerYear + " руб.");
        } else {
            System.out.println("Прибыль за год = " + profitPerYear + " руб.");
        }

        //Задание 9. Подсчет количества банкнот
        System.out.println("\n9. Подсчет количества банкнот");
        int withdrawalAmount = 567;
        int hundredsAvailable = 10;
        int tensAvailable = 5;
        int unitsAvailable = 50;
        int issueHundreds;
        int issueTens;
        int issueUnits;
        System.out.println("Выдаваемая сумма = " + withdrawalAmount + " USD");
        if (withdrawalAmount / 100 <= hundredsAvailable) {
            issueHundreds = withdrawalAmount / 100;
            withdrawalAmount -= (withdrawalAmount / 100) * 100;
        } else {
            issueHundreds = hundredsAvailable;
            withdrawalAmount -= hundredsAvailable * 100;
        }
        if (withdrawalAmount / 10 <= tensAvailable) {
            issueTens = withdrawalAmount / 10;
            withdrawalAmount -= (withdrawalAmount / 10) * 10;
        } else {
            issueTens = tensAvailable;
            withdrawalAmount -= tensAvailable * 10;
        }
        if (withdrawalAmount <= unitsAvailable) {
            issueUnits = withdrawalAmount;
            System.out.println("100 USD: " + issueHundreds + "\n"
                    + "10 USD: " + issueTens + "\n" + "1 USD: " + issueUnits);
        } else {
            System.out.println("Банкнот для выдачи суммы недостаточно");
        }
    }
}