package junit_calc;

import lombok.extern.log4j.Log4j;
import task_7.Task_7_calc.Triangle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Log4j
class TriangleTest {
    //Позитивная проверка расчета периметра треугольника
    @Test
    void calculatePerimeter() {
        Triangle triangle = new Triangle(10, 5, 10);
        double actual = triangle.CalculatePerimeter();
        double expected = 25.0;
        assertEquals(expected, actual);
        log.info("Проверка вычисления периметра пройдена. Ожидаемый результат: " + expected
                + ", Фактический результат: " + actual);
    }

    //Позитивная проверка расчета площади треугольника
    @Test
    void calculateArea() {
        Triangle triangle = new Triangle(10, 5, 10);
        double actual = triangle.CalculateArea();
        double expected = 24.206;
        assertEquals(expected, actual, 0.001);
        log.info("Проверка вычисления площади пройдена. Ожидаемый результат: " + expected
                + ", Фактический результат: " + actual);
    }
}