package Homework_lesson12;

import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HomeWorkLesson12 {
    public static void main(String[] args) {
        //Task 1
        printAbbreviation();

        //Task *
        printInfo();
    }

    private static void printAbbreviation() {
        String text = input("Enter the text to search for abbreviations:");

        Pattern pattern = Pattern.compile("\\s*[A-ZА-Я]{2,6}(\\s*|\\W?)");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(matcher.group().trim());
        }

    }

    private static void printInfo() {
        NamedPattern[] namedPatterns = {
                new NamedPattern("document number", Pattern.compile("\\d{4}-\\d{4}-\\d{2}")),
                new NamedPattern("phone", Pattern.compile("\\+\\(\\d{2}\\)\\d{7}?")),
                new NamedPattern("email", Pattern.compile("\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*\\.\\w{2,4}"))
        };


        String text = input("Enter the text to search for a match:");


        StringBuilder builder = new StringBuilder();
        boolean isFirst = false;
        for (int i = 0; i < namedPatterns.length; i++) {
            Matcher matcher = namedPatterns[i].getPattern().matcher(text);
            builder.append(namedPatterns[i].getName());
            isFirst = true;
            while (matcher.find()) {
                builder.append((isFirst ? ": ":", ") + matcher.group().trim());
                isFirst = false;
            }
            builder.append("\n");
        }

        System.out.println(builder);
    }

    private static String input(String text) {
        System.out.print(text);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}

