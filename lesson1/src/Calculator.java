package src;

public class Calculator {
    public static void main(String[] args) {
        int a = 10;
        int b = 3;
        char sign = '/';
        double result = 1.0;
        final String DIVIDING_BY_ZERO = "На 0 делить нельзя!";
        if (sign == '+') {
            result = a + b;
        } else if (sign == '-') {
            result = a - b;
        } else if (sign == '*') {
            result = a * b;
        } else if (sign == '^') {
            for (int i = 1; i <= b; i++) {
                result = result * a;
            }
        } else if (sign == '/' || sign == '%') {
            if (b == 0) {
                System.out.println(DIVIDING_BY_ZERO);
                return;
            } else if (sign == '/') {
                result = (double) a / b;
            } else if (sign == '%') {
                result = a % b;
            }
        }
        System.out.print(a + " " + sign + " " + b + " = " + result);
    }
}