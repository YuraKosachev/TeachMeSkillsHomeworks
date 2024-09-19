package Homework_lesson13;

public class HomeWorkLesson13StarTask {
    public static void main(String[] args) {
        //Example 1
        exampleInfinityLoop();

        //Example 2
        exampleSystemExit();
    }

    public static void exampleInfinityLoop() {
        try {

            //Infinity loop
            while (true){

            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        } finally {
            System.out.println("Finally block - i'm sad because you never see me");
        }
    }

    public static void exampleSystemExit() {
        try {
            //the program exits immediately without finally being called.
            System.exit(0);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        } finally {
            System.out.println("Finally block - i'm sad because you never see me");
        }
    }
}
