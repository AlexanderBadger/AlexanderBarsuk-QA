package junit_calc;

import lombok.extern.log4j.Log4j;
import org.junit.jupiter.api.Test;
import task_7.Task_7_calc.Circle;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Log4j
class CircleTest {
    //Позитивная проверка расчета периметра круга
    @Test
    void calculatePerimeter() {
        Circle circle = new Circle(10);
        double actual = circle.CalculatePerimeter();
        double expected = 62.832;
        assertEquals(expected, actual, 0.001);
        log.info("Проверка вычисления периметра пройдена. Ожидаемый результат: " + expected
                + ", Фактический результат: " + actual);
    }

    //Позитивная проверка расчета площади круга
    @Test
    void calculateArea() {
        Circle circle = new Circle(10);
        double actual = circle.CalculateArea();
        double expected = 314.159;
        assertEquals(expected, actual, 0.001);
        log.info("Проверка вычисления площади пройдена. Ожидаемый результат: " + expected
                + ", Фактический результат: " + actual);
    }
}