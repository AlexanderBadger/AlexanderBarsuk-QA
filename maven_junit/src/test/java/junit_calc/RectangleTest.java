package junit_calc;

import lombok.extern.log4j.Log4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import task_7.Task_7_calc.Rectangle;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Log4j
class RectangleTest {
    //Позитивная проверка расчета периметра прямоугольника
    @Test
    void calculatePerimeter() {
        Rectangle rectangle = new Rectangle(10, 15);
        double actual = rectangle.CalculatePerimeter();
        double expected = 50.0;
        assertEquals(expected, actual);
        log.info("Проверка вычисления периметра пройдена. Ожидаемый результат: " + expected
                + ", Фактический результат: " + actual);
    }

    //Позитивная проверка расчета площади прямоугольника
    @Test
    void calculateArea() {
        Rectangle rectangle = new Rectangle(10, 15);
        double actual = rectangle.CalculateArea();
        double expected = 150.0;
        assertEquals(expected, actual);
        log.info("Проверка вычисления площади пройдена. Ожидаемый результат: " + expected
                + ", Фактический результат: " + actual);
    }

    //Негативная проверка создания прямоугольника с некорректными параметрами
    @ParameterizedTest
    @MethodSource("NegativeTestData")
    void createRectangleWithInvalidValues(RectangleNegativeTestData data) {
        assertThrows(IllegalArgumentException.class, () -> new Rectangle(data.width, data.height));
        log.info("Проверка создания прямоугольника с некорректными параметрами пройдена");
    }

    //Позитивный параметризованный тест расчета периметра и площади прямоугольника
    @ParameterizedTest
    @MethodSource("testData")
    void parameterizedCalculatePerimeter(RectangleTestData data) {
        Rectangle rectangle = new Rectangle(data.width, data.height);
        double actualPerimeter = rectangle.CalculatePerimeter();
        double actualArea = rectangle.CalculateArea();
        assertEquals(data.expectedPerimeter, actualPerimeter);
        assertEquals(data.expectedArea, actualArea);
        log.info("Создание прямоугольника и расчет параметров: параметризованный тест пройден");
    }

    static class RectangleNegativeTestData {
        double width;
        double height;

        public RectangleNegativeTestData(double width, double height) {
            this.width = width;
            this.height = height;
        }
    }

    private static Stream<RectangleNegativeTestData> NegativeTestData() {
        return Stream.of(
                new RectangleNegativeTestData(-5, 10),
                new RectangleNegativeTestData(0, 10)
        );
    }

    static class RectangleTestData {
        double width;
        double height;
        double expectedPerimeter;
        double expectedArea;

        public RectangleTestData(double width, double height, double expectedPerimeter, double expectedArea) {
            this.width = width;
            this.height = height;
            this.expectedPerimeter = expectedPerimeter;
            this.expectedArea = expectedArea;
        }
    }

    private static Stream<RectangleTestData> testData() {
        return Stream.of(
                new RectangleTestData(4, 5, 18, 20),
                new RectangleTestData(10, 20, 60, 200)
        );
    }
}