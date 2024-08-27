package Homework_lesson9;

public abstract class Employee implements Position {
    private final String name;
    private final String position;

    Employee(String name, String position) {
        this.name = name;
        this.position = position;
    }

    public abstract void workProcess();

    @Override
    public void printPosition() {
        System.out.println("Employee " + name + " is " + position);
    }
}
