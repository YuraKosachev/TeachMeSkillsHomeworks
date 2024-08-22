package Homework_lesson8;

public class Rabbit extends Animal{
    @Override
    public String voice() {
        return "Rabbit says: Something like a rabbit's voice";
    }

    @Override
    public String eat(String food) {
        if (!food.equalsIgnoreCase("grass"))
            return "Rabbit eats: Ugh.. " + food + " I don't like eat " + food + ".";
        return "Rabbit eats: ohh grass!! I like eat grass!";
    }
}
