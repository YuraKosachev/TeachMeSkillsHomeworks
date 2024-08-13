package Homework_lesson5;

import java.util.Random;
import java.util.Scanner;

public class HomeWorkLesson5 {

    public static void main(String[] args) {
        sumArrayElements();
        createChessboard();
        printSnake();
    }

    //Task 1
    private static void sumArrayElements(){
        System.out.println("Task 1 is running");
        final int startRange = 0;
        final int endRange = 100;
        int outer = input("Enter outer range of array: ");
        int inner = input("Enter inner range of array: ");
        int[][] array = createArray(outer, inner);

        fillArray(array, startRange, endRange);

        System.out.println("Created new array:");
        printArray(array);

        int add = input("enter a value for sum: ");
        System.out.println("Array after elements sum:");
        sumElements(array, add);
        printArray(array);
    }

    //Task 2
    private static void createChessboard(){
        System.out.println("Task 2 is running");
        String[][] chessboard = new String[8][8];
        fillChessboard(chessboard);
        printChessboard(chessboard);

    }

    //Task3
    private static void printSnake(){
        System.out.println("Task * is running");
        int n = input("Enter n value: ");
        int m = input("Enter m value: ");
        int[][] array = createArray(n, m);
        fillSnakeArray(array);
        printSnakeArray(array);
    }

    private static void fillSnakeArray(int[][] array){

        for(int i = 0, counter = 0; i < array.length; i++){
            for(int j = 0; j < array[i].length; j++, counter++)
                array[i][j] = counter;
        }
    }
    private static void printSnakeArray(int[][] array){
        for(int i = 0; i < array.length; i++){
            boolean isEven = i % 2 == 0;
            for(int j = isEven ? 0 : array[i].length - 1; isEven ? j < array[i].length: j>=0; j += isEven ? 1 : -1)
                System.out.print(getFormat(array[i][j]));
            System.out.println();
        }
    }


    private static void fillChessboard(String[][] chessboard){
        for(int i = 0; i < chessboard.length; i++){
            for(int j = 0; j < chessboard[i].length; j++)
                chessboard[i][j] = (i + j) % 2 == 0 ? "W":"B";
        }
    }

    private static void printChessboard(String[][] chessboard){
        for(int i = 0; i < chessboard.length; i++){
            for(int j = 0; j < chessboard[i].length; j++)
                System.out.print(chessboard[i][j] + " ");
            System.out.println();
        }
    }

    private static void printArray(int[][] array){
        for(int i = 0; i < array.length; i++ ){
            for(int j = 0; j < array[i].length; j++)
                System.out.print(getFormat(array[i][j]));
            System.out.println();
        }
    }

    private static void fillArray(int[][] array, int fromRange, int toRange){
        for(int i = 0; i < array.length; i++ )
            for(int j = 0; j < array[i].length; j++)
                array[i][j] = getRandomInt(fromRange, toRange);
    }
    private static void sumElements(int[][] array, int add){
        for(int i = 0; i < array.length; i++ )
            for(int j = 0; j < array[i].length; j++)
                array[i][j] += add;
    }

    private static int[][] createArray(int outer, int inner){
        return new int[outer][inner];
    }

    private static String getFormat(int val){
        int length = String.valueOf(val).length();
        String format =  length > 1 ? "%d ": " %d ";
        return String.format(format, val);
    }

    private static int input(String message){
        System.out.print(message);
        return new Scanner(System.in).nextInt();
    }

    private static int getRandomInt(int from, int to){
        return new Random().nextInt(from, to);
    }
}
