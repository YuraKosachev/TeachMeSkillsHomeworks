package Homework_lesson2;

public class HomeWorkLesson2 {
    public static void main(String[] args) {
        double task1Result = getTask1Example(2, 4);
        int task2Result = getTwoDigitSum(26);
        int task3Result = getThreeDigitSum(999);
        long task4Result = getRound(2.2);
        System.out.printf("Задача1: %.2f\nЗадача 2: %d\nЗадача 3: %d\n", task1Result, task2Result, task3Result);
        System.out.printf("Задача 4: %d\n", task4Result);
    }

    //Task 1
    static double getTask1Example(double b, double c) {
        return 4 * (b + c - 1) / 2;
    }

    //Task 2
    static int getTwoDigitSum(int src){
        return src / 10 +  src % 10;
    }

    //Task 3
    static int getThreeDigitSum(int src){
        return src / 100 + getTwoDigitSum(src % 100);
    }

    //Task 4
    static long getRound(double src){
        return Math.round(src);
    }

}
