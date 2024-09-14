package Homework_lesson13;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Validation {
    public static boolean isLengthCorrect(String src, int from, int to){
        return src != null && src.length() >= from && src.length() <= to;
    }

    public static boolean hasWhiteSpace(String src){
        return hasMatch(src, "\\s");
    }

    public  static boolean hasDigit(String src){
        return hasMatch(src, "\\d");
    }

    private static boolean hasMatch(String src, String pattern){
        Matcher matcher = Pattern.compile(pattern).matcher(src);
        return matcher.find();
    }
}
