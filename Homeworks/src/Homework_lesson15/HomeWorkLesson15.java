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

    }

    //Task 1
    private static void task1() {
        String[] inputArray = input("Enter the sequence values separated by commas:").split(",");
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
