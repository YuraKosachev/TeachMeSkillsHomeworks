package Homework_lesson18;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class HomeWorkLesson18 {
    public static void main(String[] args) {
        //Task 1
        printSumOperation();

        //Task *
        printNames();
    }

    //Task1
    private static void printSumOperation() {
        Random random = new Random();
        // generation int collection
        List<Integer> collection = IntStream.rangeClosed(1, 1000)
                .map(el -> random.nextInt(1, 10))
                .boxed()
                .collect(Collectors.toList());

        int sum = collection.stream()
                .distinct() //remove duplicate
                .filter(x -> x % 2 == 0)
                .mapToInt(x -> x.intValue())
                .sum();

        System.out.println(sum);
    }

    //Task *
    private static void printNames() {
        Supplier<String> nameGenerator = () -> {
            Random random = new Random();
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < random.nextInt(5, 12); i++) {
                char c = (char) random.nextInt(97, 122);
                builder.append(i == 0 ? Character.toUpperCase(c) : c);
            }
            return builder.toString();
        };

        List<Integer> includes = List.of(1, 2, 5, 8, 9, 13);
        Map<Integer, String> map = IntStream.rangeClosed(1, 1000)
                .boxed()
                .collect(Collectors.toMap(k -> k, v -> nameGenerator.get()));

        List<String> names = map.entrySet().stream()
                .filter(x -> includes.contains(x.getKey()) && x.getValue().length() % 2 == 0)
                .map(x -> new StringBuilder(x.getValue()).reverse().toString())
                .collect(Collectors.toList());

        names.stream().forEach(System.out::println);
    }
}
