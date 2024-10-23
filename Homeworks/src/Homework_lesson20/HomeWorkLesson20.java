package Homework_lesson20;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;

public class HomeWorkLesson20 {
    public static void main(String[] args) {
        //Task1
        //printMaxMin();

        //Task2

        printSortedArray();
    }

    private static void printSortedArray() {
        //fill collection
        List<Integer> list = getUserInput();

        Printer printer = new Printer();
        printer.print(list, "main");
        
        Thread bubbleSort = new SortThread(new BubleSort(), new ArrayList<>(list), printer);
        Thread choiceSort = new SortThread(new ChoiceSort(), new ArrayList<>(list), printer);
        Thread insertSort = new SortThread(new InsertSort(), new ArrayList<>(list), printer);
        
        bubbleSort.start();
        choiceSort.start();
        insertSort.start();
    }

    private static void printMaxMin() {
        //fill collection
        List<Integer> list = getUserInput();

        AtomicReference<OptionalInt> max = new AtomicReference<>(OptionalInt.empty());
        AtomicReference<OptionalInt> min = new AtomicReference<>(OptionalInt.empty());

        Thread threadMax = new Thread(() -> max.set(list.stream().mapToInt(x -> x).max()));
        Thread threadMin = new Thread(() -> min.set(list.stream().mapToInt(x -> x).min()));
        try {
            threadMax.start();
            threadMin.start();
            threadMin.join();
            threadMax.join();
            System.out.println("max -> " + (!max.get().isPresent() ? "collection is empty" : max.get().getAsInt()));
            System.out.println("min -> " + (!min.get().isPresent() ? "collection is empty" : min.get().getAsInt()));
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static List<Integer> getUserInput() {
        Scanner scanner = new Scanner(System.in);
        List<Integer> result = new ArrayList<>();
        while (true) {
            System.out.print("Enter an integer value to continue or a letter to complete the array filling process:");
            if (!scanner.hasNextInt())
                break;
            result.add(scanner.nextInt());

        }
        return result;
    }
}
