package Homework_lesson15;

public class Animal {
    private final String name;
    private final int number;
    public Animal(String name, int number){
        this.name = name;
        this.number = number;
    }

    @Override
    public String toString() {
        return String.format("name: %s; number: %d", this.name, this.number);
    }
}
