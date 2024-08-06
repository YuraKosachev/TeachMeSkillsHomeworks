package Homework_lesson3;

import java.util.Scanner;

public class HomeWorkLesson3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //task 1
        System.out.println("Please enter number:");
        int src = scanner.nextInt();
        String answer = isEven(src) ? "even" : "odd";
        System.out.printf("number %d is %s\n", src, answer);

        //task 2
        System.out.println("Please enter degree:");
        int degree = scanner.nextInt();
        System.out.println(checkTemperature(degree));

        //task 3
        printSquare(10, 20);
        //task 4
        printSequence(7);

        //task *
        System.out.println("Enter a positive number:");
        String value = scanner.nextLine();

        String res = isValid(value) ? getSum(Integer.parseInt(value)) + "" : "entered number is not valid";
        System.out.println(res);
    }

    //task1
    private static boolean isEven(int src) {
        return src % 2 == 0;
    }

    //task2
    private static String checkTemperature(int degree) {

        if (degree > -5)
            return "Warm";

        if (degree <= -5 && degree > -20)
            return "Normal";

        return "Cold";
    }

    // task3
    private static void printSquare(int from, int to) {
        for (; from <= to; from++) {
            System.out.println("square for " + from + " is " + (from * from));
        }
    }

    //task4
    private static void printSequence(int value) {
        int multiplier = 1;
        int result = 0;

        while (true) {
            result = value * multiplier;
            if (result > 100)
                break;
            System.out.print(result + " ");
            multiplier++;
        }
        System.out.println();
    }

    //task *
    private static int getSum(int to) {
        int result = 0;
        for (int i = 1; i < to; i++) {
            result += i;
        }
        return result;
    }

    private static boolean isValid(String src) {
        try {
            int result = Integer.parseInt(src);
            return result > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
