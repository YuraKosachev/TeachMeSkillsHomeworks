package Homework_lesson6;

public class Logger {

    public void info(String message){
        this.print(message);
    }
    public void error(String message){
        this.print(message);
    }

    private void print(String message){
        System.out.println(message);
    }
}
