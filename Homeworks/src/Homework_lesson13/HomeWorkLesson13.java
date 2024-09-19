package Homework_lesson13;

import java.io.File;
import java.util.Scanner;

public class HomeWorkLesson13 {
    public static void main(String[] args) {
        //Task 1
        task1();

        //Task *
        taskStar();
    }

    private static void taskStar() {
        String filePath = input("enter file path");
        String saveDirecotryPath = "D:\\Code\\Java projects\\TextFiles\\Results";
        execute(filePath, saveDirecotryPath, new NumberDocumentOperation());
    }

    private static void task1() {
        String filePath = "D:\\Code\\Java projects\\TextFiles\\Romeo and Julietta(en).txt";
        String saveDirecotryPath = "D:\\Code\\Java projects\\TextFiles\\Results";
        execute(filePath, saveDirecotryPath, new MaxLenghtWordOperation());
    }

    private static void execute(String filePath, String saveDirectoryPath, Operation operation) {
        TextAnalizator textAnalizator = new TextAnalizator(operation);
        try {
            textAnalizator.saveMaxLenghtWord(filePath, saveDirectoryPath);
            System.out.println("Result file successfully added, check " + saveDirectoryPath + " directory");
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    private static String input(String message){
        System.out.println(message);
        return new Scanner(System.in).nextLine();
    }
}
