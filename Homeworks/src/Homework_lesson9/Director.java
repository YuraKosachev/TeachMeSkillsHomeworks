package Homework_lesson9;

public class Director extends Employee {
    Director(String name){
        super(name,"Director");
    }

    @Override
    public void workProcess() {
        System.out.println("The director is doing an important job! He is very busy man.");
    }
}
