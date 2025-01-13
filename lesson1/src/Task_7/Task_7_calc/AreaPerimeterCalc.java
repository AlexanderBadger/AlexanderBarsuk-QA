package Task_7.Task_7_calc;

public class AreaPerimeterCalc {
    public static void main(String[] args) {

        try {
            Circle circle = new Circle(5);
            circle.setRadius(10);
            System.out.printf("Тип фигуры - %s%nПараметры: %.2f%nПлощадь фигуры = %.2f%nПериметр фигуры = %.2f%n%n",
                    circle.Type(), circle.getRadius(), circle.CalculateArea(), circle.CalculatePerimeter());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            Triangle triangle = new Triangle(10, 5, 10);
            triangle.setSide1(triangle.getSide1() * 2);
            triangle.setSide2(triangle.getSide2() * 2);
            triangle.setSide3(triangle.getSide3() * 2);
            if (triangle.getSide1() + triangle.getSide2() < triangle.getSide3()
                    | triangle.getSide1() + triangle.getSide3() < triangle.getSide2()
                    | triangle.getSide2() + triangle.getSide3() < triangle.getSide1()) {
                throw new IllegalArgumentException("Треугольника с такими сторонами не существует" + "\n");
            }
            System.out.printf(
                    "Тип фигуры - %s%nПараметры: %.2f; %.2f; %.2f%nПлощадь фигуры = %.2f%nПериметр фигуры = %.2f%n%n",
                    triangle.Type(), triangle.getSide1(), triangle.getSide2(), triangle.getSide3(),
                    triangle.CalculateArea(), triangle.CalculatePerimeter());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            Rectangle rectangle = new Rectangle(10, 15);
            rectangle.setHeight(rectangle.getWidth());
            rectangle.setWidth(rectangle.getHeight());
            System.out.printf(
                    "Тип фигуры - %s%nПараметры: %.2f; %.2f%nПлощадь фигуры = %.2f%nПериметр фигуры = %.2f%n%n",
                    rectangle.Type(), rectangle.getWidth(), rectangle.getHeight(),
                    rectangle.CalculateArea(), rectangle.CalculatePerimeter());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}