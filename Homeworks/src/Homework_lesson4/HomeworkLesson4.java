package Homework_lesson4;

import java.util.Arrays;
import java.util.Scanner;

public class HomeworkLesson4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = createArray(scanner);
        //Task 1
        System.out.print("Print forward - ");
        printArray(array, false);

        System.out.print("Print reverse - ");
        printArray(array, true);

        //Task 2 Max, min
        printMaxMin(array);

        //Task 3 Max, min index
        printMaxMinIndex(array);

        //Task 4 zero count
        printZeroCount(array);

        //Task 5 change elements
        changeElements(array);

        //Task 6 comment previous method
        checkArray(array);

        //Task *
        int[] arr = createArray(scanner);
        int val = input("Add value: ",scanner );
        printArray(add(arr, val), false);

    }

    private static int[] createArray(Scanner scanner) {
        int lenght = input("Please enter array lenght: ", scanner);
        int[] result = new int[lenght];

        boolean isManual = input("Set 1 if you wont to create array's elements manualy: ", scanner) == 1;

        //fill array
        for (int i = 0; i < result.length; i++) {
            if (isManual) {
                result[i] = input("please enter [" + i + "] element:", scanner);
                continue;
            }
            result[i] = (int) (Math.random() * 10);
        }
        return result;
    }

    private static int input(String message, Scanner scanner) {
        System.out.print(message);
        if (!scanner.hasNextInt())
            return -1;

        return scanner.nextInt();
    }

    //Task1
    private static void printArray(int[] array, boolean reverse) {
        int end = reverse? -1 : array.length;

        for (int i = reverse ? array.length - 1: 0; reverse ? i > end : i < end ; i += reverse ? -1: 1) {
            System.out.printf(" %d ", array[i]);
        }
        System.out.println();
    }

    //Task2
    private static void printMaxMin(int[] array){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i : array){
            max = Math.max(max,i);
            min = Math.min(min,i);
        }

        System.out.printf("Маx - %d, min - %d\n", max, min);
    }

    //Task3
    private static void printMaxMinIndex(int[] array){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i : array){
            max = Math.max(max,i);
            min = Math.min(min,i);
        }

        System.out.printf("Маx index - %d, min index - %d\n", findIndex(array, max),findIndex(array, min));
    }

    private static int findIndex(int[] arr, int element) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == element) {
                return i;
            }
        }
        return -1;
    }

    //Task4
    private static void printZeroCount(int[] array){
        final int zero = 0;
        int zeroCounter = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != zero){
                continue;
            }
            zeroCounter++;
        }
        String message = zeroCounter == zero
                ? "Zero elements not found"
                : String.format("%d zero elements found", zeroCounter);
        System.out.println(message);
    }

    //Task 5
    private static void changeElements(int[] array){
        for(int i = 0, j = array.length - 1; i < j; i++, j--){
            array[i] = array[i] ^ array[j];
            array[j] = array[i] ^ array[j];
            array[i] = array[i] ^ array[j];
        }
        printArray(array,false);
    }

    //Task 6
    private static void checkArray(int[] array){
        //int previous;
        boolean isIncreasingSequence = true;

        for(int i = 0; i < array.length; i++){
            if(i == 0)
                continue;

            if(array[i - 1] > array[i]){
                isIncreasingSequence = false;
                break;
            }
        }

        System.out.printf("Sequence is %sincreasing", isIncreasingSequence ? "": "not ");
    }

    //Task *
    private static int[] add(int[] array, int add){
        int sum = arrayToInt(array) + add;
        return intToArray(sum);
    }
    private static int arrayToInt(int[] array){
        StringBuilder builder = new StringBuilder();
        for(int i : array){
            builder.append(i);
        }
        return Integer.parseInt(builder.toString());
    }
    private static int[] intToArray(int src){
        int[] result = new int[String.valueOf(src).length()];
        for(int i = result.length - 1; src > 0; i--, src /= 10){
            result[i] = src % 10;
        }
        return result;
    }
}
