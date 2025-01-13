package task_7.Task_7_calc;

public class Triangle implements CalcInterface {

    private double side1;
    private double side2;
    private double side3;

    public Triangle(double side1, double side2, double side3) {
        this.side1 = validateParam(side1);
        this.side2 = validateParam(side2);
        this.side3 = validateParam(side3);
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    @Override
    public String Type() {
        return "Треугольник";
    }

    @Override
    public double CalculateArea() {
        double halfPerimeter = (side1 + side2 + side3) / 2;
        return Math.sqrt(halfPerimeter * (halfPerimeter - side1) * (halfPerimeter - side2) * (halfPerimeter - side3));
    }

    @Override
    public double CalculatePerimeter() {
        return side1 + side2 + side3;
    }
}