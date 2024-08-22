package Homework_lesson8;

public class Dog extends Animal {
    private Dog() {
    }

    @Override
    public String voice() {
        return "Dog says: Woof woof woof...";
    }

    @Override
    public String eat(String food) {
        if (!food.equalsIgnoreCase("meat"))
            return "Dog eats: Ugh.. " + food + "I'm dog and I don't like eat " + food + ".";
        return "Dog eats: I'm dog and I like eat meat!";
    }

    //Task *
    public static Dog getInstance(){
        return new Dog();
    }


}
