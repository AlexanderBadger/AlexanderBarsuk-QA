package src;

import java.util.Random;

public class GuessTheNumber {
    public static void main(String[] args) {
        Random rand = new Random();
        int hiddenNumber = rand.nextInt(101);
        int guessedNumber = 50;
        while (true) {
            if (guessedNumber == hiddenNumber) {
                System.out.println("Вы победили! Компьютер загадал число = " + hiddenNumber);
                break;
            } else if (guessedNumber > hiddenNumber) {
                System.out.println("Число " + guessedNumber + " больше того, что загадал компьютер");
                guessedNumber--;
            } else {
                System.out.println("Число " + guessedNumber + " меньше того, что загадал компьютер");
                guessedNumber++;
            }
        }
    }
}