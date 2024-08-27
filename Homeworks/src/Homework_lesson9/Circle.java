package Homework_lesson9;

public class Circle extends Figure {
    private final double radius;

    Circle(double radius){
        this.radius = radius;
    }
    @Override
    public double getPerimeter() {
        return 2 * Math.PI * this.radius;
    }

    @Override
    public double getSquare() {
        return Math.PI * Math.pow(this.radius, 2);
    }
}
