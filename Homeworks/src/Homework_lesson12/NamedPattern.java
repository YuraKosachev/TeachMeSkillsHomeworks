package Homework_lesson12;

import java.util.regex.Pattern;

public class NamedPattern {
    private final String name;
    private final Pattern pattern;

    public NamedPattern(String name, Pattern pattern){
        this.name = name;
        this.pattern = pattern;
    }

    public String getName() {
        return name;
    }

    public Pattern getPattern() {
        return pattern;
    }
}
