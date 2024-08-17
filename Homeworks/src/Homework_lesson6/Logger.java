package Homework_lesson6;

public class Logger {

    public static final String RESET = "\033[0m";  // Text Reset

    // Regular Colors
    public static final String RED = "\033[0;31m";     // RED
    public static final String BLUE = "\033[0;34m";    // BLUE

    public void info(String message) {
        this.print(BLUE + message);
    }

    public void error(String message) {
        this.print(RED + message);
    }

    private void print(String message) {
        System.out.println(message + RESET);
    }
}
