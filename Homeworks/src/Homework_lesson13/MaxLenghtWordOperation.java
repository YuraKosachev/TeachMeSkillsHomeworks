package Homework_lesson13;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MaxLenghtWordOperation implements Operation {
    @Override
    public SaveData[] execute(String text) {
        if (text == null || text.trim().isEmpty())
            return null;

        Matcher matcher = Pattern.compile("(?<=\\s|^)[a-zA-Z']*(?=[-.,;:!?]?\\s|$)")
                .matcher(text.replaceAll("\r\n", ""));

        String max = null;
        while (matcher.find()) {
            if (max == null || max.length() < matcher.group().length())
                max = matcher.group();
        }
        return new SaveData[]{ new SaveData("max_lenght_word.txt", max) };
    }
}
