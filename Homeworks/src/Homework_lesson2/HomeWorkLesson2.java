package Homework_lesson2;

public class HomeWorkLesson2 {
    public static void main(String[] args) {
        double task1Result = getTask1Example(2, 4);
        int task2Result = getTwoDigitSum(26);
        int task3Result = getThreeDigitSum(999);
        long task4Result = getRound(2.2);
        String task5Result = getDivFormat(21, 8);
        System.out.printf("Задача 1: %.2f\nЗадача 2: %d\nЗадача 3: %d\n", task1Result, task2Result, task3Result);
        System.out.printf("Задача 4: %d\nЗадача 5: %s\n", task4Result, task5Result);

        //Task *
        //Example 1 use temp
        int a0 = 2;
        int b0 = 3;
        int temp = a0;

        a0 = b0;
        b0 = temp;
        System.out.printf("ex. 1 - a = %d b = %d\n", a0, b0);

        //Example 2 use xor
        int a1 = 2;
        int b1 = 3;
        a1 = a1 ^ b1;
        b1 = a1 ^ b1;
        a1 = a1 ^ b1;
        System.out.printf("ex. 2 - a = %d b = %d\n", a1, b1);

        // Example 3
        int a2 = 2;
        int b2 = 3;
        a2 = a2 * b2; // or use +
        b2 = a2 / b2; // or use -
        a2 = a2 / b2; // or use -

        System.out.printf("ex. 3 - a = %d b = %d\n", a2, b2);
    }

    //Task 1
    static double getTask1Example(double b, double c) {
        return 4 * (b + c - 1) / 2;
    }

    //Task 2
    static int getTwoDigitSum(int src) {
        return src / 10 + src % 10;
    }

    //Task 3
    static int getThreeDigitSum(int src) {
        return src / 100 + getTwoDigitSum(src % 100);
    }

    //Task 4
    static long getRound(double src) {
        return Math.round(src);
    }

    //Task 5
    static String getDivFormat(int q, int w) {
        return String.format("%d и %d в остатке", q / w, q % w);
    }


}
