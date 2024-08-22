package Homework_lesson8;

import java.lang.reflect.Constructor;

public class HomeWorkLesson8 {
    public static void main(String[] args) {
        //Task 1
        System.out.println("TASK 1 ---------------------------");
        taskZoo();

        //Task*
        System.out.println("TASK * ---------------------------");
        privateCreate();


    }

    private static void privateCreate() {
        try {
            System.out.println("-----------Exmple 1-----------");

            //use reflection
            Constructor<Dog> constructor = Dog.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            Dog dog1 = constructor.newInstance();

            System.out.println(dog1.voice());
            System.out.println(dog1.eat("Meat"));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println("-----------Exmple 2-----------");
        //Create into class dog static method to get instance class
        Dog dog2 = Dog.getInstance();

        System.out.println(dog2.eat("Meat"));
        System.out.println(dog2.voice());

    }

    private static void taskZoo() {
        Animal[] animals = {
                //new Dog(),
                new Rabbit(),
                new Tiger()
        };

        for (Animal animal : animals) {
            System.out.println("Animal eats -------");

            System.out.println(animal.eat("Grass"));
            System.out.println(animal.eat("Meat"));

            System.out.println("Animal says --------");
            System.out.println(animal.voice());
        }
    }
}
