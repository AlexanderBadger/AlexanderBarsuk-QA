package cucumber.steps;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.junit.Assert;
import task_6.Task6_4;
import task_6.TypeParamEnum;
import task_7.Task_7_calc.Circle;
import task_7.Task_7_calc.Rectangle;
import task_7.Task_7_calc.Triangle;

public class Steps {
    private Circle circle;
    private Rectangle rectangle;
    private Triangle triangle;
    private String inputString;
    private double result;
    private int resultParam;
    private TypeParamEnum currentParam;
    private IllegalArgumentException error;

    @Дано("круг с радиусом {double}")
    public void circleWithRadius(double radius) {
        try {
            this.circle = new Circle(radius);
        } catch (IllegalArgumentException e) {
            error = e;
            System.out.println(error.getMessage());
        }
    }

    @Дано("прямоугольник с шириной {double} и высотой {double}")
    public void rectangleWithWidthAndHeight(double width, double height) {
        this.rectangle = new Rectangle(width, height);
    }

    @Дано("треугольник со сторонами {double}, {double}, {double}")
    public void createTriangle(double side1, double side2, double side3) {
        try {
            this.triangle = new Triangle(side1, side2, side3);
            if (triangle.getSide1() + triangle.getSide2() < triangle.getSide3()
                    || triangle.getSide1() + triangle.getSide3() < triangle.getSide2()
                    || triangle.getSide2() + triangle.getSide3() < triangle.getSide1()) {
                throw new IllegalArgumentException("Треугольника с такими сторонами не существует");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            this.triangle = null;
        }
    }

    @Дано("строка {string}")
    public void setString(String str) {
        inputString = str;
    }

    @Когда("вычисляется периметр круга")
    public void calculatePerimeterCircle() {
        this.result = circle.CalculatePerimeter();
    }

    @Когда("вычисляется площадь круга")
    public void calculateAreaCircle() {
        this.result = circle.CalculateArea();
    }

    @Когда("вычисляется периметр прямоугольника")
    public void calculatePerimeterRectangle() {
        this.result = rectangle.CalculatePerimeter();
    }

    @Когда("вычисляется площадь прямоугольника")
    public void calculateAreaRectangle() {
        this.result = rectangle.CalculateArea();
    }

    @Когда("вычисляется периметр треугольника")
    public void calculatePerimeterTriangle() {
        this.result = triangle.CalculatePerimeter();
    }

    @Когда("вычисляется {string} в строке")
    public void calculateParameters(String string) {
        switch (string) {
            case "длина строки":
                currentParam = TypeParamEnum.LENGTH;
                break;
            case "количество цифр":
                currentParam = TypeParamEnum.DIGIT;
                break;
            case "количество букв":
                currentParam = TypeParamEnum.LETTER;
                break;
            case "количество пробелов":
                currentParam = TypeParamEnum.SPACE;
                break;
            case "количество гласных":
                currentParam = TypeParamEnum.VOWEL;
                break;
            default:
                System.out.println("Неизвестный параметр");
        }

        if (currentParam != null) {
            resultParam = Task6_4.getStringParams(inputString, currentParam);
        } else {
            System.out.println("Не выбран параметр для вычисления");
        }
    }

    @Тогда("результат должен быть примерно равен {double} с точностью {double}")
    public void resultMustBeEquals(double expected, double accuracy) {
        Assert.assertEquals(expected, this.result, accuracy);
    }

    @Тогда("результат должен быть равен {int}")
    public void verifyParam(int expectedParam) {
        Assert.assertEquals(expectedParam, resultParam);
    }

    @Тогда("должно быть выброшено исключение")
    public void exceptionMustBeThrown() {
        Assert.assertNotEquals(error, null);
    }
}