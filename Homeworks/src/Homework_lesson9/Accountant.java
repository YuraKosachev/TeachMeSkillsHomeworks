package Homework_lesson9;

public class Accountant extends Employee {
    Accountant(String name) {
        super(name, "Accountant");
    }

    @Override
    public void workProcess() {
        System.out.println("The accountant brings together the balance sheet of the company");
    }
}
