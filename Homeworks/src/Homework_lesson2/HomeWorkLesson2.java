package Homework_lesson2;

public class HomeWorkLesson2 {
    public static void main(String[] args) {
        double task1Result = getTask1Example(2, 4);
        System.out.printf("Задача1: %.2f\n", task1Result);
    }
    static double getTask1Example(double b, double c) {
        return 4 * (b + c - 1) / 2;
    }
}
