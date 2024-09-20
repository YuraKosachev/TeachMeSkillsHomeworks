package Homework_lesson15;

import java.util.*;

public class HomeWorkLesson15 {
    public static void main(String[] args) {
        //Task1
        task1();

        //Task2
        task2();

        //Task3
        task3();

        //Task *
        taskStar();

    }

    //Task 1
    private static void task1() {
        String[] inputArray = input("Enter the sequence values separated by commas:")
                .split(",");
        HashSet<String> hashSet = new HashSet();
        for (String item : inputArray) {
            hashSet.add(item.trim());
        }
        print(hashSet, false);
    }

    //Task 2
    private static void task2() {
        AnimalStore<Animal> animals = new AnimalStore<>();
        //Generate
        System.out.println("---SET TO STORE---");
        for (int i = 0; i < 10; i++) {
            Animal animal = new Animal("Animal" + i, i);
            System.out.println(animal);
            animals.add(animal);
        }
        System.out.println("---EXTRACT FROM STORE---");
        while (!animals.isEmpty()) {
            System.out.println(animals.getLast());
        }

    }

    //Task 3
    private static void task3() {
        University university = new University("Belarusian national technical university (BNTU)");
        //Entering to university
        for (int groupNumber = 1; groupNumber < 6; groupNumber++) {
            for (int person = 1; person <= 20; person++) {
                university.enter(1,
                        new Student("StudentId:" + UUID.randomUUID(),
                                "group number " + groupNumber));
            }
        }

        for (int course = 1; course < 7; course++) {
            if (course != 1)
                university.nextCourse(course);
            System.out.printf("---------COURSE: %d-Students count: %d-------\n", course, university.studentsCount());
            print(university.getStudentsByCourse(course), true);
        }
    }

    //Task *

    private static void taskStar(){
        CustomCollection<String> collection = new CustomCollection<String>();
        //Test collection
        //add elements
        for(int i = 0; i< 10; i++){
            collection.add("ITEM "+ i);
        }

        //get elements by index
        System.out.println("---------------TEST GET Element by index --------------");
        for(int i =0 ; i < collection.size(); i++){
            System.out.println(collection.get(i));
        }

        //Get  index by element
        System.out.println("---------------TEST GET INDEX BY ELEMENT --------------");
        int index = collection.find("ITEM 1");
        System.out.println("ITEM 1 index : " + index);
        //Remove elements
        //Remove element by index
        collection.remove(2);
        //Remove element by elements
        collection.remove("ITEM 1");
        System.out.println("---------------TEST REMOVE --------------");
        for(int i =0 ; i < collection.size(); i++){
            System.out.println(collection.get(i));
        }
        System.out.println("---------------TEST REMOVE ALL --------------");
        collection.removeAll();
        System.out.println("Collection is empty : " + collection.isEmpty());

        System.out.println("---------------EXTENDS COLLECTION SET 100 elements --------------");
        for(int i = 0; i< 100; i++){
            collection.add("ITEM "+ i);
        }
        System.out.println("---------------SUCCESSFULLY ADDED --------------");
        System.out.println("---------------PRINT COLLECTION --------------");

        for(int i =0 ; i < collection.size(); i++){
            System.out.println(collection.get(i));
        }

    }


    private static String input(String message) {
        System.out.println(message);
        return new Scanner(System.in).nextLine();
    }

    private static <T> void print(Collection<T> collection, boolean isNewLine) {
        for (T item : collection) {
            System.out.print(item + (isNewLine ? "\n" : " "));
        }
    }
}
