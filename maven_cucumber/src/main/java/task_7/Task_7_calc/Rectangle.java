package task_7.Task_7_calc;

public class Rectangle implements CalcInterface {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = validateParam(width);
        this.height = validateParam(height);
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = validateParam(width);
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = validateParam(height);
    }

    @Override
    public String Type() {
        return "Прямоугольник";
    }

    @Override
    public double CalculatePerimeter() {
        return 2 * (width + height);
    }

    @Override
    public double CalculateArea() {
        return width * height;
    }
}