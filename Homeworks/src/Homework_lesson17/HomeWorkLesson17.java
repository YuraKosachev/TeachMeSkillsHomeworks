package Homework_lesson17;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class HomeWorkLesson17 {
    public static void main(String[] args) {
        //Task 1
        printCenturyDate();

        //Task 2
        printOnlyPositive();

        //Task 3
        functionMoneyConverter();

        //Task 4
        supplierMoneyConverter();

        //Task 5
        revertString();


    }

    //Task 1
    private static void printCenturyDate() {
        String format = "yyyy-MM-dd";
        final int century = 100;
        String dateFormat = input("Enter your date of birth in " + format + " format:").nextLine();
        SimpleDateFormat dateFormatter = new SimpleDateFormat(format);
        try {
            Date date = dateFormatter.parse(dateFormat);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.YEAR, century);
            System.out.println("Date of your century birthday will be -> " + dateFormatter.format(calendar.getTime()));

        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }

    }

    //Task 2
    private static void printOnlyPositive() {
        //Array
        int[] array = {1, 2, 123, 4, 4, -1, 32, -4, -5, 167, -888, -32};
        Predicate<Integer> isPositive = x -> x >= 0;
        System.out.println("Print array");
        for (int value : array) {
            if (isPositive.test(value)) {
                System.out.println(value);
            }
        }

        //Collection
        System.out.println("Print collection");
        List<Integer> collection = List.of(1, 2, 123, 4, 4, -1, 32, -4, -5, 167, -888, -32);
        collection.stream().filter(isPositive).forEach(System.out::println);
    }

    //Task 3
    private static void functionMoneyConverter(){
        final double usdByn = 3.30D;

        Function<String, String> converter = src-> {

            String[] values = src.trim().split(" ");
            Double money = Double.parseDouble(values[0]);
            String currency = values[1].toUpperCase();
            Double convertedValue = currency.equals("BYN")
                    ? money / usdByn
                    : money * usdByn;
            return String.format ("%.2f %s", convertedValue, currency.equals("BYN") ? "USD" : "BYN");
        };
        String money = input("Enter the quantity and currency in the format '[COUNT] [BYN or USD]' for conversion").nextLine();
        System.out.println(converter.apply(money));
    }

    //Task 4
    private static void supplierMoneyConverter(){
        final double usdByn = 3.30D;

        Supplier<String> converter = () -> {
            String input = input("Enter the quantity and currency in the format '[COUNT] [BYN or USD]' for conversion").nextLine();
            String[] values = input.trim().split(" ");
            Double money = Double.parseDouble(values[0]);
            String currency = values[1].toUpperCase();
            Double convertedValue = currency.equals("BYN")
                    ? money / usdByn
                    : money * usdByn;
            return String.format ("%.2f %s", convertedValue, currency.equals("BYN") ? "USD" : "BYN");
        };
        System.out.println(converter.get());
    }

    //Task 5
    private static void revertString(){

        Supplier<String> revert = () -> {
            String input = input("Enter string to revert:").nextLine();
            return new StringBuilder(input).reverse().toString();
        };
        System.out.println(revert.get());
    }


    private static Scanner input(String message) {
        System.out.println(message);
        return new Scanner(System.in);
    }
}
