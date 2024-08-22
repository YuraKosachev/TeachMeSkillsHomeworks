package Homework_lesson8;

public class Tiger extends Animal {
    @Override
    public String eat(String food) {
        if (!food.equalsIgnoreCase("meat"))
            return "Tiger eats: Ugh.. " + food + " I don't like eat " + food + ".";
        return "Tiger eats: ohh meat!! I like eat meat!";
    }

    @Override
    public String voice() {
        return "Tiger says: Rrrrrrr...";
    }
}
