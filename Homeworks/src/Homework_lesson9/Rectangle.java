package Homework_lesson9;

public class Rectangle extends Figure {
    private final double a;
    private final double b;

    Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public double getPerimeter() {
        return 2 * (this.a + this.b);
    }

    @Override
    public double getSquare() {
        return this.a * this.b;
    }
}
