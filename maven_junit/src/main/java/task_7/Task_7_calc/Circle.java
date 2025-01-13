package task_7.Task_7_calc;

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