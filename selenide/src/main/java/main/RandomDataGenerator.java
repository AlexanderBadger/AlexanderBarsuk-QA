package main;

import java.util.Random;

import static main.constants.IntegerConstants.INT_10;
import static main.constants.IntegerConstants.INT_8;
import static main.constants.IntegerConstants.INT_ZERO;
import static main.constants.IntegerConstants.RANDOM_GENERATOR_BOUND;
import static main.constants.StringConstants.RANDOM_LOGIN_EXAMPLE;

public class RandomDataGenerator {
    private static final String EMAIL_DOMAIN = RANDOM_LOGIN_EXAMPLE;
    private static final Random RANDOM = new Random();

    public static String generateRandomEmail() {
        StringBuilder email = new StringBuilder();
        for (int i = INT_ZERO; i < INT_10; i++) {
            // Генерация случайной буквы
            char ch = (char) ('a' + RANDOM.nextInt(RANDOM_GENERATOR_BOUND));
            email.append(ch);
        }
        email.append(EMAIL_DOMAIN);
        return email.toString();
    }

    public static String generateRandomPassword() {
        StringBuilder password = new StringBuilder();
        for (int i = INT_ZERO; i < INT_8; i++) {
            // Генерация случайной буквы
            char ch = (char) ('a' + RANDOM.nextInt(RANDOM_GENERATOR_BOUND));
            password.append(ch);
        }
        return password.toString();
    }
}