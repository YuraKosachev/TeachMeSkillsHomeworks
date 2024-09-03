package Homework_lesson11;

import java.util.Scanner;

public final class Input {
    public static String in(String message) {
        out(message, true);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static void out(String message, boolean isNewLine) {
        System.out.print(message + (isNewLine ? "\n" : ""));
    }
    public static int inToInt(String message){
        out(message, true);
        Scanner scanner = new Scanner(System.in);
        while(true){
            if(!scanner.hasNextInt())
                out("Please enter correct value", true);
            return scanner.nextInt();
        }
    }
}
