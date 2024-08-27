package Homework_lesson9;

public class Triangle extends Figure {
    private final double a;
    private final double b;
    private final double c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double getPerimeter() {
        return  this.a + this.b + this.c;
    }

    @Override
    public double getSquare() {
        //use Heron's formula for triangle square
        //p - semi-perimeter
        double p = (this.a + this.b + this.c) / 2;
        return Math.sqrt(p * (p - this.a) * (p - this.b) * (p - this.c));
    }
}
