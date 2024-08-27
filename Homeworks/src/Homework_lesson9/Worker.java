package Homework_lesson9;

public class Worker extends Employee{
    Worker(String name) {
        super(name, "Worker");
    }

    @Override
    public void workProcess() {
        System.out.println("The worker works hard all day.");
    }
}
