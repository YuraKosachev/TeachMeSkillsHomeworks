package Homework_lesson20;

import java.util.List;

public class Printer {
    public synchronized void print(List<Integer> integerList, String name) {
        System.out.print("sort class: " + name + " -> ");
        integerList.stream().forEach(x -> System.out.printf(" %d ", x));
        System.out.println();
    }
}
