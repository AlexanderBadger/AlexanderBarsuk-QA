package task_7.Task_7_calc;

public interface CalcInterface {

    String Type();

    double CalculatePerimeter();

    double CalculateArea();

    default double validateParam(double size) {
        if (size <= 0) {
            throw new IllegalArgumentException("У фигуры " + Type() + " размер задан не корректно");
        }
        return size;
    }
}