package Homework_lesson16;
import java.util.*;


public class HomeWorkLesson16 {
    public static void main(String[] args) {
        //Task 1
        task1();

        //Task2
        task2();

        //Task *
        taskStar();
    }

    private static void taskStar() {
        String[] test = new String[]{"()", "[()]","{[()]}" , "([{{[(())]}}])", "{{[]()}}}}", "{[(])}","{()}((("};

        for (String src : test) {
            System.out.println("String -> " + src + (isBalanced(src) ? " is" : " isn't") + " balanced");
        }

    }

    private static void task2() {
        String[][] test = new String[3][];
        test[0] = new String[]{"code", "bug"};
        test[1] = new String[]{"man", "moon", "main"};
        test[2] = new String[]{"man", "moon", "good", "night"};

        for (String[] itemTest : test) {
            System.out.println(pairs(itemTest));
        }
    }

    private static boolean isBalanced(String src) {

        Map<Character, Integer> costs = new HashMap<>() {{
            put('{', (int)'{');
            put('(', (int)'(');
            put('[', (int)'[');
            put('}', -1 * (int)'{');
            put(')', -1 * (int)'(');
            put(']', -1 * (int)'[');
        }};

        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        for (char ch : src.toCharArray()) {

            if (!costs.containsKey(ch))
                continue;

            int cost = costs.get(ch);
            if (cost < 0 && (stack.isEmpty() || cost != stack.pop()))
                return false;
            else if (cost > 0)
                stack.push(-1 * cost);

            sum += cost;
        }
        return sum == 0;
    }

    private static void task1() {
        String[][] test = new String[3][];
        test[0] = new String[]{"a", "b", "a", "c", "b"};
        test[1] = new String[]{"c", "b", "a"};
        test[2] = new String[]{"c", "c", "c", "c"};

        for (String[] itemTest : test) {
            System.out.println(wordMultiple(itemTest));
        }

    }

    private static Map<String, String> pairs(String[] src) {
        Map<String, String> tree = new TreeMap<>(); //can use hashmap
        for (String s : src) {
            if (s == null)
                continue;
            tree.put(String.valueOf(s.charAt(0)), String.valueOf(s.charAt(s.length() - 1)));
        }
        return tree;
    }

    private static Map<String, Boolean> wordMultiple(String[] src) {
        Map<String, Boolean> map = new HashMap<>();
        for (String s : src) {
            map.put(s, map.containsKey(s));
        }
        return map;
    }
}
