package Task_7.Task_7_calc;

public class Circle implements CalcInterface {
    private double radius;

    public Circle(double radius) {
        this.radius = validateParam(radius);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = validateParam(radius);
    }

    private double validateParam(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Значение заданно неверно. Радиус не может быть <= 0" + "\n");
        }
        return radius;
    }

    @Override
    public String Type() {
        return "Круг";
    }

    @Override
    public double CalculatePerimeter() {
        return Math.PI * radius * 2;
    }

    @Override
    public double CalculateArea() {
        return Math.PI * radius * radius;
    }
}