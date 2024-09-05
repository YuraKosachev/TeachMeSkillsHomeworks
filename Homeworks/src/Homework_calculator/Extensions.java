package Homework_calculator;

import java.util.Arrays;

public final class Extensions {
    public static boolean isContains(char source, char[] chars){
        for (int i = 0; i < chars.length; i++){
            if(source == chars[i])
                return true;
        }
        return false;
    }

    public static String[] extend(String[] source, String element){
        int lastIndex = source.length;
        String[] result = Arrays.copyOf(source, source.length + 1);
        result[lastIndex] = element;
        return result;
    }
}
