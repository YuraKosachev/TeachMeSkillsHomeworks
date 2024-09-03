package Homework_lesson11;

import java.util.Arrays;
import java.util.Comparator;

public final class StringOperation {
    public static String getMaxMinInfo(String... source) {
        if (source == null || source.length == 0)
            return null;

        String max = source[0];
        String min = source[0];
        for (int i = 1; i < source.length; i++) {
            max = max.length() < source[i].length() ? source[i] : max;
            min = min.length() > source[i].length() ? source[i] : min;
        }

        return String.format("Max: %s %d\nMin: %s %d", max, max.length(), min, min.length());
    }

    public static String[] sortByLength(String... source) {
        Comparator<String> stringLengthComparator = Comparator.comparing(
                String::length, (s1, s2) -> s1.compareTo(s2));

        Arrays.sort(source, stringLengthComparator);
        return source;
    }

    public static String lessAvg(String... source) {
        if (source == null || source.length == 0)
            return null;
        int sum = 0;
        for (String s : source)
            sum += s.length();

        double avg = sum / source.length;
        StringBuilder builder = new StringBuilder();
        for (String s : source)
            if (s.length() < avg)
                builder.append(String.format("str -> %s len-> %d\n", s, s.length()));

        return builder.toString();
    }

    public static String doubleChar(String source) {
        if (source == null)
            return null;
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < source.length(); i++) {

            builder.append(String.format("%c%c", source.charAt(i), source.charAt(i)));
        }

        return builder.toString();
    }

    public static String getDifferentWord(String... source) {
        for (String str : source) {

            String[] words = str.split(" ");
            for (String word : words)
            {
                if(hasDifferentChar(word))
                    return word;
            }

        }
        return null;
    }

    private static boolean hasDifferentChar(String source) {
        if (source == null || source.trim().isEmpty())
            return false;
        char[] chars = source.trim().toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (isContains(chars, i))
                return false;
        }
        return true;
    }

    private static boolean isContains(char[] chars, int indexChar) {
        char src = Character.toLowerCase(chars[indexChar]);
        for (int i = 0; i < chars.length; i++) {
            if (indexChar == i)
                continue;
            if (src == Character.toLowerCase(chars[i]))
                return true;
        }
        return false;
    }
}
