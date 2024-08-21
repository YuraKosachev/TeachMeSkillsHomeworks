package Homework_lesson7;

public final class Printer {
    private static final String RESET = "\033[0m";  // Text Reset

    // Regular Colors
    private static final String BLACK = "\033[0;30m";   // BLACK
    private static final String RED = "\033[0;31m";     // RED
    private static final String GREEN = "\033[0;32m";   // GREEN
    private static final String YELLOW = "\033[0;33m";  // YELLOW
    private static final String BLUE = "\033[0;34m";    // BLUE
    private static final String PURPLE = "\033[0;35m";  // PURPLE
    private static final String CYAN = "\033[0;36m";    // CYAN
    private static final String WHITE = "\033[0;37m";

    public static void info(String message) {
        print(message, BLUE, true);
    }

    public static void error(String message){
        print(message, RED,true);
    }

    public static void action(String message){
        print(message, YELLOW, true);
    }

    private static void print(String message, String color, boolean isNextLine) {
        System.out.print(color + message + RESET + (isNextLine ? "\n" : ""));
    }
}
